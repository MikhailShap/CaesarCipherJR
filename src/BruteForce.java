import java.util.InputMismatchException;

public class BruteForce {
    public static String goBruteForce(String encryptFullText){
        int key = 0;
        String optionDecodeText;
        int maxIndexPartText = Math.min(encryptFullText.length(),1000);
        String partText = encryptFullText.substring(0,maxIndexPartText);
        while (true) {
            optionDecodeText = CaesarCipher.deCode(partText, key);
            int counterPoint = 0;
            int spaceCounterAfterDot = 0;
            for (int i = 0; i < optionDecodeText.length() - 1; i++) {
                if (optionDecodeText.charAt(i) == '.') {
                    counterPoint++;
                }
                if (optionDecodeText.charAt(i) == '.' && (optionDecodeText.charAt(i + 1) == ' ' || optionDecodeText.charAt(i + 1) == '\n' || optionDecodeText.charAt(i + 1) == ']')) {
                    spaceCounterAfterDot++;
                }
            }
            if ((counterPoint != 0) && counterPoint == spaceCounterAfterDot) {
                System.out.println(optionDecodeText);
                ConsoleInterface consoleInterface = new ConsoleInterface();
                if (consoleInterface.openMenuGetUserApproval()) {
                    return CaesarCipher.deCode(encryptFullText,key);
                }
            }
            key++;
        }

    }

}
