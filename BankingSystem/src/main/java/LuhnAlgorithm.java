public class LuhnAlgorithm {

    public boolean luhnAlgorithm(String cardNumber) {
        int numDigits = cardNumber.length();

        int numSum = 0;
        boolean isSecond = false;

        for (int i = numDigits - 1; i >= 0; i --) {
            int digit = cardNumber.charAt(i) - '0';
            if(isSecond) {
                digit = digit * 2;
            }
            numSum += digit/10;
            numSum += digit%10;
            isSecond = !isSecond;
        }
        return (numSum % 10) == 0;
    }
}
