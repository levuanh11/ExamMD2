
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
    private static final String AMOUNT_REGEX = "\\d+";
    private static final String PRICE_REGEX = "\\d+";

    public Validate() {
    }

    public boolean validateAmount(String regex) {
        Pattern pattern = Pattern.compile(AMOUNT_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }

    public boolean validatePrice(String regex) {
        Pattern pattern = Pattern.compile(PRICE_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
