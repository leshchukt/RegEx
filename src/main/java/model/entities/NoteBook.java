package model.entities;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Created by leshchuk.t on 20.11.2017.
 */
public class NoteBook {

    public static NoteBook noteBook;
    private ArrayList<Note> notes;

    private NoteBook() {
        notes = new ArrayList<>();
        notes.add(new Note("Ivanov", "Ivan", "Vano",
                LocalDate.of(1992, 2, 2), Group.COLLEAGUES,
                "+38(098)765-4567", "ivanov@gmail.com", "ivan92",
                String.valueOf(03057), "Kovalenka", "14a", LocalDate.now()));
        notes.add(new Note("Petrov", "Petro", "Petya",
                LocalDate.of(1991, 03, 02), Group.FRIENDS,
                "+38(093)453-2597", "petrov@gmail.com", "pet91",
                String.valueOf(03057), "Kyrychenka", "13f", LocalDate.now()));
    }

    public static NoteBook getNoteBook() {
        if (noteBook == null) {
            noteBook = new NoteBook();
        }
        return noteBook;
    }

    public boolean isAlreadyExists(String nickname) {
        for (Note note : notes) {
            if (note.getNickname().equalsIgnoreCase(nickname))
                return true;
        }
        return false;
    }

    public void addUniqueNote(Note note) throws NotUniqueLoginException{
        String login = note.getNickname();
        if (!isAlreadyExists(login)) {
            notes.add(note);
        } else throw new NotUniqueLoginException("Not unique note with login: " + login);
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        for (Note note : notes) {
            stringBuffer.append(note).append('\n');
        }
        return "NoteBook{" +
                stringBuffer.toString() +
                '}';
    }
}
