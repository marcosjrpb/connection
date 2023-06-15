package com.example.demo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class Tela extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private JLabel label;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Tela frame = new Tela();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Tela() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        textField = new JTextField();
        contentPane.add(textField);
        textField.setColumns(35);

        JButton enviar = new JButton("Enviar");
        enviar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String textoDoCampo = textField.getText();
                label.setText(textoDoCampo);
            }
        });
        contentPane.add(enviar);
        
        label = new JLabel("Digite algo:");
        contentPane.add(label);
    }
}
