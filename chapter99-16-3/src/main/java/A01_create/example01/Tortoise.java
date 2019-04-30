package A01_create.example01;

import javax.swing.*;

/**
 * Created by 64274 on 2019/4/30.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/4/30---11:47
 */
public class Tortoise implements Runnable {

    private JTextArea tortoiseTextArea;

    public Tortoise(JTextArea tortoiseTextArea) {
        this.tortoiseTextArea = tortoiseTextArea;
    }

    @Override
    public void run() {
        for (int i = 1; i < 11; i++) {
            String text = tortoiseTextArea.getText();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            tortoiseTextArea.setText(text + "乌龟跑了" + i + "0米\n");
            if (i == 10) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                tortoiseTextArea.setText(text + "乌龟到达终点\n");
            }
        }

    }

}
