

package cn.goatool.core.util;

import org.junit.After;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class FileSystemUtilsTests {

	String folder = "D:\\222\\father\\";
	String destFolder = "D:\\222\\dest\\";

	/**
	 * String folder = "D:\\222\\father\\";
	 * 最后的 \\ 可有可无
	 * 注意：最后一层目录(father)会被删掉
	 * @Date:   2020/3/17
	*/
	@Test
	public void deleteRecursively() throws Exception {
		File root = new File(folder);
		File child = new File(root, "child");
		File grandchild = new File(child, "grandchild");
		System.out.println(grandchild.mkdirs());
		File bar = new File(child, "bar.txt");
		bar.createNewFile();
		assertTrue(root.exists());
		assertTrue(child.exists());
		assertTrue(grandchild.exists());
		assertTrue(bar.exists());

		FileSystemUtils.deleteRecursively(root);
		assertFalse(root.exists());
		assertFalse(child.exists());
		assertFalse(grandchild.exists());
		assertFalse(bar.exists());
	}

	@Test
	public void copyRecursively() throws Exception {
		File src = new File(folder);
		File child = new File(src, "child");
		File grandchild = new File(child, "grandchild");
		System.out.println(grandchild.mkdirs());
		File bar = new File(child, "bar.txt");
		bar.createNewFile();
		assertTrue(src.exists());
		assertTrue(child.exists());
		assertTrue(grandchild.exists());
		assertTrue(bar.exists());

		File dest = new File(destFolder);
		// 执行递归拷贝操作
		FileSystemUtils.copyRecursively(src, dest);

		// 确定拷贝成功
		assertTrue(dest.exists());
		assertTrue(new File(dest, child.getName()).exists());

		// 递归删除
		FileSystemUtils.deleteRecursively(src);
		FileSystemUtils.deleteRecursively(dest);
		assertFalse(src.exists());
	}


	@After
	public void tearDown() {
		File tmp = new File("./tmp");
		if (tmp.exists()) {
			FileSystemUtils.deleteRecursively(tmp);
		}
		File dest = new File("./dest");
		if (dest.exists()) {
			FileSystemUtils.deleteRecursively(dest);
		}
	}

}
