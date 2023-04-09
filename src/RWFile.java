import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class RWFile {
    //TODO Сменить способы работы для шифровки и дешифровки
    public void startRWFileEncrypt(Path inPath, Path outPath, int key) {
        outPath = outPath.resolve("Encryption_" + inPath.getFileName());
        String originalText = readFile(inPath);
        String encodeTex = CaesarCipher.enCode(originalText,key);
        writeFile(outPath,encodeTex);
    }
    public void startRWFileDecrypt(Path inPath, Path outPath, int key){
        outPath = outPath.resolve("Decryption_"+inPath.getFileName());
        String encryptText = readFile(inPath);
        String decodeText = CaesarCipher.deCode(encryptText,key);
        writeFile(outPath,decodeText);
    }
    public void  startRWFileBruteForce(Path inPath,Path outPath){
        outPath = outPath.resolve("Decryption_BF_"+inPath.getFileName());
        String encryptText =readFile(inPath);
        String decodeText = BruteForce.goBruteForce(encryptText);
        writeFile(outPath,decodeText);
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
        System.out.println("Файл сохранен по пути "+ outPath+"\n");
    }

}

