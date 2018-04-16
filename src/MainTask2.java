public class MainTask2 {
    public static void main(String[] args) {
        Table table = new Table();
        Student student = new Student(table);
        Student student2 = new Student(table);
        Student student3 = new Student(table);
        Student student4 = new Student(table);
        student.start();
        student2.start();
        student3.start();
        student4.start();
        try {
            student.join();
            student2.join();
            student3.join();
            student4.join();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
