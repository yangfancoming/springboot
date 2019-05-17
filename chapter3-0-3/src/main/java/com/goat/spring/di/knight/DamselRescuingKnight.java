package com.goat.spring.di.knight;


import com.goat.spring.di.quest.RescueDamselQuest;

/**

正如你所见，DamselRescuingKnight 在它的构造函数中自行创建了 RescueDamselQuest ，
这使得DamselRescuingKnight和RescueDamselQuest紧密地耦合到了一起，
因此极大地限制了这个骑士的执行能力。
如果一个少女需要救援，这个骑士能够召之即来。
但是如果一条恶龙需要杀掉，那么这个骑士只能爱莫能助了
     * @Date:   2018/7/24
*/
public class DamselRescuingKnight implements Knight {

  private RescueDamselQuest quest;

  public DamselRescuingKnight() { // 构造函数没有参数 没有通过构造函数方式注入！  与 RescueDamselQuest 紧耦合  因为没能实现多态！！！
    this.quest = new RescueDamselQuest();
  }

    @Override
    public void embarkOnQuest() {
        quest.embark();
    }

}
