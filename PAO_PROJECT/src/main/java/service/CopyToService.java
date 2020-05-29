package main.java.service;

import main.java.model.DefaultFile;
import main.java.model.Folder;

public class CopyToService {

    public void copy(DefaultFile file, Folder folder){
        folder.addFile(file);
    }

    public void copy(Folder toCopy, Folder folder){
        folder.addFolder(toCopy);
    }
}