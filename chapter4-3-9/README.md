# 
    SAX的设计实现与DOM是完全不同的！DOM处理XML文档是基于将XML文档解析成树状模型，放入内存进行处理。
    而SAX则是采用基于事件驱动的处理模式，它将XML文档转化成一系列的事件，由单独的事件处理器来决定如何处理。
    为了了解如何使用SAX API处理XML文档，这里先介绍一下SAX所使用的基于事件驱动的处理模式。
    
    
# 现在总结一下如何书写基于SAX的应用程序。一般步骤如下：
    
    实现一个或多个处理器接口(ContentHandler, ErrorHandler, DTDHandler ,or EntityResover)。
    创建一个XMLReader类的实例。
    在新的XMLReader实例中通过大量的set*****() 方法注册一个事件处理器的实例
    调用XMLReader的parse()方法来处理文档。