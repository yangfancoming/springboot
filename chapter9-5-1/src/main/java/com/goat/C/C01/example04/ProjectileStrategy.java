
package com.goat.C.C01.example04;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * Projectile strategy.
 *
 */
public class ProjectileStrategy implements DragonSlayingStrategy {

  private static final Logger LOGGER = LoggerFactory.getLogger(ProjectileStrategy.class);

  @Override
  public void execute() {
    LOGGER.info("You shoot the dragon with the magical crossbow and it falls dead on the ground!");
  }
}
