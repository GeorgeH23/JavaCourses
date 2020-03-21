package lBasicIO.pPathsFilesystem.cReadExistingDirectoryContents;

import java.io.IOException;
import java.nio.file.*;

public class Main {

    public static void main(String[] args) {

        Path directory = FileSystems.getDefault().getPath("FileTree/Dir2");
        System.out.println("Using globe with string matcher:");
        try (DirectoryStream<Path> contents = Files.newDirectoryStream(directory, "*.dat")){
            for (Path file : contents) {
                System.out.println(file.getFileName());
            }
        } catch (IOException | DirectoryIteratorException e) {
            e.printStackTrace();
        }

        /*DirectoryStream.Filter<Path> filter = new DirectoryStream.Filter<Path>() {

            @Override
            public boolean accept(Path entry) throws IOException {
                return Files.isRegularFile(entry);
            }
        };*/

        // Using lambda expression
        DirectoryStream.Filter<Path> filter = p -> Files.isRegularFile(p);

        System.out.println("\nUsing a filter to show regular files:");
        try (DirectoryStream<Path> contents = Files.newDirectoryStream(directory, filter)){
            for (Path file : contents) {
                System.out.println(file.getFileName());
            }
        } catch (IOException | DirectoryIteratorException e) {
            e.printStackTrace();
        }
    }
}
