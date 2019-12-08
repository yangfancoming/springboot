package cn.goatool.core.plugin;

import java.util.Map;

/**
 * Created by Administrator on 2019/12/8.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/12/8---20:07
 */
@Intercepts({ @Signature(type = Map.class, method = "get", args = {Object.class})})
public class AlwaysMapPlugin implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) {
        return "Always";
    }

}