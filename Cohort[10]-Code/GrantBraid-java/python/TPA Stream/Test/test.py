# https://www.youtube.com/watch?v=FFDDN1C1MEQ - example video
# using PyCharm

# chrome webdriver - https://sites.google.com/a/chromium.org/chromedriver/downloads - ChromeDriver 2.46
# have Chrome 71

# HTML parsing - BeautifulSoup4 - https://stackoverflow.com/questions/13960326/how-can-i-parse-a-website-using-selenium-and-beautifulsoup-in-python

#pip install selenium
#pip install beautifulsoup4 - this one was already installed

from selenium import webdriver
import time
from selenium.webdriver.common.keys import Keys
from bs4 import BeautifulSoup
import csv



def main():

    #change this for correct writing to csv file
    numberOfColumns = 3

    # Created a new directory in folder for chrome driver and got its path
    driver = webdriver.Chrome("/Users/grantbraid/workspace/GrantBraid-java/python/TPA Stream/Drivers/chromedriver")
    isCorrectPage = True

    driver.set_page_load_timeout(10)

    # will keep looping until the page displays the login page
    while isCorrectPage:
        driver.get("http://www.montmere.com/test.php")
        html = driver.page_source
        soup = BeautifulSoup(html)
        header = soup.find('h1')
        if header:
            isCorrectPage = False


    #enter in the correct username and password and enter
    driver.find_element_by_name("username").send_keys("test")
    driver.find_element_by_name("password").send_keys("test")
    driver.find_element_by_name("password").send_keys(Keys.ENTER)

    # gather new html and information for page
    html = driver.page_source
    soup = BeautifulSoup(html)
    table = soup.find("table", {"id": "the-table"})
    tableInfo= soup.find_all("td")

    # If there is no td tags refresh page till there is and gather info
    if not tableInfo:
       while not tableInfo:
            driver.refresh()
            driver.find_element_by_tag_name("body").send_keys(Keys.ENTER)
            time.sleep(4)
            html = driver.page_source
            soup = BeautifulSoup(html)
            table = soup.find("table", {"id": "the-table"})
            tableHead = soup.findAll("th")
            tableInfo = soup.findAll("td")

    #set up csv file
    download_dir = "testCSV.csv"
    csv = open(download_dir, "w")
    infoFinal = []

    #get info without the tags add to infoFinal
    for info in tableInfo:
        info = str(info)[4:]
        info = info.replace("</td>","")
        infoFinal.append(info)

    #get the header info and get rid of tags and write to csv
    for header in tableHead:
        header = str(header)[4:]
        header = header.replace("</th>","")
        csv.write(header+", ")

    csv.write("\n")
    count = 0

    #write the table info insert newline after the proper number of columns of info
    for info in infoFinal:
        if count % numberOfColumns == 0 and count > 0:
            csv.write("\n")

        csv.write(info+", ")
        count += 1

    driver.quit()



if __name__ == '__main__':
    main()


# Scrapped code

#would be in line 52 - performs the same exact thing repetitive
    #loop through to determine if the table is currently loaded or not
    #if not reset the page and gather info again
#    while True:
#        if not table or ("You've been randomly selected to" in table):
#            driver.refresh()
#            html = driver.page_source()
#            soup = BeautifulSoup(html)
#            table = soup.find("table", {"id": "the-table"})
#        else:
           # driver.quit()
           # main()
#            break


    #Wait 4 seconds for the page to load and gather the correct info
#    html = driver.page_source
#    soup = BeautifulSoup(html)
#    table = soup.find("table", {"id": "the-table"})
#    tableHead = soup.findAll("th")
#    tableInfo = soup.findAll("td")