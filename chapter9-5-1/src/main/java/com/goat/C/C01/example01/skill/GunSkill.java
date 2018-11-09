package com.goat.C.C01.example01.skill;

/**
 * Created by 64274 on 2018/11/5.
 *
 * @author 山羊来了
 * @Description: 鲁班技能
 * @date 2018/11/5---10:04
 */
public class GunSkill implements SkillBehavior {
    @Override
    public void useSkill() {
        System.out.println("释放手枪技能");
    }
}