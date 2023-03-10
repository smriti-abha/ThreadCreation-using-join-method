
class NewThread implements Runnable{
    String name;
    Thread t;
    NewThread(String name){
        this.name=name;
        t= new Thread(this,name);
        System.out.println("New Thread: "+t);
        t.start();
    }
    public void run(){
        try{
            for(int i=5;i>0;i--){
                System.out.println(name+" "+i);
                Thread.sleep(1000);
            }
        }catch(InterruptedException e){
            System.out.println(name+"Interrupted");

        }
        System.out.println(name+" existing");
    }
}
public class Main {
    public static void main(String[] args) {
    NewThread newThread1=new NewThread("one");
    NewThread newThread2=new NewThread("two");
        NewThread newThread3=new NewThread("three");
        System.out.println("Thread one is alive"+newThread1.t.isAlive());
        System.out.println("Thread two is alive"+newThread2.t.isAlive());
        System.out.println("Thread three is alive"+newThread3.t.isAlive());
       try{
           System.out.println("Waiting for Threads to Finish");
           newThread1.t.join();
           newThread2.t.join();
           newThread3.t.join();

       }catch(InterruptedException e){
        System.out.println("Main Thread Interrupted");
       }
        System.out.println("Thread one is alive"+newThread1.t.isAlive());
        System.out.println("Thread two is alive"+newThread2.t.isAlive());
        System.out.println("Thread three is alive"+newThread3.t.isAlive());
        System.out.println("Main Thread Existing");
    }
}