import java.io.FileWriter;
import java.io.IOException;

public class Roid {
    public  FileWriter roidThread;

    public  Roid(String file) throws IOException {
        roidThread = new FileWriter(file,true);
    }

    public void skip(String str, int i) throws IOException {
        long startTime = System.nanoTime();
        roidThread.append("Приехала машина с направления "+ str+" под номером"+ i);
        roidThread.append("Осталось" + (3-i));
        System.out.println("Приехала машина с направления "+ str+" под номером"+ i);
        System.out.println("Осталось" + (3-i));
        long estimatedTime = System.nanoTime() - startTime;
        System.out.println("Машина под номером "+ i+" по направлению "+ str+" прошла за "+ estimatedTime);
    }
}