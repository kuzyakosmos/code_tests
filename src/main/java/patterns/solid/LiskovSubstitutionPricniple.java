package patterns.solid;

import java.util.ArrayList;

public class LiskovSubstitutionPricniple {

    class ListElemensftPrinter {
        void printListElements(ArrayList arrayList) {
            for (Object element: arrayList) {
                System.out.println(element);
            }
        }
    }
}
