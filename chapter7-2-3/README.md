#  报错： Expected mime type application/octet-stream but got text/html
    解决方式：
        1.application.properties 配置文件中 spring.data.solr.host=http://192.168.211.128:8983/solr
            不应考虑core问题  core问题 在JPA 实体类的 @SolrDocument(solrCoreName = "user", collection = "user")
            中已经指定了！
            
            