package A09;

import javax.swing.*;

/** 往账户里存钱 */
public class Transfer implements Runnable {

	private Bank bank;
	private JTextArea textArea;

	public Transfer(Bank bank, JTextArea textArea) {
		this.bank = bank;
		this.textArea = textArea;
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			bank.deposit(10); // 每次往账户里存入10元
			textArea.setText(textArea.getText() + "账户的余额是：" + bank.getAccount() + "\n");
		}
	}
}