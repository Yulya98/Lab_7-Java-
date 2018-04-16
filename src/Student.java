import java.util.Random;

public class Student extends Thread{
    Table table = new Table();

    Student(Table newTable){
        this.table = newTable;
    }

    public void run(){
        Random random = new Random();
        try {
            table.getTable();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep(random.nextInt(200));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        table.putTable();
    }
}
