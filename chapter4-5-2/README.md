mongo shell

``db`` 显示你当前正在使用的数据库， 此操作将返回默认数据库``test`` 

``use <db>`` 切换数据库 

``show dbs`` 显示 所有可用的数据库。
``show collections`` 显示当前数据库中所有集合。

当你第一次向数据库存储数据，如通过创建一个集合，MongoDB将自动创建数据库。
例如，当执行 insert() 操作期间，数据库``myNewDatabase`` 和 collection ``myCollection``都将被创建。
use myNewDatabase
db.myCollection.insert({x:1})

``myCollection``是集合的名称。

# 应运而生
    由于传统关系型数据库(mysql) 
    1.对于数据库高并发的读写
    2.海量数据的高效存储和访问
    3.对于数据库的可扩展性
    都显得力不从心，mongodb 应运而生！

    mongo优点是：
    以上3点再加
    4.灵活性：集合中插入的文档 可以是不同的实体类，在传统关系型数据库中 插入的记录  必须是相同的，因此 mongo具有了更大灵活性
        即：同一个集合里的文档，可以拥有完全不同的字段
            当我们创建文档时，如果文档所在的集合和数据库不存在，则会自动创建数据库和集合。
            当我们向集合中插入文档时，如果没有给文档指定 _id 属性，则会自动生成属性值赋值给 _id 属性。

    mongo缺点是：
    1.事务差：（MongoDB 目前只支持单文档事务，需要复杂事务支持的场景暂时不适合）像银行转账这种强事务类型的操作，mongodb就不再适用
    2.复杂查询效率低 ：既然是非关系型数据库，在连表查询效率远低于mysql，但是mongo是在单表的查询效率远高于mysql
        
# 应用场景：（应用不需要事务及复杂的连接查询）
    游戏场景，使用 MongoDB 存储游戏用户信息，用户的装备、积分等直接以内嵌文档的形式存储，方便查询、更新
    物流场景，使用 MongoDB 存储订单信息，订单状态在运送过程中会不断更新，以 MongoDB 内嵌数组的形式来存储，一次查询就能将订单所有的变更读取出来。
    社交场景，使用 MongoDB 存储用户信息，以及用户发表的朋友圈信息，通过地理位置索引实现附近的人、地点等功能
    物联网场景，使用 MongoDB 存储所有接入的智能设备信息，以及设备汇报的日志信息，并对这些信息进行多维度的分析
    视频直播，使用 MongoDB 存储用户信息、礼物信息、点赞、收藏等 

    
# 比较运算符
    
    Name	Description
    $eq	    Matches values that are equal to a specified value.
    $gt	    Matches values that are greater than a specified value.
    $gte	Matches values that are greater than or equal to a specified value.
    $in	    Matches any of the values specified in an array.
    $lt 	Matches values that are less than a specified value.
    $lte	Matches values that are less than or equal to a specified value.
    $ne 	Matches all values that are not equal to a specified value.
    $nin	Matches none of the values specified in an array. 
    
# 查询

    db.inventory.find( { status: "D" } )
    SELECT * FROM inventory WHERE status = "D"
    

    db.inventory.find( { status: { $in: [ "A", "D" ] } } )
    SELECT * FROM inventory WHERE status in ("A", "D")
    
    db.inventory.find( { status: "A", qty: { $lt: 30 } } )
    SELECT * FROM inventory WHERE status = "A" AND qty < 30
    
    db.inventory.find( { $or: [ { status: "A" }, { qty: { $lt: 30 } } ] } )
    SELECT * FROM inventory WHERE status = "A" OR qty < 30
    
    
# 设想  doit
    是否可以使用mybatis的方式 调用mongodb 的框架 mongoplus