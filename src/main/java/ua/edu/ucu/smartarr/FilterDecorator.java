package ua.edu.ucu.smartarr;
import java.util.Arrays;

import ua.edu.ucu.functions.MyPredicate;

// Tests every element and removes it if it doesn't satisfy MyPredicate
public class FilterDecorator extends SmartArrayDecorator {
    private MyPredicate n;
    private SmartArray amr;

    public FilterDecorator(SmartArray smartArray, MyPredicate n) {
        super(smartArray);
        this.n = n;
        remove_predicate();

    }

    public void remove_predicate() {
        Object[] arr = new Object[smartArray.size()];
        int y = 0;
        for (int i = 0; i < smartArray.size(); i++) {
            if (n.test(smartArray.toArray()[i])) {
                arr[y] = smartArray.toArray()[i];
                y++;
            }
        }
        this.smartArray = new BaseArray(Arrays.copyOfRange(arr, 0, y));
    }


    @Override
    public Object[] toArray() {
        return smartArray.toArray();
    }

    @Override
    public String operationDescription() {
        return "This is Filter Decorator: ";
    }

    @Override
    public int size() {
        return smartArray.size();
    }
}
