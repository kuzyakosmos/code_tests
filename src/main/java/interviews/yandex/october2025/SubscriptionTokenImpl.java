package interviews.yandex.october2025;

import java.util.Objects;
import java.util.UUID;

public class SubscriptionTokenImpl implements SubscriptionToken {
    private final UUID token = UUID.randomUUID();

    @Override
    public UUID getToken() {
        return token;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubscriptionTokenImpl that = (SubscriptionTokenImpl) o;
        return Objects.equals(token, that.token);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(token);
    }
}
