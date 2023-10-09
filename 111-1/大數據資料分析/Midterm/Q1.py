import requests
from bs4 import BeautifulSoup

headers = {"User-Agent":"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.110 Safari/537.36 Edg/96.0.1054.57"}

url = 'https://zh.wikipedia.org/zh-tw/2019%E5%86%A0%E7%8B%80%E7%97%85%E6%AF%92%E7%97%85%E6%AD%BB%E4%BA%A1%E7%97%85%E4%BE%8B%E6%95%B8'

request = requests.get(url, headers=headers)
request.encoding = 'utf-8'

soup = BeautifulSoup(request.text, 'html.parser')


titles = soup.find_all('h2')

for title in titles:
    try:
        title = title.find('span', 'mw-headline').text
        print(title)
    except:
        continue