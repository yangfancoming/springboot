package com.goat;

/**
 * Created by 64274 on 2019/1/6.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/1/6---17:40
 */
public interface IRedisService {

    public Object get(String key);

    public void  set(String key, Object value);
}
