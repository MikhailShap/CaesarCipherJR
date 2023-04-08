import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class RWFile {
    //TODO Сменить способы работы для шифровки и дешифровки
    public void startRWFile(Path inPath, Path outPath,int key) {
        outPath = outPath.resolve("Decryption" + inPath.getFileName());
        String originalText = readFile(inPath);
        String encodeTex = CaesarCipher.enCode(originalText,key);
        writeFile(outPath,encodeTex);
    }

    public String readFile(Path inPath) {
        StringBuilder textFile = new StringBuilder();
        try (BufferedReader bufferedReader = Files.newBufferedReader(inPath)) {
            while (bufferedReader.ready()){
                textFile.append(bufferedReader.readLine());
                textFile.append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return textFile.toString();
    }

    public void writeFile(Path outPath,String text) {
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(outPath)) {
            bufferedWriter.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Файл сохранен по пути "+ outPath);
    }

}
