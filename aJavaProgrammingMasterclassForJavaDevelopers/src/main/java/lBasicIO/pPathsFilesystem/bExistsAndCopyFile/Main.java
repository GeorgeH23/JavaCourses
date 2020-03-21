package lBasicIO.pPathsFilesystem.bExistsAndCopyFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Path path = FileSystems.getDefault().getPath("WorkingDirectoryFile.txt");
        printFile(path);

        // path = FileSystems.getDefault().getPath("files","SubdirectoryFile.txt");
        path = Paths.get(".","files","SubdirectoryFile.txt");
        printFile(path);

        // path = Paths.get("/Users/gharpa/Desktop/JavaProjects/OutThere.txt");
        // path = Paths.get("C:\\Users\\gharpa\\Desktop\\JavaProjects\\OutThere.txt");
        path = Paths.get("/Users/lampy/Desktop/OutThere.txt");
        printFile(path);

        path = Paths.get(".");
        System.out.println(path.toAbsolutePath());
        // D:\Examples\.\subfolder\..\directory
        // D:\Examples\directory
        Path path2 = FileSystems.getDefault().getPath(".", "files", "..", "files", "SubdirectoryFile.txt");
        // Use the .normalize() method in order to get rid of the dot/dots in the paths we retrieve
        System.out.println(path2.normalize().toAbsolutePath());
        printFile(path2.normalize());

    }

    private static void printFile(Path path) {
        try(BufferedReader fileReader = Files.newBufferedReader(path)) {
            String line;
            while ((line = fileReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
