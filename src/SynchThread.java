import java.io.IOException;

public class SynchThread extends Thread{
    private Roid roid;
    public  SynchThread(String nameOfDirection, Roid r){
        super(nameOfDirection);
        this.roid = r;
    }
    public synchronized void run(){
        for(int i=1;i<4;i++){
            try {
                roid.skip(getName(),i);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
