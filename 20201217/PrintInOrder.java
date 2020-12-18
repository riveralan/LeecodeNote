/**
设置两个屏障在second和three之间，屏障前自旋，执行完first后，解除second屏障；执行完second，解除three的屏障
**/
class Foo {
    private volatile int flag = 1; 
    public Foo() {
        
    }

    public void first(Runnable printFirst) throws InterruptedException {
        
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        flag = 2;
    }

    public void second(Runnable printSecond) throws InterruptedException {
            while(flag!=2);
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        flag = 3;
    }

    public void third(Runnable printThird) throws InterruptedException {
            while(flag!=3) ;
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}