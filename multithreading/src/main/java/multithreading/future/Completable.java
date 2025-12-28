package multithreading.future;

public class Completable {
    public static void main(String[] args) {

//        CompletableFuture<?> feature = CompletableFuture.supplyAsync(Completable::getInt)
//                .thenApply(Completable::getInt);
//        try {
//            Integer result = feature.get();
//            ;
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
    }

    static Integer getInt() {
        return 1;
    }

//    static CompletableFuture getFuture(Integer x) {
//        return new CompletableFuture;
//    }
}
