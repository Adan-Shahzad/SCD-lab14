import java.util.concurrent.Semaphore;
class Printer  extends Thread{
    private int id;
    private Semaphore semaphore;
    Printer(int id, Semaphore semaphore){
        this.id=id;
        this.semaphore=semaphore;
    }
    public void run(){
        try {
            System.out.println("Printer" +id+ "Waiting for permit and waiting for printer");
            semaphore.acquire();
            System.out.println("Printer" +id+ "Got permit and is working and printer acquired");
            Thread.sleep(2000);
            System.out.println("Printer" +id+ "Finshed working and printing");
        } catch (InterruptedException e) {
            e.getStackTrace();
        }
        finally{
            semaphore.release();
            System.out.println("Printer" +id+ "Release permit");
        }
    }
}
    public class PrinterLab{
        public static void main(String[] args){
            Semaphore semaphore = new Semaphore(3);
            for(int i=1;i<=5;i++){
                new Printer(i, semaphore).start();
            }
        }
 }
 public class ResolvedDeadLockDemo{
    private final Object lockA = new Object();
    private final Object lockB = new Object();
    private final Object lockC = new Object();
    public void methodOne(){
        synchronized (lockA){
                synchronized (lockB){
                    System.out.println("Thread 1: Acquiring lockA and lockB safely");
        }
    }
}
public void methodtwo(){
    synchronized (lockA){
            synchronized (lockB){
                System.out.println("Thread 2: acquiring lockA and lockB");
    }
}
}
public void methodthree(){
    synchronized (lockA){
            synchronized (lockC){
                System.out.println("Thread 3: acquiring lockA,lockB and lockC");
    }
}
}
public static void main(String[] args){
    ResolvedDeadLockDemo demo = new ResolvedDeadLockDemo();
    Thread t1 = new Thread(()->demo.methodOne());
    Thread t2 = new Thread(()->demo.methodtwo());
    Thread t3 = new Thread(()->demo.methodthree());
    t1.start();
    t2.start();
    t3.start();
}
}
