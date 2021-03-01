public class VolatileTest implements Runnable {
    private  boolean flag = false;
    @Override
    public void run() {
        while (!flag){

        }
        System.out.println("线程结束运行...");
    }
    public void setFlag(boolean flag) {
        this.flag = flag;
    }
    public static void main(String[] args) throws InterruptedException {
        VolatileTest v = new VolatileTest();
        Thread t1 = new Thread(v);
        t1.start();
        Thread.sleep(2000);
        synchronized(v){
            v.setFlag(true);
            System.out.println("flag修改");
        }

    }
}
