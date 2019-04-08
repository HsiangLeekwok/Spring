## 多线程核心知识，手写JDK锁

- 线程安全之原子性问题？
- JDK中是如何解决的？
- JDK中提供了那些锁？
- JDK中锁的原理？
- JDK中锁与JVM中锁的区别？

CAS(Compare and Swap)比较和交换

    CAS操作需要输入两个数值，一个旧值A（期望操作前的值）和一个新值B，在操作期间会先比较旧值有没有变化，如果没有变化，才交换成新值，否则不进行交换
    
Java 无法访问底层操作系统，但 JDK 有一个类 Unsave，可以用来在任意内存地址位置处读写数据。

Unsave 提供CAS操作的本地方法：compareAndSwapInt

CAS的问题：

- ABA问题
- 开销问题：循环多次不成功，线程会一直执行，占用资源
- 只能保证一个共享变量的原子操作

Lock接口和核心方法

- lock()
- unlock()
- tryLock()

可重入锁 ReentrantLock

公平锁、非公平锁

Synchronized 和 Lock 锁有什么不同

    Synchronized -> JVM实现，C++写的
    Lock 锁在 JDK 层实现
    
    底层都是 CAS 实现