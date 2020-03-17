# 如何 定制和修改 内嵌 Servlet容器的相关配置
    1、修改和server有关的配置（ServerProperties【也是EmbeddedServletContainerCustomizer】）；
        server.port=8081
        server.context-path=/crud
        server.tomcat.uri-encoding=UTF-8
        
        //通用的Servlet容器设置
        server.xxx
        //Tomcat的设置
        server.tomcat.xxx
    
    // 以下配置方式  在Springboot 2.x 系列中 已经去除
    2、编写一个EmbeddedServletContainerCustomizer：嵌入式的Servlet容器的定制器；来修改内嵌Servlet容器的配置
    
        @Bean  //一定要将这个定制器加入到容器中
        public EmbeddedServletContainerCustomizer embeddedServletContainerCustomizer(){
            return new EmbeddedServletContainerCustomizer() {
        
                //定制嵌入式的Servlet容器相关的规则
                @Override
                public void customize(ConfigurableEmbeddedServletContainer container) {
                    container.setPort(8083);
                }
            };
        }
    
