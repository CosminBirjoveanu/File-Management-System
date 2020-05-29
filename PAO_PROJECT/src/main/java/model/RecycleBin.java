package main.java.model;

import java.util.HashSet;
import java.util.Set;

public class RecycleBin extends Folder{
    private final String fileName = "Recycle Bin";
    private double totalSize;
    private Set<DefaultFile> files = new HashSet<>();
    private Set<Folder> folders = new HashSet<>();

    private RecycleBin() { }

    public void addFile(DefaultFile file) {
        files.add(file);
    }

    public void addFolder(Folder folder) {
        folders.add(folder);
    }

    public void showContents() {
        System.out.println(folders);
        System.out.println(files);
    }

    public double getTotalSize() {
        return totalSize;
    }

    public static RecycleBin getInstance() {
        return RecycleBin.SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder {
        private static final RecycleBin INSTANCE = new RecycleBin();
    }
}
