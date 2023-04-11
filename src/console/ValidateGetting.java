package console;

import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ValidateGetting {
    private static final Scanner console = new Scanner(System.in);
    private static boolean isValidInputFile(String path){
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
   private static boolean isValidOutputDirectory(String outDir){
        Path outPath;
        try {
            outPath = Path.of(outDir);
            if (Files.exists(outPath) && Files.isDirectory(outPath)) {
                return true;
            }
            System.out.println("\nНекорректный путь к директории или ее не существует\n");
        } catch (InvalidPathException e) {
            System.out.println("\nНекорректный путь к директории\n");

        }
        return false;
    }


    public static Path getPathInValidFile(String mode) {
        while (true) {
            System.out.print(mode + "\nНапишите путь к файлу:");
            String strInPath = console.nextLine();
            if (isValidInputFile(strInPath)) {
                Path inPath = Path.of(strInPath);
                return inPath;
            }

        }
    }

    public static Path getPathValidDir(String mode) {
        while (true) {
            System.out.print(mode + "\nНапишите директорию куда сохранить файл:");
            String strOutDir = console.nextLine();
            if (isValidOutputDirectory(strOutDir)) {
                Path outPath = Path.of(strOutDir);
                return outPath;
            }
        }
    }
    public  static int getValidNum(String headText){
        while (true) {
            try {
                System.out.println(headText);
                int numberChoice = console.nextInt();
                return numberChoice;
            } catch (InputMismatchException e) {
                System.out.println("\nНекорректный ввод\n");
            }finally {
                console.nextLine();
            }
        }
    }
    public static int getValidKey(String mode) {
        while (true) {
            System.out.print(mode + "\nНапиши ключ:");
            try {
                int number = console.nextInt();
                if (number < 0) {
                    System.out.println("\nНекорректный ввод\n");
                } else {
                    return number;
                }
            } catch (InputMismatchException e) {
                System.out.println("\nНекорректный ввод\n");

            } finally {
                console.nextLine();
            }
        }
    }


}
