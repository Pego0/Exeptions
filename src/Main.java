public class Main {
    public static void main(String[] args) {
        boolean result = AllParameters.parameters("@!#!Login_test_123", "Password_123", "Password_123");
        if (result) {
            System.out.println("Ok");
        } else  {
            System.out.println("Data must be corrected");
        }
    }
}