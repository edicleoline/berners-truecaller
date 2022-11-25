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
            print("Clicking page " + str(i))
            button = driver.find_element(by=By.CLASS_NAME, value="ai-button-rounded")
            button.click()
            driver.implicitly_wait(1)
    except:
        print("non trovato")
        driver.quit()

    time.sleep(3)
    data = []

    table = driver.find_element(by=By.ID, value="latestComments")
    rows = table.find_elements(By.TAG_NAME, "tr")

    print('Lets scrap ' + str(len(rows) - 1) + ' rows')

    for row in rows:
        cols = row.find_elements(By.TAG_NAME, "td")
        if len(cols) < 1:
            continue

        number = cols[0].find_elements(by=By.CLASS_NAME, value="ai-phone")[0].text.strip()
        spam_reason = cols[0].find_elements(by=By.CLASS_NAME, value="ai-spam-reason")[0].text.strip()

        comment_mid = cols[1].find_elements(by=By.CLASS_NAME, value="ai-comment-mid-line")[0].text
        comment = cols[1].text.replace(comment_mid, '').strip()
        timestamp = cols[2].text.strip()

        data.append({"number": number, "spam_reason": spam_reason, "comment": comment, "comment_mid": comment_mid, "time": timestamp})

    
    driver.quit()
    return data   

if __name__ == "__main__":
    
    data = extractNumData(3)    
    
    with open('/home/berners/Documents/dev/web/truecaller/scrapper/data2.json', 'w', encoding='utf-8') as f:
        f.write(json.dumps(data))
   