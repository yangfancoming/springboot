        注意三个模块的写法，
        api 来提供统一的接口,  
        provider 实现并作为提供者，
        consumer 使用提供的服务，
        这里引入了dubbo-admin管理界面,可自行去官网下载https://github.com/apache/incubator-dubbo/tree/2.5.x/dubbo-admin
        
        
        
        api      项目 打包方式  <packaging>jar</packaging>
        provider 项目  引用 api 项目  需要 api项目 install 到本地仓库   或者 deploy 到私服 这样 provider 项目才可以引用到