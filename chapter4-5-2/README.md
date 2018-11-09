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
