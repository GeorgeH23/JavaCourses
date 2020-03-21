package lBasicIO.pPathsFilesystem.eWalkingAFileTree;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

    public static void main(String[] args) {

        System.out.println("---Walking Tree for Dir2---");
        Path dirPath = FileSystems.getDefault().getPath("FileTree");
        try {
            Files.walkFileTree(dirPath, new PrintNames());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
