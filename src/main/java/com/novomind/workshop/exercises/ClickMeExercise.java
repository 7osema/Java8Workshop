package com.novomind.workshop.exercises;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ClickMeExercise {

	private String text = "text";

	public static void main(String[] args) {
		JFrame frame = new JFrame("Hello");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 200, 100);

		JButton button = new JButton("Click me!");

		button.addActionListener(ClickMeExercise::onClick);

		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("action performed");
			}
		});

		frame.getContentPane().add(button);

		frame.setVisible(true);
	}

	// Wieso funktioniert das, das ist kein ActionListener??
	private static void onClick(ActionEvent event) {
		System.out.println("Hallo");
	}

}
