# 远程调用接口时报：Can not deserialize instance of java.util.ArrayList out of START_OBJECT token
# 对应 本项目的  @RequestMapping("test4") 

    原因一，是远程客户端返回的数据类型与接收类型不一致。单数据类型无法返回复杂的数据类型。
    这里的关键词是ArrayList和START_OBJECT标记。您不能将单个对象反序列化为对象数组。试着理解这一点，你就会明白为什么。
    您只能将一组 JSON对象反序列化为一个数组或POJO集合。请注意，虽然JSON对象由{ }大括号分隔，但数组由[ ]括号分隔，其中包含一些对象。
    因此，首先你先认真检查两个服务接口返回类型是否一致。我是因为这个原因，对方自己把接口改了，所以我不知道没检查，一直在纠结这个错误。因此写此博客目的：是提醒大家先检查数据对象类型是否一致，再去解决转换方式或把数据类型更改一直即可。


    对应这种请求结果  要使用  Temp[] obj;   来接收 不能使用 List<Temp> obj;  否则无法接收到 数组数据
    可以使用 数组接收后 再  List<Temp> lists = Arrays.asList(body.getObj());// 数组转集合list
    
    {
        "success": true,
        "msg": "操作成功",
        "obj": [
            {
                "detailId": 21851253,
                "mainId": 21848403,
                "deviceCode": "S07-D4-1",
                "locCode": "1",
                "trackCode": "67",
                "feederCode": "3 x 8mm SL",
                "divCode": "1",
                "partNumber": "X00013500010",
                "pickups": 37,
                "isPrint": null
            },
            {
                "detailId": 21851253,
                "mainId": 21848403,
                "deviceCode": "S07-D4-1",
                "locCode": "1",
                "trackCode": "67",
                "feederCode": "3 x 8mm SL",
                "divCode": "1",
                "partNumber": "X00013500010",
                "pickups": 37,
                "isPrint": null
            }
    }