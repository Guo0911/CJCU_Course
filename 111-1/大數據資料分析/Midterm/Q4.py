import requests, csv
from bs4 import BeautifulSoup

headers = {"User-Agent":"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.110 Safari/537.36 Edg/96.0.1054.57"}

total = 0
newsSet = {}
date_title = []

def spider(url):
    try:
        global total
        request = requests.get(url, headers=headers)
        request.encoding = 'utf-8'

        soup = BeautifulSoup(request.text, 'html.parser')

        date = soup.find_all('div', 'col-sm-3 padded-tb5')
        title = soup.find_all('div', 'topic')

        for i, d in enumerate(date):
            total += 1
            if (d.text in newsSet):
                newsSet[d.text] += 1
            else:
                newsSet[d.text] = 1

            date_title.append([d.text, title[i].text])

    except:
        pass

for p in range(1, 41):
    spider(f'https://www.cjcu.edu.tw/tw/news.php?page_want={p}&newstype=NEWS')

year_total = {}
month_total = {}
for date in newsSet.keys():
    year, month, day = date.split('/')

    if (f'{year}年' in year_total):
        year_total[f'{year}年'] += newsSet[date]
    else:
        year_total[f'{year}年'] = newsSet[date]

    if (f'{year}年{month}月' in month_total):
        month_total[f'{year}年{month}月'] += newsSet[date]
    else:
        month_total[f'{year}年{month}月'] = newsSet[date]


print(f'總和: {total}')

for i in year_total:
    print(f'{i}: {year_total[i]}')

for i in month_total:
    print(f'{i}: {month_total[i]}')


with open('./result/news_table.csv', 'w', newline= '', encoding='UTF-8-Sig') as f:
    writer = csv.writer(f, delimiter=',')
    writer.writerows(date_title)
        