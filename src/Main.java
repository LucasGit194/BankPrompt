import java.util.Scanner;

public class Main {
    static String endingMessage= "The Imaginary Bank thanks you for your preference. Have a great day!";
    public static String MAIN_MENU = """
            What do you wish to do today?\n
            1 - Verify Balance
            2 - Deposit Funds
            3 - Withdraw Funds
            4 - Exit\n
            """;
    static String CURRENT_BALANCE_MESSAGE = "Your current balance is %.2f USD\n";
    static Scanner input = new Scanner(System.in);
    static int operationNumber = 0;
    static float accountBalance = 2500;
    static String ERROR_MESSAGE = "Invalid option. Try again.";
    public static boolean continueOperations = true;
    public static String SECONDARY_MENU = """
                    Do you wish to proceed with another operation?\n
                    1 - Yes
                    2 - No\n
                    """;

    public static boolean newOperationCheck(boolean j) {
        j = true;
        while (continueOperations) {
            System.out.println(SECONDARY_MENU);
            int i = input.nextInt();
            if (i == 1) {
                getOperationNumber();
                break;
            } else if (i == 2) {
                System.out.println(endingMessage);
                j = false;
                continueOperations = false;
                break;
            } else {
                System.out.println(ERROR_MESSAGE);
            }
        }
        return j;
    }
    public static boolean loop(boolean i) {
        i = true;
        switch (operationNumber) {
            case 1:
                System.out.println(CURRENT_BALANCE_MESSAGE.formatted(accountBalance) + "\n");
                newOperationCheck(i);
                break;
            case 2:
                System.out.println("Input desired deposit ammount:\n");
                int addBalance;
                addBalance = input.nextInt();
                accountBalance += addBalance;
                System.out.printf((CURRENT_BALANCE_MESSAGE) + "%n", accountBalance);
                newOperationCheck(i);
                break;
            case 3:
                System.out.println("Input desired withdraw ammount:\n");
                int subBalance;
                subBalance = input.nextInt();
                while (subBalance > accountBalance) {
                    System.out.println("Ammount not aviable. Please try a different ammount.");
                    System.out.println("Input desired withdraw ammount:\n");
                    subBalance = input.nextInt();
                }
                accountBalance -= subBalance;
                System.out.printf((CURRENT_BALANCE_MESSAGE) + "%n", accountBalance);
                newOperationCheck(i);
                break;
            case 4:
                System.out.println(endingMessage);
                break;
            default:
                operationNumber = 0;
                System.out.println(ERROR_MESSAGE + "\n");
                System.out.println(MAIN_MENU);
                operationNumber = input.nextInt();
                getOperationNumber();
                break;
        }
        return i;
    }
    public static void getOperationNumber() {
        while (continueOperations) {
            System.out.println(MAIN_MENU);
            operationNumber = input.nextInt();
            loop(continueOperations);
            break;
        }
    }

    public static void main(String[] args) {
        String costumerName = "Clark Kent";
        String accountType = "Checking account";
        String welcomeMessage = """
            *****************************
            Welcome to the Imaginary Bank
            Costumer Name: %s
            Account Type: %s
            Current Balance: %.2f USD
            *****************************
            """.formatted(costumerName, accountType, accountBalance);

        System.out.println(welcomeMessage);
        getOperationNumber();
    }
}
