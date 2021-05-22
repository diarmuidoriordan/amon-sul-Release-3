/**
 * @author Dermot O'Riordan
 */
package controllers;

import models.User;
import play.Logger;
import play.mvc.Controller;
import utils.UserDetails;

/**
 * This class controls displaying the user's profile and managing their personal information.
 *
 * This class contains 2 static methods, one for ADDING a new user and saving their details,
 * and another for UPDATING a user's personal information and setting a new profile picture.
 * @author Dermot O'Riordan
 */
public class ProfileCtrl extends Controller {

    /**
     * This method renders the user's profile page, where they can view
     * their personal details, and select to edit them if they wish.
     */
    public static void index() {

        Logger.info("Rendering Profile Info. for current logged-in User");

        User user = new Account().getLoggedInUser();
        user.obfuscatedPassword = UserDetails.obfuscatePassword(user.password);

        Logger.info ("Loading profile for User: " + user.email);
        render ("profile.html", user);
    }

    /**
     * This method is called when the user has selected the "Edit My Details"
     * button on their profile. It renders the "Edit User Details" web page.
     * @param userid The user's ID, passed as a Long.
     */
    public static void editUserInfo(Long userid) {
        User user = User.findById(userid);
        Logger.info("Editing Profile details for " + user.email);
        render("editprofile.html", user);
    }

    /**
     * This method is called when the user has edited their personal information
     * and clicked on the button named "Save Edited Details".
     *
     * This method saves the new details as provided by the user.
     * @param userid The user's ID, passed as a Long.
     * @param firstname The user's Christian name.
     * @param lastname The user's surname.
     * @param email The user's email address.
     * @param password The user's password.
     * @param profilepic A String containing a URL for the user's profile picture.
     */
    public static void saveUserInfo(Long userid, String firstname, String lastname, String email,
                                    String password, String profilepic) {

        Logger.info("Saving edited Profile details for " + email);
        User user = User.findById(userid);

        user.firstName = firstname;
        user.lastName = lastname;
        user.email = email;
        user.password = password;
        user.obfuscatedPassword = UserDetails.obfuscatePassword(user.password);

        if (((!profilepic.equals("")) && (!profilepic.equals(null)))) {
            user.profilePic = profilepic;
        }

        user.save();

        index();
    }
}
