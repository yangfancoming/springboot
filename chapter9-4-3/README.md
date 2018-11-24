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