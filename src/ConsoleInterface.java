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
                case 2-> openDecryptionMenu();
                case 3-> openBruteForceMenu();
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
            System.out.println("Encryption:\nНапиши ключ");
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
            System.out.print("Encryption:\nНапишите путь к файлу:");
            String strInPath = console.nextLine();
            if(PathValidate.isInputFileOk(strInPath)){
                inPath = Path.of(strInPath);
                break;
            }

        }
        while (true) {
            System.out.print("Encryption:\nНапишите директорию куда сохранить зашифрованный файл:");
            String strOutDir = console.nextLine();
            if(PathValidate.isOutDIROk(strOutDir)){
                outPath = Path.of(strOutDir);
                break;
            }
        }
        System.out.println();
        //TODO вызов метода для зашифровки
        RWFile rwFile = new RWFile();
        rwFile.startRWFileEncrypt(inPath,outPath,key);


    }
    private  void openDecryptionMenu(){
        console.nextLine();
        Path inPath;
        Path outPath;
        int key;
        while (true){
            System.out.println("Decryption:\nНапиши ключ");
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
            System.out.print("Decryption:\nНапишите путь к зашифрованному файлу:");
            String strInPath = console.nextLine();
            if(PathValidate.isInputFileOk(strInPath)){
                inPath = Path.of(strInPath);
                break;
            }

        }
        while (true) {
            System.out.print("Decryption:\nдиректорию куда сохранить расшифрованный файл:");
            String strOutDir = console.nextLine();
            if(PathValidate.isOutDIROk(strOutDir)){
                outPath = Path.of(strOutDir);
                break;
            }
        }
        RWFile rwFile = new RWFile();
        rwFile.startRWFileDecrypt(inPath,outPath,key);

    }
    private void openBruteForceMenu(){
        console.nextLine();
        Path inPath;
        Path outPath;
        while (true) {
            System.out.print("BruteForce:\nНапишите путь к зашифрованному файлу:");
            String strInPath = console.nextLine();
            if(PathValidate.isInputFileOk(strInPath)){
                inPath = Path.of(strInPath);
                break;
            }
        }
        while (true) {
            System.out.print("BruteForce:\nНапишите директорию куда сохранить расшифрованный файл:");
            String strOutDir = console.nextLine();
            if(PathValidate.isOutDIROk(strOutDir)){
                outPath = Path.of(strOutDir);
                break;
            }
        }
        RWFile rwFile = new RWFile();
        rwFile.startRWFileBruteForce(inPath,outPath);
    }
    public  boolean openMenuGetUserApproval() {
        while (true) {
            System.out.println("Это часть похоже на расшифрованный текст ?\n(1) - Да\n(2) - Нет");
            int choiceNum;
            try {
                choiceNum = console.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Некорректный ввод");
                console.nextLine();
                continue;
            }
            switch (choiceNum) {
                case 1 -> {
                    console.nextLine();
                    return true;
                }
                case 2 -> {
                    System.out.println("Продолжаем подбор...\n");
                    return false;
                }
                default -> System.out.println("Неизвестная команда");
            }
        }
    }

}
