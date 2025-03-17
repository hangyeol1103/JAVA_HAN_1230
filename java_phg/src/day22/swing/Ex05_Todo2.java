package day22.swing;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Ex05_Todo2 {

	public static void main(String[] args) {
		/* 오늘의 할일을 입력받아 엔터를 치거나 버튼을 클릭하면
		 * 오늘의 할일이 추가되는 코드를 작성하세요.
		 * */
		
		JFrame frame = new JFrame("예제2");
		
		frame.setLayout(new BorderLayout());
		frame.setSize(400, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		
		JButton btn = new JButton("버튼");
		
		JTextField textField = new JTextField(20);
		
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		JList<String> list = new JList<String>(listModel);
		JScrollPane scrollPane = new JScrollPane(list);
		
		
		
		btn.addActionListener(e -> {
			String text = textField.getText().trim();
			
			if(!text.isEmpty()) {
				listModel.addElement(text);
			}
			
			textField.setText("");
		});
		
		textField.addActionListener(e -> {
			String text = textField.getText().trim();
			
			if(!text.isEmpty()) {
				listModel.addElement(text);
			}
			
			textField.setText("");
		});
		
		
		panel.add(textField);
		panel.add(btn);
		
		frame.add(panel, BorderLayout.NORTH);
		frame.add(scrollPane, BorderLayout.CENTER);
		
		frame.setVisible(true);
	}

}
