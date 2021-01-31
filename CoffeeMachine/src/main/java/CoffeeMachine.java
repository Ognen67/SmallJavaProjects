import java.util.Scanner;

public class CoffeeMachine {

    private int water;
    private int milk;
    private int coffeeBeans;
    private int sugar;
    private int plasticCups;
    private int money;
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        CoffeeMachine machine = new CoffeeMachine();
        Customer customer = new Customer("Ognen", 10);

        machine.initialize();
        String value;

        while (true) {
            machine.optionsMessage();
            value = input.nextLine();
            if (value.equals("buy")) {
                machine.buyMessage();
                machine.buyCoffee(input.nextInt());
            }
            if (value.equals("fill")) {

            }
            if (value.equals("take")) {

            }
            if (value.equals("remaining")) {
                machine.remaining();
            }
            if (value.equals("exit")) {

            }
        }
    }

    private void buyCoffee(int numberOfOrder) {
        if (numberOfOrder < 1 || numberOfOrder > 3) {
            System.out.println("Invalid input");
        }
        if (numberOfOrder == 1) {
            buyEspresso();
        }
        if (numberOfOrder == 2) {
            buyCappuccino();
        }
        if (numberOfOrder == 3) {
            buyLatte();
        }
    }

    private void buyLatte() {
        Latte l = new Latte(100, 50, 50, 20);
        if (canMakeLatte(l)) {
            makeLatte(l);
            System.out.println("Making you an Latte!");
        } else {
            System.out.println("Not enough resources");
        }
    }

    private boolean canMakeLatte(Latte l) {
        return this.water - l.water >= 0 && this.milk - l.milk >= 0 && this.coffeeBeans - l.coffeeBeans >= 0 && this.sugar - l.sugar >= 0;
    }

    private void makeLatte(Latte l) {
        this.water -= l.water;
        this.milk -= l.milk;
        this.coffeeBeans -= l.coffeeBeans;
        this.sugar -= l.sugar;
    }

    private void buyCappuccino() {
        Cappuccino c = new Cappuccino(100, 25, 50, 20);
        if (canMakeCappuccino(c)) {
            makeCappuccino(c);
            System.out.println("Making you an Cappuccino!");
        } else {
            System.out.println("Not enough resources");
        }
    }

    private boolean canMakeCappuccino(Cappuccino c) {
        return this.water - c.water >= 0 && this.milk - c.milk >= 0 && this.coffeeBeans - c.coffeeBeans >= 0 && this.sugar - c.sugar >= 0;
    }

    private void makeCappuccino(Cappuccino c) {
        this.water -= c.water;
        this.milk -= c.milk;
        this.coffeeBeans -= c.coffeeBeans;
        this.sugar -= c.sugar;
    }

    private void buyEspresso() {
        Espresso e = new Espresso(100, 50);
        if (canMakeEspresso(e)) {
            makeEspresso(e);
            System.out.println("Making you an Espresso!");
        } else {
            System.out.println("Not enough resources");
        }
    }


    private boolean canMakeEspresso(Espresso e) {
        return this.water - e.water >= 0 && this.coffeeBeans - e.coffeeBeans >= 0;
    }

    private void makeEspresso(Espresso e) {
        this.water -= e.water;
        this.coffeeBeans -= e.coffeeBeans;
    }

    private void fill() {
        System.out.println("How much water do you want to add?");
        water = water + input.nextInt();
        System.out.println("How much milk do you want to add?");
        milk = milk + input.nextInt();
        System.out.println("How much coffee beans do you want to add?");
        coffeeBeans = coffeeBeans + input.nextInt();
        System.out.println("How much sugar do you want to add?");
        sugar = sugar + input.nextInt();
        System.out.println("How much plastic cups do you want to add?");
        plasticCups = plasticCups + input.nextInt();
        System.out.println("How much money do you want to add?");
        money = money + input.nextInt();
    }

    private void initialize() {
        water = 100;
        milk = 100;
        coffeeBeans = 100;
        sugar = 100;
        plasticCups = 3;
        money = 0;
    }

    private void remaining() {
        System.out.println("The Coffee Machine has: ");
        System.out.println("Water: " + water + " ml");
        System.out.println("Milk: " + milk + " ml");
        System.out.println("Coffee beans: " + coffeeBeans + " gr");
        System.out.println("Sugar: " + sugar + " gr");
        System.out.println("Plastic cups: " + plasticCups);
        System.out.println("Money: " + money);
    }

    private void buyMessage() {
        System.out.println("What do you want to buy?");
        System.out.println("1. Espresso");
        System.out.println("2. Cappuccino");
        System.out.println("3. Latte");
    }

    private void optionsMessage() {
        System.out.println("Write action (buy, fill, take, remaining, exit): ");
    }
}
