package main.java.service;

import main.java.model.Folder;

public class PrintContentService {
    public void print(Folder folder) {
        folder.showContents();
    }
}
