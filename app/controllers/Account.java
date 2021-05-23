/**
 * @author Dermot O'Riordan
 */
package controllers;

import models.User;
import play.Logger;
import play.mvc.Controller;
import utils.UserDetails;

/**
 * This class creates and manages the User accounts for the program.
 *
 * This class contains 6 static methods that can be accessed by other
 * parts of this program to manage user accounts as necessary.
 * @author Dermot O'Riordan
 */
public class Account extends Controller {

    /**
     * Renders the registration page for new users to sign up.
     */
    public static void signup() {
        render("signup.html");
    }

    /**
     * Renders the Login page for users to sign in.
     */
    public static void login() {
        render("start.html");
    }

    /**
     * Creates a new user upon registration, accepting the user's personal
     * details from the values they input into the registration form.
     * @param firstname The user's Christian name.
     * @param lastname The user's surname.
     * @param email The user's email address.
     * @param password The user's password.
     */
    public static void register(String firstname, String lastname, String email, String password) {

        Logger.info("Registering new user " + email);
        User user = new User(firstname, lastname, email, password, "/public/images/default-profile-pic.jpg");
        user.save();
        authenticate(email, password);
    }

    /**
     * If the user input the correct email address and password when attempting
     * to log in, then the user will be redirected to their Stations dashboard,
     * otherwise they will be returned to the home page to re-attempt logging in.
     * @param email The user's email address.
     * @param password The user's password.
     */
    public static void authenticate(String email, String password) {
        Logger.info("Attempting to authenticate with " + email + ":" + password);
        User user = User.findByEmail(email);

        if ((user != null) && (user.checkPassword(password) == true)) {
            Logger.info("Authentication successful");
            session.put("logged_in_Userid", user.id);
            redirect ("/dashboard");
        }
        else {
            Logger.info("Authentication failed");
            redirect("/");
        }
    }

    /**
     * Redirects the user to the home page when they log out.
     */
    public static void logout() {
        session.clear();
        redirect ("/");
    }

    /**
     * A method to retrieve the currently logged-in user and return this user as a User.
     *
     * Returns to the login page if it cannot recognise the user as logged in.
     * @return The user that is logged in.
     */
    public static User getLoggedInUser() {
        User user = null;

        if (session.contains("logged_in_Userid")) {
            String userId = session.get("logged_in_Userid");
            user = User.findById(Long.parseLong(userId));
        }
        else {
            login();
        }
        return user;
    }
}
