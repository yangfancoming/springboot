package com.goat.myimport1;

import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

/**
 * Created by 64274 on 2019/1/27.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/1/27---21:50
 */

@Component
@Import({Customer.class,Broker.class})
/**
 *使用Import 将指定的类的实例注入至Spring 容器中  http://localhost:1111/test0 可以看到
 * ***---***com.goat.myimport.Customer
 * ***---***com.goat.myimport.Broker
 * ***---***importDirect
 */
public class ImportDirect {

}
