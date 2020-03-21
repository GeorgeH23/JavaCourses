package lBasicIO.pPathsFilesystem.bExistsAndCopyFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MoreOnPaths {

    public static void main(String[] args) {
        // write your code here
        Path path = FileSystems.getDefault().getPath("WorkingDirectoryFile.txt");
        printFile(path);

        // path = FileSystems.getDefault().getPath("files","SubdirectoryFile.txt");
        path = Paths.get(".","files","SubdirectoryFile.txt");
        printFile(path);

        path = Paths.get("/Users/gharpa/Desktop/JavaProjects/OutThere.txt");
        // path = Paths.get("C:\\Users\\gharpa\\Desktop\\JavaProjects\\OutThere.txt");
        printFile(path);

        path = Paths.get(".");
        System.out.println(path.normalize().toAbsolutePath());

        Path path2 = FileSystems.getDefault().getPath(".", "files", "..", "files", "SubdirectoryFile.txt");
        // when you get a path from a class, method, etc. it's a good idea to normalize the path in order to remove the point/points
        printFile(path2.normalize());
        System.out.println(path2.normalize().toAbsolutePath());

        Path path3 = FileSystems.getDefault().getPath("thisFileDoesntExist.txt");
        System.out.println(path3.toAbsolutePath());

        // this path doesn't exist
        Path path4 = Paths.get("Z:\\", "abddef", "whatever.txt");
        System.out.println(path4.toAbsolutePath());

        path = FileSystems.getDefault().getPath("files");
        System.out.println("Exists = " + Files.exists(path));
        System.out.println("Exists = " + Files.exists(path4));

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
