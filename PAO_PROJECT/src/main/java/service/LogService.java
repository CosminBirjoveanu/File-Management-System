package main.java.service;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LogService {

    private final String PATH = "log.csv";
    private String HEADER = "ActionName,Timestamp\n";
    private SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");

    private LogService() {
        Path path = Path.of(PATH);
        if (!Files.exists(path)) {
            try {
                Files.createFile(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(PATH);
            fileWriter.write(HEADER);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createLog(String action) {
        Date date = new Date();
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(PATH, true);
            fileWriter.append(action);
            fileWriter.append(",");
            fileWriter.append(formatter.format(date));
            fileWriter.append("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static LogService getInstance() {
        return LogService.SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder {
        private static final LogService INSTANCE = new LogService();
    }
}
