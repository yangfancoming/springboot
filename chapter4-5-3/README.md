    本项目 使用 MongoRepository 方式  不能够共享 0-0-0 项目的 实体类 因为 0-0-0 项目启动类中 有 @SpringBootApplication
    
    本项目 启动类也有 @SpringBootApplication  当启动本项目test 类 进行测试时 会报错：
    
    Found multiple @SpringBootConfiguration annotated classes [Generic bean: class [com.goat.MongoDBApplication]
    
    
    去掉 0-0-0 项目 启动类 的 @SpringBootApplication 注解 就没问题 但是  最好还是不要去掉
    
# 