package console;

import utils.ALPHABET;
import utils.ModeRWFile;
import utils.RWFile;

import java.nio.file.Path;

public class ConsoleInterface {

    public void start() {
        int numberChoice;
        while (true) {
            String headText = "Язык текста (" + ALPHABET.getLanguageName() + ")\nОсновное меню:\n" + "(1) - Зашифровать текст\n" +
                    "(2) - Расшифровать текст\n(3) - Подбор BruteForce\n(4) - Выбрать язык текста\n(5) - Выйти";
            numberChoice = ValidateGetting.getValidNum(headText);
            switch (numberChoice) {
                case 1 -> openCipherMenu(ModeRWFile.ENCRYPT);
                case 2 -> openCipherMenu(ModeRWFile.DECRYPT);
                case 3 -> openCipherMenu(ModeRWFile.BRUTE_FORCE);
                case 4 -> openMenuSetLanguage();
                case 5 -> {
                    System.out.println("Завершение...");
                    System.exit(0);
                }
                default -> System.out.println("\nНет такой команды\n");
            }
        }
    }

    private void openMenuSetLanguage() {
        int numberChoice;
        String headText = "Выберите язык:\n(1) - Русский\n(2) - Английский\n(3) - Украинский\n(4) - Вернуться в основное меню";
        while (true) {
            numberChoice = ValidateGetting.getValidNum(headText);
            switch (numberChoice) {
                case 1 -> {
                    ALPHABET.setBasicAlphabet(ALPHABET.RUSSIAN);
                    return;
                }
                case 2 -> {
                    ALPHABET.setBasicAlphabet(ALPHABET.ENGLISH);
                    return;
                }
                case 3 -> {
                    ALPHABET.setBasicAlphabet(ALPHABET.UKRAINIAN);
                    return;
                }
                case 4 -> {
                    return;
                }
                default -> System.out.println("\nНет такой команды\n");
            }
        }
    }

    private void openCipherMenu(ModeRWFile mode) {
        String modeName = "";
        switch (mode) {
            case ENCRYPT -> modeName = "Encryption:";
            case DECRYPT -> modeName = "Decryption:";
            case BRUTE_FORCE -> {
                System.out.println("Оригинальный текст должен содержать хотябы одно предложение");
                modeName = "BruteForce:";
            }
        }
        int key = 0;
        if (mode != ModeRWFile.BRUTE_FORCE) {
            key = ValidateGetting.getValidKey(modeName);
        }
        Path inPath = ValidateGetting.getPathInValidFile(modeName);
        Path outPath = ValidateGetting.getPathValidDir(modeName);
        RWFile rwFile = new RWFile();
        rwFile.startCipherRWFile(inPath, outPath, key, mode);
    }

    public boolean openMenuGetUserApproval() {
        int choiceNum;
        String headText = "\nЭто часть похоже на расшифрованный текст ?\n(1) - Да\n(2) - Нет";
        while (true) {
            choiceNum = ValidateGetting.getValidNum(headText);
            switch (choiceNum) {
                case 1 -> {
                    return true;
                }
                case 2 -> {
                    System.out.println("Продолжаем подбор...\n");
                    return false;
                }
                default -> System.out.println("\nНеизвестная команда\n");
            }
        }
    }

}
