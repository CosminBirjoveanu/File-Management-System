package main.java.service;

import main.java.model.Folder;
import main.java.repositories.FilesRepository;
import main.java.repositories.FoldersRepository;

public class ListAllService {

    private FoldersRepository foldersRepository = FoldersRepository.getInstance();
    private FilesRepository filesRepository = FilesRepository.getInstance();

    public void list(String string) {
        if (string.equals("files")) {
            System.out.println(filesRepository);
        }
        else if (string.equals("folders")) {
            System.out.println(foldersRepository);
        }
        else {
            System.out.println("Cannot list. Use keyword 'files' or 'folders'.");
        }
    }
}
