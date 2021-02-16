public class Card {

    private String firstName;
    private String lastName;
    private String cardNumber;
    private String cardPin;
    private int money;

    public Card(String firstName, String lastName, String cardNumber, String cardPin) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.cardNumber = cardNumber;
        this.cardPin = cardPin;
    }

    public void printCard() {
        System.out.println("First name: " + firstName);
        System.out.println("Last name: " + lastName);
        System.out.println("Card number: " + cardNumber);
        System.out.println("Card pin: " + cardPin);
        System.out.println("Balance: " + money);
    }

    public int getMoney() {
        return money;
    }

    public void deposit(int amount) {
        System.out.println("Choose amount to deposit");
        if(amount >= 0) {
            this.money += amount;
            System.out.println("Successfully deposited " + amount + " euros");
        }
        else {
            System.out.println("Invalid input, enter a positive amount");
        }
    }

    public void withdraw(int amount) {
        if (amount <= money) {
            this.money -= amount;
            System.out.println("Successfully withdrawn " + amount + " euros");
        } else {
            System.out.println("Not enough funds.");
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardPin() {
        return cardPin;
    }

    public void setCardPin(String cardPin) {
        this.cardPin = cardPin;
    }

}
