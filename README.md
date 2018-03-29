[![Build Status](https://travis-ci.org/petterobam/my-html2file.svg?branch=master)](https://travis-ci.org/petterobam/my-html2file)
[![MIT Licence](https://badges.frapsoft.com/os/mit/mit.svg?v=103)](https://opensource.org/licenses/mit-license.php)
[![stable](http://badges.github.io/stability-badges/dist/stable.svg)](http://github.com/badges/stability-badges)

# my-html2file
自己用java写文档转化生成果然有很多弊端和不兼容的地方，而一些开源插件转这些东西还是效果蛮不错，于是心生收集各种插件（兼容windows和linux）并封装成服务的想法。

这里我将收集一系列html转文档的开源插件，做成html页面转文件的微服务集成Web应用，预计包含：

1. 网页转PDF
2. 网页转图片
3. 网页转TEXT
4. 网页转WORD
5. 网页转markdown
6. 网页转......

# 目前支持

![演示图片](docs/images/my-html2file.gif)

1. 网页转PDF（[wkhtml2pdf插件](https://wkhtmltopdf.org)）

    - 例如：http://localhost:7800/html2pdf?pageUrl=https://wkhtmltopdf.org
    
2. 网页转图片（[wkhtml2pdf插件](https://wkhtmltopdf.org)）

    - 例如：http://localhost:7800/html2image?pageUrl=https://wkhtmltopdf.org&fileExt=[可为空|默认 ```.png```]

3. 网页转Markdown（参用[jHTML2Md](https://github.com/pnikosis/jHTML2Md)）

    - 例如：http://localhost:7800/html2markdown?pageUrl=http://jsoup.org
    
# 服务部署

服务开箱即用，Maven已经配好发布过程，install后将 ```dist``` 内的文件夹复制到服务器，将进入到 ```bin/``` 文件夹下面

1. linux系统

```
chmod +x my-html2file.sh  #授权脚本
sh my-html2file.sh start  #启动服务
sh my-html2file.sh stop   #停止服务
sh my-html2file.sh reload #重启服务
sh my-html2file.sh status #状态查看
sh my-html2file.sh log    #日志查看
```

2. windows系统
    
直接双击 ```my-html2file.bat``` 文件即可，也可以将该文件注册成服务，在服务管理里面启动。
    
