package multithreading.aqs;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class Mutex {

    static class Sync extends AbstractQueuedSynchronizer {
        public Sync() {
            setState(100); // set the initial satate, being unlocked
        }

        @Override
        protected boolean tryAcquire(int arg) {
            return super.tryAcquire(arg);
        }

        @Override
        protected boolean tryRelease(int arg) {
            return super.tryRelease(arg);
        }
    }
}
