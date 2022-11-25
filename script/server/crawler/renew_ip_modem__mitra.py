#!/usr/bin/python
# -*- coding: utf-8 -*-

import requests
import time
import sys
import base64
from datetime import datetime
import hashlib

CRED = '\033[91m'
CGREEN = '\033[92m'
CYELLOW = '\033[93m'
CBLUE = '\033[94m'
CMAGENTA = '\033[95m'
CGREY = '\033[90m'
CBLAC = '\033[90m'
CEND = '\033[0m'

class MitraStarDevice:
    _initialIp = None
    _lastIp = None
    def __init__(self, host, username, password):
        self.host = host
        self.username = username
        self.password = password
        self.LOGIN_URL = 'http://{ip}/login-padrao.cgi'.format(**{'ip': self.host})
        self.WAN_INTERFACE_URL = 'http://{ip}/wancfg.cmd'.format(**{'ip': self.host})
        self.headers1 = {
            'user-agent': 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_3) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/13.0.5 Safari/605.1.15'
        }
        self.session = requests.Session()

    def login(self):
        sys.stdout.write('{0}[!] Logging...{1}\n'.format(CYELLOW, CEND))
        sys.stdout.flush()
        try:
            r = requests.get(self.LOGIN_URL, headers=self.headers1, timeout=30)
            # print(r.text)
            sid_start = r.text.find("var sid = ")
            sid_end = r.text.find(";", sid_start)
            sid = r.text[sid_start:sid_end].replace("var sid =", "").replace('"', '').replace(" ", "")

            hash = self.username + ":" + hashlib.md5(str(sid + ":" + self.password).encode('utf-8')).hexdigest()
            session_key = base64.b64encode(str(hash).encode("utf-8"))

            self.session = requests.Session()
            payload = { 'session_key': session_key, 'user': '', 'pass': '' }
            header = { 'Content-Type': 'application/x-www-form-urlencoded', 'Referer': 'http://192.168.10.1/padrao_adv.html', 'Host': '192.168.10.1', 'Origin': 'http://192.168.10.1', 'Upgrade-Insecure-Requests': '1' }
            r = self.session.post(self.LOGIN_URL, headers = header, data = payload)
            #print(r.text)
            #print(r.headers)
            return True
        except Exception as e:
            print(e)
            return False

    def validIPAddress(self, IP):
      """
      :type IP: str
      :rtype: str
      """
      def isIPv4(s):
         try: return str(int(s)) == s and 0 <= int(s) <= 255
         except: return False
      def isIPv6(s):
         if len(s) > 4:
            return False
         try : return int(s, 16) >= 0 and s[0] != '-'
         except:
            return False
      if IP.count(".") == 3 and all(isIPv4(i) for i in IP.split(".")):
         return "IPv4"
      if IP.count(":") == 7 and all(isIPv6(i) for i in IP.split(":")):
         return "IPv6"
      return "Neither"

    def getCurrentIp(self):
        r = self.session.get(self.WAN_INTERFACE_URL, headers=self.headers1, timeout=60)
        if "precisaestarautenticado" in r.text or "RouterConfigurationwindow,andtryagaininafewminutes" in r.text:
            sys.stdout.write('{0}[!] Error getting IP{1}\n'.format(CRED, CEND))
            sys.stdout.flush()
            raise NameError('We are not logged')

        ip_index = r.text.find("<td>PPPoE</td>") + 14
        ip_index_end = r.text.find("</td>", ip_index)
        ip = r.text[ip_index:ip_index_end].replace('<td>', '').replace("\n", '').replace(' ', '')
        if self.validIPAddress(ip) != 'IPv4' and ip != 'N/A':
            sys.stdout.write('{0}[!] Error getting IP{1}\n'.format(CRED, CEND))
            sys.stdout.flush()
            raise NameError('We are not logged')
        else:
            if self._initialIp == None and self.validIPAddress(ip) == 'IPv4':
                self._initialIp = ip

            if self.validIPAddress(ip) == 'IPv4':
                self._lastIp = ip

            return ip            

    def getWanInterfaceSessionKey(self):
        r = self.session.get(self.WAN_INTERFACE_URL, headers=self.headers1, timeout=30)
        session_key_index = r.text.find("&sessionKey=")
        session_key_index_end = r.text.find("'", session_key_index)
        session_key = r.text[session_key_index:session_key_index_end].replace('&sessionKey=', '')
        return session_key

    def toggleEnableWanInterface(self, sessionKey, enableIfc):
        r = self.session.get(self.WAN_INTERFACE_URL + '?action=renew&wanIfName=ppp0.1&enableIfc=' + enableIfc + '&sessionKey=' + sessionKey, headers=self.headers1, timeout=30)

    def hasChangedIp(self):
        if self._initialIp != None and self._lastIp != None and self._initialIp != self._lastIp:
            return True

        return False

    def renewWanIp(self):
        currentIp = self.getCurrentIp()
        sys.stdout.write('{0}[*] Current IP: {2}{1}\n'.format(CYELLOW, CEND, currentIp))
        sys.stdout.flush()

        exitLoop = False

        while exitLoop == False:
            wanInterfaceSessionKey = device.getWanInterfaceSessionKey()
            sys.stdout.write('{0}[*] Wan Session Key: {2}{1}\n'.format(CYELLOW, CEND, wanInterfaceSessionKey))
            sys.stdout.flush()

            sys.stdout.write('{0}[!] Renewing IP (ifc=false)...{1}\n'.format(CYELLOW, CEND))
            sys.stdout.flush()
            self.toggleEnableWanInterface(wanInterfaceSessionKey, 'false')

            time.sleep(1)

            sys.stdout.write('{0}[!] Renewing IP (ifc=true)...{1}\n'.format(CYELLOW, CEND))
            sys.stdout.flush()
            wanInterfaceSessionKey = device.getWanInterfaceSessionKey()
            self.toggleEnableWanInterface(wanInterfaceSessionKey, 'true')

            exitLoopGetIp = False
            tryGetIpCount = 0
            while exitLoopGetIp == False:
                tryGetIpCount += 1
                time.sleep(1)
                newIp = self.getCurrentIp()
                sys.stdout.write('{0}[*] Current IP: {2}{1}\n'.format(CYELLOW, CEND, newIp))
                sys.stdout.flush()
                if newIp != 'N/A' or tryGetIpCount > 5:
                    exitLoopGetIp = True

            if newIp != currentIp and newIp != 'N/A':
                exitLoop = True


device = MitraStarDevice(host='192.168.10.1', username='support', password="krh15elx")

#while True:
#    print("Trying logging...")
#    if device.login() == True:
#        break
#    time.sleep(1)

while True:
    try:
        if device.hasChangedIp():
            break

        device.login()
        device.renewWanIp()
        break
    except Exception as e:
        sys.stdout.write('{0}[!] Error → {2}{1}\n'.format(CRED, CEND, e))
        sys.stdout.flush()
        time.sleep(1)

#Fdjiqjifj
#Fdjiqjifj
