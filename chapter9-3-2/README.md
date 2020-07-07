# hessian 请求报错： expected integer at 0x53 java.lang.String  
    原因： 客户端使用版本 和 服务器端使用版本 不兼容导致的
             客户端版本  4.0.63  服务器版本 3.1.6     客户端请求服务器就会导致这样的报错
    解决： 将版本改成一致的就可以了
    