from click import style
import requests, csv
from bs4 import BeautifulSoup

headers = {"User-Agent":"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.110 Safari/537.36 Edg/96.0.1054.57"}

url = 'https://zh.wikipedia.org/wiki/2019%E5%86%A0%E7%8B%80%E7%97%85%E6%AF%92%E7%97%85%E5%85%A8%E7%90%83%E5%90%84%E5%9C%B0%E7%96%AB%E6%83%85'

request = requests.get(url, headers=headers)
request.encoding = 'utf-8'

soup = BeautifulSoup(request.text, 'html.parser')

img_div = soup.find_all('div', style='margin:0px auto;')

for i, div in enumerate(img_div):
    link = div.find('a')['href']
    if (link.split('.')[-1] != 'svg'):
        url = f'https://zh.wikipedia.org/{link}'

        request = requests.get(url, headers=headers)
        request.encoding = 'utf-8'
        soup = BeautifulSoup(request.text, 'html.parser')

        file_name = link.split(':')[-1].replace('_', ' ')

        image_link = soup.find('a', 'internal')['href']

        image = requests.get(f'http:{image_link}')

        print(f'https://zh.wikipedia.org/{link}')
        print(f'http:{image_link}')

        with open("result/image/" + file_name, "wb") as file:
            file.write(image.content)
