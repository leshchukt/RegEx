package model.entities;

import java.time.LocalDate;

/**
 * Created by leshchuk.t on 20.11.2017.
 */
public class Note {
    private String lastName;
    private String firstName;
    private String nickname;
    private LocalDate birthday;
    private Group group;
    private String mobilePhoneNumber;
    private String email;
    private String skypeAccount;
    private String postCode;
    private String street;
    private String houseNumber;
    private LocalDate startDate;

    public Note(String lastName, String firstName, String nickname, LocalDate birthday,
                Group group, String mobilePhoneNumber, String email, String skypeAccount,
                String postCode, String street, String houseNumber, LocalDate startDate) {

        this.lastName = lastName;
        this.firstName = firstName;
        this.nickname = nickname;
        this.birthday = birthday;
        this.group = group;
        this.mobilePhoneNumber = mobilePhoneNumber;
        this.email = email;
        this.skypeAccount = skypeAccount;
        this.postCode = postCode;
        this.street = street;
        this.houseNumber = houseNumber;
        this.startDate = startDate;
    }

    public String getNickname() {
        return nickname;
    }

    String getInitials() {
        return lastName + " " + firstName.charAt(0) + ".";
    }

    String getAddress() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(postCode)
                .append(" ")
                .append(" ")
                .append(street)
                .append(" ")
                .append(houseNumber);
        return stringBuffer.toString();
    }

    @Override
    public String toString() {
        return "Note{" +
                "name='" + this.getInitials() + '\'' +
                ", nickname='" + nickname + '\'' +
                ", birthday='" + birthday + '\'' +
                ", group=" + group +
                ", mobilePhoneNumber='" + mobilePhoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", skypeAccount='" + skypeAccount + '\'' +
                ", address='" + this.getAddress() + '\'' +
                ", startDate=" + startDate +
                "}\n";
    }
}
