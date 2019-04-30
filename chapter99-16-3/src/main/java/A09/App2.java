package A09;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by 64274 on 2019/4/30.
 *
 * @ Description: 带有返回值的
 * @ author  山羊来了
 * @ date 2019/4/30---10:19
 */
public class App2 extends JFrame{

    /**
     *
     */
    private static final long serialVersionUID = 2671056183299397274L;
    private JPanel contentPane;
    private JTextArea thread1TextArea;
    private JTextArea thread2TextArea;
    private JTextArea thread3TextArea;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Throwable e) {
            e.printStackTrace();
        }
        EventQueue.invokeLater(()->{
            try {
                App2 frame = new App2();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the frame.
     */
    public App2() {
        setTitle("\u65B0\u5EFA\u6709\u8FD4\u56DE\u503C\u7684\u7EBF\u7A0B");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        JPanel buttonPanel = new JPanel();
        contentPane.add(buttonPanel, BorderLayout.SOUTH);

        JButton startButton = new JButton("\u5F00\u59CB\u5B58\u94B1");
        startButton.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        startButton.addActionListener(arg0->do_button_actionPerformed());
        buttonPanel.add(startButton);

        JPanel processPanel = new JPanel();
        contentPane.add(processPanel, BorderLayout.CENTER);
        processPanel.setLayout(new GridLayout(0, 3, 5, 5));

        JPanel thread1Panel = new JPanel();
        processPanel.add(thread1Panel);
        thread1Panel.setLayout(new BorderLayout(0, 0));

        JLabel thread1Label = new JLabel("\u4E00\u53F7\u7EBF\u7A0B");
        thread1Label.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        thread1Label.setHorizontalAlignment(SwingConstants.CENTER);
        thread1Panel.add(thread1Label, BorderLayout.NORTH);

        JScrollPane thread1ScrollPane = new JScrollPane();
        thread1Panel.add(thread1ScrollPane, BorderLayout.CENTER);

        thread1TextArea = new JTextArea();
        thread1TextArea.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        thread1ScrollPane.setViewportView(thread1TextArea);

        JPanel thread2Panel = new JPanel();
        processPanel.add(thread2Panel);
        thread2Panel.setLayout(new BorderLayout(0, 0));

        JLabel thread2Label = new JLabel("\u4E8C\u53F7\u7EBF\u7A0B");
        thread2Label.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        thread2Label.setHorizontalAlignment(SwingConstants.CENTER);
        thread2Panel.add(thread2Label, BorderLayout.NORTH);

        JScrollPane thread2ScrollPane = new JScrollPane();
        thread2Panel.add(thread2ScrollPane, BorderLayout.CENTER);

        thread2TextArea = new JTextArea();
        thread2TextArea.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        thread2ScrollPane.setViewportView(thread2TextArea);

        JPanel thread3Panel = new JPanel();
        processPanel.add(thread3Panel);
        thread3Panel.setLayout(new BorderLayout(0, 0));

        JLabel thread3Label = new JLabel("\u4E09\u53F7\u7EBF\u7A0B");
        thread3Label.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        thread3Label.setHorizontalAlignment(SwingConstants.CENTER);
        thread3Panel.add(thread3Label, BorderLayout.NORTH);

        JScrollPane thread3ScrollPane = new JScrollPane();
        thread3Panel.add(thread3ScrollPane, BorderLayout.CENTER);

        thread3TextArea = new JTextArea();
        thread3TextArea.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        thread3ScrollPane.setViewportView(thread3TextArea);
    }

    protected void do_button_actionPerformed() {
        Bank bank = new Bank();
        Transfer2 transfer1 = new Transfer2(bank, thread1TextArea);// 创建Transfer对象
        Transfer2 transfer2 = new Transfer2(bank, thread2TextArea);// 创建Transfer对象
        FutureTask<Integer> task1 = new FutureTask<>(transfer1);// 创建FutureTask对象
        FutureTask<Integer> task2 = new FutureTask<>(transfer2);// 创建FutureTask对象
        Thread thread1 = new Thread(task1);// 创建一号线程
        Thread thread2 = new Thread(task2);// 创建二号线程
        thread1.start();// 运行一号线程
        thread2.start();// 运行二号线程
        try {
            int thread1Result = task1.get();// 获得一号线程的计算结果
            int thread2Result = task2.get();// 获得二号线程的计算结果
            thread3TextArea.setText(thread3TextArea.getText() + "一号计算结果是：" + thread1Result + "\n");// 更新三号线程文本域信息
            thread3TextArea.setText(thread3TextArea.getText() + "二号计算结果是：" + thread2Result + "\n");// 更新三号线程文本域信息
            thread3TextArea.setText(thread3TextArea.getText() + "实际的金额是：" + (thread1Result + thread2Result - 100) + "\n");// 更新三号线程文本域信息
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
