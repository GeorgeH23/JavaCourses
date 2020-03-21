package lBasicIO.pPathsFilesystem.gMappingIOandNIOMethods;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {

        File file = new File("Examples/file.txt");
        Path convertedPath = file.toPath();
        System.out.println("Converted Path = " + convertedPath);

        File parent = new File("Examples");
        File resolvedFile = new File(parent, "dir/file.txt");
        System.out.println(resolvedFile.toPath());

        resolvedFile = new File("Examples", "dir/file.txt");
        System.out.println(resolvedFile.toPath());

        // Is the equivalent of this
        Path parentPath = Paths.get("Examples");
        Path childRelativePath = Paths.get("dir/file.txt");
        System.out.println(parentPath.resolve(childRelativePath));

        File workingDirectory = new File("").getAbsoluteFile();
        System.out.println("Working directory = " + workingDirectory.getAbsolutePath());

        System.out.println("--- Print Dir2 contents using .list() method---");
        File dir2File = new File(workingDirectory, File.separator + "FileTree" + File.separator + "Dir2");
        String[] dir2Contents = dir2File.list();
        for (int i = 0; i < dir2Contents.length; i++){
            System.out.println("i = " + i + ": " + dir2Contents[i]);
        }

        System.out.println("--- Print Dir2 contents using .listFiles() method---");
        File[] dir2Files = dir2File.listFiles();
        for (int i = 0; i < dir2Files.length; i++){
            System.out.println("i = " + i + ": " + dir2Files[i].getName());
        }
    }
}
