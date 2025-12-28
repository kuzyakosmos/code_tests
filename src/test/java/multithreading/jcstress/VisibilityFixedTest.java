package multithreading.jcstress;

import org.openjdk.jcstress.annotations.*;
import org.openjdk.jcstress.infra.results.I_Result;

@JCStressTest
@Outcome(id = "0", expect = Expect.ACCEPTABLE)
@Outcome(id = "42", expect = Expect.ACCEPTABLE)
@Outcome(id = "0", expect = Expect.FORBIDDEN)
@State
public class VisibilityFixedTest {

    int data;
    volatile boolean ready;

    @Actor
    public void writer() {
        data = 42;
        ready = true;
    }

    @Actor
    public void reader(I_Result r) {
        if (ready) {
            r.r1 = data;
        }
    }
}