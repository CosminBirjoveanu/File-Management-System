package main.java.service;

import main.java.model.DefaultFile;
import main.java.model.Folder;
import main.java.repositories.FilesRepository;
import main.java.repositories.FoldersRepository;

import java.util.Optional;

public class DeleteService {
    private FilesRepository filesRepository = FilesRepository.getInstance();
    private FoldersRepository foldersRepository = FoldersRepository.getInstance();

    public void delete(DefaultFile file) {
        filesRepository.deleteFile(file);
        for (Folder f : foldersRepository.findFoldersByFile(file)) {
            f.deleteFile(file);
        }
    }

    public void delete(Folder folder) {
        foldersRepository.deleteFolder(folder);
        for (Folder f : foldersRepository.findFoldersByFolderName(folder.getFolderName())) {
            f.deleteFolder(folder);
        }
    }

}
