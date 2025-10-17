package multithreading.lockfreealgorithm;

/*
Операция CAS включает 3 объекта-операнда: адрес ячейки памяти (V),
ожидаемое старое значение (A) и новое значение (B).
Процессор атомарно обновляет адрес ячейки (V), если значение в ячейке памяти совпадает
со старым ожидаемым значением(A), иначе изменения не зафиксируется. В любом случае, будет выведена величина,
которая предшествовала времени запроса. Некоторые варианты метода CAS просто сообщают,
успешно ли прошла операция, вместо того, чтобы отобразить само текущее значение.
Фактически, CAS только сообщает: «Наверное,  значение по адресу V равняется A;
если так оно и есть, поместите туда же B, в противном случае не делайте этого,
но обязательно скажите мне, какая величина — текущая.»
*/
public class CompareAndSwap {
//    public final int incrementAndGet() {
//        for (; ; ) {
//            int current = get();
//            int next = current + 1;
//            if (compareAndSet(current, next))
//                return next;
//        }
//    }
//
//    public final boolean compareAndSet(int expect, int update) {
//        return unsafe.compareAndSwapInt(this, valueOffset, expect, update);
//    }
}
