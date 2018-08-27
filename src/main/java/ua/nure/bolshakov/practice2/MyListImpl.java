package ua.nure.bolshakov.practice2;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyListImpl implements MyList, ListIterable {

    private Object[] arr = new Object[0];

    public void add(Object e) {
        Object[] newArr = new Object[arr.length + 1];
        System.arraycopy(arr, 0, newArr, 0, arr.length);
        arr = newArr;
        arr[arr.length - 1] = e;
    }

    public void clear() {
        arr = new Object[0];
    }

    public int findElement(Object o) {
        if (o == null) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == null)
                    return i;
            }
        } else {
            for (int i = 0; i < arr.length; i++) {
                if (o.equals(arr[i]))
                    return i;
            }
        }
        return -1;
    }
//проверка длины
    public boolean remove(Object o) {
        Object[] newData = new Object[arr.length - 1];
        int index = findElement(o);
        if (index == -1)
            return false;
        Object[] firstPart = Arrays.copyOf(arr, index);
        if (index == arr.length - 1) {
            System.arraycopy(arr, 0, newData, 0, arr.length - 1);
        } else {
            Object[] secondPart = Arrays.copyOfRange(arr, index + 1, arr.length);
            System.arraycopy(firstPart, 0, newData, 0, firstPart.length);
            System.arraycopy(secondPart, 0, newData, firstPart.length, secondPart.length);
        }
        arr = newData;
        return true;
    }

    public Object[] toArray() {
        Object[] newArr = new Object[arr.length];
        System.arraycopy(arr, 0, newArr, 0, arr.length);
        return newArr;
    }

    public int size() {
        return arr.length;
    }

    public boolean contains(Object o) {
        if (findElement(o) != -1)
            return true;
        else
            return false;
    }

    public boolean containsAll(MyList c) {
        Object[] List = c.toArray();
        boolean containsAll = true;
        for (Object element : List) {
            if (!contains(element))
                containsAll = false;
        }
        return containsAll;
    }

    @Override
    public String toString() {
        String s = "[";
        for (int i = 0; i < arr.length; i++) {
            if (i != arr.length - 1) {
                s += arr[i] + ", ";
            } else {
                s += arr[i];
            }
        }
        s += "]";
        return s;
    }

    public Iterator<Object> iterator() {
        return new IteratorImpl();
    }


    private class IteratorImpl implements Iterator<Object> {
        int current = 0;
        int indexOfLastReturned = -1;

        public boolean hasNext() {

            return current < arr.length;
        }

        public Object next() {
            if (current >= arr.length)
                throw new NoSuchElementException();
            indexOfLastReturned = current;
            return arr[current++];
        }

        public void remove() {
            if (indexOfLastReturned == -1)
                throw new IllegalStateException();
            MyListImpl.this.remove(arr[indexOfLastReturned]);
            current--;
            indexOfLastReturned = -1;
        }
    }

    public ListIterator listIterator() {
        return new ListIteratorImpl();
    }

    private class ListIteratorImpl extends IteratorImpl implements ListIterator {
        @Override
        public boolean hasPrevious() {
            return current != 0;
        }

        @Override
        public Object previous() {
            if (current == -1)
                throw new NoSuchElementException();
            indexOfLastReturned = current;
            return arr[--current];
        }

        @Override
        public void set(Object e) {
            if (indexOfLastReturned == -1)
                throw new IllegalStateException();
            arr[indexOfLastReturned] = e;
            indexOfLastReturned = -1;
        }
    }
}
