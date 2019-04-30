package A01_create;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * Created by 64274 on 2019/4/30.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/4/30---11:01
 */
public class ThreadTest extends JFrame {

    private static final long serialVersionUID = -7584852068430067696L;
    private JPanel contentPane;
    private JTextArea textArea1;
    private JTextArea textArea2;

    private String text1 = "111\n";
    private String text2 = "222\n";

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Throwable e) {
            e.printStackTrace();
        }
        EventQueue.invokeLater(()->{
            try {
                ThreadTest frame = new ThreadTest();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the frame.
     */
    public ThreadTest() {
        setTitle("\u65B0\u5EFA\u6CA1\u6709\u8FD4\u56DE\u503C\u7684\u7EBF\u7A0B");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel buttonPanel = new JPanel();
        contentPane.add(buttonPanel, BorderLayout.NORTH);
        buttonPanel.setLayout(new GridLayout(1, 2, 5, 5));

        JButton button1 = new JButton("\u5355\u7EBF\u7A0B\u7A0B\u5E8F");
        button1.addActionListener(e->do_button1_actionPerformed());
        button1.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        buttonPanel.add(button1);

        JButton button2 = new JButton("\u591A\u7EBF\u7A0B\u7A0B\u5E8F");
        button2.addActionListener(e->do_button2_actionPerformed());
        button2.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        buttonPanel.add(button2);

        JPanel contentPanel = new JPanel();
        contentPane.add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(new GridLayout(1, 2, 5, 5));

        JScrollPane scrollPane1 = new JScrollPane();
        contentPanel.add(scrollPane1);

        textArea1 = new JTextArea();
        textArea1.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        scrollPane1.setViewportView(textArea1);

        JScrollPane scrollPane2 = new JScrollPane();
        contentPanel.add(scrollPane2);

        textArea2 = new JTextArea();
        textArea2.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        scrollPane2.setViewportView(textArea2);
    }

    // 单线程 按钮
    protected void do_button1_actionPerformed() {
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            sb.append(text1);
        }
        for (int i = 0; i < 5; i++) {
            sb.append(text2);
        }
        textArea1.setText(sb.toString());
    }

    // 双线程 按钮
    protected void do_button2_actionPerformed() {
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            new Thread(()->doWork(text1,sb,textArea2)).start();
        }
        for (int i = 0; i < 5; i++) {
            new Thread(()->doWork(text2,sb,textArea2)).start();
        }
    }

    public void doWork(String text,StringBuilder sb,JTextArea textArea2){
        sb.append(text);
        textArea2.setText(sb.toString());
    }
}
