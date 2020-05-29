package main.java.repositories;

import main.java.model.DefaultFile;
import main.java.model.Folder;
import main.java.model.RecycleBin;

import java.util.ArrayList;
import java.util.List;

public class FoldersRepository {

    private List<Folder> folders = new ArrayList<>();

    private FoldersRepository() { }

    public Folder get(int i){
        return folders.get(i);
    }

    public int size() {
        return folders.size();
    }

    public void addFolder(Folder folder) {
        folders.add(folder);
        update();
    }

    public void deleteFolder(Folder folder) {
        RecycleBin recycleBin = RecycleBin.getInstance();
        recycleBin.addFolder(folder);
        folders.remove(folder);
    }

    public List<Folder> findFoldersByFile (DefaultFile file) {
        List<Folder> list = new ArrayList<>();
        for (int i = 0; i < folders.size(); i++) {
            if (folders.get(i).getFiles().contains(file)) {
                list.add(folders.get(i));
            }
        }
        return list;
    }

    public List<Folder> findFoldersByFolderName (String name) {
        List<Folder> list = new ArrayList<>();
        for (int i = 0; i < folders.size(); i++) {
            for (int j = 0; j < folders.get(i).getFolders().size(); j++) {
                if (folders.get(i).getFolders().get(j).getFolderName().equals(name)) {
                    list.add(folders.get(i).getFolders().get(j));
                }
            }
        }
        return list;
    }

    private void update(){
        folders.sort(Folder::compareTo);
    }

    public static FoldersRepository getInstance() {
        return FoldersRepository.SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder {
        private static final FoldersRepository INSTANCE = new FoldersRepository();
    }
}
