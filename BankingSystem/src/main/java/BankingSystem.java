import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankingSystem {

    public static List<Card> cards = new ArrayList<>();
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int option = 123;
        boolean logged = false;
        int id = -1;
        while (option != 0) {
            printMenu();
            option = Integer.parseInt(input.nextLine());

            if (option == 1) {
                createAnAccount();
            }
            if (option == 2) {
                id = logIntoAccount();
                logged = id != -1;
            }
            if (id != -1) {
                while (logged) {
                    printLoggedMenu();
                    option = Integer.parseInt(input.nextLine());
                    if (option == 1) {
                        System.out.println("Choose amount to deposit");
                        int amount = Integer.parseInt(input.nextLine());
                        cards.get(id).deposit(amount);
                    }
                    if (option == 2) {
                        System.out.println("Choose amount to withdraw");
                        int amount = Integer.parseInt(input.nextLine());
                        cards.get(id).withdraw(amount);
                    }
                    if (option == 3) {
                        System.out.println("Balance: " + cards.get(id).getMoney());
                    }
                    if (option == 4) {
                        logged = false;
                    }
                }
            }
        }

    }

    private static void printLoggedMenu() {
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Balance");
        System.out.println("4. Log out");
    }

    private static int logIntoAccount() {
        System.out.println("Enter your card number and pin to login");
        String searchCardNumber = input.nextLine();
        String searchPin = input.nextLine();

        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i).getCardNumber().equals(searchCardNumber) && cards.get(i).getCardPin().equals(searchPin)) {
                System.out.println("You have successfully logged in!");
                return i;
            }
        }
        System.out.println("Wrong card name or pin!");
        return -1;
    }

    private static void createAnAccount() {
        System.out.println("Enter your first name");
        String firstName = input.nextLine();
        System.out.println("Enter your last name");
        String lastName = input.nextLine();
        String cardNumber = generateCardNumber();
        String cardPin = generateCardPin();
        Card card = new Card(firstName, lastName, cardNumber, cardPin);
        card.printCard();
        cards.add(card);
    }

    private static int exit() {
        return 0;
    }

    private static String generateCardPin() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            int digit = (int) (Math.random() * 10);
            builder.append(digit);
        }
        return String.valueOf(builder);
    }

    private static String generateCardNumber() {
        StringBuilder builder = new StringBuilder();
        LuhnAlgorithm checkValid = new LuhnAlgorithm();
        boolean isValid = false;
        while (true) {
            for (int i = 0; i < 16; i++) {
                int digit = (int) (Math.random() * 10);
                builder.append(digit);
            }
            isValid = checkValid.luhnAlgorithm(String.valueOf(builder));
            if (isValid) {
                break;
            }
            else {
                builder.setLength(0);
            }
        }
        return String.valueOf(builder);
    }



    private static void printMenu() {
        System.out.println("1. Create an account");
        System.out.println("2. Log into account");
        System.out.println("0. Exit");
    }
}
