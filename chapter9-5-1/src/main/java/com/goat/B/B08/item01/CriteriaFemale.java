package com.goat.B.B08.item01;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 64274 on 2019/10/10.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/10/10---16:56
 */

public class CriteriaFemale implements Criteria {

    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> femalePersons = new ArrayList<Person>();
        for (Person person : persons) {
            if(person.getGender().equalsIgnoreCase("FEMALE")){
                femalePersons.add(person);
            }
        }
        return femalePersons;
    }
}
