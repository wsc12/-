# encoding=utf-8
import re
import sys
import requests
reload(sys)
sys.setdefaultencoding('utf-8')
f=open('youku.txt','r')
data=f.read()
f.close()
#匹配图片网址
imgs_url = re.findall('<img class="quic" _src="(.*?)"', data, re.S)
i=1
for url in imgs_url:
    print url
    t=open('urls.txt','a+')
    t.write(url+"\n")
    t.close()


