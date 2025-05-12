package sec01.Singleton;

public class TestSingleton {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();
        logger1.log("System started");
        System.out.println("Same instance: " + (logger1 == logger2));
    }
}
