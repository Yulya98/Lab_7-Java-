import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Roid newRoid = new Roid("synh.txt");
        SynchThread sync1 = new SynchThread("Слева-направо", newRoid);
        SynchThread sync2 = new SynchThread("Справа-налево", newRoid);
        sync1.start();
        sync2.start();
        sync1.join();
        sync2.join();
    }
}
