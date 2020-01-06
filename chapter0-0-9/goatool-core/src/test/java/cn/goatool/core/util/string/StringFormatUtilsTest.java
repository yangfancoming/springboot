package cn.goatool.core.util.string;

import org.junit.Test;

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
    public void testStripFilenameExtension() {
        assertEquals("", StringFormatUtils.stripFilenameExtension(""));
        assertEquals("myfile", StringFormatUtils.stripFilenameExtension("myfile"));
        assertEquals("myfile", StringFormatUtils.stripFilenameExtension("myfile."));
        assertEquals("myfile", StringFormatUtils.stripFilenameExtension("myfile.txt"));
        assertEquals("mypath/myfile", StringFormatUtils.stripFilenameExtension("mypath/myfile"));
        assertEquals("mypath/myfile", StringFormatUtils.stripFilenameExtension("mypath/myfile."));
        assertEquals("mypath/myfile", StringFormatUtils.stripFilenameExtension("mypath/myfile.txt"));
        assertEquals("/home/user/.m2/settings/myfile", StringFormatUtils.stripFilenameExtension("/home/user/.m2/settings/myfile"));
        assertEquals("/home/user/.m2/settings/myfile", StringFormatUtils.stripFilenameExtension("/home/user/.m2/settings/myfile."));
        assertEquals("/home/user/.m2/settings/myfile", StringFormatUtils.stripFilenameExtension("/home/user/.m2/settings/myfile.txt"));
    }
    
    @Test
    public void testGetFilenameExtension() {
        assertEquals(null, StringFormatUtils.getFilenameExtension(null));
        assertEquals(null, StringFormatUtils.getFilenameExtension(""));
        assertEquals(null, StringFormatUtils.getFilenameExtension("myfile"));
        assertEquals(null, StringFormatUtils.getFilenameExtension("myPath/myfile"));
        assertEquals(null, StringFormatUtils.getFilenameExtension("/home/user/.m2/settings/myfile"));
        assertEquals("", StringFormatUtils.getFilenameExtension("myfile."));
        assertEquals("", StringFormatUtils.getFilenameExtension("myPath/myfile."));
        assertEquals("txt", StringFormatUtils.getFilenameExtension("myfile.txt"));
        assertEquals("txt", StringFormatUtils.getFilenameExtension("mypath/myfile.txt"));
        assertEquals("txt", StringFormatUtils.getFilenameExtension("/home/user/.m2/settings/myfile.txt"));
    }
    
    @Test
    public void testGetFilename() {
        assertEquals(null, StringFormatUtils.getFilename(null));
        assertEquals("", StringFormatUtils.getFilename(""));
        assertEquals("myfile", StringFormatUtils.getFilename("myfile"));
        assertEquals("myfile", StringFormatUtils.getFilename("mypath/myfile"));
        assertEquals("myfile.", StringFormatUtils.getFilename("myfile."));
        assertEquals("myfile.", StringFormatUtils.getFilename("mypath/myfile."));
        assertEquals("myfile.txt", StringFormatUtils.getFilename("myfile.txt"));
        assertEquals("myfile.txt", StringFormatUtils.getFilename("mypath/myfile.txt"));
    }
    
    @Test
    public void testCapitalize() {
        assertEquals("I am not capitalized", StringFormatUtils.capitalize("i am not capitalized"));
    }

    @Test
    public void testUncapitalize() {
        assertEquals("i am capitalized", StringFormatUtils.uncapitalize("I am capitalized"));
    }

    @Test
    public void testUnqualify() {
        assertEquals("unqualified", StringFormatUtils.unqualify("i.am.not.unqualified"));
        assertEquals("qualified", StringFormatUtils.unqualify("this:name:is:qualified" ,':'));
    }

    @Test
    public void testQuote() {
        assertEquals("'goat'", StringFormatUtils.quote("goat"));
        assertEquals("''", StringFormatUtils.quote(""));
        assertNull(StringFormatUtils.quote(null));
    }


    @Test
    public void testQuoteIfString() {
        assertEquals("'myString'", StringFormatUtils.quoteIfString("myString"));
        assertEquals("''", StringFormatUtils.quoteIfString(""));
        assertNull(StringFormatUtils.quoteIfString(null));
        assertEquals(5, StringFormatUtils.quoteIfString(5));
    }
}
