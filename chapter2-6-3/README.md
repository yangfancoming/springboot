
#   

    nginx + ssl 
    
    docker run -p 80:80 --name nginx  -p 443:443 
    -v /home/goat/nginx/cert:/etc/nginx/cert 
    -v /home/goat/nginx/conf/nginx.conf:/etc/nginx/nginx.conf 
    -v/home/goat/nginx/log:/var/log/nginx   4bb46517cac3（镜像id）

    
    将再阿里云 证书服务页面中下载的  nginx的证书下载 解压出现2个文件
    4486669_www.goatcoming.cn.pem;
    cert/4486669_www.goatcoming.cn.key;
    
    分别放在  /home/goat/nginx/cert 目录下 以便映射到 docker容器的/etc/nginx/cert  目录下




# 报错总结
    java.lang.IllegalArgumentException: Invalid character found in method name. HTTP method names must be tokens
    
    原因： 问题原因是 本来是http的请求，错误使用https方式请求，所以报该错误。
    解决： nginx 将https转成http 方式就可以了