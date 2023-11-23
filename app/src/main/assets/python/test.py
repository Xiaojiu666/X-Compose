from bs4 import BeautifulSoup

html_doc = """
<p style="font-size: 0px;color: #5eb95e" id="imgList">
    <img src="https://4.static04mh.xyz/A/1497/l6M6mXLSyBChMdAeiv8Few==.jpg" width="100%">
    <br>
    <img src="https://4.static04mh.xyz/A/1497/PaqiWKuXeVsZqc8RipbbA==.jpg" width="100%">
    <br>
    <img src="https://4.static04mh.xyz/A/1497/MXklVY27kqfMcAEa02Efw==.jpg" width="100%">
    <br>
    <img class="lazy" src="/data/jzz.png" data-original="https://4.static04mh.xyz/A/1497/ji5EB1CWF1YrhKc4OxuGBQ==.jpg" width="100%">
    <br>
    <img class="lazy" src="/data/jzz.png" data-original="https://4.static04mh.xyz/A/1497/N7rA3XKstEOOqfYC9jR76A==.jpg" width="100%">
    <br>
</p>
"""

# 使用Beautiful Soup解析HTML文档
soup = BeautifulSoup(html_doc, 'html.parser')

# 找到id为"imgList"的p标签
img_list_p = soup.find('p', {'id': 'imgList'})

# 提取p标签内所有img标签的src属性
img_sources = [img.get('data-original') or img.get('src') for img in img_list_p.find_all('img')]


# 打印结果
print(img_sources)