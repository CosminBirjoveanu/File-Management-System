package main.java.main;
import main.java.model.DefaultFile;
import main.java.model.FileInterface;
import java.io.File;
import static main.java.model.FileInterface.Type.MP3;

public class Main {

    public static void main(String[] args){
        File file1 = new File("C:\\Users\\chido\\Documents\\Daft Punk - The Game of Love (Official Audio).mp3");
        DefaultFile file = FileInterface.build(MP3, file1);
    }
}
