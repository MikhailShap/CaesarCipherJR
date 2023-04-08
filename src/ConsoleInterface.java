import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleInterface {
    private final Scanner console = new Scanner(System.in);

    public void start() {
        int numberChoice;
        while (true) {
            System.out.println("Язык русский\nОсновное меню:");
            System.out.println("(1) - Зашифровать текст\n(2) - Расшифровать текст\n(3) - Подбор BruteForce\n(4) - Выйти");
            try {
                numberChoice = console.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("\nНекорректный ввод\n");
                console.next();
                continue;
            }
            switch (numberChoice) {
                case 1 -> openEncryptionMenu();
                case 4 -> {
                    System.out.println("Завершение...");
                    System.exit(0);
                }
                default -> System.out.println("\nНет такой команды\n");
            }
        }
    }

    private void openEncryptionMenu() {
        console.nextLine();
        Path inPath;
        Path outPath;
        int key;
        while (true){
            System.out.println("Напиши ключ");
            try {
                key = console.nextInt();
                break;
            }catch (InputMismatchException e){
                System.out.println("Некорректный ключ");

            }finally {
                console.nextLine();
            }
        }
        while (true) {
            System.out.print("Напишите путь к файлу:");
            String strInPath = console.nextLine();
            if(PathValidate.isInputFileOk(strInPath)){
                inPath = Path.of(strInPath);
                break;
            }

        }
        while (true) {
            System.out.print("Напишите директорию куда сохранить расшифрованный файл:");
            String strOutDir = console.nextLine();
            if(PathValidate.isOutDIROk(strOutDir)){
                outPath = Path.of(strOutDir);
                break;
            }
        }
        System.out.println();
        //TODO вызов метода для зашифровки
        RWFile rwFile = new RWFile();
        rwFile.startRWFile(inPath,outPath,key);


    }

}
