package yandex.october2025;

//import org.junit.jupiter.api.Test;

//import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

//import static org.junit.jupiter.api.Assertions.*;
//import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyTest {

//    @Test
    public void testEventDeliveryWithToken() throws InterruptedException {
//        EventBus eventBus = new EventBusImpl();

        AtomicInteger orderCount = new AtomicInteger();
        AtomicReference<String> lastOrderId = new AtomicReference<>();

//        SubscriptionToken token = eventBus.subscribe(order -> {
            orderCount.incrementAndGet();
//            lastOrderId.set(order.getOrderId());
//        });


//        eventBus.publish(new OrderCreated("ORDER-123"));
        Thread.sleep(100);

//        assertEquals(1, orderCount.get());
//        assertEquals("ORDER-123", lastOrderId.get());
    }

}
