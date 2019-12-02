#  简介
    位于org.w3c.dom操作XML会比较简单，就是将XML看做是一颗树，
    DOM就是对这颗树的一个数据结构的描述，但对大型XML文件效果可能会不理想
    
# 作用
    1.当做 配置文件使用
    2.当做  网络接口使用
    
#  API 

    1.解析器工厂类：DocumentBuilderFactory
    创建的方法：DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    
    2.解析器：DocumentBuilder
    创建方法：通过解析器工厂类来获得 DocumentBuilder db = dbf.newDocumentBuilder();
    
    3.文档树模型Document
    创建方法：Document doc = db.parse(is); 
     a.通过xml文档 Document doc = db.parse("bean.xml"); 
     b.将需要解析的xml文档转化为输入流 InputStream is = new FileInputStream("bean.xml");
    
    Document对象代表了一个XML文档的模型树，所有的其他Node都以一定的顺序包含在Document对象之内，排列成一个树状结构，
    以后对XML文档的所有操作都与解析器无关，
    
    4.节点列表类NodeList
    NodeList代表了一个包含一个或者多个Node的列表，根据操作可以将其简化的看做为数组
    
    5.节点类Node
    Node对象是DOM中最基本的对象，代表了文档树中的抽象节点。但在实际使用中很少会直接使用Node对象，而是使用Node对象的子对象Element,Attr,Text等
    
    6.元素类Element
    是Node类最主要的子对象，在元素中可以包含属性，因而Element中有存取其属性的方法
    
    
    7.属性类Attr
    代表某个元素的属性，虽然Attr继承自Node接口，但因为Attr是包含在Element中的，但并不能将其看做是Element的子对象，因为Attr并不是DOM树的一部分