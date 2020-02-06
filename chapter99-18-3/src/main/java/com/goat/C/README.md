# 参数化类型
    ParameterizedType就是参数化类型的意思
    
    声明类型中带有“<>”的都是参数化类型，比如List<Integer>，Map<String,Long>
    
    getActualTypeArguments()返回Type[]，即“<>”里的参数，比如Map<String,Integer>
    
    getRawType()返回Tpye，得到“<>”前面的类型，比如List<String>
    
    getOwnerType()返回Type，O<T>.I<S>类型变量调用时会返回O<T>，比如Map.Entry<Long,Short>