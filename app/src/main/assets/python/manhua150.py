from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.chrome.options import Options
from bs4 import BeautifulSoup
import requests
import os
import time
from requests.adapters import HTTPAdapter
from urllib3.util.retry import Retry


GLOBAL_URL = "https://www.mhqwe.xyz/play?linkId=2224586&bookId=1497&path=4&key=Bo3cVVKXCPOfVwqmHPNt8g=="
GLOBAL_PAGE = 150

def create_directory(directory_path):
    # Check if the directory already exists
    if not os.path.exists(directory_path):
        # Create the directory
        os.makedirs(directory_path)
        print(f"Directory '{directory_path}' created successfully.")

def check_file_in_directory(directory_path, filename):
   # 获取目录中的所有文件
    files_in_directory = os.listdir(directory_path)

    # 检查文件是否在目录中
    return filename in files_in_directory

def get_folder_size(folder_path):
    total_size = 0
    for dirpath, dirnames, filenames in os.walk(folder_path):
        for filename in filenames:
            file_path = os.path.join(dirpath, filename)
            total_size += os.path.getsize(file_path)
    return total_size


def findUrlList(url:str,name:int):
    # 创建ChromeOptions对象
    chrome_options = Options()

    # 启用无界面模式
    chrome_options.add_argument('--headless')

    # 创建Chrome WebDriver，并传入ChromeOptions
    browser = webdriver.Chrome(options=chrome_options)

    print(f"第{str(name)}页 url {url} start")
    browser.get(url)
    try:
        # Set a WebDriverWait to wait for the alert to be present (adjust timeout as needed)
        wait = WebDriverWait(browser, 5)
        alert = wait.until(EC.alert_is_present())

            # Access the text of the alert
        alert_text = alert.text
        alert.accept()

        print(f"html parser start")

        soup = BeautifulSoup(browser.page_source, 'html.parser')
            # 查找 id 为 "imgList" 的 P 标签
        img_list_p = soup.find('p', {'id': 'imgList'})
        print(f"html parser end")
         # 提取 data-original 值
        if img_list_p:
            # 提取p标签内所有img标签的src属性
            img_sources = [img.get('data-original') or img.get('src') for img in img_list_p.find_all('img')]
            nameFloder = r"D:/Users/Desktop/python/manhua/" + str(name)
            create_directory(nameFloder)
            fileSize  = get_folder_size(nameFloder)
            if not fileSize == len(img_sources):
                for index, img_url in enumerate(img_sources):
                    print(f"img_url download {img_url}")
                    imageName = str(index)+".jpg"
                    if not check_file_in_directory(nameFloder, os.path.basename(imageName)):
                            # 重试次数
                            session = requests.Session()
                            retry = Retry(connect=3, backoff_factor=0.5)
                            adapter = HTTPAdapter(max_retries=retry)
                            session.mount('http://', adapter)
                            session.mount('https://', adapter)
                            response = session.get(img_url)
                            # response.raise_for_status()
                            print(f"img_url response {response} url {img_url}")
                            # Check if the request was successful (status code 200)
                            if response.status_code == 200:
                                    # Extract the file name from the URL
                                file_name = os.path.join(nameFloder, os.path.basename(imageName))
                                    # Save the image to the local folder
                                with open(file_name, 'wb') as file:
                                    file.write(response.content)
                                    response.close()
                            else:
                                print(f"Failed to download image. Status code: {response.status_code}")
                            # time.sleep(1)

        print(f"第{name} end")         
        wait.until(EC.presence_of_element_located((By.CLASS_NAME, 'button')))
        # Click the "下一話" button
        next_button = browser.find_element(By.XPATH,"//a[contains(text(), '下一話')]")
        next_button.click()
        GLOBAL_PAGE = name +1
        GLOBAL_URL = browser.current_url
        #递归
        findUrlList(GLOBAL_URL,GLOBAL_PAGE)
        # browser.quit()
    except requests.exceptions.ConnectionError as errc:
        print(f"Error Connecting: {errc}")
        # findUrlList(GLOBAL_URL,GLOBAL_PAGE)
findUrlList(GLOBAL_URL,GLOBAL_PAGE)