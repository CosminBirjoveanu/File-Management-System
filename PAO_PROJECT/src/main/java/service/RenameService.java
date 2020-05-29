package main.java.service;

import main.java.model.DefaultFile;
import main.java.model.Folder;

public class RenameService {

    public void rename(DefaultFile file, String newName) {
        file.setFileName(newName);
    }

    public void rename(Folder folder, String newName) {
        folder.setFolderName(newName);
    }

}
