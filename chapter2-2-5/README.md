#  在linux 系统部署后  遇到 日期时间 格式 解析错误
    数据采集项目 在windows上部署 wms 给其post推送数据 isdc 可以正常解析
    但是 isdc 在linux上部署 后 wms 给其post推送数据  isdc 系统 报错：java.text.ParseException: Unparseable date: "2019-03-13 17:42:54"
    
    Gson gson = new Gson();
    List<TraceEnt> traceList = gson.fromJson(content, new TypeToken<List<TraceEnt>>() {}.getType());
    解析： 以上代码在windows中完全没有问题，但是如果部署到linux中则会出现时间转换异常错误 
    linux在转换 ‘2017-04-27 17:55：00’ 时间成Date类型时会发生异常，
    猜想因为linux的默认格式与我们传递的存在冲突，所以我们在转换时必须指定一个时间转换的格式。
    解决方式：
    Gson gson = new GsonBuilder().setDateFormat(“yyyy-MM-dd HH:mm:ss”).create();
    List<TraceEnt> traceList = gson.fromJson(content, new TypeToken<List<TraceEnt>>() { }.getType());
    

