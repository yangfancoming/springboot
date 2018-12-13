 
 ### truelicense in springboot
 
 ### 生成密钥对
     
     1、首先要用KeyTool工具来生成私匙库：（-alias别名 –validity 3650表示10年有效
     keytool -genkeypair -alias privatekey -keysize 1024 -sigalg SHA1withDSA -keystore D:/privateKey.store -validity 180 -storetype pkcs12 -storepass init123
  
     2、然后把私匙库内的公匙导出到一个文件当中
     keytool -exportcert -alias privatekey -keystore D:/privateKey.store -storetype pkcs12 -file D:/certfile.cer -storepass init123
 
     3、然后再把这个证书文件导入到公匙库：
     keytool -importcert -alias publickey -file D:/certfile.cer -keystore D:/publicKey.store -storepass init123 
 
 