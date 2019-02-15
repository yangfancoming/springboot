# Spring的 RestTemplate访问使用了模版方法的设计模式.

    模版方法将过程中与特定实现相关的部分委托给接口,而这个接口的不同实现定义了接口的不同行为.
    RestTemplate定义了36个与REST资源交互的方法，其中的大多数都对应于HTTP的方法。 
    其实，这里面只有11个独立的方法，其中有十个有三种重载形式，而第十一个则重载了六次，这样一共形成了36个方法。
    
    delete()    在特定的URL上对资源执行HTTP DELETE操作
    exchange()  在URL上执行特定的HTTP方法，返回包含对象的ResponseEntity，这个对象是从响应体中映射得到的
    execute()   在URL上执行特定的HTTP方法，返回一个从响应体映射得到的对象
    getForEntity() 发送一个HTTP GET请求，返回的ResponseEntity包含了响应体所映射成的对象
    getForObject() 发送一个HTTP GET请求，返回的请求体将映射为一个对象
    postForEntity() POST 数据到一个URL，返回包含一个对象的ResponseEntity，这个对象是从响应体中映射得 到的
    postForObject() POST 数据到一个URL，返回根据响应体匹配形成的对象
    headForHeaders() 发送HTTP HEAD请求，返回包含特定资源URL的HTTP头
    optionsForAllow() 发送HTTP OPTIONS请求，返回对特定URL的Allow头信息
    postForLocation() POST 数据到一个URL，返回新创建资源的URL
    put() PUT 资源到特定的URL

# 返回值问题： RestTemplate.getForObject 和 RestTemplate.getForEntity
    ResponseEntity<List> forEntity = restTemplate.getForEntity(HOST + "/warehouseStockContentLog/getWarehouseLog1", List.class);
    List<T> list = restTemplate.getForObject(HOST + "/warehouseStockContentLog/getWarehouseLog2", List.class);
    使用以上两种方式 返回结果 ，不管这个T是什么，接收到都被转化为 LinkedHashMap