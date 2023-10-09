import requests, csv
from bs4 import BeautifulSoup

headers = {"User-Agent":"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.110 Safari/537.36 Edg/96.0.1054.57"}


url = 'https://zh.wikipedia.org/zh-tw/2019%E5%86%A0%E7%8B%80%E7%97%85%E6%AF%92%E7%97%85%E6%AD%BB%E4%BA%A1%E7%97%85%E4%BE%8B%E6%95%B8'

request = requests.get(url, headers=headers)
request.encoding = 'utf-8'

soup = BeautifulSoup(request.text, 'html.parser')

table = soup.find('table', class_='wikitable sortable mw-datatable')

th, td = table.find_all('th'), table.find_all('td')

title = []
for t in th:
    title.append(t.text.replace('\xa0', '').replace('\n', ''))

main = []
this = []
for i, t in enumerate(td):
    if ((i % len(title)) == 0):
        main.append(this)
        this = [t.text.replace('\xa0', '').replace('\n', '')]
    else:
        t = t.text.replace('\xa0', '').replace('\n', '')

        if ('年' in t):
            t = t.split('0000')[-1]
        
        this.append(t)
main.append(this)
main = main[1:]

dead = {0: 0, 3000: 0, 5000: 0, 10000: 0}

for i in main[3:]:
    i = i[2:]

    for j in i:
        j = int(j.replace(',', ''))
        
        if (j >= 10000):
            dead[10000] += 1
        
        if (j >= 5000):
            dead[5000] += 1
        
        if (j >= 3000):
            dead[3000] += 1
        
        if (j == 0):
            dead[0] += 1

print(f'死亡人數為0人: {dead[0]}')
print(f'死亡人數超過3000人: {dead[3000]}')
print(f'死亡人數超過5000人: {dead[5000]}')
print(f'死亡人數超過10000人: {dead[10000]}')

with open('./result/wiki_table.csv', 'w', newline= '', encoding='UTF-8-Sig') as f:
    writer = csv.writer(f, delimiter=',')
    writer.writerow(title)
    writer.writerows(main)
