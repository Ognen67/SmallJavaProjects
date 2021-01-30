import java.util.ArrayList;
import java.util.List;

public class CoffeeMachine {

    private int coffee;
    private int milk;
    private int sugar;
    private int plasticCups;

    public static void main(String[] args) {
        List<Drink> drinks = new ArrayList<>();
        Drink espresso = new Drink(5, 0, 0);
        Drink cappuccino = new Drink(3, 2, 0);
        Drink latte = new Drink(2, 2, 0);
        drinks.add(espresso);
        drinks.add(cappuccino);
        drinks.add(latte);

        drinks.forEach(Drink::print);

    }



}
