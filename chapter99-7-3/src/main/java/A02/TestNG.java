package A02;

import org.testng.annotations.Test;

import java.io.IOException;

public class TestNG {

    @Test
    public void test() throws IOException {
        Runtime rt = Runtime.getRuntime();
        // 运行记事本程序，单独启动一个进程运行操作系统命令
        rt.exec("notepad.exe");
    }




}
