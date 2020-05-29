package main.java.service;

import main.java.model.DefaultFile;
import main.java.repositories.FilesRepository;

public class CreateFileService {
    private FilesRepository filesRepository = FilesRepository.getInstance();

    public void addFile (DefaultFile file) {
        filesRepository.addFile(file);
    }
}
