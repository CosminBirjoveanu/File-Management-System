package main.java.model;

import java.util.ArrayList;
import java.util.List;

public class Folder implements Comparable<Folder> {
    private String folderName;
    private double totalSize;
    private List<DefaultFile> files = new ArrayList<>();
    private List<Folder> folders = new ArrayList<>();

    public Folder() {
    }

    public Folder(String folderName) {
        this.folderName = folderName;
    }

    public List<DefaultFile> getFiles() {
        return files;
    }

    public List<Folder> getFolders() {
        return folders;
    }

    public void addFile(DefaultFile file) {
        files.add(file);
        computeTotalSize();
    }

    public void addFolder(Folder folder) {
        folders.add(folder);
        computeTotalSize();
    }

    public void deleteFile(DefaultFile file) {
        RecycleBin recycleBin = RecycleBin.getInstance();
        recycleBin.addFile(file);
        files.remove(file);
    }

    public void deleteFolder(Folder folder) {
        RecycleBin recycleBin = RecycleBin.getInstance();
        recycleBin.addFolder(folder);
        folders.remove(folder);
    }

    public void showContents() {
        System.out.println(folders);
        System.out.println(files);
    }

    public String getFolderName() {
        return folderName;
    }

    public void setFolderName(String folderName) {
        this.folderName = folderName;
    }

    public double getTotalSize() {
        return totalSize;
    }

    public void computeTotalSize(){
        double sum = 0;
        for (DefaultFile f:files) {
            sum += f.getFileSize();
        }
        this.totalSize = sum;
    }

    @Override
    public int compareTo(Folder f) {
        return this.folderName.compareTo(f.folderName);
    }
}
