import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankingSystem {

    public static List<Card> cards = new ArrayList<>();
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println(generateCardNumber());
        printMenu();
        int option = Integer.parseInt(input.nextLine());
//        selectOption(option);
    }

//    private static void selectOption(int option) {
//        if (option == 1) {
//            createAnAccount();
//        }
//        if(option ==2) {
//            logIntoAccount();
//        }
//        if (option == 0 ) {
//            exit();
//        }
//    }
//
//    private static void createAnAccount() {
//        String firstName = input.nextLine();
//        String lastName = input.nextLine();
//        generateCardNumber();
//        generateCardPin();
//        Card card = new Card(firstName, lastName, );
//    }

    private static String generateCardNumber() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 16; i++) {
            int digit = (int) (Math.random() * 10);
            builder.append(digit);
        }
        return String.valueOf(builder);

    }

    private static void printMenu() {
        System.out.println("1. Create an account");
        System.out.println("2. Log into account");
        System.out.println("0. Exit");
    }
}
