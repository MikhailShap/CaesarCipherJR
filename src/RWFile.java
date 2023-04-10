import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class RWFile {

    public void startCipherRWFile(Path inPath, Path outPath, int key, ModeRWFile mode) {
        String originalText = readFile(inPath);
        if(originalText == null){
            return;
        }
        if (originalText.length() == 0) {
            System.out.println("Файл пустой");
            return;
        }
        String resultText = null;
        switch (mode) {
            case ENCRYPT -> {
                outPath = outPath.resolve("Encryption_" + inPath.getFileName());
                resultText = CaesarCipher.enCode(originalText, key);
            }
            case DECRYPT -> {
                outPath = outPath.resolve("Decryption_" + inPath.getFileName());
                resultText = CaesarCipher.deCode(originalText, key);
            }
            case BRUTE_FORCE -> {
                outPath = outPath.resolve("Decryption_BF_" + inPath.getFileName());
                resultText = BruteForce.goBruteForce(originalText);
            }
        }
        if(resultText == null){
            return;
        }
        writeFile(outPath, resultText);
    }

    private String readFile(Path inPath) {
        StringBuilder textFile = new StringBuilder();
        try (BufferedReader bufferedReader = Files.newBufferedReader(inPath)) {
            while (bufferedReader.ready()) {
                textFile.append(bufferedReader.readLine());
                textFile.append("\n");
            }
            return textFile.toString();
        } catch (IOException e) {
            System.err.println("\nЧто то пошло не так ,попробуйте еще раз\n");
            return null;
        }

    }

    private void writeFile(Path outPath, String text) {
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(outPath)) {
            bufferedWriter.write(text);
            System.out.println("\nФайл сохранен по пути " + outPath + "\n");
        } catch (IOException e) {
            System.err.println("\nЧто то пошло не так,файл не сохранился ,попробуйте еще раз\n");
        }

    }

}

