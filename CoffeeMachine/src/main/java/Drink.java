public class Drink {

    private int coffee;
    private int milk;
    private int sugar;

    public Drink(int coffee, int milk, int sugar) {
        this.coffee = coffee;
        this.milk = milk;
        this.sugar = sugar;
    }

    public void print() {
        System.out.println("Coffee: " + this.coffee + " Sugar: " + this.milk + " Cream: " + this.sugar);
    }
}
