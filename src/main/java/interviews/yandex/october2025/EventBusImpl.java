package interviews.yandex.october2025;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

public class EventBusImpl implements EventBus {

    ConcurrentHashMap<SubscriptionToken, Consumer<OrderCreated>> consumerMap = new ConcurrentHashMap<>();

    @Override
    public SubscriptionToken subscribe(Consumer<OrderCreated> handler) {
        SubscriptionToken subscriptionToken = new SubscriptionTokenImpl();
        consumerMap.put(subscriptionToken, handler);
        return subscriptionToken;
    }

    @Override
    public void unsubscribe(SubscriptionToken token) {
        consumerMap.remove(token);
    }

    @Override
    public void publish(OrderCreated event) {
        CompletableFuture<Consumer<OrderCreated>> completableFuture = new CompletableFuture<>();
        ExecutorService threadPoolExecutor = Executors.newCachedThreadPool();

        consumerMap.values().forEach(consumer -> {
            threadPoolExecutor.submit(() -> consumer.accept(event)
            );
        });
    }

    @Override
    public void close() throws Exception {

    }
}
