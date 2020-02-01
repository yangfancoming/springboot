# IDEA 创建文件后 是否添加到 git  配置：version control --- confirmation ---- Add silently 创建文件自动add 到暂存区

# git 中 文件的三种状态 
    1.已修改 (文件呈蓝色)
    2.已暂存 (文件呈绿色)   
    3.已提交 (文件呈无色)

    对应三种工作区：
    工作区---暂存区---本地库
    
    工作区：就是项目的目录
    暂存区：又叫stage/index 一般在 .git目录下 就是我们计划要提交的文件
    本地库：也在 .git 目录下
    
    流程： 
    在工作区写代码 ---add--- 到暂存区临时存储 ----commit---  本地库 ----push---- 远程库
    
    git init   初始化 本地库 Initialized empty Git repository in E:/Git/mygit/.git/
    执行 init命令后 自动生成一个 .git的文件夹 包含默认：master 分支
    
    touch text.txt 新建文件  并 创建默认master分支 
    
    git add 命令：    新建的文件text.txt（进入工作区） 再IDEA中文件名显示红色  命令行输入 git add text.txt 命令后  文件名变成绿色 （将该文件添加到暂存区）
    git add .  该条命令会把 当前目录及其子目录下所有的文件都添加到暂存区
    git add *.html  //添加一类文件
    
    git rm --cached 命令： 用于将暂存区的文件恢复到工作区
    git rm --cached 命令： 将绿色的缓冲区文件从暂存区移回到工作区，文件名变成红色   对应 IDEA revert 功能
    
    git rm ： 命令用于从工作区和暂存区中删除文件 
    git rm 222.txt  文件被commit变成无色后  要想删除 该文件使用 git rm  命令 物理文件也会被删除  对应 IDEA 删除  功能
        
    git commit 命令： 将所有暂存区中(绿色)的文件 提交到本地库中 颜色由绿色变成无色  对应 IDEA commit  功能
    git commit -m '我是注释'  （这样就可以不用进入到编辑页面了）
    git commit --amend -m '修改注释' doit ???

    解决问题： 当使用 .gitignore 时候 发现某文件 已经在暂存区(文件呈绿色) 在提交时候 还是会出现在 提交框中 这时就需要使用 git rm --cached 命令
    将该文件从 暂存区中删除 后   再次提交就不会出现在 提交框中了 
    
    git checkout -- 123.txt  撤销本次所有修改： 对应 IDEA revert 功能

    git mv 222.txt 211.txt  将222.txt文件名 改成 211.txt   文件重命名的 命令
    
    查看远程库信息：
    git remote -v

    连接远程仓库：其中 origin 为远程仓库名
    git remote add origin goat@47.98.148.84:/srv/goat-test.git 
    
    提交远程仓库：其中 origin 为远程仓库名  mater 为要提交到的分支
    git push -u origin mater 
    
# 设置 git 用户名和 email 
    1.全局方式  优先级低  ~/.gitconfig  很常用 对于没有使用局部方式指定特定项目的其他项目/新建项目 默认都是使用的全局方式显示 
    git config --global user.name 'goat'
    git config --global user.name 'fan.yang'
    git config --global user.name 'yangfan'
    git config --global user.email '642744551@qq.com'
    
    2.局部方式  优先级高  .git/config  针对于特定的项目 
    git config --local user.name 'fan.yang'
    git config --local user.name 'yangfan'
    git config --local user.name 'test1'
    git config --local user.email '642744551@qq.com'

    查看 用户名和email   
    git config user.name
    git config user.email
    
# 取消版本控制 命令  单个文件
     git add 123.log
     git rm --cached 123.log
     git rm --cached compiler.xml
     git rm --cached encodings.xml
     git rm --cached .gitignore
# 取消版本控制 命令  目录
    git rm --cached E:\demo\.idea -r 
     
# 创建和 删除 分支
    git branch -a   查看所有分支
    git branch devMy   # 创建一个新分支
    git checkout devMy  # 切换到新分支
    或者 git checkout -b devMy   # 创建并切换分支
    git branch -d devMy  删除分支 
    合并分支：
    git merge devMy # 表示将devMy分支合并到当前所在分支
    
    git checkout master  切换回主分支前 必须要提交所有暂存区的文件后 才能实现切换
    
    
    删除远程分支：
    $ git push origin -d devMy
    
#  分支与HEAD  
    master、devMy等分支 指向最后一次提交
    HEAD 是指向分支的指针， 当前切换到哪条分支就指向哪条分支
    查看当前HEAD指向哪个分支命令：
     git symbolic-ref HEAD
    
# 合并某分支到当前分支：git merge <name>
    git merge master
    
    将develop分支合并到feature分支最简单的办法就是用下面这些命令：
    方式一：
    git checkout feature
    git merge develop 
    方式二： 你也可以把它们压缩在一行里。(个人还是喜欢上面的写法)
    git merge develop feature
    
    git merge master lampbelt  将master分支 合并到 lampbelt分支
    
#    sos 切记 合并分支后 是合并在你本地的  必须要 push 到对应远程分支后 其他同事才能看到并拉取代码！！！


#  Filename too long unable to index file   即 git for windows下的Filename too long

    git有可以创建4096长度的文件名，然而在windows最多是260，因为git用了旧版本的windows api，为此踩了个坑。
    解决方法： 点击IDEA  Terminal  输入 git config --global core.longpaths true  后  在 右键git---> add  
    就不会再报错 Filename too long unable to index file 了 
    
#  GitHub  我提交了commit，但为什么我没有出现在贡献者列表中呢？
    有两个原因：
    1. 检查你的commit中的邮箱信息，这个邮箱必须和你的github.com账号关联。怎么关联邮箱账号呢。先选择Account Setting, 在左边先Emails，
        于是就看到可以verify邮箱地址的页面了。关联邮箱地址后还有过一段时间，贡献者列表才会更新。
    2. 你的commit必须被提交到工程的默认分支上。如果提交到其它的分支上，你的名字就不会被显示。
    
    
    
    
# IDEA 本地项目 上传到 远程git仓库  注意：不是GitHub
        复制粘贴出已经Git控制的项目文件夹  然后将新项目文件夹中的.git隐藏文件夹删除掉 (干掉版本控制)
        
        然后 VCS --- import into version Control --- Create Git Resiptory 
        然后 设置 远程分支 VCS ---  Git --- Remotes  输入 git url 
        
        IDEA push 后报错
       报错： Push rejected: Push to origin/master was rejected 
       
       切换到自己项目所在的目录 (.git 所在目录)，右键选择GIT BASH Here
       在terminl窗口中依次输入命令：
       git pull
       git pull origin master
       git pull origin master --allow-unrelated-histories
       在idea中重新push自己的项目，即可成功push。
       
       IDEA  pull 拉取代码报错后
       VCS ---  Git --- pull  弹出框中 点击刷新分支按钮后  打钩刷新出的分支 再pull拉取代码 就可以了
       
#  git 中央服务器仓库搭建
    第一步：  用户操作
        1.添加 用户
        adduser goat
        2.添加密码
        passwd goat   后输入两次密码
        3.添加用户组
        groupadd goat 
        4.添加指定用户到指定组  第一个goat为用户 第二个goat为组
        usermod -G goat goat
        
        
    第二步：  创建git仓库
        切换/新建 仓库目录 srv
        再 srv目录下  继续创建   mkdir goat-test.git 
        继续进入 cd goat-test.git/  后 
        输入 git init --bare 创建仓库  bare指定创建裸仓库（没有工作区）
        为goat用户 修改权限
        chown -R goat:goat /srv/goat-test.git 

        
      第三步： 注意 @ 符号前的 goat 指的是账号  就是 第二步为 goat用户 修改权限的那个账号！！！
      再本地 通过IDEA git下载项目 
        goat@47.98.148.84:/srv/goat-test.git
        输入密码 12345 即可down项目了
         
#  GitHub 强制删除 某一次提交历史 
    git reset --hard 6dc42554076ec85655109bd45b136fec5af0cd8c
    git push origin HEAD --force    
    
    git reset --hard 70c590d7e5e181fe5728827f2782eab292592077
    git push origin HEAD --force
        