# https://www.youtube.com/watch?v=FFDDN1C1MEQ - example video
# using PyCharm

# chrome webdriver - https://sites.google.com/a/chromium.org/chromedriver/downloads - ChromeDriver 2.46
# have Chrome 71

from selenium import webdriver
import time

driver = webdriver.Chrome()

driver.set_page_load_timeout(10)
driver.get("http://google.com")
driver.find_element_by_name("q").send_keys("Automation Step by Step")
driver.find_element_by_name("btnK").click()
time.sleep(4)
driver.quit()


x = range(6)

for n in x:
    print(n)