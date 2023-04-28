package wang.chenguang.learn.question;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class 基于AQS实现一个锁 {

    public void lock() {
        sync.tryAcquire(1);
    }

    public void unLock() {
        sync.tryAcquire(1);
    }

    private final Sync sync = new Sync();

    private static class Sync extends AbstractQueuedSynchronizer {

        @Override
        public boolean tryAcquire(int arg) {
            if (compareAndSetState(0, 1)) {
                return true;
            }
            return false;
        }

        @Override
        public boolean tryRelease(int arg) {
            setState(0);
            return false;
        }

    }


}
