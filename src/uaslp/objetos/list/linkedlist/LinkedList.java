package uaslp.objetos.list.linkedlist;

import uaslp.objetos.list.Iterator;
import uaslp.objetos.list.List;
import uaslp.objetos.list.exceptions.NullNotAllowedException;
import uaslp.objetos.list.exceptions.WrongIndexException;

public class LinkedList<E> implements List<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size;

    @Override
    public void addAtFront(E data) throws NullNotAllowedException {
        if (data == null) throw new NullNotAllowedException();

        Node<E> node = new Node<>(data);
        node.setNext(head);

        if (head != null) {
            head.setPrevious(node);
        } else {
            tail = node;
        }

        head = node;
        size++;
    }

    @Override
    public void addAtTail(E data) throws NullNotAllowedException{
        if (data == null) throw new NullNotAllowedException();

        Node<E> node = new Node<>(data);
        node.setPrevious(tail);

        if (tail != null) {
            tail.setNext(node);
        } else {
            head = node;
        }

        tail = node;
        size++;
    }

    @Override
    public void setAt(int index, E data) throws WrongIndexException, NullNotAllowedException{
        if (index < 0 || index > size) throw new WrongIndexException();

        if (data == null) throw new NullNotAllowedException();

        if (index == 0) {
            addAtFront(data);
        } else if (index == size) {
            addAtTail(data);
        } else {
            Node<E> node = new Node<>(data);
            Node<E> nodeIterator = head;

            int indexIterator = 0;
            while (indexIterator < index) {
                indexIterator++;
                nodeIterator = nodeIterator.getNext();
            }

            node.setNext(nodeIterator);
            node.setPrevious(nodeIterator.getPrevious());
            nodeIterator.setPrevious(node);
            node.getPrevious().setNext(node);

            size++;
        }
    }

    @Override
    public E getAt(int index) throws WrongIndexException {
        if (index < 0 || index >= size) throw new WrongIndexException();

        Node<E> nodeIterator = head;

        int indexIterator = 0;
        while (indexIterator < index) {
            indexIterator++;
            nodeIterator = nodeIterator.getNext();
        }

        return nodeIterator.getData();
    }

    @Override
    public void remove(int indexToRemove) throws WrongIndexException {
        if (indexToRemove < 0 || indexToRemove >= size) throw new WrongIndexException();

        if (size == 1) {
            head = null;
            tail = null;
            size = 0;
            return;
        }

        Node<E> nodeIterator = head;

        int indexIterator = 0;
        while (indexIterator < indexToRemove) {
            indexIterator++;
            nodeIterator = nodeIterator.getNext();
        }

        if (nodeIterator.getNext() != null) {
            nodeIterator.getNext().setPrevious(nodeIterator.getPrevious());
        } else {
            tail = nodeIterator.getPrevious();
            if (tail != null) {
                tail.setNext(null);
            }
        }

        if (nodeIterator.getPrevious() != null) {
            nodeIterator.getPrevious().setNext(nodeIterator.getNext());
        } else {
            head = nodeIterator.getNext();
            if (head != null) {
                head.setPrevious(null);
            }
        }

        size--;
    }

    @Override
    public void removeAll() {
        int i = 0;

        while (i < size) {
            this.remove(0);
        }
    }

    @Override
    public void removeAllWithValue(E data) {
        int indexIterator = 0;
        Iterator<E> it = this.iterator();

        while (it.hasNext()) {
            if (data.equals(it.next())) {
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

    @Override
    public Iterator<E> iterator() {
        return new LinkedListIterator();
    }

    @Override
    public String toString() {
        if (size > 0){
            StringBuilder result = new StringBuilder("[ ");
            Iterator<E> listIterator = iterator();
            while(listIterator.hasNext()){
                result.append(listIterator.next()).append(" - ");
            }
            result.delete(result.length()-3, result.length());
            return result + " ]";
        }
        else{
            return "Empty List";
        }
    }

    private static class Node<E> {
        private final E data;
        private Node<E> next;
        private Node<E> previous;

        public Node(E data) {
            this.data = data;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }

        public void setPrevious(Node<E> previous) {
            this.previous = previous;
        }

        public E getData() {
            return this.data;
        }

        public Node<E> getNext() {
            return this.next;
        }

        public Node<E> getPrevious() {
            return this.previous;
        }
    }

    private class LinkedListIterator implements Iterator<E> {
        private Node<E> current;

        public LinkedListIterator() {
            current = head;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            if (hasNext()) {
                E data = current.getData();
                current = current.getNext();
                return data;
            } else {
                return null;
            }
        }
    }
}