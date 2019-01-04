# encoding='utf-8'
import re
import requests
import sys
reload(sys)
sys.setdefaultencoding('utf-8')
headers = {
        "User-Agent":"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.106 Safari/537.36"
}
data = {
    kw:222
}
url= "http://list.youku.com/category/show/c_97.html?spm=a2ha1.12325017.m_2544.5~1~3!6~8~A"
html=requests.get(url,headers=headers)  #参数 url   data   header
print html.text
with open('youku.txt','w') as f:
    f.write(html.text)
    f.close()


