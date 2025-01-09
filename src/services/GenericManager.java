package services;

import java.util.List;

public interface GenericManager<T> {
    List<T> getAll();
    void add(T item);
    void delete(String id);
    void update(T item);
    void sort();
    T searchById(String id);
    void displayAll();

}
