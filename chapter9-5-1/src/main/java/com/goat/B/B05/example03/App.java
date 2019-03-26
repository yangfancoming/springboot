
package com.goat.B.B05.example03;

import com.goat.B.B05.example03.enchantment.Enchantment;
import com.goat.B.B05.example03.enchantment.FlyingEnchantment;
import com.goat.B.B05.example03.enchantment.SoulEatingEnchantment;
import com.goat.B.B05.example03.weapon.Hammer;
import com.goat.B.B05.example03.weapon.Sword;
import com.goat.B.B05.example03.weapon.Weapon;

/**
 * 
 * Composition over inheritance. The Bridge pattern can also be thought of as two layers of abstraction.
 * With Bridge, you can decouple an abstraction from its implementation so that the two can vary independently.
 * In Bridge pattern both abstraction ({@link Weapon}) and implementation ({@link Enchantment})
 * have their own class hierarchies. The interface of the implementations can be changed without affecting the clients.
 * In this example we have two class hierarchies. One of weapons and another one of enchantments. We can easily
 * combine any weapon with any enchantment using composition instead of creating deep class hierarchy.
 * 
 */
public class App {

  public static void main(String[] args) {
      System.out.println("The knight receives an enchanted sword");
      Sword enchantedSword = new Sword(new SoulEatingEnchantment());
      enchantedSword.wield();
      enchantedSword.swing();
      enchantedSword.unwield();

      System.out.println("The valkyrie receives an enchanted hammer.");
      Hammer hammer = new Hammer(new FlyingEnchantment());
      hammer.wield();
      hammer.swing();
      hammer.unwield();

      System.out.println("The valkyrie receives an enchanted hammer.");
      Hammer hammer1 = new Hammer(new SoulEatingEnchantment());
      hammer1.wield();
      hammer1.swing();
      hammer1.unwield();
  }
}
