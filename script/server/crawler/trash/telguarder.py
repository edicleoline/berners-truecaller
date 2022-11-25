#!python3
import time
from selenium.webdriver.firefox.options import Options
from selenium import webdriver
from selenium.webdriver.common.by import By
import pandas as pd
import json


opt = webdriver.FirefoxOptions()
opt.add_argument("--headless")

def extractNumData(refreshPage: int):
    telGuarderUrl = "https://www.telguarder.com/br"

    driver = webdriver.Firefox(options=opt)
    driver.get(telGuarderUrl)

    acceptCookie = driver.find_element(by=By.ID, value="didomi-notice-agree-button").click()
    try:
        for i in range(refreshPage):
            button = driver.find_element(by=By.CLASS_NAME, value="ai-button-rounded")
            button.click()
            driver.implicitly_wait(1)
    except:
        print("non trovato")
        driver.quit()


    #telephone numbers extraction#
    numbers = []
    telephonesNumbers = driver.find_elements(by=By.CLASS_NAME, value="ai-phone")#margin-2
    for number in telephonesNumbers:
        if number.text != '':
            numbers.append(number.text)
    del numbers[-20:]

    #comments extractions
    comments = []
    numComments = driver.find_elements(by=By.CLASS_NAME, value="ai-column-comment")
    for comment in numComments:
        if comment.text != '':
            comments.append(comment.text)

    spamReasons = []
    numSpamReasons = driver.find_elements(by=By.CLASS_NAME, value="ai-spam-reason")
    for spamReason in numSpamReasons:
        if spamReason.text != '':
            spamReasons.append(spamReason.text)

    timestamps = []
    numTimestamps = driver.find_elements(by=By.CLASS_NAME, value="ai-column-timestamp")
    for timestamp in numTimestamps:
        if timestamp.text != '':
            timestamps.append(timestamp.text)


    #BUILDING RELATIONSHIP NUMBER-COMMENT
    numCom = []
    for i in range(len(numbers)):
        numCom.append([numbers[i],spamReasons[i],comments[i],timestamps[i]])
    driver.quit()
    return numCom

def extractNum(refreshPage: int):
    telGuarderUrl = "https://www.telguarder.com/br"

    #starting telguarder site wait 1 second#
    driver = webdriver.Firefox(options=opt)
    driver.get(telGuarderUrl)


    #accept cookie#
    acceptCookie = driver.find_element(by=By.ID, value="didomi-notice-agree-button").click()
    try:
        for i in range(refreshPage):
            button = driver.find_element(by=By.CLASS_NAME, value="ai-button-rounded")
            button.click()
            driver.implicitly_wait(1)
    except:
        print("non trovato")
        driver.quit()


    #telephone numbers extraction#
    numbers = []
    telephonesNumbers = driver.find_elements(by=By.CLASS_NAME, value="ai-phone")#margin-2
    for number in telephonesNumbers:
        if number.text != '':
            numbers.append(number.text)
    del numbers[-20:]
    driver.quit()
    return numbers

if __name__ == "__main__":
    
    data = extractNumData(1)
    # df = pd.DataFrame(data, columns=['Number', 'Comment', 'Score', 'Type', 'Organization', 'Source'])
    df = pd.DataFrame(data, columns=['number', 'spam_reason', 'comment', 'timestamp'])
    # print()
    data = df.to_json()
    with open('/home/berners/Documents/dev/web/truecaller/scrapper/data.json', 'w', encoding='utf-8') as f:
        f.write(data)
        # json.dump(data, f, ensure_ascii=False, indent=4)
   