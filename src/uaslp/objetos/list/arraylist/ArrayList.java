package uaslp.objetos.list.arraylist;

import uaslp.objetos.list.Iterator;
import uaslp.objetos.list.List;
import uaslp.objetos.list.exceptions.NullNotAllowedException;
import uaslp.objetos.list.exceptions.WrongIndexException;

public class ArrayList<E> implements List<E> {
    private int size;
    private E[] arrayList;

    @SuppressWarnings("unchecked")
    public ArrayList() {
        int defaultSize = 10;
        arrayList = (E[]) new Object[defaultSize];
    }

    @SuppressWarnings("unchecked")
    public ArrayList(int initialSize) {
        arrayList = (E[]) new Object[initialSize];
    }

    @Override
    public void addAtFront(E data) throws NullNotAllowedException {
        if (data == null) throw new NullNotAllowedException();

        if (size > 0) {
            int indexIterator = size - 1;
            addAtTail(arrayList[indexIterator]);

            while (indexIterator > 0) {
                arrayList[indexIterator--] = arrayList[indexIterator];
            }

            arrayList[indexIterator] = data;
        } else {
            arrayList[size++] = data;
        }
    }

    @Override
    public void addAtTail(E data) throws NullNotAllowedException {
        if (data == null) throw new NullNotAllowedException();

        if (size == arrayList.length) {
            arrayList = grow();
        }

        arrayList[size++] = data;
    }

    @SuppressWarnings("unchecked")
    private E[] grow() {
        int newCapacity = arrayList.length + (arrayList.length >> 1);

        E[] newArrayList = (E[]) new Object[newCapacity];

        int i = 0;
        for (E item : arrayList) {
            newArrayList[i++] = item;
        }

        return newArrayList;
    }

    @Override
    public void setAt(int index, E data) throws WrongIndexException, NullNotAllowedException {
        if (index < 0 || index >= size) throw new WrongIndexException();

        if (data == null) throw new NullNotAllowedException();

        arrayList[index] = data;
    }

    @Override
    public E getAt(int index) throws WrongIndexException {
        if (index < 0 || index >= size) throw new WrongIndexException();

        return arrayList[index];
    }

    @Override
    public void remove(int indexToRemove) throws WrongIndexException {
        if (indexToRemove < 0 || indexToRemove >= size) {
            throw new WrongIndexException();
        }

        for (int indexIt = indexToRemove; indexIt < size-1; indexIt++) {
            arrayList[indexIt] = arrayList[indexIt+1];
        }

        arrayList[size-1] = null;
        size--;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void removeAll() {
        int oldCapacity = arrayList.length;
        arrayList = (E[]) new Object[oldCapacity];
        size = 0;
    }

    @Override
    public void removeAllWithValue(E data) {
        int indexIterator = 0;
        while (indexIterator < size) {
            if (arrayList[indexIterator].equals(data)) {
                remove(indexIterator);
            } else {
                indexIterator++;
            }
        }
    }

    @Override
    public int size() {
        return this.size;
    }

    public Iterator<E> iterator () {
        //return new ArrayListIterator(this);
        return new Iterator<>() {
            private int currentIndex;

            @Override
            public boolean hasNext() {
                return currentIndex < size;
            }

            @Override
            public E next() {
                if (hasNext()){
                    return arrayList[currentIndex++];
                } else {
                    return null;
                }
            }
        };
    }

    @Override
    public String toString() {
        if (size > 0) {
            StringBuilder result = new StringBuilder("[");
            for (int arrayIterator = 0; arrayIterator < size; arrayIterator++) { result.append(arrayList[arrayIterator]).append(", "); }
            result.delete(result.length()-2, result.length());
            return result + "]";
        } else {
            return "Empty List";
        }
    }
}
