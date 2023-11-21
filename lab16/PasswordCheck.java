package lab16;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PasswordCheck extends JFrame {
    private JTextField serviceField;
    private JTextField userNameField;
    private JPasswordField passwordField;

    public PasswordCheck() {
        setTitle("Password Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new GridLayout(4, 2, 15, 15));

        // Добавление компонентов
        add(new JLabel("Service:"));
        serviceField = new JTextField();
        add(serviceField);

        add(new JLabel("User name:"));
        userNameField = new JTextField();
        add(userNameField);

        add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        add(passwordField);

        JButton checkButton = new JButton("Check Password");
        checkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkPassword();
            }
        });
        add(checkButton);

        pack();
        setLocationRelativeTo(null);
    }

    private void checkPassword() {
        String userName = userNameField.getText();
        char[] passwordChars = passwordField.getPassword();
        String password = new String(passwordChars);

        if (("Pavel".equals(userName) && !"1234".equals(password)) || ("Dmitriy".equals(userName) && !"4321".equals(password))) {
            JOptionPane.showMessageDialog(this, "Неправильный пароль", "Ошибка", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Вход выполнен успешно!", "Успех", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new PasswordCheck().setVisible(true);
            }
        });
    }
}

