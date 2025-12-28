package multithreading.jcstress;

import org.openjdk.jcstress.annotations.*;
import org.openjdk.jcstress.infra.results.I_Result;

@JCStressTest
@Outcome(id = "0", expect = Expect.ACCEPTABLE, desc = "Reader did not see the flag")
@Outcome(id = "42", expect = Expect.ACCEPTABLE, desc = "Reader saw the correct value")
@Outcome(id = "-1", expect = Expect.FORBIDDEN, desc = "Flag seen, but data not visible")
@State
public class VisibilityBrokenTest {

    int data;
    boolean ready;

    @Actor
    public void writer() {
        data = 42;
        ready = true;
    }

    @Actor
    public void reader(I_Result r) {
        if (ready) {
            r.r1 = data;
        } else {
            r.r1 = 0;
        }
    }
}
