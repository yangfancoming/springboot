package com.goat.B.B08.item01;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 64274 on 2019/10/10.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/10/10---16:57
 */

public class CriteriaSingle implements Criteria {

    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> singlePersons = new ArrayList<>();
        for (Person person : persons) {
            if(person.getMaritalStatus().equalsIgnoreCase("SINGLE")){
                singlePersons.add(person);
            }
        }
        return singlePersons;
    }
}
