package Work.workshop15.test04;

public class SleepThread extends Thread{




    @Override
    public void run() {

        for (int i = 1; i <=5; i++) {

            System.out.println("출력: "+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }

    @Override
    public void start() {
        super.start();
    }
}
