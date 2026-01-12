public class Deadlockdemo{
    private final Object lockA = new Object();
    private final Object lockB = new Object();
    public void methodOne(){
        synchronized (lockA){
            System.out.println("Thread 1: holding lockA");
            try {
                Thread.sleep(100);
            } 
            catch (InterruptedException e) { }
                synchronized (lockB){
                    System.out.println("Thread 1: holding lockA and lockB");
        }
    }
}
public void methodtwo(){
    synchronized (lockB){
        System.out.println("Thread 2: holding lockB");
        try {
            Thread.sleep(100);
        } 
        catch (InterruptedException e) { }
            synchronized (lockA){
                System.out.println("Thread 1: holding lockB and lockA");
    }
}
}
public static void main(String[] args){
    Deadlockdemo demo = new Deadlockdemo();
    Thread t1 = new Thread(()->demo.methodOne());
    Thread t2 = new Thread(()->demo.methodtwo());
    t1.start();
    t2.start();
}
}

