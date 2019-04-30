package A01_create.example01;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * Created by 64274 on 2019/4/30.
 *
 * @ Description: 线程睡眠   龟兔赛跑演示
 * @ author  山羊来了
 * @ date 2019/4/30---11:45
 */

public class RaceFrame extends JFrame {

    private static final long serialVersionUID = 4941729012450153307L;
    private JPanel contentPane;
    private JTextArea rabbitTextArea;
    private JTextArea tortoiseTextArea;

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Throwable e) {
            e.printStackTrace();
        }
        EventQueue.invokeLater(()->{
            try {
                RaceFrame frame = new RaceFrame();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the frame.
     */
    public RaceFrame() {
        setTitle("\u4F11\u7720\u5F53\u524D\u7EBF\u7A0B");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        JPanel buttonPanel = new JPanel();
        contentPane.add(buttonPanel, BorderLayout.SOUTH);

        JButton button = new JButton("\u6BD4\u8D5B\u5F00\u59CB");
        button.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        button.addActionListener(arg0->do_button_actionPerformed());
        buttonPanel.add(button);

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.CENTER);
        panel.setLayout(new GridLayout(1, 2, 5, 5));

        JPanel rabbitPanel = new JPanel();
        panel.add(rabbitPanel);
        rabbitPanel.setLayout(new BorderLayout(0, 0));

        JLabel rabbitLabel = new JLabel("\u5154\u5B50\u7684\u6BD4\u8D5B\u8BB0\u5F55");
        rabbitLabel.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        rabbitLabel.setHorizontalAlignment(SwingConstants.CENTER);
        rabbitPanel.add(rabbitLabel, BorderLayout.NORTH);

        JScrollPane rabbitScrollPane = new JScrollPane();
        rabbitPanel.add(rabbitScrollPane, BorderLayout.CENTER);

        rabbitTextArea = new JTextArea();
        rabbitTextArea.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        rabbitScrollPane.setViewportView(rabbitTextArea);

        JPanel tortoisePanel = new JPanel();
        panel.add(tortoisePanel);
        tortoisePanel.setLayout(new BorderLayout(0, 0));

        JLabel tortoiseLabel = new JLabel("\u4E4C\u9F9F\u7684\u6BD4\u8D5B\u8BB0\u5F55");
        tortoiseLabel.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        tortoiseLabel.setHorizontalAlignment(SwingConstants.CENTER);
        tortoisePanel.add(tortoiseLabel, BorderLayout.NORTH);

        JScrollPane tortoiseScrollPane = new JScrollPane();
        tortoisePanel.add(tortoiseScrollPane, BorderLayout.CENTER);

        tortoiseTextArea = new JTextArea();
        tortoiseTextArea.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        tortoiseScrollPane.setViewportView(tortoiseTextArea);
    }

    protected void do_button_actionPerformed() {
        Runnable run1 = new Rabbit(rabbitTextArea);
        Runnable run2 = new Tortoise(tortoiseTextArea);
        Thread rabbit = new Thread(run1);
        Thread tortoise = new Thread(run2);
        rabbit.start();
        tortoise.start();
    }

}