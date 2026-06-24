public class Main {

    public static void main(String[] args) {

        BankAccount account =
                new BankAccount(10000);

        new LoginGUI(account);
    }
}