import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;

/**
 * <b>Author</b>: Hsiang Leekwok<br/>
 * <b>Date</b>: 2019/04/08 21:10<br/>
 * <b>Version</b>: v1.0<br/>
 * <b>Description</b>: 手写 JDK 可重入锁：所有线程都可以抢，也可以释放
 */
public class TestLock implements Lock {

    // 即将抢到资源的线程
    // private Thread thread = null;
    // 已经抢到资源的线程
    AtomicReference<Thread> owner = new AtomicReference<>();
    // 定义一个等待列表，记录没有抢到锁的线程
    LinkedBlockingQueue<Thread> waiting = new LinkedBlockingQueue<>();

    @Override
    public void lock() {
        while (!owner.compareAndSet(null, Thread.currentThread())) {
            // 当前线程抢不到资源，则将其放入等待队列
            waiting.add(Thread.currentThread());
            // 休眠当前线程，线程会阻塞在这里
            LockSupport.park();
            // 唤醒之后执行
            waiting.remove(Thread.currentThread());
        }
    }

    @Override
    public void unlock() {
        // 判断当前线程是不是持有资源，是才能释放，否则不予理睬
        if (owner.compareAndSet(Thread.currentThread(), null)) {
            Object[] objects = waiting.toArray();
            for (Object object : objects) {
                Thread next = (Thread) object;
                LockSupport.unpark(next);
            }
        }
    }


    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
