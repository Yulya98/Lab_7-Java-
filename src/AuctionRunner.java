import java.util.Random;

public class AuctionRunner {
    public static void main(String[] args) throws InterruptedException {
        Auction auction = new Auction();
        int startPrice = 1000 + (int) (Math.random() * 1200);
        for(int i =0;i<auction.BIDS_NUMBER;i++){
            Bid thread = new Bid(i,startPrice,auction.getBarrier());
            auction.add(thread);
            thread.start();
        }
        Thread.sleep(5000);
        startPrice = auction.winner.getPrice();
        for(int i =0;i<auction.BIDS_NUMBER;i++){
            Bid thread = new Bid(i,startPrice,auction.getBarrier());
            auction.add(thread);
            thread.start();
        }
    }
}
