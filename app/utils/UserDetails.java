/**
 * @author Dermot O'Riordan
 */
package utils;

/**
 * This class provides a static method for obfuscating a user's password.
 * @author Dermot O'Riordan
 */
public class UserDetails {

    /**
     * This method receives the user's password as a parameter, and
     * returns a String of "****" stars the same length as the password.
     *
     * This is intended for display on the site, to protect privacy
     * and ensure security.
     * @param password The user's password.
     * @return A String of "****" stars the same length as the user's password.
     */
    public static String obfuscatePassword(String password) {
        String obfuscated = "*";
        for (int i = 1; i < password.length(); i++) {
            obfuscated += "*";
        }
        return obfuscated;
    }
}
