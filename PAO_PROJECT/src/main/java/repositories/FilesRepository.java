package main.java.repositories;
import main.java.model.DefaultFile;
import main.java.model.RecycleBin;

public class FilesRepository {

    private DefaultFile[] files = new DefaultFile[100];
    private int n = 0;

    public int getN() {
        return n;
    }

    public DefaultFile get(int i) {
        return files[i];
    }

    private FilesRepository() {

    }

    public void addFile(DefaultFile file) {
        files[n] = file;
        n++;
    }

    public void deleteFile(DefaultFile file) {
        for (int i = 0; i < n; i++) {
            if (files[i] == file) {
                RecycleBin recycleBin = RecycleBin.getInstance();
                recycleBin.addFile(files[i]);
                if (n - 1 - i >= 0)
                    System.arraycopy(files, i + 1, files, i, n - 1 - i);
                n--;
            }
        }
    }

    public DefaultFile findFileByName(String name){
        for (int i = 0; i < n; i++) {
            if (files[i].getFileName().equals(name)) {
                return files[i];
            }
        }
        return null;
    }

    public static FilesRepository getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder {
        private static final FilesRepository INSTANCE = new FilesRepository();
    }
}
