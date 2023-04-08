import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;

public class PathValidate {

    static boolean isInputFileOk(String path){
        Path inPath;
        try {
            inPath = Path.of(path);
            if (Files.exists(inPath) && Files.isRegularFile(inPath) ) {
               return true;
            }
            System.out.println("\nФайл не существует или указан некорректный путь\n");
        }catch (InvalidPathException e){
            System.out.println("\nНекорректный путь\n");
        }
        return false;

    }
    static boolean isOutDIROk(String outDir){
        Path outPath;
        try {
            outPath = Path.of(outDir);
            if (Files.exists(outPath) && Files.isDirectory(outPath)) {
                return true;
            }
            System.out.println("Некорректный путь к директории или ее не существует");
        } catch (InvalidPathException e) {
            System.out.println("Некорректный путь к директории");

        }
        return false;
    }

}
