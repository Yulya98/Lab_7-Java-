public class Table {
    public int countOfTable = 3;
    public  boolean available = false;

    public  synchronized void getTable() throws InterruptedException {
        while(countOfTable <1){
            wait();
        }
        countOfTable --;
        System.out.println("Взят 1 стол");
        System.out.println("Осталось " + countOfTable+ " столов");
        notify();
    }

    public  synchronized void putTable(){
        while (countOfTable>=3){
            try{wait();}
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        countOfTable++;
        System.out.println("Студент освободил 1 стол");
        System.out.println("Осталось " + countOfTable+ " столов");
        notify();
    }
}
