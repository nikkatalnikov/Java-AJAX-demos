package org.kpi.iasa.view;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by student on 02.05.2020.
 */
public class View {

    // Resource Bundle Installation's
    static String MESSAGES_BUNDLE_NAME = "messages";
    public static final ResourceBundle bundle =
            ResourceBundle.getBundle(
                    MESSAGES_BUNDLE_NAME,
                    new Locale("en"));        // English

    //Utilities methods
    /**
     *
     * @param message
     */
    public void printMessage(String message){
        System.out.println(message);
    }
    /**
     *
     * @param message
     * @return
     */
    public String concatenationString(String... message){
            StringBuilder concatString = new StringBuilder();
            for(String v : message) {
              concatString.append(v);
            }
            return new String(concatString);
    }

    public void printStringInput(String message) {
        printMessage(concatenationString(
                bundle.getString(TextConstant.INPUT_STRING_DATA),
                bundle.getString(message)));
    }

    public void printWrongStringInput(String message) {
        printMessage(concatenationString(
                bundle.getString(TextConstant.WRONG_INPUT_DATA),
                bundle.getString(TextConstant.INPUT_STRING_DATA),
                bundle.getString(message)));
    }


}
