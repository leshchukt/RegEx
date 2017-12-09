package view;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by leshchuk.t on 20.11.2017.
 */
public class View implements TextConstants, Regex{

    // Resource Bundle Installation
    static String BUNDLE_NAME = "messages";

    public static final ResourceBundle bundle = ResourceBundle.getBundle(
            BUNDLE_NAME,
            //new Locale("uk"));
            new Locale("en"));

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printInputMessage(String message) {
        System.out.println(bundle.getString(message));
    }

    public void printErrorMessage(String message) {
        System.out.println(bundle.getString(errorPart + message));
    }

}
