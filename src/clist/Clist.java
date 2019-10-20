package clist;

import java.util.*;

public class Clist<E> implements List {

    private Object[] data;
    String[] l = new String[12];

    public Clist() {
        data = new Object[0];
    }

    @Override
    public int size() {
        return data.length;
    } // OK

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    } // OK

    @Override
    public boolean contains(Object o) { // OK
        if (!this.isNullOrEmpty(o)) {
            for (Object obj : this.data) {
                if (obj.equals(o)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isNullOrEmpty(Object o) { // OK
        if (o == null || this.isEmpty()) {
            return true;
        }
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean add(Object o) { // OK
        try {
            this.grow();
            this.data[this.size() - 1] = o;
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    private void grow() {
        Object[] temp = this.data;

        int lastSize = this.size();
        this.data = new Object[lastSize + 1];
        for (int i = 0; i < temp.length; i++) {
            this.data[i] = temp[i];
        }
    }

    private Object[] decreasedList() {
        Object[] listObject = new Object[this.size() - 1];
        return listObject;
    }


    @Override
    public boolean remove(Object o) { // OK
        Integer findedIndex = null;
        if (!o.equals(null) && !this.isEmpty()) {
            for (int i = 0; i < this.size(); i++) {
                if (!this.data[i].equals(o)) {
                    findedIndex = i;
                }
            }
            if (findedIndex != null) {
                Object[] newList = this.decreasedList();
                for (int i = 0, j = 0; i < this.size(); i++) {
                    if (findedIndex != i) {
                        newList[j++] = this.data[i];
                    }
                }
                this.data = newList;
            }
        }
        return findedIndex != null;
    }

    @Override
    public boolean addAll(Collection collection) { // OK
        try {
            Clist<E> clist = new Clist<E>();
            clist.data = this.data;

            for (Object obj : collection) {
                clist.add(obj);
            }

            this.data = clist.data;
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean addAll(int i, Collection collection) {
        return false;
    }

    @Override
    public void clear() { // OK
        this.data = new Object[0];
    }

    @Override
    public Object get(int i) { // OK
        if (this.size() >= i) {
            return this.data[i];
        }
        return null;
    }

    @Override
    public Object set(int i, Object o) {
        return null;
    }

    @Override
    public void add(int i, Object o) {

    }

    @Override
    public Object remove(int i) { // OK
        if (!this.isEmpty() && i < this.size()) {
            Object[] newList = this.decreasedList();

            for (int j = 0, k = 0; j < this.size(); j++) {
                if (i != j) {
                    newList[k++] = this.data[j];
                }
            }
            this.data = newList;
        }
        return null;
    }

    @Override
    public int indexOf(Object o) { // OK
        for (int i = 0; i < this.size(); i++) {
            if (this.data[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) { // OK
        int findedLastIndex = -1;
        for (int i = 0; i < this.size(); i++) {
            if (this.data[i].equals(o)) {
                findedLastIndex = i;
            }
        }
        return findedLastIndex;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int i) {
        return null;
    }

    @Override
    public List subList(int i, int i1) { // OK
        Clist<E> newList = new Clist<E>();
        if ((i > -1 && i < this.size()) && (i1 > i && i1 < this.size())) {
            int newSize = i1 - i;
            for (int j = 0, k = i; j < newSize; j++) {
                newList.add(this.data[k++]);
            }
            return newList;
        }
        return null;
    }

    @Override
    public boolean retainAll(Collection collection) {
        return false;
    }

    @Override
    public boolean removeAll(Collection collection) { // OK
        if (this.containsAll(collection)) {
            int newSize = this.size() - collection.size();
            Object[] newList = new Object[newSize];
            Object[] arrayCollection = collection.toArray();
            for (int i = 0, j = 0; i < this.size(); i++) {
                if (this.indexOf(arrayCollection[i]) != i) {
                    newList[j++] = this.data[i];
                }
            }
            this.data = newList;
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection collection) { // OK
        for (Object o : collection) {
            if (!this.contains(o)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Object[] toArray(Object[] objects) {
        return new Object[0];
    }
}
