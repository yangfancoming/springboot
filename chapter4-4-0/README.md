# 
    XML的解析方式分为四种：1、DOM解析；2、SAX解析；3、JDOM解析；4、DOM4J解析。
    其中前两种属于基础方法，是官方提供的平台无关的解析方式；
    后两种属于扩展方法，它们是在基础的方法上扩展出来的，只适用于java平台。 
    
    mybatis 采用DOM解析：
    xml解析器一次性把整个xml文档加载进内存，然后在内存中构建一棵Document的对象树，
    通过Document对象，得到树上的节点对象，通过节点对象访问（操作）到xml文档的内容。
  
#  由来
    1、DOM解析   基于 w3c 标准  缺点是  一次性将xml文件 加载到内存后 再开始解析。。。如果xml文件很大 则加载很慢
    2、SAX解析   因此应运而生  sax可以在不全部加载完毕的情况下 就可以开始解析了！


# SAX解析
    1.sax 解析器
    2. MyParseHandler extends DefaultHandler
    
    
    
# xpath 表达式
    1、选取节点
    XPath 使用路径表达式在 XML 文档中选取节点，节点是沿着路径或者 step 来选取的。
    常见的路径表达式：
    
    nodename 选取当前节点的所有子节点
    /    从根节点选取
    //   从匹配选择的当前节点选择文档中的节点，而不考虑它们的位置
    .    选取当前节点
    ..   选取当前节点的父节点
    @    选取属性
    
    示例：
    bookstore        选取 bookstore 元素的所有子节点
    /bookstore       选取根元素 bookstore
    bookstore/book   选取bookstore 下名字为 book的所有子元素。
    //book           选取所有 book 子元素，而不管它们在文档中的位置。
    bookstore//book  选取bookstore 下名字为 book的所有后代元素，而不管它们位于 bookstore 之下的什么位置。
    //@lang          选取所有名为 lang 的属性。    
    
    2、谓语（Predicates）
    谓语用来查找某个特定的节点或者包含某个指定的值的节点。
    谓语被嵌在方括号中。
    
   /bookstore/book[1]                    选取属于 bookstore 子元素的第一个 book 元素。
   /bookstore/book[last()]               选取属于 bookstore 子元素的最后一个 book 元素。
   /bookstore/book[last()-1]             选取属于 bookstore 子元素的倒数第二个 book 元素。
   /bookstore/book[position()<3]         选取最前面的两个属于 bookstore 元素的子元素的 book 元素。
   //title[@lang]                        选取所有拥有名为 lang 的属性的 title 元素。
   //title[@lang='eng']                  选取所有 title 元素，要求这些元素拥有值为 eng 的 lang 属性。
   /bookstore/book[price>35.00]          选取所有 bookstore 元素的 book 元素，要求book元素的子元素 price 元素的值须大于 35.00。
   /bookstore/book[price>35.00]/title    选取所有 bookstore 元素中的 book 元素的 title 元素，要求book元素的子元素 price 元素的值须大于 35.00
   
       3、选取未知节点
       XPath 通配符可用来选取未知的 XML 元素。
       *        匹配任何元素节点
       @*       匹配任何属性节点
       node()       匹配任何类型的节点
       
       示例：
        /bookstore/*    选取 bookstore 元素的所有子节点
        //*      选取文档中的所有元素
        //title[@*]     选取所有带有属性的 title 元素。
        
        
       
       4、选取若干路径  通过在路径表达式中使用“|”运算符，您可以选取若干个路径。
       //book/title | //book/price       选取所有 book 元素的 title 和 price 元素。
       //title | //price        选取所有文档中的 title 和 price 元素。
       /bookstore/book/title|//price        选取所有属于 bookstore 元素的 book 元素的title 元素，以及文档中所有的 price 元素。
       
       5、XPath 轴  轴可定义某个相对于当前节点的节点集。
       
       ancestor  选取当前节点的所有先辈（父、祖父等）
       ancestor-or-self      选取当前节点的所有先辈（父、祖父等）以及当前节点本身
       attribute        选取当前节点的所有属性
       child        选取当前节点的所有子元素。
       descendant       选取当前节点的所有后代元素（子、孙等）。
       descendant-or-self       选取当前节点的所有后代元素（子、孙等）以及当前节点本身。
       following        选取文档中当前节点的结束标签之后的所有节点。
       namespace        选取当前节点的所有命名空间节点
       parent        选取当前节点的父节点。
       preceding        选取文档中当前节点的开始标签之前的所有节点。
       preceding-sibling         选取当前节点之前的所有同级节点。
       self      选取当前节点。
       
       
       7、XPath 运算符
       
       |  计算两个节点集    //book | //cd   返回所有带有 book 和 ck 元素的节点集
       +  加法   6 + 4    10
       -  减法   6 - 4    2
       *  乘法   6 * 4  24
       div  除法  8 div 4   2
       =  等于    price=9.80   如果 price 是 9.80，则返回 true。   如果 price 是 9.90，则返回 fasle。
       !=  不等于    price!=9.80   如果 price 是 9.90，则返回 true。  如果 price 是 9.80，则返回 fasle。
       <  小于  price<9.80             如果 price 是 9.00，则返回 true。    如果 price 是 9.90，则返回 fasle。
       <= 小于或等于   price<=9.80        如果 price 是 9.00，则返回 true。  如果 price 是 9.90，则返回 fasle。
       >    大于       price>9.80   如果 price 是 9.90，则返回 true。   如果 price 是 9.80，则返回 fasle。
       >=   大于或等于    price>=9.80   如果 price 是 9.90，则返回 true。  如果 price 是 9.70，则返回 fasle。
       or  或   price=9.80 or price=9.70  如果 price 是 9.80，则返回 true。  如果 price 是 9.50，则返回 fasle。
       and  与    price>9.00 and price<9.90 如果 price 是 9.80，则返回 true。    如果 price 是 8.50，则返回 fasle。
       mod  计算除法的余数    5 mod 2   1
       
       
       
     6、路径
     位置路径可以是绝对的，也可以是相对的。
     绝对路径起始于正斜杠( / )，而相对路径不会这样。在两种情况中，位置路径均包括一个或多个步，每个步均被斜杠分割：
     /step/step/...
     step/step/...
     每个步均根据当前节点集之中的节点来进行计算。
     轴（axis）：定义所选节点与当前节点之间的树关系
     节点测试（node-test）：识别某个轴内部的节点
     零个或者更多谓语（predicate）：更深入地提炼所选的节点集
     步的语法：轴名称::节点测试[谓语]

        child::book     选取所有属于当前节点的子元素的 book 节点
        attribute::lang      选取当前节点的 lang 属性
        child::*         选取当前节点的所有子元素
        attribute::*          选取当前节点的所有属性
        child::text()        选取当前节点的所有文本子节点
        child::node()        选取当前节点的所有子节点
        descendant::book          选取当前节点的所有 book 后代
        ancestor::book      选择当前节点的所有 book 先辈
        ancestor-or-self::book  选取当前节点的所有book先辈以及当前节点（假如此节点是book节点的话）
        child::*/child::price       选取当前节点的所有 price 孙。
        
        
     
       
       
      