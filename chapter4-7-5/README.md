#在使用 MySQL 8.0 时重启应用后提示 
    Failed to initialize pool: Public Key Retrieval is not allowed
    com.mysql.jdbc.exceptions.jdbc4.MySQLNonTransientConnectionException: Public Key Retrieval is not allowed
    没有仔细研究到底是什么问题，最简单的解决方法是在连接后面添加 &allowPublicKeyRetrieval=true
    
    
# 读写分离验证  
    通过上述步骤，我们就快速搭建了读写分离环境，在业务代码中，也完全没有对数据库操作做任何特殊处理，
    那么Sharding-JDBC真的能让人无感知地将操作路由到不同的数据库吗？理论上，读操作应该全部路由到从库中，
    而写操作则路由到主库中，根据官方介绍，若在同一线程中，执行完写操作又立刻执行读操作，
    为了避免由于主从同步延迟引起的数据不一致问题，Sharding-JDBC此时会强制将读操作也路由到主库中，为此我设计了以下三个测试用例来进行验证。

    1.写操作验证
    先将从库关闭，主库保持开启，此时进行写操作，即新增用户信息操作。 
    http://localhost:8475/userinfo/123 
    发现由于主库开启  可以保存数据功能正常  
    查询操作： http://localhost:8475/userinfo 
    可以看到 在查询时候时候 则报错  java.net.ConnectException: Connection refused: connect
    由于从库关闭，而查询操作需要在从库读取 所以导致 该错误
    
    2.读操作验证
    
    将主库关闭，从库保持开启 此时进行读操作   http://localhost:8475/userinfo  发现读取正常
    再调保存数据操作 保存失败了，证明读操作都是走的主库。此步验证通过。
    
    3.即时数据读写验证
    我在控制器中设计了一个接口，该接口是保存用户信息后，立刻再查询此用户信息，而Sharding-JDBC为了避免读到脏数据，此时会强制把查询请求放到主库中，那么我再将从库关闭，主库开启，进行验证。
    此时发现数据能够正常被保存以及查询出来，证明此时读写操作均走了主库，验证通过。
    
    总结：  Sharding-JDBC的功能不仅仅如此，它也可以支持更为复杂的分库分表操作，后续有机会我也写一篇文章来阐述。总的来说，这个工具还是十分好用，
            起码可以在不影响原有业务逻辑的前提下快速完成读写分离，且无需引入第三方的中间件服务器。但我觉得还有提升的空间，如当主从库任何一个库出现异常时，
            若此时能够将读写操作自动路由到其它正常的库，那就更完美了。
