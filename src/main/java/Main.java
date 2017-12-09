import controller.Controller;
import view.View;

/**
 * Created by leshchuk.t on 20.11.2017.
 */
public class Main {
    public static void main(String[] args) {

        //initialization
        Controller controller = new Controller(new View());

        //main process
        controller.process();
    }
}
