
package com.goat.B.B05.example03.enchantment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// 灵魂吞噬 魔法
public class SoulEatingEnchantment implements Enchantment {

  private static final Logger LOGGER = LoggerFactory.getLogger(SoulEatingEnchantment.class);

  @Override
  public void onActivate() { // 他开始 展现杀戮欲 (嗜血状态)
    LOGGER.info("The item spreads bloodlust.");
  }

  @Override
  public void apply() { // 他吞噬了敌人的灵魂
    LOGGER.info("The item eats the soul of enemies.");
  }

  @Override
  public void onDeactivate() { // 嗜血状态 慢慢消失
    LOGGER.info("Bloodlust slowly disappears.");
  }
}
