 
 ### truelicense in springboot
 
 ### 生成密钥对
     
     1、首先要用KeyTool工具来生成私匙库：（-alias别名 –validity 3650表示10年有效）
     C:\Program Files\Java\jre1.8.0_60\bin
     keytool -genkeypair -alias privatekey -keysize 1024 -sigalg SHA1withDSA -keystore D:/privateKey.store -validity 180 -storetype pkcs12 -storepass init123
  
     2、然后把私匙库内的公匙导出到一个文件当中
     keytool -exportcert -alias privatekey -keystore D:/privateKey.store -storetype pkcs12 -file D:/certfile.cer -storepass init123
 
     3、然后再把这个证书文件导入到公匙库：
     keytool -importcert -alias publickey -file D:/certfile.cer -keystore D:/publicKey.store -storepass init123 
     keytool -import -alias certificatekey -file E:/zhongruan/企税银/辽宁工行/ICBC_LN.cer -keystore E:/zhongruan/企税银/辽宁工行/ICBC_LN.jks
     一、原理说明
     首先生成密钥库（加密算法），通过公钥和私钥的匹配情况和授权文件的验证情况来判断是否已授权。需要重新授权的时候使用license可以避免修改源码，改动部署，授权方直接生成一个新的license发送给使用方替换掉原来的license文件即可。
     二、使用说明
     
           授权方：
           （1）使用keytool工具生成密钥对（公钥和私钥），私钥授权方保存，公钥给使用方。
           （2）创建.lic授权文件给使用方。
     
           使用方：
           （1）保存公钥
           （2）使用时加载.lic授权文件，验证。



#使用JDK自带的 KEYTOOL 工具生成公私钥证书库：
##假如我们设置公钥库密码为： public_password1234 ，私钥库密码为： private_password1234 ，则生成命令如下：

#生成命令
    keytool -genkeypair -keysize 1024 -validity 3650 -alias "privateKey" -keystore "privateKeys.keystore" -storepass "public_password1234" -keypass "private_password1234" -dname "CN=localhost, OU=localhost, O=localhost, L=SH, ST=SH, C=CN"

#导出命令
    keytool -exportcert -alias "privateKey" -keystore "privateKeys.keystore" -storepass "public_password1234" -file "certfile.cer"

#导入命令
    keytool -import -alias "publicCert" -file "certfile.cer" -keystore "publicCerts.keystore" -storepass "public_password1234"

    上述命令执行完成之后，会在当前路径下生成三个文件，分别是：privateKeys.keystore、publicCerts.keystore、certfile.cer。 
    其中文件certfile.cer不再需要可以删除，文件privateKeys.keystore用于当前的 ServerDemo 项目给客户生成license文件，
    而文件publicCerts.keystore则随应用代码部署到客户服务器，用户解密license文件并校验其许可信息 。
    
    
# create 项目运行 生成 licens.lic  文件 在 springboot 总项目的 根目录下！！！