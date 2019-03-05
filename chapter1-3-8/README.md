

# 关于日期时间格式化的三种使用场景
  
      （1）使用@ResponseBody返回JSON信息会用到MappingJackson2HttpMessageConverter 。
      （2）使用@ResponseBody返回XML信息会用到MappingJackson2XmlHttpMessageConverter。
      （3）使用ModelAndView返回HTML页面信息。
      
      值得注意的是，无论上面哪种消息转换器均无法满足页面日期的全局格式化，因为th:object默认调用的日期Date的toString方法，所以在Thymemleaf页面对日期格式化需要借助工具类#dates。
      例如：<input th:value="*{#dates.format(createTime,'yyyy-MM-dd HH:mm:ss')}">
      

      
# 小结
    1、使用@ResponseBody会根据请求头信息来智能选择JSON/XML消息转换器。
    2、通过重写HttpMessageConverter可以自定义消息转换器来实现全局日期格式化。
    3、采用类似yyyy-MM-dd HH:mm:ss的日期格式更符合国人的阅读习惯，能够提升用户体验。