#安装vsftpd服务
yum install vsftpd -y
#设置开机自启动
systemctl enable vsftpd

#重启FTP服务
systemctl restart vsftpd
#查看FTP服务监听的端口
netstat -anpt |grep ftp


systemctl stop firewalld



# (在进行文件传输之前，我们需要创建一个用于登录FTP服务器的用户。执行以下命令以创建一个名为ftpuser的用户，并设置密码：)

 useradd -m ftpuser
 passwd ftpuser
 输入 jwfl724168

user_list 文件中增加  一行  ftpuser
[//]: # ( chown -R ftpuser:ftpuser /var/ftp)
[//]: # ( chown R 755 ftpuser:ftpuser /var/ftp)

# 报错 Job for vsftpd.service failed because the control process exited with error code. See "systemctl status vsftpd.service" and "journalctl -xe" for details.
因为 配置/etc/vsftpd/vsftpd.conf有问题。


 # (yum -y install ftp lftp)



#  报错 (500 OOPS: cannot change directory:/var/ftp  # 添加)
