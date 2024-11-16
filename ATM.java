import java.util.Scanner;

class ATM {
    private double balance;
    private int pin;

    // Constructor
    public ATM(double initialBalance, int userPin) {
        balance = initialBalance;
        pin = userPin;
    }

    // Verify the PIN
    private boolean verifyPin(int enteredPin) {
        return enteredPin == pin;
    }

    // Check balance
    public void checkBalance() {
        System.out.println("Your current balance is: $" + balance);
    }

    // Withdraw money
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("You have withdrawn $" + amount);
            System.out.println("New balance: $" + balance);
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    // Show menu options
    public void showMenu() {
        System.out.println("1: Check balance");
        System.out.println("2: Withdraw money");
        System.out.println("3: Exit");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Initialize user's account
        ATM userATM = new ATM(1000.0, 1234);

        System.out.println("Please enter your PIN:");
        int enteredPin = sc.nextInt();

        // Verify the PIN
        if (userATM.verifyPin(enteredPin)) {
            int choice;

            do {
                userATM.showMenu();
                System.out.println("Please select an option:");
                choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        userATM.checkBalance();
                        break;
                    case 2:
                        System.out.println("Enter the amount to withdraw:");
                        double amount = sc.nextDouble();
                        userATM.withdraw(amount);
                        break;
                    case 3:
                        System.out.println("Thank you! Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice, please try again.");
                }
            } while (choice != 3);
        } else {
            System.out.println("Incorrect PIN!");
        }
    }
}
