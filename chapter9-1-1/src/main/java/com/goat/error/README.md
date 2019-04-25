# 彻底解决mysql报错:1030, 'Got error 28 from storage engine'
    Filesystem      Size  Used Avail Use% Mounted on
    /dev/sda2       134G  127G     0 100% /
    tmpfs            16G     0   16G   0% /dev/shm
    /dev/sda1       388M   68M  301M  19% /boot

    原因： 这个问题确实是服务器系统盘满了,mysql指定的临时文件目录满掉,大概就是这个意思.
        