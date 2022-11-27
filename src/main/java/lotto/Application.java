package lotto;

public class Application {
    public static void main(String[] args) {
        Controller controller = new Controller();


        try {
            controller.play();
        } catch (IllegalArgumentException e) {
            System.out.print("[ERROR]");
            e.printStackTrace();
        }

    }
}
