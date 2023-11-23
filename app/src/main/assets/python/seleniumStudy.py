from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

browser = webdriver.Chrome()
browser.get("https://www.mhqwe.xyz/manhua/info/1497.html")
   
try:
    # Set a WebDriverWait to wait for the alert to be present (adjust timeout as needed)
    alert = WebDriverWait(browser, 10).until(EC.alert_is_present())

    # Access the text of the alert
    alert_text = alert.text
    # Handle the alert (you can accept, dismiss, or perform other actions)
    alert.accept()
    print(f"Alert accept: successful")
    buttons = browser.find_elements(By.CSS_SELECTOR,'.cell-type.xl4')
    for button in buttons:
        # 记录当前窗口的句柄
        current_window_handle = browser.current_window_handle
        
        button.click()
        
        # 等待新窗口出现（你可能需要根据实际情况调整等待时间）
        browser.implicitly_wait(10)
        
        # 获取所有窗口的句柄
        all_window_handles = browser.window_handles
        
        # 切换到新打开的窗口
        new_window_handle = [handle for handle in all_window_handles if handle != current_window_handle][0]
        browser.switch_to.window(new_window_handle)
        
        # 输出新页面的 URL
        new_page_url = browser.current_url
        print(f"The URL of the new page is: {new_page_url}")
        
        # 关闭新窗口
        browser.close()
        
        # 切换回原始窗口
        browser.switch_to.window(current_window_handle)
except Exception as e:
    # Handle other exceptions if needed
    print(f"Exception: {e}")
finally:
    # Close the browser window
    browser.quit()
