package main.java.model;

import org.w3c.dom.Text;

import java.io.File;

public interface FileInterface {

    void run();

    static DefaultFile build(Type type, File file) {
        switch (type) {
            case MP3: return new AudioFile(file);
            case MP4: return new VideoFile(file);
            case DOC: return new DocumentFile(file);
            case EXE: return new ExecutableFile(file);
            case IMG: return new ImageFile(file);
            case TXT: return new TextFile(file);
        }

        throw new RuntimeException("No such type");
    }

    enum Type {
        MP3, MP4, DOC, EXE, IMG, TXT
    }
}
