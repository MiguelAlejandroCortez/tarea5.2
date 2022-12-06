package uaslp.objetos.list;

import uaslp.objetos.list.exceptions.NullNotAllowedException;
import uaslp.objetos.list.exceptions.WrongIndexException;

public interface List<T> {

    void addAtTail(T data) throws NullNotAllowedException;

    void addAtFront(T data) throws NullNotAllowedException;

    void remove(int index) throws WrongIndexException;

    void removeAll();

    void setAt(int index, T data) throws WrongIndexException, NullNotAllowedException;

    T getAt(int index) throws WrongIndexException;

    void removeAllWithValue(T data);

    int size();

    Iterator<T> iterator();
}
