package clist;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Clist<E> implements List {

    private Object[] data;
    String[] l = new String[12];

    public Clist() {
        data = new Object[0];
    }

    @Override
    public int size() {
        return data.length;
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public boolean contains(Object o) {
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
    public boolean add(Object o) {
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

    private Object[] decrease() {
        Object[] listObject = new Object[this.size() - 1];
        return listObject;
    }


    @Override
    public boolean remove(Object o) {
        Integer findedIndex = null;
        if (!o.equals(null) && !this.isEmpty()) {
            for (int i = 0; i < this.size(); i++) {
                if (!this.data[i].equals(o)) {
                    findedIndex = i;
                }
            }
            if (findedIndex != null) {
                int countNewList = 0;
                Object[] newList = this.decrease();
                for (int i = 0; i < this.size(); i++) {
                    if (findedIndex != i) {
                        newList[countNewList] = this.data[i];
                    }
                    countNewList++;
                }
            }
        }
        return findedIndex != null;
    }

    @Override
    public boolean addAll(Collection collection) {
        return false;
    }

    @Override
    public boolean addAll(int i, Collection collection) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public Object get(int i) {
        // TODO: Check empty list

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
    public Object remove(int i) {
        if (!this.isEmpty() && i < this.size()) {
            Object[] newList = this.decrease();
        }
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
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
    public List subList(int i, int i1) {
        return null;
    }

    @Override
    public boolean retainAll(Collection collection) {
        return false;
    }

    @Override
    public boolean removeAll(Collection collection) {
        return false;
    }

    @Override
    public boolean containsAll(Collection collection) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] objects) {
        return new Object[0];
    }
}
