

package cn.goatool.core.util;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;


public class DigestUtilsTests {

	private byte[] bytes;

	@Before
	public void createBytes() throws UnsupportedEncodingException {
		bytes = "Hello World".getBytes("UTF-8");
	}

    @Test
    public void test() throws UnsupportedEncodingException {
        String s = DigestUtils.md5DigestAsHex("123");
        System.out.println(s);
    }

	@Test
	public void md5() throws IOException {
		byte[] expected = new byte[]{-0x4f, 0xa, -0x73, -0x4f, 0x64, -0x20, 0x75, 0x41, 0x5, -0x49, -0x57, -0x65, -0x19, 0x2e, 0x3f, -0x1b};
		byte[] result = DigestUtils.md5Digest(bytes);
		assertArrayEquals("Invalid hash", expected, result);
		result = DigestUtils.md5Digest(new ByteArrayInputStream(bytes));
		assertArrayEquals("Invalid hash", expected, result);
	}

	@Test
	public void md5Hex() throws IOException {
		String expected = "b10a8db164e0754105b7a99be72e3fe5";
		String hash = DigestUtils.md5DigestAsHex(bytes);
		assertEquals("Invalid hash", expected, hash);
		hash = DigestUtils.md5DigestAsHex(new ByteArrayInputStream(bytes));
		assertEquals("Invalid hash", expected, hash);
	}

	@Test
	public void md5StringBuilder() throws IOException {
		String expected = "b10a8db164e0754105b7a99be72e3fe5";
		StringBuilder builder = new StringBuilder();
		DigestUtils.appendMd5DigestAsHex(bytes, builder);
		assertEquals("Invalid hash", expected, builder.toString());
		builder = new StringBuilder();
		DigestUtils.appendMd5DigestAsHex(new ByteArrayInputStream(bytes), builder);
		assertEquals("Invalid hash", expected, builder.toString());
	}

}
