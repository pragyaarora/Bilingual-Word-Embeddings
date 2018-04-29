
# coding: utf-8

# In[ ]:

from bs4 import BeautifulSoup
import urllib.request


# In[ ]:

with urllib.request.urlopen("https://iu.wikipedia.org/w/index.php?title=Special:AllPages&hideredirects=1") as url:
    s = url.read()
soup = BeautifulSoup(s)
urls = [a_elem['href'] for a_elem in soup.findAll('a') if a_elem.attrs.get('href', '').startswith('/wiki/')]


# In[ ]:

urls


# In[ ]:

import os.path
base_url = 'https://iu.wikipedia.org'


# In[ ]:

for url in urls:
    name = 'C:/Users/pragya/cl2 project/wikipedia/'+url.split("/")[2]+".txt"
    file = open(name, 'w', encoding='utf-8')
    with urllib.request.urlopen(base_url+url) as url:
        data = url.read()
        soup = BeautifulSoup(data,"lxml")
        heading = soup.find_all("h1", class_="firstHeading")[0].text
        file.write(heading+'\n')
        content = soup.find_all("div", id="mw-content-text")[0].text.strip()
        content=content.replace('\n\n','')
        file.write(content+'\n')
        categories = soup.find_all("div", id="catlinks")[0].text.strip()
        file.write(categories)
        file.close()


# In[ ]:

len(urls)


# In[ ]:

for url in urls:
    name = 'C:/Users/pragya/cl2 project/wiki_eng/'+url.split("/")[2]+".txt"
    file = open(name, 'w', encoding='utf-8')
    try:
        url = urllib.request.urlopen('https://en.wikipedia.org'+url)
    except urllib.error.HTTPError as e:
        if e.getcode() == 404:
            continue
    data = url.read()
    soup = BeautifulSoup(data,"lxml")
    heading = soup.find_all("h1", class_="firstHeading")[0].text
    file.write(heading+'\n')
    content = soup.find_all("div", id="mw-content-text")[0].text.strip()
    content=content.replace('\n\n','')
    file.write(content+'\n')
    categories = soup.find_all("div", id="catlinks")[0].text.strip()
    file.write(categories)
    file.close()


# In[ ]:



