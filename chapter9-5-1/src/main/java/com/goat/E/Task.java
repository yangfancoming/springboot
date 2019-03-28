
package com.goat.E;

/**
 * Template-method class for callback hook execution
 */
public abstract class Task {

  /*** Execute with callback*/
  public final void executeWith(Callback callback,String para) {
      execute();
      callback.call2(para);
  }

  public abstract void execute();
}
