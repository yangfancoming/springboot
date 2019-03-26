
package com.goat.B.B05.example03.enchantment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


// 飞击 魔法
public class FlyingEnchantment implements Enchantment {

  private static final Logger LOGGER = LoggerFactory.getLogger(FlyingEnchantment.class);

  @Override
  public void onActivate() {
    LOGGER.info("The item begins to glow faintly."); // 它开始微微发光
  }

  @Override
  public void apply() { // 它飞起来，击中敌人，最后又回到了主人的手上
    LOGGER.info("The item flies and strikes the enemies finally returning to owner's hand.");
  }

  @Override
  public void onDeactivate() { // 它开始慢慢变暗
    LOGGER.info("The item's glow fades.");
  }
}
