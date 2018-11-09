
//均为Char类型
fun main(args: Array<String>) {

	// 直接指定单个字符作为字符值
	val aChar  = 'a'

	// 使用转义字符来作为字符值
	val enterChar = '\r'

	// 使用Unicode编码值来指定字符值
	val ch = '\u9999'

	// 定义一个'疯'字符值
	var zhong = '疯'

    print(aChar)
    print(enterChar)
    println(ch)
    println(zhong)

}