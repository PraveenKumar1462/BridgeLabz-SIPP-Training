package RegexAndJUnit;

public class UsernameValidator {
    private static final String USERNAME_PATTERN = "^[a-zA-Z][a-zA-Z0-9_]{4,14}$";
    private static final java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(USERNAME_PATTERN);
    
    public static boolean isValid(String username) {
        if (username == null) {
            return false;
        }
        return pattern.matcher(username).matches();
    }
}
