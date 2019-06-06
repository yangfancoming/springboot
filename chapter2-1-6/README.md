# 错误记录1  sos 
    当遇到 js 或 jsp html 等文件 写入代码后  页面却没有显示的问题
    1. 清除浏览器缓存
    2. 前端 F12 打开调试 source栏  ctrl + P 找到对应的文件 查看对应代码 是否有更新到前端
    我就遇到 在 js 中写了 console.log("13我都是多发")  在前端页面 无论怎么刷新 都看不到其执行！
    使用第二种 方法 看到 console.log("13我都是多发") 代码根本没有 更新到前端   不知道为啥  IDEA 在更新一次  前端就看到了
    我之前IDEA 也都是每次都更新为啥可就看到呢？  太瘠薄难了 
    
    
    
# 错误记录2 sos
    前端发起请求：
           $.ajax({
                    type: "POST",
                    url: ctx + "/materialLocation/delete",
                    data: {"id": id},
                    
    后端接收：
    public void deleteFromCache(long id) {
        logger.info("UserSVImpl.deleteFromCache()=========删除缓存中的...Id="+id);
    }
    
    报错内容： Optional long parameter 'id' is present but cannot be translated into a null value due to being
    
    大意是说 如果参数是非必须的，则会赋值为null，因此参数应该是一个object，它才能接受这个null值。
    而上面代码参数id 的类型 为 long，它接受不了null值。
    解决办法：将long类型换成对象类型Long，问题解决。
    
   
