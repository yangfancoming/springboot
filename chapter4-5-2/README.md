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


# 再mongodb中 不需要手动创建 数据库和集合
    当我们创建文档时，如果文档所在的集合和数据库不存在，则会自动创建数据库和集合。
    当我们向集合中插入文档时，如果没有给文档指定 _id 属性，则会自动生成属性值赋值给 _id 属性。