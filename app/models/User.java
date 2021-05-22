/**
 * @author Dermot O'Riordan
 */
package models;

import play.db.jpa.Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * This class creates and instance of the User object.
 *
 * It contains a constructor that takes in a value for each
 * of the user's personal details as its parameters, and
 * uses this to initialise the class variables.
 */
@Entity
public class User extends Model {

    /**
     * The user's Christian name.
     */
    public String firstName;

    /**
     * The user's surname.
     */
    public String lastName;

    /**
     * The user's email address.
     */
    public String email;

    /**
     * The user's password.
     */
    public String password;

    /**
     * A String of "****" the same length as the user's password.
     */
    public String obfuscatedPassword;

    /**
     * A String containing the URL for the user's profile picture.
     */
    public String profilePic;

    /**
     * A List of all the Stations for this User.
     */
    @OneToMany(cascade = CascadeType.ALL)
    public List<Station> stations = new ArrayList<Station>();

    /**
     * Constructor of the User class, this method takes in the personal details saved for the user
     * and initialises the appropriate class instance variables with these values.
     * @param firstName The Christian name of the user.
     * @param lastName The surname of the user.
     * @param email The email address of the user.
     * @param password The password of the user.
     * @param profilePic A link to the profile picture of the user.
     */
    public User(String firstName, String lastName, String email, String password, String profilePic) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.profilePic = profilePic;
    }

    /**
     * Returns a User object using the username (email address) to search
     * for the correct user's details.
     * @param email The username (email address) of the user to locate.
     * @return The correct User having been located.
     */
    public static User findByEmail(String email) {
        return find("email", email).first();
    }

    /**
     * Confirms that the password entered matches that on file for the user.
     * @param password The user's password.
     * @return True or False; whether the password entered matches the user's password.
     */
    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }
}
