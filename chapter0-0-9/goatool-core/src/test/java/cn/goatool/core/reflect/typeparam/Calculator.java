
package cn.goatool.core.reflect.typeparam;

public class Calculator<T> {
  protected T id;

  private T fld;

  protected T attribute;

  public T getId() {
    return id;
  }

  public void setId(T id) {
    this.id = id;
  }

  public static class SubCalculator extends Calculator<String> {
  }
}
