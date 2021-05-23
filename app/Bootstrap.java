/**
 * @author Dermot O'Riordan
 */
import java.util.List;

import play.*;
import play.jobs.*;
import play.test.*;

import models.*;

/**
 * This class is a bootstrapper for loading data from a YAML
 * file to fill the database and let the web app run correctly.
 * @author Dermot O'Riordan
 */
@OnApplicationStart
public class Bootstrap extends Job{

    /**
     * This method loads the data from the YAML file to populate
     * the appropriate fields on the website with data.
     */
    public void doJob() {

        if (User.count() == 0) {

            Fixtures.loadModels("data.yml");
        }
    }
}
