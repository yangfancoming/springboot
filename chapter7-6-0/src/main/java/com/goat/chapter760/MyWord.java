package com.goat.chapter760;

import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;

import java.io.File;
import java.util.List;

/**
 * Created by 64274 on 2018/7/13.
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/7/13---13:47
 */
public class MyWord {
    private MyWord() {}    //sos 构造函数私有化 防止在外部创建
    /**
         * @Description: 功能描述： 将word文档中的空白行 全部干掉！ （word版本必须2007以上）
         * @author: Goat
         * @Param:  word文档所在路径 包括文件名及后缀  "D:\\123\\123.docx"
         * @Return: 干掉空白行后的文档
         * @Date:   2018/7/13
    */
    public static void RemoveBlankLine(String filePath) throws Exception {
        WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage.load(new File(filePath));
        MainDocumentPart documentPart = wordMLPackage.getMainDocumentPart();
        // 拿到word文档内容副本
        List<Object> temp = documentPart.getContent();
        // 遍历文档中的空白行并干掉
        for (int i = 0; i <temp.size() ; i++) {
            if(temp.get(i).toString().equals("")){
                documentPart.getContent().remove(i);
                //因为通过副本遍历，删除的却是实际文档内容，所以干掉一行空白后 索引需要减1，否则串行
                i--;
            }
        }
        // 保存干掉空白行后的文档
        wordMLPackage.save(new File(filePath));
    }
}
