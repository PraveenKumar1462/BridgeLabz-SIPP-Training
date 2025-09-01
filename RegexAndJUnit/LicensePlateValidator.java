package RegexAndJUnit;

public class LicensePlateValidator {
    private static final String LICENSE_PLATE_PATTERN = "^[A-Z]{2}\\d{4}$";
    private static final java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(LICENSE_PLATE_PATTERN);
    
    public static boolean isValid(String plate) {
        if (plate == null) {
            return false;
        }
        return pattern.matcher(plate).matches();
    }
}
