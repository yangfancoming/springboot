

fun main(args: Array<String>) {
	// 以0b或0B开头的整数数值是二进制的整数
	var binValue1 = 0b1010101
	var binValue2 = 0B10101110
	// 以0x或0X开头的整数数值是十六进制的整数
	var hexValue1 = 0x13
	var hexValue2 = 0XaF
	println("binValue1的值为：$binValue1")
	println("binValue2的值为：$binValue2")
	println("hexValue1的值为：$hexValue1")
	println("hexValue2的值为：$hexValue2")

	val oneMillion = 1_000_000
	val price = 234_234_234 // price实际的值为234234234
	val android = 1234_1234 // android实际的值为12341234

    print(oneMillion)
    print(price)
    print(android)
}