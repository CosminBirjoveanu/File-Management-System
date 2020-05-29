package main.java.service;
import main.java.model.DefaultFile;

public class PrintFileTypeService {

    public void print(DefaultFile file) {
        System.out.println(file.getFileType());
    }
}
