项目启动后 访问地址：http://localhost:8080/ws/countries.wsdl


通常你提供了几个xsd文件就应该创建几个Endpoint类。
Endpoint本质上是接收一个request，然后经过你的业务逻辑再返回一个response。