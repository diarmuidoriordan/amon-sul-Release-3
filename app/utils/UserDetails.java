package utils;

public class UserDetails {

    public static String obfuscatePassword(String password) {
        String obfuscated = "*";
        for (int i = 1; i < password.length(); i++) {
            obfuscated += "*";
        }
        return obfuscated;
    }
}
