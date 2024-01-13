import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        boolean isValid = false;
        int montBank = 2000;
        String username = "user1";
        String password = "123";
        int validBank = 100034778;

        if (login(isValid, username, password, scanner)) {
            mainOptions(montBank, validBank, scanner);
        } else {
            System.out.println("Contact");
            Thread.sleep(5000);
        }
        scanner.close();
    }

    static boolean login(boolean isValid, String username, String password, Scanner scanner) {
        int cont = 0;
        while (cont < 3) {
            System.out.println("Username: ");
            String validName = scanner.next();
            System.out.println("Password: ");
            String validPass = scanner.next();

            if (validName.equals(username) && validPass.equals(password)) {
                return isValid = true;
            } else {
                cont++;
                System.out.println("System incorrect");
            }
        }
        return isValid;
    }

    static int mainMenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the bank");
        System.out.println("1. deposit");
        System.out.println("2. withdraw");
        System.out.println("3. view");
        System.out.println("4. transfer money");
        System.out.println("5. exit");
        int numberOptions = scanner.nextInt();
        return numberOptions;
    }

    static int mainOptions(int montBank, int validBank, Scanner scanner) {
        boolean exit = false;
        while (!exit) {
            switch (mainMenu()) {
                case 1:
                    montBank = deposit(montBank, scanner);
                    break;
                case 2:
                    montBank = withdraw(montBank, scanner);
                    break;
                case 3:
                    System.out.println("Total amount: " + montBank);
                    break;
                case 4:
                    transfer(montBank, validBank, scanner);
                    break;
                case 5:
                    System.out.println("Goodbye");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        return montBank;
    }

    static int deposit(int montBank, Scanner scanner) {
        System.out.println("Deposit: ");
        int sumDeposit = scanner.nextInt();

        if (sumDeposit >= 0) {
            montBank += sumDeposit;
            System.out.println("This is the amount after deposit: " + montBank);
        } else {
            System.out.println("Error in the system");
        }
        return montBank;
    }

    static  int withdraw(int montBank, Scanner scanner) {
        System.out.println("Current balance: " + montBank);
        System.out.println("Withdraw: ");
        int withdrawalAmount = scanner.nextInt();

        if (withdrawalAmount <= montBank && withdrawalAmount >= 0) {
            montBank -= withdrawalAmount;
            System.out.println("This is the amount after withdrawal: " + montBank);
        } else {
            System.out.println("Error in the system");
        }
        return montBank;
    }

    static int transfer(int montBank, int validBank, Scanner scanner) {
        System.out.print("Recipient's Name: ");
        String recipientName = scanner.next();
        System.out.print("Recipient's Account Number: ");
        int recipientAccount = scanner.nextInt();
        System.out.println("Amount to Transfer: ");
        int transferAmount = scanner.nextInt();

        if (transferAmount > 0 && transferAmount <= montBank && recipientAccount == validBank) {
            montBank -= transferAmount;
            System.out.println("Transfer Successful");
            System.out.println("Recipient's Name: " + recipientName);
            System.out.println("Recipient's Account Number: " + recipientAccount);
            System.out.println("Transferred Amount: " + transferAmount);
            System.out.println("Remaining Balance: " + montBank);
        } else {
            System.out.println("Error in the system");
        }
        return montBank;
    }


}
