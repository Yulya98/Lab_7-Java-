import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.CyclicBarrier;

public class Auction {
    private ArrayList<Bid> bids;
    public CyclicBarrier barrier;
    public final int BIDS_NUMBER =5;
    static boolean flag = false;
    Bid winner = new Bid(1,2,barrier);

    public Auction(){
        this.bids = new ArrayList<Bid>();
        this.barrier = new CyclicBarrier(this.BIDS_NUMBER, new Runnable() {
            @Override
            public void run() {
                winner = Auction.this.defineWinnner();
                if(flag == true) {
                    System.out.println("Ставка #" + winner.getBidId() + ", цена: " + winner.getPrice() + " победил!");
                }
                flag = true;
            }
        });
    }
    public CyclicBarrier getBarrier(){
        return barrier;
    }
    public boolean add(Bid e){
        return bids.add(e);
    }
    public  Bid defineWinnner(){
        return Collections.min(bids, new Comparator<Bid>() {
            @Override
            public int compare(Bid o1, Bid o2) {
                return o1.getPrice() - o2.getPrice();
            }
        });
    }
}
