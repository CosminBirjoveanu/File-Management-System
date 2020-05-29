package main.java.model;

import java.io.File;

public class DefaultFile {
    protected File file;
    protected String fileType;
    protected String fileName;
    protected double fileSize;

    public DefaultFile() {}

    public DefaultFile(String name) {
        fileName = name;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public double getFileSize() {
        return fileSize;
    }

    public File getFile() {
        return file;
    }

    public void run() {}
}
