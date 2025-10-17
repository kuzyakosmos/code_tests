package multithreading.lockfreealgorithm;

/*
Fetch-and-Add работает проще и не содержит никаких циклов (в архитектуре Intel осуществляется группой команд xadd).
Также он включает 2 объекта-операнда: адрес ячейки памяти (V) и значение (S), на которое следует увеличить старое значение,
хранимое по адресу памяти (V). Так, FAA можно описать в таком виде: получить значение, располагаемое по указанному адресу (V)
и сохранить его временно. Затем в указанный адрес (V) занести сохраненное ранее значение, увеличенное на значение,
которое из себя представляет 2 объект-операнд (S). Причем, все указанные выше операции выполняются атомарно
и реализованы на аппаратном уровне.
* */
public class FetchAndAdd {
//    public final int incrementAndGet() {
//        return unsafe.getAndAddInt(this, valueOffset, 1) + 1;
//    }
//
//    public final int getAndAddInt(Object var1, long var2, int var4) {
//        int var5;
//        do {
//            var5 = this.getIntVolatile(var1, var2);
//        } while (!this.compareAndSwapInt(var1, var2, var5, var5 + var4));
//
//        return var5;
//    }
}
