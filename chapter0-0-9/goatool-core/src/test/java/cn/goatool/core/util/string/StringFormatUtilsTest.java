package cn.goatool.core.util.string;

import org.junit.Test;

import static cn.goatool.core.util.string.StringFormatUtils.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created by Administrator on 2020/1/6.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2020/1/6---14:06
 */
public class StringFormatUtilsTest {


    @Test
    public void test(){
        // 用 0 填充  填充后总长度为4位  待填充内容  ==
        String haha = fill("1", 6, 9);
        assertEquals("1111119", haha);
    }

    
    @Test
    public void testStripFilenameExtension() {
        assertEquals("", stripFilenameExtension(""));
        assertEquals("myfile", stripFilenameExtension("myfile"));
        assertEquals("myfile", stripFilenameExtension("myfile."));
        assertEquals("myfile", stripFilenameExtension("myfile.txt"));
        assertEquals("mypath/myfile", stripFilenameExtension("mypath/myfile"));
        assertEquals("mypath/myfile", stripFilenameExtension("mypath/myfile."));
        assertEquals("mypath/myfile", stripFilenameExtension("mypath/myfile.txt"));
        assertEquals("/home/user/.m2/settings/myfile", stripFilenameExtension("/home/user/.m2/settings/myfile"));
        assertEquals("/home/user/.m2/settings/myfile", stripFilenameExtension("/home/user/.m2/settings/myfile."));
        assertEquals("/home/user/.m2/settings/myfile", stripFilenameExtension("/home/user/.m2/settings/myfile.txt"));
    }
    
    @Test
    public void testGetFilenameExtension() {
        assertEquals(null, getFilenameExtension(null));
        assertEquals(null, getFilenameExtension(""));
        assertEquals(null, getFilenameExtension("myfile"));
        assertEquals(null, getFilenameExtension("myPath/myfile"));
        assertEquals(null, getFilenameExtension("/home/user/.m2/settings/myfile"));
        assertEquals("", getFilenameExtension("myfile."));
        assertEquals("", getFilenameExtension("myPath/myfile."));
        assertEquals("txt", getFilenameExtension("myfile.txt"));
        assertEquals("txt", getFilenameExtension("mypath/myfile.txt"));
        assertEquals("txt", getFilenameExtension("/home/user/.m2/settings/myfile.txt"));
    }
    
    @Test
    public void testGetFilename() {
        assertEquals(null, getFilename(null));
        assertEquals("", getFilename(""));
        assertEquals("myfile", getFilename("myfile"));
        assertEquals("myfile", getFilename("mypath/myfile"));
        assertEquals("myfile.", getFilename("myfile."));
        assertEquals("myfile.", getFilename("mypath/myfile."));
        assertEquals("myfile.txt", getFilename("myfile.txt"));
        assertEquals("myfile.txt", getFilename("mypath/myfile.txt"));
    }
    
    @Test
    public void testCapitalize() {
        assertEquals("I am not capitalized", capitalize("i am not capitalized"));
    }

    @Test
    public void testUncapitalize() {
        assertEquals("i am capitalized", uncapitalize("I am capitalized"));
    }

    @Test
    public void testUnqualify() {
        assertEquals("unqualified", unqualify("i.am.not.unqualified"));
        assertEquals("qualified", unqualify("this:name:is:qualified" ,':'));
    }

    @Test
    public void testQuote() {
        assertEquals("'goat'", quote("goat"));
        assertEquals("''", quote(""));
        assertNull(quote(null));
    }


    @Test
    public void testQuoteIfString() {
        assertEquals("'myString'", quoteIfString("myString"));
        assertEquals("''", quoteIfString(""));
        assertNull(quoteIfString(null));
        assertEquals(5, quoteIfString(5));
    }
}
