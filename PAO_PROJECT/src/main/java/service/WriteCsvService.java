package main.java.service;

import main.java.repositories.FilesRepository;
import main.java.repositories.FoldersRepository;

import java.io.FileWriter;
import java.io.IOException;

public class WriteCsvService {

    private FilesRepository filesRepository = FilesRepository.getInstance();
    private FoldersRepository foldersRepository = FoldersRepository.getInstance();

    public void writeFile(){
        try {
            FileWriter csvWriter = new FileWriter("file.csv");
        for (int i = 0; i < filesRepository.getN(); i++) {
            csvWriter.append(filesRepository.get(i).getFileName());
            csvWriter.append(",");
        }
        csvWriter.append("\n");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeFolder(){
        try {
            FileWriter csvWriter = new FileWriter("folder.csv");
            for (int i = 0; i < foldersRepository.size() ; i++) {
                csvWriter.append(foldersRepository.get(i).getFolderName());
                csvWriter.append(",");
            }
            csvWriter.append("\n");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }


}
