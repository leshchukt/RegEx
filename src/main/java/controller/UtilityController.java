package controller;

import view.View;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class UtilityController {

    private View view;
    private Scanner scanner;

    public UtilityController(View view, Scanner scanner) {
        this.view = view;
        this.scanner = scanner;
    }

    LocalDate inputDateValueWithRegEx(String message, String regex) {
        String answer;
        view.printInputMessage(message);
        while (!(scanner.hasNext() && (answer = scanner.next()).matches(regex) && parseDate(answer))) {
            view.printErrorMessage(message);
        }
        return LocalDate.parse(answer);
    }

    private boolean parseDate(String possibleDate) {
        try {
            LocalDate date = LocalDate.parse(possibleDate);
            return date.isBefore(LocalDate.now());
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    /**
     * Utility method for scanner input values
     * @param message view what info you need to input
     * @param regex pattern for input values
     * @return correct input value
     */
    String inputStringValueWithRegEx(String message, String regex){
        String answer;
        view.printInputMessage(message);
        while (!(scanner.hasNext() && (answer = scanner.next()).matches(regex))) {
            view.printErrorMessage(message);
        }
        return answer;
    }

    /**
     * Method to check if there is next contact to input
     * @return true if "Y", false if else
     */
    boolean isNextContact() {
        view.printMessage(view.bundle.getString(view.nextContact));
        return  (scanner.hasNext() && scanner.next().equalsIgnoreCase("Y"));
    }
}
