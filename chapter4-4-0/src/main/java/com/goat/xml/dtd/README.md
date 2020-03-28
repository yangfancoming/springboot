# dtd 约束
    约束 xml 文档中可以出现的各个元素、元素的名称、元素的属性、元素的先后顺序
    
    
# IDEA  dtd约束 xml明显错误的标签  却没有提示   这是一个大坑！！！！！！！！
    原因一：
     因为xml文档中的 <?xml version="1.0" encoding="UTF-8"?> 
    必须要放在第一行 否则整个xml文档会被视为 错误的问题 IDEA就不会去检测
    
    原因二：
     再引入外部约束dtd文件是   再不要在外部dtd文件中 写
        <!DOCTYPE persons [
         
         ]>
      这是内部dtd用的
      
      
      
# <!DOCTYPE note SYSTEM "note.dtd"> 中SYSTEM 后的dtd 文件没有颜色提示？？？
    解决： 删除 "note.dtd" 后 手动重新敲一遍 就可以了