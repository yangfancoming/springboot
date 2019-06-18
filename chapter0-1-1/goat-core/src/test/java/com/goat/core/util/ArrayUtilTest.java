package com.goat.core.util;


import org.junit.Assert;
import org.junit.Test;


/**
 * {@link ArrayUtil} 数组工具单元测试
 * 
 * @author Looly
 *
 */
public class ArrayUtilTest {

	@Test
	public void isEmptyTest() {
		int[] a = {};
		Assert.assertTrue(ArrayUtil.isEmpty(a));

		int[] b = null;
		Assert.assertTrue(ArrayUtil.isEmpty(b));

        Long[] c = new Long[0];
        Assert.assertTrue(ArrayUtil.isEmpty(c));
	}

}
