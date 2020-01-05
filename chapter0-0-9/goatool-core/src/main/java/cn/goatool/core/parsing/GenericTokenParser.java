
package cn.goatool.core.parsing;

/**
 * GenericTokenParser 是对常用 Token 进行解析的工具类
 */
public class GenericTokenParser {
  /**
   解析以上配置中的 ${driver}， 那么这几个成员变量
   openToken="${";
   closeToken="}";
  */
  private final String openToken; //参数开始标志
  private final String closeToken; //参数解析标志
  private final TokenHandler handler; //ParameterMappingTokenHandler,参数hanler

  /**
   * 利用带参数的构造函数初始化各项属性
   * @param openToken 开始标记
   * @param closeToken 结束标记
   * @param handler 表处理器
   */
  public GenericTokenParser(String openToken, String closeToken, TokenHandler handler) {
    this.openToken = openToken;
    this.closeToken = closeToken;
    this.handler = handler;
  }

  /**
   * 解析statement中的sql语句
   * 将openToken和 endToken 间的字符串取出来用handler处理下，然后再拼接到一块
   * @param text
   */
  public String parse(String text) {
    if (text == null || text.isEmpty()) {
      return "";
    }
    // search open token  //  查找开始标记的下标  //判断openToken在text中的位置，注意indexOf函数的返回值-1表示不存在，0表示在在开头的位置
    int start = text.indexOf(openToken);
    if (start == -1) {
      return text;
    }
    char[] src = text.toCharArray();
    // offset用来记录builder变量读取到了哪
    int offset = 0;
    // builder 是最终返回的字符串
    final StringBuilder builder = new StringBuilder();
    StringBuilder expression = null;  // expression 是每一次找到的表达式， 要传入处理器中进行处理
    while (start > -1) {
      if (start > 0 && src[start - 1] == '\\') {  //如果text中在openToken前存在转义符就将转义符去掉。如果openToken前存在转义符，start的值必然大于0，最小也为1
        // this open token is escaped. remove the backslash and continue.  // 开始标记是转义的， 则去除转义字符'\'
        //因为此时openToken是不需要进行处理的，所以也不需要处理endToken。接着查找下一个openToken
        builder.append(src, offset, start - offset - 1).append(openToken);
        offset = start + openToken.length();
      } else { //如果不存在openToken，则直接将offset位置后的字符添加到builder中
        // found open token. let's search close token.  // 此分支是找到了结束标记， 要找到结束标记
        if (expression == null) {
          expression = new StringBuilder();
        } else {
          expression.setLength(0);
        }
        // 将开始标记前的字符串都添加到 builder 中
        builder.append(src, offset, start - offset);
        // 计算新的 offset //重设offset
        offset = start + openToken.length();
        // 从此处开始查找结束的标记
        int end = text.indexOf(closeToken, offset);

        while (end > -1) {
          if (end > offset && src[end - 1] == '\\') {
            // this close token is escaped. remove the backslash and continue.  // 此结束标记是转义的
            //添加openToken前offset后位置的字符到bulider中
            expression.append(src, offset, end - offset - 1).append(closeToken);
            offset = end + closeToken.length();//重设offset
            end = text.indexOf(closeToken, offset);
          } else {
            expression.append(src, offset, end - offset);
            break;
          }
        }

        if (end == -1) {
          // close token was not found. // 找不到结束标记了
          builder.append(src, start, src.length - start);
          offset = src.length;
        } else {
          // 找到了结束的标记， 则放入处理器进行处理
          builder.append(handler.handleToken(expression.toString()));
          offset = end + closeToken.length();
        }
      }
      // 因为字符串中可能有很多表达式需要解析， 因此开始下一个表达式的查找
      start = text.indexOf(openToken, offset);
    }
    // 最后一次未找到开始标记， 则将 offset 后的字符串添加到 builder 中
    if (offset < src.length) {
      builder.append(src, offset, src.length - offset);
    }
    return builder.toString();
  }
}
