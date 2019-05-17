package com.goat.spring.di.knight;


import com.goat.spring.di.quest.Quest;

/**
不同于之前的DamselRescuingKnight，BraveKnight没有自行创建探险任务，
而是在构造器中把探险任务作为参数注入，这也是依赖注入的一种方式，即构造器注入。

更为重要的是，BraveKnight 中注入的探险类型是 Quest，Quest 只是一个探险任务所必须实现的接口。
因此，BraveKnight能够响RescueDamselQuest、SlayDraonQuest等任意一种Quest实现，这正是多态的体现。

这里的要点是BraveKnight没有与任何特定的Quest实现发生耦合。
对它来说，被要求挑战的探险任务只要实现了Quest接口，那么具体是哪一类型的探险就无关紧要了。
这就是依赖注入最大的好处--松耦合。
如果一个对象只通过接口（而不是具体实现或初始化的过程）来表明依赖关系，
那么这种依赖就能够在对象本身毫不知情的情况下，用不同的具体实现进行替换。
     * @Date:   2018/7/24
*/
public class BraveKnight implements Knight {

  private Quest quest;

  public BraveKnight(Quest quest) {  //构造函数有参数！  构造器注入  这里松耦合 因为实现了多态！！！
      System.out.println("BraveKnight construction！");
    this.quest = quest;
  }

  @Override
  public void embarkOnQuest() {
    quest.embark();
  }

}
