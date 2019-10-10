package com.goat.B.B08.item01;

import java.util.List;

/**
 步骤 2
 为标准（Criteria）创建一个接口。
 */
public interface Criteria {

    public List<Person> meetCriteria(List<Person> persons);

}
