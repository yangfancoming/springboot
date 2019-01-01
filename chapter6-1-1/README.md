







http://localhost:端口号/项目名称/swagger-ui.html 
http://localhost:8611/swagger-ui.html 


第三方的UI界面地址/doc.html，基于本项目地址是 http://localhost:端口号/项目名称/doc.html
第三方的UI界面地址/doc.html，基于本项目地址是 http://localhost:8611/doc.html


#Swagger2 基本使用：

    @Api  描述类/接口的主要用途  类集描述  用于controller类上
    @ApiResponses	Response集	 用在controller的方法上
    @ApiResponse    Response	 用在 @ApiResponses里边
    @ApiOperation  描述方法用途  用在controller的方法上
    @ApiImplicitParams 描述方法的参数(Multi-Params) 非对象参数集 用在controller的方法上
    @ApiImplicitParam  描述方法的参数  非对象参数描述  用在@ApiImplicitParams的方法里边
    
    @ApiIgnore 忽略某类/方法/参数的文档
    @ApiModelProperty   对象属性		用在参数对象的字段上
    @ApiModel 描述返回对象的意义		用在返回对象类上




    
#Swagger2相关注解说明
    @Api：用在请求的类上，表示对类的说明
        tags="说明该类的作用，可以在UI界面上看到的注解"
        value="该参数没什么意义，在UI界面上也看到，所以不需要配置"
    
    @ApiOperation：用在请求的方法上，说明方法的用途、作用
        value="说明方法的用途、作用"
        notes="方法的备注说明"
    
    @ApiImplicitParams：用在请求的方法上，表示一组参数说明
        @ApiImplicitParam：用在@ApiImplicitParams注解中，指定一个请求参数的各个方面
            name：参数名
            value：参数的汉字说明、解释
            required：参数是否必须传
            paramType：参数放在哪个地方
                · header --> 请求参数的获取：@RequestHeader
                · query --> 请求参数的获取：@RequestParam
                · path（用于restful接口）--> 请求参数的获取：@PathVariable
                · body（不常用）
                · form（不常用）    
            dataType：参数类型，默认String，其它值dataType="Integer"       
            defaultValue：参数的默认值
    
    @ApiResponses：用在请求的方法上，表示一组响应
        @ApiResponse：用在@ApiResponses中，一般用于表达一个错误的响应信息
            code：数字，例如400
            message：信息，例如"请求参数没填好"
            response：抛出异常的类
    
    @ApiModel：用于响应类上，表示一个返回响应数据的信息
                （这种一般用在post创建的时候，使用@RequestBody这样的场景，
                请求参数无法使用@ApiImplicitParam注解进行描述的时候）
                
## @ApiModelProperty：用在实体类的属性上，描述响应类的属性  
    value–字段说明 
    name–重写属性名字 
    dataType–重写属性类型 
    required–是否必填 
    example–举例说明 
    hidden–隐藏
    
    @ApiModelProperty(value="对应角色表主键",example="32",required=true)
    private String roleid;
    
## @ApiOperation  描述方法用途  （除了 value 和 notes 其他貌似都没啥用）
    value - 字段说明
    notes - 注释说明
    httpMethod - 说明这个方法被请求的方式
    response - 方法的返回值的类型
      @ApiOperation(value="删除一个用户", notes="返回是否删除成功")
      
      