package ua.edu.ucu.smartarr;

import java.lang.reflect.Array;
import java.util.Arrays;

// Remove duplicates from SmartArray. Use method equals() to compare objects
public class DistinctDecorator extends SmartArrayDecorator {

    public DistinctDecorator(SmartArray smartArray) {
        super(smartArray);
        remove_item();

    }

    public void remove_item() {
        for (int i = 0; i < smartArray.size(); i++) {
            for (int y = i + 1; y < smartArray.size(); y++) {
                if (smartArray.toArray()[i].equals(smartArray.toArray()[y])) {
                    remove(y);
                }
            }
        }
    }

    public void remove(int y) {
        Object[] arraychuk = new Object[smartArray.toArray().length - 1];
        for (int i = 0; i < y; i++) {
            arraychuk[i] = smartArray.toArray()[i];
        }
        for (int i = y + 1; i < smartArray.size(); i++) {
            arraychuk[i - 1] = smartArray.toArray()[i];
        }
        this.smartArray = new BaseArray(arraychuk);
    }

    @Override
    public Object[] toArray() {
        return smartArray.toArray();
    }

    @Override
    public String operationDescription() {
        return "This is distinct decorator: ";
    }

    @Override
    public int size() {
        return smartArray.size();
    }
}

