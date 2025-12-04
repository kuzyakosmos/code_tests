package interviews.yandex.october2025;

import java.util.function.Consumer;

public interface EventBus extends AutoCloseable {
    SubscriptionToken subscribe(Consumer<OrderCreated> handler);

    void unsubscribe(SubscriptionToken token);

    void publish(OrderCreated event);
}