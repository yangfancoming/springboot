# 成功标识：
    项目启动后  控制台打印出  Servlet simpleGraphQLHttpServlet mapped to [/graphql/*] 
    
    
# 使用：
    项目成功启动后  浏览器输入： http://localhost:8804/graphiql?query=%7B%0A%20%20findBooks%7B%0A%20%20%20%20id%2C%0A%20%20%7D%0A%7D
    
    浏览器左侧 内容 输入
    {
      findBooks{
        id,
      }
    }
    或 
    {
      findBooks{
        id
        publisher
        author{
          name
        }
      }
    }
    
    
# 总结：graphql 很好地解决了不同接口对查询字段差异性的要求，而不会产生数据冗余


# 注意事项：
    你的springboot版本不同，引入的GraphQL的版本也会不同！比如：上面我用的是springboot2.x ，我的GraphQL的版本是5.0.2