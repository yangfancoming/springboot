# 项目启动报错：does not support identity key generation
    原因： sqlite 不支持 @GeneratedValue(strategy = GenerationType.IDENTITY) 
    解决： 将其改成 	 @GeneratedValue(strategy = GenerationType.AUTO) 