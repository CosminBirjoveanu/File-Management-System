package main.java.service;

import main.java.model.DefaultFile;
import main.java.model.Folder;
import main.java.model.RecycleBin;
import main.java.repositories.FilesRepository;
import main.java.repositories.FoldersRepository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadCsvService {

    private FilesRepository filesRepository = FilesRepository.getInstance();
    private FoldersRepository foldersRepository = FoldersRepository.getInstance();

    public void readFile(String path) {
        String line = "";
        String splitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            line = br.readLine();
            while (line != null) {
                String[] string = line.split(splitBy);
                DefaultFile file = new DefaultFile(string[0]);
                file.setFileType(string[1]);
                filesRepository.addFile(file);
                line = br.readLine();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readFolderFiles(String path) {
        String line = "";
        String splitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            line = br.readLine();
            while (line != null) {
                String[] string = line.split(splitBy);
                Folder folder = new Folder(string[0]);
                foldersRepository.addFolder(folder);
                line = br.readLine();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readRecycleBin(String path) {
        String line = "";
        String splitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            line = br.readLine();
            while (line != null) {
                String[] string = line.split(splitBy);
                RecycleBin recycleBin = RecycleBin.getInstance();
                if (string[0].equals("file")) {
                    DefaultFile file = new DefaultFile(string[1]);
                    file.setFileType(string[2]);
                    recycleBin.addFile(file);
                }
                else if (string[0].equals("folder")) {
                    Folder folder = new Folder(string[1]);
                    recycleBin.addFolder(folder);
                }
                line = br.readLine();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ReadCsvService getInstance() {
        return ReadCsvService.SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder {
        private static final ReadCsvService INSTANCE = new ReadCsvService();
    }
}
