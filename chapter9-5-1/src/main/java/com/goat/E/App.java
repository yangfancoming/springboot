
package com.goat.E;

/**
 * 
 * Callback pattern is more native for functional languages where functions are treated as
 * first-class citizens. Prior to Java 8 callbacks can be simulated using simple (alike command)
 * interfaces.
 * 
 */
public class App {
  /**
   * Program entry point
   */
  public static void main(String[] args) {
//    Task task = new SimpleTask();
      SimpleTask task = new SimpleTask();
      Callback impl = new Impl();
      task.executeWith(impl,"heihei");
  }
}
