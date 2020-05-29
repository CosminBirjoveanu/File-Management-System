package main.java.service;

import main.java.model.DefaultFile;
import main.java.model.Folder;

public class PrintSizeService{

    public void print(DefaultFile file) {
        System.out.println(file.getFileSize());;
    }

    public void print(Folder folder) {
        System.out.println(folder.getTotalSize());
    }
}
