# 百度翻译 API 



# 报错：Cannot deserialize instance of `java.lang.String` out of START_OBJECT token
       代码：  ResponseEntity<String> responseEntity = restTemplate.postForEntity(TRANS_API_HOST, translate,String.class);
       原因： 由于post请求后的返回的类型 与 String 类型不符合  改成object 就可以了
       解决：  ResponseEntity<String> responseEntity = restTemplate.postForEntity(TRANS_API_HOST, translate,String.class);