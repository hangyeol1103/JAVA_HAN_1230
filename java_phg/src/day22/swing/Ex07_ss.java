package day22.swing;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Ex07_ss {

	public static void main(String[] args) {
        JFrame frame = new JFrame("Full Size Button");
        JButton button = new JButton("Click Me");

        // BorderLayout 설정 (기본값이기 때문에 생략 가능)
        frame.setLayout(new BorderLayout());

        // 버튼을 FRAME의 중앙에 꽉 차게 배치
        frame.add(button, BorderLayout.CENTER);

        // JFrame 설정
        frame.setSize(400, 300); // 원하는 크기로 설정
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
	}
}
