package lBasicIO.pPathsFilesystem.bExistsAndCopyFile;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.TimeZone;

public class CopyFileMoveRenameDelete {

    public static void main(String[] args) {
        try {
/*
            // Copy a file
            Path sourceFile = FileSystems.getDefault().getPath("Examples", "file1.txt");
            Path copyFile = FileSystems.getDefault().getPath("Examples", "file1Copy.txt");
            Files.copy(sourceFile, copyFile, StandardCopyOption.REPLACE_EXISTING);

            // Copy a directory without the existing files in the directory
            sourceFile = FileSystems.getDefault().getPath("Examples", "Dir1");
            copyFile = FileSystems.getDefault().getPath("Examples", "Dir4");
            Files.copy(sourceFile, copyFile, StandardCopyOption.REPLACE_EXISTING);

            // Move a file to another directory
            Path filetoMove = FileSystems.getDefault().getPath("Examples", "file1Copy.txt");
            Path destination = FileSystems.getDefault().getPath("Examples", "Dir4", "file1Copy.txt");
            Files.move(filetoMove, destination, StandardCopyOption.REPLACE_EXISTING);

            // Rename a file
            Path fileToRename = FileSystems.getDefault().getPath("Examples", "file1.txt");
            Path newFileName = FileSystems.getDefault().getPath("Examples", "file2.txt");
            Files.move(fileToRename, newFileName, StandardCopyOption.REPLACE_EXISTING);

            // Delete a file
            Path fileToDelete = FileSystems.getDefault().getPath("Examples","Dir4", "file1Copy.txt");
//            if (Files.exists(fileToDelete)) {
//                Files.delete(fileToDelete);
//            } else {
//                System.out.println("No such file exists!");
//            }
            Files.deleteIfExists(fileToDelete);

            // Create a new File
            Path fileToCreate = FileSystems.getDefault().getPath("Examples", "CreatedFile.txt");
            Files.createFile(fileToCreate);

            // Create a new Directory
            Path directoryToCreate = FileSystems.getDefault().getPath("Examples", "CreatedDirectory");
            Files.createDirectory(directoryToCreate);

            // Create multiple Directories at the same time
            Path directoriesToCreate = FileSystems.getDefault().getPath("Examples", "CreatedDirectories1/CreatedDirectories2/CreatedDirectories3");
            // Path directoriesToCreate = FileSystems.getDefault().getPath("Examples/CreatedDirectories1/CreatedDirectories2/CreatedDirectories3");
            Files.createDirectories(directoriesToCreate); */

            // Get the file attributes for a specific file
            Path filePath = FileSystems.getDefault().getPath("Examples", "CreatedFile.txt");
            long size = Files.size(filePath);
            System.out.println("Size = " + size);
            System.out.println("Last modified = " + Files.getLastModifiedTime(filePath));

            BasicFileAttributes attributes = Files.readAttributes(filePath, BasicFileAttributes.class);
            System.out.println("Size = " + attributes.size());
            System.out.println("Last modified = " + attributes.lastModifiedTime());
            System.out.println("Created = " + attributes.creationTime());
            System.out.println("Is directory = " + attributes.isDirectory());
            System.out.println("Is regular file = " + attributes.isRegularFile());

        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
