package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyComparator;
import java.util.Arrays;

// Sorts elements using MyComparator to compare them
public class SortDecorator extends SmartArrayDecorator {
    private MyComparator compare;
    private SmartArray arr;

    public SortDecorator(SmartArray smartArray, MyComparator compare) {
        super(smartArray);
        this.compare = compare;
        comparator();
    }

    @Override
    public Object[] toArray() {
        return smartArray.toArray();
    }

    @Override
    public String operationDescription() {
        return "This is sort decorator: ";
    }

    @Override
    public int size() {
        return smartArray.size();
    }

    public void comparator() {
        int j, first;
        Object temp;
        for (int i = smartArray.size() - 1; i > 0; i--) {
            first = 0;
            for (j = 1; j <= i; j++) {
                if (compare.compare(smartArray.toArray()[j], smartArray.toArray()[first]) >= 0) {
                    first = j;
                }
                temp = smartArray.toArray()[first];
                smartArray.toArray()[first] = smartArray.toArray()[i];
                smartArray.toArray()[i] = temp;
            }
        }
    }
}
