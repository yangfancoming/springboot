# 百度翻译 API 



# 报错：Cannot deserialize instance of `java.lang.String` out of START_OBJECT token
       代码：  ResponseEntity<String> responseEntity = restTemplate.postForEntity(TRANS_API_HOST, translate,String.class);
       原因： 由于post请求后的返回的类型 与 String 类型不符合  改成object 就可以了
       解决：  ResponseEntity<String> responseEntity = restTemplate.postForEntity(TRANS_API_HOST, translate,String.class);
        
# 报错：Cannot deserialize instance of `com.goat.chapter277.model.TranslateResult` out of START_ARRAY token
        代码：  {"from":"zh","to":"en","trans_result":[{"src":"\u5c71\u7f8a","dst":"Goat"}]}   注意到 trans_result是数组 因为有 [] 要定义成list 
        由于 MyResult 类中的 trans_result 应该为数组  而我却定义的单个对象。。。。
        检查一下JSON数据和实体的字段结构是不是不一致导致的。比如JSON数据是数组，而实体字段为非数组。

       
       
#  添加   <artifactId>goatool-core</artifactId> 依赖后 报错 ：LoggerFactory is not a Logback LoggerContext but Logback is on the classpath     
     原因： 由于工具类模块中 加入了日志依赖 
             <dependency>
                 <groupId>org.slf4j</groupId>
                 <artifactId>slf4j-log4j12</artifactId>
                 <version>1.6.1</version>
             </dependency>
     
             <dependency>
                 <groupId>log4j</groupId>
                 <artifactId>log4j</artifactId>
                 <version>1.2.17</version>
             </dependency> 
      导致 本项目 日志与LogBack日志冲突
      
      解决： 在本项目中排除掉 工具类模块中的日志依赖
              <dependency>
                  <groupId>com.goat.springboot.learing</groupId>
                  <artifactId>goatool-core</artifactId>
                  <version>0.0.1-SNAPSHOT</version>
                  <exclusions>
                      <exclusion>
                          <artifactId>slf4j-log4j12</artifactId>
                          <groupId>org.slf4j</groupId>
                      </exclusion>
                      <exclusion>
                          <artifactId>log4j</artifactId>
                          <groupId>log4j</groupId>
                      </exclusion>
                  </exclusions>
              </dependency> 
      
       
       
#  返回信息  {"error_code":"52003","error_msg":"UNAUTHORIZED USER"}
    未授权用户  请检查sign是否计算正确、appid、服务是否开通
    干掉 HTTPClient 使用 restTemplate 请求
       
       
       
       
       
       
       
       
       
       