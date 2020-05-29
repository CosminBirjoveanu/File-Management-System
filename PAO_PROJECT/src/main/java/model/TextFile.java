package main.java.model;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class TextFile extends DefaultFile implements FileInterface {

    public TextFile(File newFile) {
        file = newFile;
        fileName = file.getName();
        fileType = fileName.substring(fileName.length() - 4);
        fileSize = file.length() / (1024 * 1024.0);
    }

    @Override
    public void run() {
        try {
            Desktop.getDesktop().open(file);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
