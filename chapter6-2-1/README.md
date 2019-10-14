
# org.springframework.mail.MailAuthenticationException: Authentication failed; nested exception is javax.mail.AuthenticationFailedException: 535 Error: authentication failed


# Caused by: javax.mail.AuthenticationFailedException: 535 Error: authentication failed

#  goat  JrkAFj9BcKE43KtS
     fan.yang@sim.com
     201907@Jul
     
# javax.mail.NoSuchProviderException: invalid provider     
    是由于  邮箱协议设置错误：
        spring.mail.protocol=smtp
        #spring.mail.protocol=imap
        #spring.mail.protocol=pop3
        
# 535 Error:ÇëÊ¹ÓÃÊÚÈ¨ÂëµÇÂ¼¡£ÏêÇéÇë¿´http://service.mail.qq.com/cgi-bin/help?subtype=1&&id=28&&no=1001256
        这是因为你的fromEmail（发件人）和tran.connect（邮件发送对象）使用的邮箱不一致，解决办法:保持一致
    使用163的服务  spring.mail.host=smtp.163.com
    却使用了 qq的用户发送  spring.mail.username=642744551@qq.com