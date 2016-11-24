package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyFunction;
import java.util.Arrays;

// Map every element to another object using MyFunction
public class MapDecorator extends SmartArrayDecorator {
    private MyFunction hg;
    private SmartArray yt;

    public MapDecorator(SmartArray smartArray, MyFunction hg) {
        super(smartArray);
        this.hg = hg;
        mapping();

    }

    public void mapping(){
        for (int i =0; i < smartArray.size(); i ++){
            smartArray.toArray()[i] = hg.apply(smartArray.toArray()[i]);
        }
    }

    @Override
    public Object[] toArray() {
        return smartArray.toArray();
    }

    @Override
    public String operationDescription() {
        return "This is Map Decorator: ";
    }

    @Override
    public int size() {
        return yt.size();
    }
}
