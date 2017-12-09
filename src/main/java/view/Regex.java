package view;

/**
 * Created by leshchuk.t on 28.11.2017.
 */
public interface Regex {
    String lastNameRegex = "regex.input.name";
    String firstNameRegex = "regex.input.name";
    String nicknameRegex = "[A-Za-z0-9_.]+";
    String birthdayRegex = "(\\d{4})\\-(\\d{2})\\-(\\d{2})";
    String groupRegex = "FAMILY|FRIENDS|COLLEAGUES|SERVICE";
    String mobilePhoneNumberRegex = "^\\+38\\(0\\d{2}\\)\\d{3}-\\d{4}$";
    String emailRegex = "[a-z0-9.]+@[a-z]+\\.(net|com)";
    String skypeRegex = "[A-Za-z0-9_]+";
    String postcodeRegex = "[0-9]{5}";
    String streetRegex = "regex.input.street";
    String houseRegex = "\\d+\\w*";
}
