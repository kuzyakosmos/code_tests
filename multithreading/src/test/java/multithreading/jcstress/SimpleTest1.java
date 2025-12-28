package multithreading.jcstress;

import org.openjdk.jcstress.annotations.JCStressTest;
import org.openjdk.jcstress.annotations.State;

@JCStressTest
@State
public class SimpleTest1 {
    int x;
    int y;

    public void threadP() {

    }
}

class IntResult {

}