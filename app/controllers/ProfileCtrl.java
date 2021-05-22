package controllers;

import models.User;
import play.Logger;
import play.mvc.Controller;
import utils.UserDetails;

public class ProfileCtrl extends Controller {

    public static void index() {

        Logger.info("Rendering Profile Info. for current logged-in User");

        User user = new Account().getLoggedInUser();
        user.obfuscatedPassword = UserDetails.obfuscatePassword(user.password);

        Logger.info ("Loading profile for User: " + user.email);
        render ("profile.html", user);
    }

    public static void editUserInfo(Long userid) {
        User user = User.findById(userid);
        Logger.info("Editing Profile details for " + user.email);
        render("editprofile.html", user);
    }

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
