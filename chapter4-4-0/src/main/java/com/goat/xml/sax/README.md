# 

    
    
# 现在总结一下如何书写基于SAX的应用程序。一般步骤如下：
    
    实现一个或多个处理器接口(ContentHandler, ErrorHandler, DTDHandler ,or EntityResover)。
    创建一个XMLReader类的实例。
    在新的XMLReader实例中通过大量的set*****() 方法注册一个事件处理器的实例
    调用XMLReader的parse()方法来处理文档。