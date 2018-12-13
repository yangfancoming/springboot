package com.goat.A01;


/***
 *
 *
 *  奇怪的是  该类里的执行结果 和  FileTest类里的执行结果居然不一样
 *  是因为 public static void main(String[] args) 为 整个项目的根目录！
 *  而 @Test 方法 则为 当前目录
 *
 */
public class FilenameFilterTest {

	public static void main(String[] args) {
	    FileTest.FilenameFilter();
	}

}
