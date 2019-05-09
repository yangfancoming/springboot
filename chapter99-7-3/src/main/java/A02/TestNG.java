package A02;


import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestNG {

    @Test
    public void test() throws IOException {
        Runtime rt = Runtime.getRuntime();
        // 运行记事本程序，单独启动一个进程运行操作系统命令
        rt.exec("notepad.exe");
    }



    /* 读取命令行 */
    public static void main(String[] args) throws IOException {
        String in ;
        do {
            System.out.println("请输入一个数字：");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            in = bufferedReader.readLine();
            System.out.println(in);
        } while (!in.equals("exit"));
    }

}
