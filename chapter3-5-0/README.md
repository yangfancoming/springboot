 
 ### truelicense in springboot
 
 ### 生成密钥对
     
     1、首先要用KeyTool工具来生成私匙库：（-alias别名 –validity 3650表示10年有效
     keytool -genkeypair -alias privatekey -keysize 1024 -sigalg SHA1withDSA -keystore D:/privateKey.store -validity 180 -storetype pkcs12 -storepass init123
  
     2、然后把私匙库内的公匙导出到一个文件当中
     keytool -exportcert -alias privatekey -keystore D:/privateKey.store -storetype pkcs12 -file D:/certfile.cer -storepass init123
 
     3、然后再把这个证书文件导入到公匙库：
     keytool -importcert -alias publickey -file D:/certfile.cer -keystore D:/publicKey.store -storepass init123 
 
 
 
 keytool -genkeypair -alias "test1" -keyalg "RSA" -keystore "test.keystore"  
 创建一个别名为test1的证书，该证书存放在名为test.keystore的密钥库中，若test.keystore密钥库不存在则创建。
 参数说明：
 -validity：指定证书有效期(单位：天)
 -genkeypair：生成一对非对称密钥;
 -alias：  指定密钥对的别名，该别名是公开的;
 -keyalg： 指定加密算法，本例中的采用通用的RAS加密算法;
 -keystore:密钥库的路径及名称，不指定的话，默认在操作系统的用户目录下生成一个".keystore"的文件  也可以指定路径  c:/myPrivateKeyStore.keystore 
 -keysize：指定密钥长度 一般为 1024
 -dname：  CN=(名字与姓氏), OU=(组织单位名称), O=(组织名称), L=(城市或区域名称), ST=(州或省份名称), C=(单位的两字母国家代码)"
 -storepass：  指定密钥库的密码(获取keystore信息所需的密码)
 -keypass： 指定别名条目的密码(私钥的密码)
-list        显示密钥库中的证书信息      keytool -list -v -keystore 指定keystore -storepass 密码
-v           显示密钥库中的证书详细信息
-export      将别名指定的证书导出到文件  keytool -export -alias 需要导出的别名 -keystore 指定keystore -file 指定导出的证书位置及证书名称 -storepass 密码
-file        参数指定导出到文件的文件名
-delete      删除密钥库中某条目          keytool -delete -alias 指定需删除的别  -keystore 指定keystore  -storepass 密码
-printcert   查看导出的证书信息          keytool -printcert -file yushan.crt
-keypasswd   修改密钥库中指定条目口令    keytool -keypasswd -alias 需修改的别名 -keypass 旧密码 -new  新密码  -storepass keystore密码  -keystore sage
-storepasswd 修改keystore口令      keytool -storepasswd -keystore e:/yushan.keystore(需修改口令的keystore) -storepass 123456(原始密码) -new yushan(新密码)
-import      将已签名数字证书导入密钥库  keytool -import -alias 指定导入条目的别名 -keystore 指定keystore -file 需导入的证书
 
###  storepass keypass  必须一致！！！
###  storepass keypass  密码 必须 6位以上 字母和数字混合！！！
 # keytool -genkeypair -validity 100 -keysize 1024 -alias goattest -keyalg RSA  -keystore D:/myPrivateKeyStore.keystore -dname CN=(SS),OU=(SS),O=(SS),L=(BJ),ST=(BJ),C=(CN) -storepass goat1234 -keypass goat1234 -v 
         正在为以下对象生成 1,024 位RSA密钥对和自签名证书 (SHA256withRSA) (有效期为 100 天):
                  CN=(SS), OU=(SS), O=(SS), L=(BJ), ST=(BJ), C=(CN)
         [正在存储D:/myPrivateKeyStore.keystore]


    {
        "subject": "license_demo",
        "privateAlias": "privateKey",
        "keyPass": "private_password1234",
        "storePass": "public_password1234",
        "licensePath": "C:/Users/zifangsky/Desktop/license_demo/license.lic",
        "privateKeysStorePath": "E:/Code/License/Github/myPrivateKeyStore.keystore",
        "issuedTime": "2018-07-10 00:00:01",
        "expiryTime": "2019-12-31 23:59:59",
        "consumerType": "User",
        "consumerAmount": 1,
        "description": "这是证书描述信息",
        "licenseCheckModel": {
            "ipAddress": ["192.168.245.1", "10.0.5.22"],
            "macAddress": ["00-50-56-C0-00-01", "50-7B-9D-F9-18-41"],
            "cpuSerial": "BFEBFBFF000406E3",
            "mainBoardSerial": "L1HF65E00X9"
        }
    }