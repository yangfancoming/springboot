#  sql 

    关系型数据库 mysql  Oracle


# nosql

    非关系型数据库类型
     一、键值对存储  redis
        
     
     
     二、文档存储   mongodb
     
     
    
     三、列存储   Hbase
        分布式文件系统
     
     四、图形存储
        朋友圈社交网络、拓扑图
     
     
#  redis
    1.应运而生
        1.由于数据库访问量过大会导致性能大大降低，需要把热点数据，高频访问数据，单独拿出来放入缓存，提供用户访问。
        2.由于传统关系型数据库，不再能胜任，文档、图形、拓扑等数据库的存储，需要新型数据库来存储。
        
        
    2.特点：
        1.高效，是基于内存的单线程操作， 避免了多线程上下文切换的耗时操作
        
        
        
        
     命令：
     dbsize 查看当前数据key数量
     flushdb  清空当前数据库
     flushall  清空所有数据库
     select x  切换当前数据库
     
     ###字符串型命令：
     set key value   设置一个key value
     get key    返回一个value
     
     incr/decr          key 给指定key的value +1/-1
     incrby/decrby n   key 给指定key的value +n/-n

     append key xxx   给指定key的value 追加xxx (如果指定key不存在，则直接新增key value)
     getrange fuck 1 3
     
     exists key  判断某个key是否存在  1 true  0 false
     move key  db   将key剪切到指定db中 
     strlen key  获取指定key的长度
     expire key  seconds   设置指定key过期时间  单位为秒。过期后 key-value将被删除
     ttl key 查看指定key剩余过期时间
     type key 查看指定key的类型
     
     
     ###字符串型命令：
     
     
     
     支持的数据类型
         字符串  string
         哈希	hash
         列表	list
         集合	set
         有序集合 	zset
         
         
         BitMaps    位图
         Geospatial   地理位置空间
         HyperLogLog