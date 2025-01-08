package controller;

import java.io.IOException;

public interface IGenericFile {
    void readFromFile();
    void writeToFile() throws IOException;
}
