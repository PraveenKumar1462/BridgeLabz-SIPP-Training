package RegexAndJUnit;

public class IPAddressValidator {
    public static boolean isValid(String ip) {
        return ip.matches("^(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)(\\.(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)){3}$");
    }
    public static void main(String[] args) {
        System.out.println(isValid("192.168.1.1"));
        System.out.println(isValid("256.100.50.0"));
    }
}