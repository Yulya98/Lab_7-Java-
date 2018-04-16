import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Bid  extends Thread{
    private Integer bidId;
    public int price;
    private CyclicBarrier barrier;
    public Bid(int id, int price, CyclicBarrier barrier){
        this.bidId =id;
        this.price = price;
        this.barrier = barrier;
    }
    public Integer getBidId(){
        return  bidId;
    }
    public  int getPrice(){
        return  price;
    }
    @Override
    public void run(){
        try {
            int a = 200;
            int b=800;
            System.out.println("Клиент " + this.bidId + " определил цену");
            Thread.sleep(new Random().nextInt(3000));
            price -= a + (int) (Math.random() * b);
            System.out.println("Заявка " + this.bidId + " : " + price);
            this.barrier.await();
            System.out.println("Подождите...");
        }
        catch (BrokenBarrierException e){
            e.printStackTrace();
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }

    }
}
