package com.goat.spring.chapter_02.autoconfig;

import org.springframework.stereotype.Component;


/**  CD 盘
     如果没有显示指定 bean 的ID 那么Spring会根据类名为其指定一个ID （sgtPeppers）
     也就是将类名的第一个字母变为小写
     @Component 注解 告知Spring要为这个类创建bean
     @Component("MycomId"): 显示指定该bean的 ID 也可以是 @Named("MycomId")
     * @Date:   2018/7/25
*/
@Component("MycomId")
public class CompactDiscImpl implements ICompactDisc {

  @Override
  public void play() {
    System.out.println("*******************播放 CD ");
  }
  
}
