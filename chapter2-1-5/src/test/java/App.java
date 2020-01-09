import org.junit.Test;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Administrator on 2020/1/8.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2020/1/8---17:21
 */
public class App {

    Integer[] arr = {1,3,5,7,9};
    String[] arr2 = {"1","3","5","7","9"};

    @Test
    public void test(){
        System.out.println(reverseArray(arr));
        System.out.println(reverseArray(arr2));
    }

    private static<T> Object[] reverseArray(T[] arr){
        List<T> list = Arrays.asList(arr);
        Collections.reverse(list);
        return list.toArray();
    }

    @Test
    public void test2(){
        calcN(1);
    }


    public static void calcN(int n) {
        System.out.println(n);
        if (n<=10000) {
            calcN(n*3);
        }
        System.out.println(n);
    }

    @Test
    public void test3(){
        System.out.println(extractYearMonthDayOfIdCard("210421198511154212"));;
    }

    /**
     * 身份证的正则表达式^(\d{15}|\d{17}[\dx])$  匹配一个字符串是不是由15位数字组成或者是17位数字+一位数字/x/X组成的
     * @param id    省份证号
     * @return    生日（yyyy-MM-dd）
     */
    public String extractYearMonthDayOfIdCard(String id) {
        //正则匹配身份证号是否是正确的，15位或者17位数字+数字/x/X
        if (id.matches("^\\d{15}|\\d{17}[\\dxX]$")) {
            String year = id.substring(6, 10);
            String month = id.substring(10,12);
            String day = id.substring(12,14);
            return year + "-" + month + "-" + day;
        }else {
            System.out.println("身份证号码不匹配！");
            return null;
        }

    }


    @Test
    public void test4() throws IOException {
        findInfoInFile("D:\\123\\12.txt","sdf");
    }


/**
     * @Description: 功能描述：(这里用一句话描述这个方法的作用)
     * @author: 杨帆
     * @Param:
     * @Return:
     * @Date:   2020/1/8
*/
    /**
     *  给定一个文件和一个字符串，判断文件是否包含该字符串，如果包含，打印该字符串的行号以及该行的全部内容
     * @param filePath    文件所在路径
     * @param subString    待查找字符串
     * @author: 杨帆
     * @Date:  2020/1/8
     */
    public static void findInfoInFile(String filePath,String subString) throws IOException {
        InputStreamReader read = new InputStreamReader(new FileInputStream(new File(filePath)));
        BufferedReader bufferedReader = new BufferedReader(read);
        String line;
        int count=0;
        while ((line = bufferedReader.readLine()) != null) {
            count++;
            if (line.contains(subString)) {
                System.out.println("子字符串整行内容：" + line + "\t 所在行数："+count);
            }
        }
    }

}
