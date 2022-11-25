#!python3
import time
from selenium.webdriver.firefox.options import Options
from selenium import webdriver
from selenium.webdriver.common.by import By
import pathlib
from datetime import datetime
import os


opt = webdriver.FirefoxOptions()
opt.add_argument("--headless")

def store_data(filename, data):
    with open(filename, 'a+') as f:
        for item in data:
            f.write('"' + item['number'] + '","' + item['spam_reason'] + '","' + item['comment'] + '","' + item['time'] + '"\n')

def scrap(filename, driver, start_at):
    data = []

    table = driver.find_element(by=By.ID, value="latestComments")
    rows = table.find_elements(By.TAG_NAME, "tr")

    print('Total ' + str(len(rows)) + '. Lets start at ' + str(start_at))

    rows_count = 0
    for row in rows:
        rows_count = rows_count + 1

        cols = row.find_elements(By.TAG_NAME, "td")
        if len(cols) < 1 or rows_count < start_at:
            continue

        number = cols[0].find_elements(by=By.CLASS_NAME, value="ai-phone")[0].text.strip()
        spam_reason = cols[0].find_elements(by=By.CLASS_NAME, value="ai-spam-reason")[0].text.strip()

        comment_mid = cols[1].find_elements(by=By.CLASS_NAME, value="ai-comment-mid-line")[0].text
        comment = cols[1].text.replace(comment_mid, '').strip().replace('"', '\\"')
        timestamp = cols[2].text.strip()

        data.append({"number": number, "spam_reason": spam_reason, "comment": comment, "comment_mid": comment_mid, "time": timestamp})

    store_data(filename, data)
    
    return rows_count + 1


def extractNumData(filename, refreshPage: int):
    telGuarderUrl = "https://www.telguarder.com/br"

    driver = webdriver.Firefox(options=opt)
    driver.get(telGuarderUrl)

    acceptCookie = driver.find_element(by=By.ID, value="didomi-notice-agree-button").click()
    try:
        start_at = 1
        for i in range(refreshPage):                        
            print("Clicking page " + str(i))
            button = driver.find_element(by=By.CLASS_NAME, value="ai-button-rounded")
            button.click()
            driver.implicitly_wait(1)            
            time.sleep(1)
            start_at = scrap(filename, driver, start_at)
    except:
        print("error on page. lets try renew ip")
        # driver.quit()
        renew_ip()
    
    driver.quit()

def renew_ip():
    path = os.path.abspath(pathlib.Path.joinpath(pathlib.Path(__file__).parent.resolve(), ".."))
    py = os.path.join(path, "renew_ip_modem__mitra.py")
    os.system('python3 ' + py)
    time.sleep(1)

if __name__ == "__main__":   
    filename = pathlib.Path(__file__).parent.resolve() 
    filename = pathlib.Path.joinpath(filename, "crawled")
    filename = pathlib.Path.joinpath(filename, datetime.now().strftime('%Y-%m-%d_%H-%M-%S.csv'))
    
    data = extractNumData(filename, 50000)
    # renew_ip()


   