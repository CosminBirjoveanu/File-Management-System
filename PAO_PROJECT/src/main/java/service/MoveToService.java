package main.java.service;

import main.java.model.DefaultFile;
import main.java.model.Folder;
import main.java.repositories.FilesRepository;
import main.java.repositories.FoldersRepository;

public class MoveToService {

    private FilesRepository filesRepository = FilesRepository.getInstance();
    private FoldersRepository foldersRepository = FoldersRepository.getInstance();

    public void move(Folder from, DefaultFile file, Folder to) {
        to.addFile(file);
        from.deleteFile(file);
    }

    public void move(Folder from, Folder folder, Folder to) {
        to.addFolder(folder);
        from.deleteFolder(folder);
    }
}
