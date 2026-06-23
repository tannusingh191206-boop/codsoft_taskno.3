import javax.swing.*;
import java.awt.*;

public class LoginGUI extends JFrame {

    public LoginGUI() {

        setTitle("ATM Login");

        setSize(400,300);

        setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        setLayout(null);

        JLabel title =
                new JLabel("ATM LOGIN");

        title.setBounds(
                120,
                50,
                200,
                40);

        title.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        28));

        add(title);
        JLabel pinLabel =
        new JLabel("Enter PIN");

pinLabel.setBounds(
        70,
        120,
        100,
        30);

add(pinLabel);

JPasswordField pinField =
        new JPasswordField();

pinField.setBounds(
        170,
        120,
        120,
        30);

add(pinField);
JButton loginButton =
        new JButton("LOGIN");

loginButton.setBounds(
        130,
        190,
        120,
        40);

add(loginButton);

        setVisible(true);
    }
}
