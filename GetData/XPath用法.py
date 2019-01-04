from lxml import  etree
f = open("youku.txt",'r')
html= f.read()
f.close()
select = etree.HTML(html)
content = select.xpath('//img[@class="quic"]/attribute::src')
for each in content:
    print each

