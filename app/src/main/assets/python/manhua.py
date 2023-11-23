from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from bs4 import BeautifulSoup
import requests
import os
import time


url = "https://www.mhqwe.xyz/play?linkId=2224437&bookId=1497&path=4&key=/4HIxMMNmJkK469c10fZfQ=="

def create_directory(directory_path):
    # Check if the directory already exists
    if not os.path.exists(directory_path):
        # Create the directory
        os.makedirs(directory_path)
        print(f"Directory '{directory_path}' created successfully.")
    else:
        print(f"Directory '{directory_path}' already exists.")

def check_file_in_directory(directory_path, filename):
   # 获取目录中的所有文件
    files_in_directory = os.listdir(directory_path)

    # 检查文件是否在目录中
    return filename in files_in_directory

def findUrlList(url:str,name:int):
    print(f"第{str(name)}页 url {url} start")
    browser = webdriver.Chrome()
    browser.get(url)
    try:
        # Set a WebDriverWait to wait for the alert to be present (adjust timeout as needed)
        wait = WebDriverWait(browser, 10)
        alert = wait.until(EC.alert_is_present())

        # Access the text of the alert
        alert_text = alert.text
        # print(f"Alert text:\n {alert_text}")
        # Handle the alert (you can accept, dismiss, or perform other actions)
        alert.accept()
        soupLazy = BeautifulSoup(browser.page_source, 'html.parser')
                # 查找 id 为 "imgList" 的 P 标签
        img_list_p_soupLazy = soupLazy.find('p', {'id': 'imgList'})
        size = 5
        if img_list_p_soupLazy:
          img_tags_soupLazy = img_list_p_soupLazy.find_all('img')
          size = len(img_tags_soupLazy)
        # 如果找到了该 P 标签
        # 模拟滚动
        print("模拟滚动开始")
        for i in range(size):  # 滚动5次，你可以根据实际情况调整
            browser.find_element(By.TAG_NAME, 'body').send_keys(Keys.PAGE_DOWN)
            # browser.find_element(By.ID, 'body').send_keys(Keys.PAGE_DOWN)
            # time.sleep(1)  # 等待加载完成，你可以根据实际情况调整等待时间
        soup = BeautifulSoup(browser.page_source, 'html.parser')
            # 查找 id 为 "imgList" 的 P 标签
        img_list_p = soup.find('p', {'id': 'imgList'})
        print("模拟滚动结束")
        # 如果找到了该 P 标签
        if img_list_p:
            # 查找 P 标签中的所有 Img 标签
            img_tags = img_list_p.find_all('img')
            # 提取 Img 标签中的 URL 地址
            img_urls = [img['src'] for img in img_tags]
            # 打印所有 URL 地址
            nameFloder = r"D:/Users/Desktop/python/manhua/" + str(name)
            create_directory(nameFloder)
            for img_url in img_urls:
                if str(img_url).lower().startswith("https"):
                    print(f"img_url download {img_url}")
                    if not check_file_in_directory(nameFloder, os.path.basename(img_url)):
                        response = requests.get(img_url,timeout=10)
                        # Check if the request was successful (status code 200)
                        if response.status_code == 200:
                                # Extract the file name from the URL
                            file_name = os.path.join(nameFloder, os.path.basename(img_url))
                                # Save the image to the local folder
                            with open(file_name, 'wb') as file:
                                file.write(response.content)
                            time.sleep(1)
                        else:
                            print(f"Failed to download image. Status code: {response.status_code}")
        print(f"第{name} end")         
        wait.until(EC.presence_of_element_located((By.CLASS_NAME, 'button')))
        # Click the "下一話" button
        next_button = browser.find_element(By.XPATH,"//a[contains(text(), '下一話')]")
        next_button.click()
        next_page = name +1
        next_page_url = browser.current_url
        #递归
        findUrlList(next_page_url,next_page)
        # browser.quit()
    except Exception as e:
        # Handle other exceptions if needed
        print(f"Exception: {e}")
    finally:
        # Close the browser window
        browser.quit()

findUrlList(url,1)