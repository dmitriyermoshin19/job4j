package ru.job4j.oo1.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Converter {
    public Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<Integer>() {
            private Iterator<Integer> innerIt = it.next();

            @Override
            public boolean hasNext() {
                while (it.hasNext() && !innerIt.hasNext()) {
                    innerIt = it.next();
                }
                return innerIt.hasNext();
            }

            @Override
            public Integer next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return innerIt.next();
            }
        };
    }
}
