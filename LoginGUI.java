import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginGUI extends JFrame implements ActionListener {

    private JPasswordField pinField;
    private JButton loginBtn;
    private BankAccount account;

    public LoginGUI(BankAccount account) {

        this.account = account;

        setTitle("ATM Login");
        setSize(400,300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        JLabel title =
                new JLabel("ATM LOGIN");

        title.setBounds(120,40,200,40);
        title.setFont(new Font("Arial",Font.BOLD,28));

        add(title);

        JLabel pinLabel =
                new JLabel("Enter PIN");

        pinLabel.setBounds(80,100,100,30);

        add(pinLabel);

        pinField =
                new JPasswordField();

        pinField.setBounds(170,100,120,30);

        add(pinField);

        loginBtn =
                new JButton("LOGIN");

        loginBtn.setBounds(120,170,140,40);

        loginBtn.addActionListener(this);

        add(loginBtn);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String pin =
                new String(pinField.getPassword());

        if(pin.equals("1234")) {

            dispose();

            new ATMGUI(account);
        }
        else {

            JOptionPane.showMessageDialog(
                    this,
                    "Wrong PIN");
        }
    }
}