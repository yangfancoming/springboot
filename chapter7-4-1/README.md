# 启动项目报错：
     Adding transport node : 192.168.235.207:9300
     failed to load elasticsearch nodes : org.elasticsearch.client.transport.NoNodeAvailableException: None of the configured nodes are available: [{#transport#-1}{-hIYBxAGQke0Rj9bWHiHTA}{192.168.235.207}{192.168.235.207:9300}]
     应该是 spring data elasticsearch  3.0.9.RELEASE  与  elasticsearch 5.6.10 版本不对应的问题
# 入门使用
    使用 postman 工具 
    1.PUT 类型  
    2.raw 
    3.json 格式    
    4.url   http://192.168.235.207:9200/megacorp/employee/3
    4.url   http://172.16.163.135:9200/megacorp/employee/3
    body： 
    {
        "first_name" :  "Douglas",
        "last_name" :   "Fir",
        "age" :         35,
        "about":        "I like to build cabinets",
        "interests":  [ "forestry" ]
    }
   
   
       get 请求  http://192.168.235.207:9200/megacorp/employee/3 
       返回信息：
       {
           "_index": "megacorp",
           "_type": "employee",
           "_id": "3",
           "_version": 1,
           "found": true,
           "_source": {
               "first_name": "Douglas",
               "last_name": "Fir",
               "age": 35,
               "about": "I like to build cabinets",
               "interests": [
                   "forestry"
               ]
           }
       }