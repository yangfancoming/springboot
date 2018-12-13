 
 ### truelicense in springboot
 
 ### 生成密钥对
     
     1、首先要用KeyTool工具来生成私匙库：（-alias别名 –validity 3650表示10年有效
     keytool -genkeypair -alias privatekey -keysize 1024 -sigalg SHA1withDSA -keystore D:/privateKey.store -validity 180 -storetype pkcs12 -storepass init123
  
     2、然后把私匙库内的公匙导出到一个文件当中
     keytool -exportcert -alias privatekey -keystore D:/privateKey.store -storetype pkcs12 -file D:/certfile.cer -storepass init123
 
     3、然后再把这个证书文件导入到公匙库：
     keytool -importcert -alias publickey -file D:/certfile.cer -keystore D:/publicKey.store -storepass init123 
 
 一、原理说明
 首先生成密钥库（加密算法），通过公钥和私钥的匹配情况和授权文件的验证情况来判断是否已授权。需要重新授权的时候使用license可以避免修改源码，改动部署，授权方直接生成一个新的license发送给使用方替换掉原来的license文件即可。
 二、使用说明
 
       授权方：
       （1）使用keytool工具生成密钥对（公钥和私钥），私钥授权方保存，公钥给使用方。
       （2）创建.lic授权文件给使用方。
 
       使用方：
       （1）保存公钥
       （2）使用时加载.lic授权文件，验证。
