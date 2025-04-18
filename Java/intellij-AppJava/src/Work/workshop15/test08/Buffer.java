package Work.workshop15.test08;

public class Buffer {

    private Integer data = null;


    public synchronized void produce(int i) {
    while(data !=null)
    {
        try{
            wait();// 소비자가 소비할때까지 기다림
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    data = i;
        System.out.println("생산됨: "+ data);
        notify();// 소비자 깨움
    }
    public synchronized void consume() {
        while(data == null) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("소비됨: "+data);
        data = null;
        notify();
    }




}
