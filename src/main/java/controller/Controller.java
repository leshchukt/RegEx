package controller;

import model.entities.*;
import view.View;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * Created by leshchuk.t on 20.11.2017.
 */
public class Controller {

    View view;
    Scanner scanner;

    /**
     * Constructor of controller.Controller class
     * @param view
     */
    public Controller(View view) {
        this.view = view;
        this.scanner = new Scanner(System.in);
    }

    //Main work method
    public void process() {
        UtilityController utilityController = new UtilityController(view, scanner);

        boolean nextContact = true;
        while (nextContact) {
            String lastName = utilityController.inputStringValueWithRegEx(view.lastNameInput,
                    view.bundle.getString(view.lastNameRegex));
            String firstName = utilityController.inputStringValueWithRegEx(view.firstNameInput,
                    view.bundle.getString(view.firstNameRegex));
            String nickname = utilityController.inputStringValueWithRegEx(view.nicknameInput,
                    view.nicknameRegex);
            LocalDate birthday = utilityController.inputDateValueWithRegEx(view.birthdayInput,
                    view.birthdayRegex);
            Group group = Group.valueOf(utilityController.inputStringValueWithRegEx(view.groupInput,
                    view.groupRegex));
            String mobilePhoneNumber = utilityController.inputStringValueWithRegEx(view.mobilePhoneNumberInput,
                    view.mobilePhoneNumberRegex);
            String email = utilityController.inputStringValueWithRegEx(view.emailInput,
                    view.emailRegex);
            String skype =  utilityController.inputStringValueWithRegEx(view.skypeInput,
                    view.skypeRegex);
            String postcode = utilityController.inputStringValueWithRegEx(view.postcodeInput,
                    view.postcodeRegex);
            String street = utilityController.inputStringValueWithRegEx(view.streetInput,
                    view.bundle.getString(view.streetRegex));
            String house = utilityController.inputStringValueWithRegEx(view.houseInput,
                    view.houseRegex);

            boolean uniqueLogin = false;
            do {
                try {
                    NoteBook.getNoteBook().addUniqueNote(new Note(
                            lastName,
                            firstName,
                            nickname,
                            birthday,
                            group,
                            mobilePhoneNumber,
                            email,
                            skype,
                            postcode,
                            street,
                            house,
                            LocalDate.now()
                    ));
                    uniqueLogin = true;
                } catch (NotUniqueLoginException e) {
                    System.err.println(e.getMessage());
                    System.out.println("Error occupied during creation of new note! Reenter the nickname, please: ");
                    nickname = utilityController.inputStringValueWithRegEx(view.nicknameInput, view.nicknameRegex);
                }
            } while (!uniqueLogin);
            nextContact = utilityController.isNextContact();
        }
        System.out.println(NoteBook.getNoteBook().toString());
    }

}
