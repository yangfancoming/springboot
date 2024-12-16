package com.goat.xml.dom4j;

import com.goat.xml.base.MyBase;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.junit.Test;

import java.io.IOException;


/**
 * 删除 xml 测试 只删除 匹配到的第一个
 */
public class DeleteStudent extends MyBase {

    @Test
    public void test() throws IOException {
        boolean result = deleteStudent(document, 321);
        if (result) {
            save(file);
        }
    }

	private static boolean deleteStudent(Document document, int rollNumber) {
		Element root = document.getRootElement();
		String expression = "/class/student[@rollnumber="+rollNumber+"]";
		Node node = document.selectSingleNode(expression);
		boolean result = false;
		if(node != null){
			Element element=(Element)node;
			root.remove(element);
			result = true;
		}
		return result;
	}

}
