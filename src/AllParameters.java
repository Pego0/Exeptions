import java.util.Objects;

public class AllParameters {

    private static final String DATA_CORRECT = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890_";

    private AllParameters() {
    }

    private static void allParameters(String login,
                                      String password,
                                      String confirmPassword)
    throws WrongLoginException, WrongPasswordExeption{
        if (Objects.isNull(login) || login.length() > 20) {
            throw new WrongLoginException("Login does not match the required length");
        }
        if (Objects.isNull(password) || password.length() >= 20 ||
                Objects.isNull(confirmPassword) || confirmPassword.length() >= 20) {
            throw new WrongPasswordExeption("Password does not match the required length");
        }if (!areSymbolsAreCorrect(password) || !areSymbolsAreCorrect(confirmPassword)  || !areSymbolsAreCorrect(login)) {
            throw new WrongPasswordExeption("Password or login contain invalid symbols");
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordExeption("Symbols are not same");
        }
    }

    public static boolean parameters(String login, String password, String confirmPassword){
        try {
            allParameters(login, password, confirmPassword);
            return true;
        } catch (WrongLoginException | WrongPasswordExeption e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    public static boolean areSymbolsAreCorrect(String data) {
        char[] symbols = data.toCharArray();
        for (char symbol : symbols) {
            if (!DATA_CORRECT.contains(String.valueOf(symbol))){
                return false;
            }
        }
        return true;
    }
}
