package controller;

import java.io.IOException;
import java.util.List;

public interface GenericManager<T> {
    List<T> getAll();
    void add(T item);
    void delete(String id);
    void update(T item);
    void sort();
    T searchById(String id);
    void displayAll(T item);
    void readFromFile(String fileName) throws IOException;
    void writeToFile(String fileName) throws ClassNotFoundException, IOException;
}
