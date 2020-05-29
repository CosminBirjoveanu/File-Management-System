package main.java.service;
import main.java.model.Folder;
import main.java.repositories.FoldersRepository;

public class CreateFolderService {
    private FoldersRepository foldersRepository = FoldersRepository.getInstance();

    public void addFolder (Folder folder) {
        foldersRepository.addFolder(folder);
    }
}
