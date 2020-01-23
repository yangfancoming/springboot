package cn.goatool.core.parsing;

import java.util.Map;

/**
 * Created by 64274 on 2019/7/12.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/7/12---11:19
 */
public class MapTokenHandler implements TokenHandler {

  private Map<String, String> variables;

  MapTokenHandler(Map<String, String> variables) {
    this.variables = variables;
  }

  @Override
  public String handleToken(String content) {
    return variables.get(content);
  }
}
