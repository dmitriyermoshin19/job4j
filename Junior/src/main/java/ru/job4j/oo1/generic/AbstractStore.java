package ru.job4j.oo1.generic;

public abstract class AbstractStore<T extends Base> implements Store<T> {
    private SimpleArray<T> simpleArray;

    public AbstractStore(int size) {
        this.simpleArray = new SimpleArray(size);
    }

    @Override
    public void add(T model) {
        simpleArray.add(model);
    }

    public int getPosition(String id) {
        int result = -1;
        int index = 0;
        for (T t : simpleArray) {
            if (t.getId().equals(id)) {
                result = index;
                break;
            }
            index++;
        }
        return result;
    }

    @Override
    public boolean replace(String id, T model) {
        boolean result = false;
        int position = getPosition(id);
        if (position != -1) {
            simpleArray.set(position, model);
            result = true;
        }
        return result;
    }

    @Override
    public boolean delete(String id) {
        boolean result = false;
        int position = getPosition(id);
        if (position != -1) {
            simpleArray.remove(position);
            result = true;
        }
        return result;
    }

    @Override
    public T findById(String id) {
        T result = null;
        int position = getPosition(id);
        if (position != -1) {
            result = simpleArray.get(position);
        }
        return result;
    }
}
