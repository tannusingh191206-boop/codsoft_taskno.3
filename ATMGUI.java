import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ATMGUI extends JFrame implements ActionListener {
    private BankAccount account;
    private JLabel balanceLabel;
    private JTextField amountField;
    private JTextArea historyArea;

    private JButton depositBtn;
    private JButton withdrawBtn;
    private JButton balanceBtn;
    private JButton exitBtn;

    public ATMGUI(BankAccount account) {

        this.account = account;
        setTitle("ATM Dashboard");

        setSize(800,600);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(
                EXIT_ON_CLOSE);

        getContentPane().setBackground(
                new Color(15,23,42));

        setLayout(null);

        JLabel title =
                new JLabel(
                        "BANK OF INDIA");

        title.setBounds(
                250,
                30,
                400,
                40);

        title.setForeground(
                Color.CYAN);

        title.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        32));

        add(title);
        JPanel cardPanel =
        new JPanel();

cardPanel.setBounds(
        200,
        100,
        400,
        150);

cardPanel.setBackground(
        new Color(37,99,235));

add(cardPanel);
balanceLabel =
        new JLabel(
                "Balance : ₹10000");

balanceLabel.setBounds(
        280,
        280,
        250,
        30);

balanceLabel.setForeground(
        Color.GREEN);

add(balanceLabel);
amountField =
        new JTextField();

amountField.setBounds(
        250,
        330,
        300,
        40);

add(amountField);
depositBtn =
        new JButton("Deposit");

depositBtn.setBounds(
        80,
        420,
        150,
        50);

add(depositBtn);
depositBtn.addActionListener(this);

withdrawBtn =
        new JButton("Withdraw");

withdrawBtn.setBounds(
        260,
        420,
        150,
        50);

add(withdrawBtn);
withdrawBtn.addActionListener(this);

balanceBtn =
        new JButton("Balance");

balanceBtn.setBounds(
        440,
        420,
        150,
        50);

add(balanceBtn);
balanceBtn.addActionListener(this);
exitBtn =
        new JButton("Exit");

exitBtn.setBounds(
        300,
        500,
        150,
        50);

exitBtn.addActionListener(this);

add(exitBtn);
historyArea =
        new JTextArea();

historyArea.setEditable(false);

JScrollPane scroll =
        new JScrollPane(historyArea);

scroll.setBounds(
        200,
        500,
        400,
        80);

add(scroll);
        setVisible(true);
}
@Override
public void actionPerformed(ActionEvent e) {

    try {

        double amount =
                Double.parseDouble(
                        amountField.getText());

        // Deposit
        if(e.getSource() == depositBtn) {

            account.deposit(amount);

            balanceLabel.setText(
                    "Balance : ₹" +
                    account.getBalance());
            historyArea.append(
                     "Deposited ₹" +
                      amount + "\n");

            JOptionPane.showMessageDialog(
                    this,
                    "₹" + amount +
                    " Deposited Successfully");
        }

        // Withdraw
        else if(e.getSource() == withdrawBtn) {

            if(account.withdraw(amount)) {

                balanceLabel.setText(
                        "Balance : ₹" +
                        account.getBalance());
                historyArea.append(
                        "Withdrawn ₹" +
                         amount + "\n");

                JOptionPane.showMessageDialog(
                        this,
                        "₹" + amount +
                        " Withdrawn Successfully");
            }
            else {

                JOptionPane.showMessageDialog(
                        this,
                        "Insufficient Balance");
            }
        }

        // Balance Button
        else if(e.getSource() == balanceBtn) {

            JOptionPane.showMessageDialog(
                    this,
                    "Current Balance : ₹" +
                    account.getBalance());
        }
        else if(e.getSource() == exitBtn) {

    System.exit(0);
}

        amountField.setText("");

    }
    catch(Exception ex) {

        JOptionPane.showMessageDialog(
                this,
                "Enter a valid amount");
    }
}
}