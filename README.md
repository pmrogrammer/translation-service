# translation-service
基于百度翻译API的一个springboot项目
默认端口8801
接口名为/json/translation
接受post和get请求
目前只支持汉译英

psot请求示例：
http://localhost:8801/json/translation   body里为要翻译的字词 如：我们的时代
返回{"from": "zh","to": "en","trans_result":[{"src": "我们的时代","dst": "Our time"}]}
       
get请求示例：
http://localhost:8801/json/translation?query=我
返回  {"from":"zh","to":"en","trans_result":[{"src":"\u6211","dst":"I"}]}

