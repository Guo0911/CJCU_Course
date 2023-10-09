import requests, time, pymysql, random, bs4
from bs4 import BeautifulSoup

db_settings = {
    "host": "localhost",
    "port": 3306,
    "user": "user",
    "password": "password",
    "db": "db_name",
    "charset": "utf8"
}
db = pymysql.connect(**db_settings)
cursor = db.cursor()

headers = {"cookie": "over18=1",
"User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/107.0.0.0 Safari/537.36 Edg/107.0.1418.35"}

month = {'Jan': '01', 'Feb': '02', 'Mar': '03'
        ,'Apr': '04', 'May': '05', 'Jun': '06'
        ,'Jul': '07', 'Aug': '08', 'Sep': '09'
        ,'Oct': '10', 'Nov': '11', 'Dec': '12'}


def get_page(old_url:str, new_url:str):
    Kanban = ("".join(old_url.split('index')[:-1]) + 'index')
    page = int(new_url.replace(Kanban, '').replace('.html', ''))
    return Kanban, page+1


def get_soup(url):
    request = requests.get(url, headers=headers)
    request.encoding = 'utf-8'
    return BeautifulSoup(request.text, 'html.parser')


def pose_date_convert(date):
    date = date.split(' ')

    for m in month.keys():
        if (date[1] == m):
            new_time = month[m]
    
    new_time = f'{date[-1]}-{new_time}-{date[-3]} {date[-2]}'

    return new_time


url = input('請輸入批踢踢實業坊看板網址: ')
soup = get_soup(url)

last_page = soup.find_all(class_ = 'btn wide')[1]['href']
Kanban, page = get_page(url, f'https://www.ptt.cc{last_page}') # 看板連結和最後一頁數值

total_article = 0
error_article = 0
start_time = time.time()

datetime = '1970-01-01 00:00:00'
for p in range(page, 0, -1):
    print('---------------------------------------')
    print(f'目前爬蟲頁數: {p} / {page}')

    url = f'{Kanban}{p}.html'
    soup = get_soup(url)
    
    articles = soup.find_all(class_='r-ent')
    for article in articles:
        total_article += 1
        
        link = ''
        try:
            link = article.find(class_='title').find('a')['href']

            if ('https' not in link): # 連結內沒有前墜
                link = f'https://www.ptt.cc{link}'

            soup = get_soup(link)
            content = []
            main_content = soup.find(id='main-content')
            
            for c in main_content.contents:
                    if (type(c) == bs4.element.NavigableString):
                        content += c.split('\n')
        except: # if 文章不存在則會報錯
            error_article += 1

            author = article.find(class_='author').text
            title = article.find(class_='title').text
            content = ''

            author = author.replace('\\', '\\\\')
            title = title.replace('\\', '\\\\')
            
            cursor.execute(f"SELECT * FROM `article` WHERE `author` = '{author}' and `title` = '{title}' and `time` = '{datetime}' and `content` = '{content}' and `url` = '{link}'")
            if cursor.rowcount:
                continue

            end_time = time.time()
            execute_time = round((end_time - start_time), 4)
            cursor.execute(f"UPDATE `information` SET `run_time`={execute_time},`total`={total_article},`error`={error_article}")
            db.commit()

            cursor.execute(f"INSERT INTO `article`(`author`, `title`, `time`, `content`, `url`) VALUES ('{author}', '{title}', '{datetime}', '{content}', '{link}')")
            db.commit()
            continue
        
        try:
            header_of_article = soup.find_all(class_='article-metaline')
        except:
            header_of_article = []
        finally:
            try:
                author = header_of_article[0].find(class_='article-meta-value').text
                for w in ['\u3000', '\t', "'", '"']:
                    author = author.replace(w, '')
            except:
                author = 'undefined'
            
            try:
                title = header_of_article[1].find(class_='article-meta-value').text
                for w in ['\u3000', '\t', "'", '"']:
                    title = title.replace(w, '')
            except:
                title = 'undefined'
            
            try:
                datetime = pose_date_convert(header_of_article[2].find(class_='article-meta-value').text)
            except:
                datetime = datetime

        content = "\n".join([i for i in content if i != ''])
        for w in ['\u3000', '\t', "'", '"']:
            content = content.replace(w, '')

        author = author.replace('\\', '\\\\')
        title = title.replace('\\', '\\\\')
        content = content.replace('\\', '\\\\')
        
        cursor.execute(f"SELECT * FROM `article` WHERE `author` = '{author}' and `title` = '{title}' and `time` = '{datetime}' and `content` = '{content}' and `url` = '{link}'")
        if cursor.rowcount:
            continue

        end_time = time.time()
        execute_time = round((end_time - start_time), 4)
        cursor.execute(f"UPDATE `information` SET `run_time`={execute_time},`total`={total_article},`error`={error_article}")
        db.commit()

        cursor.execute(f"INSERT INTO `article`(`author`, `title`, `time`, `content`, `url`) VALUES ('{author}', '{title}', '{datetime}', '{content}', '{link}')")
        db.commit()

        id_ = cursor.lastrowid

        content_of_response = soup.find_all(class_='push')
        for cr in content_of_response:
            try:
                push_tag = cr.find(class_='push-tag').text.replace('\n', '').rstrip().lstrip()
                push_id = cr.find(class_='push-userid').text.replace('\n', '').rstrip().lstrip()
                push_content = cr.find(class_='push-content').text[1:].replace('\n', '').replace('\\', '\\\\').rstrip().lstrip()
                ip_datetime = cr.find(class_='push-ipdatetime').text.replace('\n', '').rstrip().lstrip()

                sql = f"INSERT INTO `comment`(`a_id`, `push-tag`, `push-userid`, `push-content`, `push-ipdatetime`) VALUES ('{id_}', '{push_tag}', '{push_id}', '{push_content}', '{ip_datetime}')"
                cursor.execute(sql)
                db.commit()
            except:
                continue

    end_time = time.time()
    execute_time = round((end_time - start_time), 4)

    print(f'總文章篇數: {total_article}, 已刪除篇數: {error_article}')
    print(f'每頁平均文章篇數: {round((total_article/(page-p+1)), 2)}')
    print(f'每頁平均刪除篇數: {round((error_article/(page-p+1)), 2)}')
    print(f'本次執行已經過約: {round(execute_time, 4)} 秒')
    print('---------------------------------------')

    time.sleep(random.uniform(0.1, 0.3))



print(f'執行時間: {execute_time}')