import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ATMGUI extends JFrame implements ActionListener {
    private BankAccount account;
    private JLabel balanceLabel;
    private JTextField amountField;
    private JTextArea historyArea;
    private JLabel clockLabel;

    private JButton depositBtn;
    private JButton withdrawBtn;
    private JButton balanceBtn;
    private JButton exitBtn;
    private JButton clearBtn;

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
        clockLabel =
        new JLabel();

clockLabel.setBounds(
        650,
        30,
        120,
        30);

clockLabel.setForeground(
        Color.WHITE);

clockLabel.setFont(
        new Font(
                "Arial",
                Font.BOLD,
                16));

add(clockLabel);
        JPanel cardPanel =
        new JPanel();

cardPanel.setBounds(
        200,
        100,
        400,
        150);

cardPanel.setBackground(
        new Color(37,99,235));

cardPanel.setLayout(null);
JLabel cardTitle =
        new JLabel("DEBIT CARD");

cardTitle.setBounds(
        20,
        15,
        200,
        30);

cardTitle.setForeground(
        Color.WHITE);

cardTitle.setFont(
        new Font(
                "Arial",
                Font.BOLD,
                20));

cardPanel.add(cardTitle);
JLabel cardNumber =
        new JLabel(
                "**** **** **** 1234");

cardNumber.setBounds(
        20,
        70,
        250,
        30);

cardNumber.setForeground(
        Color.WHITE);

cardNumber.setFont(
        new Font(
                "Arial",
                Font.BOLD,
                18));

cardPanel.add(cardNumber);
JLabel holderName =
        new JLabel(
                "CARD HOLDER");

holderName.setBounds(
        20,
        110,
        150,
        20);

holderName.setForeground(
        Color.WHITE);

cardPanel.add(holderName);
JLabel expiry =
        new JLabel(
                "12/29");

expiry.setBounds(
        320,
        110,
        60,
        20);

expiry.setForeground(
        Color.WHITE);

cardPanel.add(expiry);
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
        depositBtn.setBackground(
        new Color(34,197,94));

depositBtn.setForeground(
        Color.WHITE);

add(depositBtn);
depositBtn.addActionListener(this);

withdrawBtn =
        new JButton("Withdraw");

withdrawBtn.setBounds(
        260,
        420,
        150,
        50);
        withdrawBtn.setBackground(
        new Color(239,68,68));

withdrawBtn.setForeground(
        Color.WHITE);

add(withdrawBtn);
withdrawBtn.addActionListener(this);

balanceBtn =
        new JButton("Balance");

balanceBtn.setBounds(
        440,
        420,
        150,
        50);
        balanceBtn.setBackground(
        new Color(59,130,246));

balanceBtn.setForeground(
        Color.WHITE);

add(balanceBtn);
balanceBtn.addActionListener(this);
exitBtn =
        new JButton("Exit");

exitBtn.setBounds(
        300,
        500,
        150,
        50);
        exitBtn.setBackground(
        Color.DARK_GRAY);

exitBtn.setForeground(
        Color.WHITE);

exitBtn.addActionListener(this);

add(exitBtn);
clearBtn =
        new JButton("Clear");

clearBtn.setBounds(
        620,
        350,
        120,
        40);

clearBtn.setBackground(
        Color.LIGHT_GRAY);

clearBtn.addActionListener(this);

add(clearBtn);
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
startClock(); 
JOptionPane.showMessageDialog(
        this,
        "Welcome to Bank Of India ATM");

setVisible(true);
}
private void startClock() {

    Timer timer =
            new Timer(
                    1000,
                    e -> {

                        clockLabel.setText(
                                LocalTime.now()
                                .format(
                                        DateTimeFormatter
                                        .ofPattern(
                                                "HH:mm:ss")));
                    });

    timer.start();
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
else if(e.getSource() == clearBtn) {

    amountField.setText("");
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