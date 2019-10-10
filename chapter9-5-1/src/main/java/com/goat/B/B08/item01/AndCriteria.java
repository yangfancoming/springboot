package com.goat.B.B08.item01;

import java.util.List;

/**
 * Created by 64274 on 2019/10/10.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/10/10---16:58
 */
public class AndCriteria implements Criteria {

    private Criteria criteria;
    private Criteria otherCriteria;

    public AndCriteria(Criteria criteria, Criteria otherCriteria) {
        this.criteria = criteria;
        this.otherCriteria = otherCriteria;
    }

    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> firstCriteriaPersons = criteria.meetCriteria(persons);
        return otherCriteria.meetCriteria(firstCriteriaPersons);
    }
}
