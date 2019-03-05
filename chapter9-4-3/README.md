docker-compose 
主要用于： 快速部署分布式应用

我们知道使用一个 Dockerfile 模板文件，可以让用户很方便的定义一个单独的应用容器。
然而，在日常工作中，经常会碰到需要多个容器相互配合来完成某项任务的情况。
例如要实现一个 Web 项目，除了 Web 服务容器本身，往往还需要再加上后端的数据库服务容器，甚至还包括负载均衡容器等。
Compose 恰好满足了这样的需求。它允许用户通过一个单独的 docker-compose.yml 模板文件（YAML 格式）来定义一组相关联的应用容器为一个项目

Compose 的默认管理对象是项目，通过子命令对项目中的一组容器进行便捷地生命周期管理。

服务 (service)：一个应用的容器，实际上可以包括若干运行相同镜像的容器实例。
项目 (project)：由一组关联的应用容器组成的一个完整业务单元，在 docker-compose.yml 文件中定义。

docker-compose 常用命令：
build 构建或重建服务
help 命令帮助
kill 杀掉容器
logs 显示容器的输出内容
port 打印绑定的开放端口
ps 显示容器
pull 拉取服务镜像
restart 重启服务
rm 删除停止的容器
run 运行一个一次性命令
scale 设置服务的容器数目
start 开启服务
stop 停止服务
up 创建并启动容器




docker-compose 需要注意的
我根据我自己的体验，给出几点需要注意的

不要把 docker 当做数据容器来使用，数据一定要用 volumes 放在容器外面
不要把 docker-compose 文件暴露给别人， 因为上面有你的服务器信息
多用 docker-compose 的命令去操作， 不要用 docker 手动命令&docker-compose 去同时操作
写一个脚本类的东西，自动备份docker 映射出来的数据。
不要把所有服务都放在一个 docker 容器里面



#查看帮助
docker-compose -h

# -f  指定使用的 Compose 模板文件，默认为 docker-compose.yml，可以多次指定。
docker-compose -f docker-compose.yml up -d 

#启动所有容器，-d 将会在后台启动并运行所有的容器
docker-compose up -d

#停用移除所有容器以及网络相关
docker-compose down

#查看服务容器的输出
docker-compose logs

#列出项目中目前的所有容器
docker-compose ps

#构建（重新构建）项目中的服务容器。服务容器一旦构建后，将会带上一个标记名，例如对于 web 项目中的一个 db 容器，可能是 web_db。可以随时在项目目录下运行 docker-compose build 来重新构建服务
docker-compose build

#拉取服务依赖的镜像
docker-compose pull

#重启项目中的服务
docker-compose restart

#删除所有（停止状态的）服务容器。推荐先执行 docker-compose stop 命令来停止容器。
docker-compose rm 

#在指定服务上执行一个命令。
docker-compose run ubuntu ping docker.com

#设置指定服务运行的容器个数。通过 service=num 的参数来设置数量
docker-compose scale web=3 db=2

#启动已经存在的服务容器。
docker-compose start

#停止已经处于运行状态的容器，但不删除它。通过 docker-compose start 可以再次启动这些容器。
docker-compose stop


# 注意事项：
     运行 docker-compose up -d 命令  其目录下的 yml 文件名 必须为 docker-compose.yml   这是必须的！！！
    