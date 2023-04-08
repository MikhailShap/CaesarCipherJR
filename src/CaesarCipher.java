public class CaesarCipher {
    public static String enCode(String text, int key) {
        StringBuilder encodeText = new StringBuilder();

        for (char symbol : text.toCharArray()) {
            int indexInAlphabet = ALPHABET.BASIC.indexOf(symbol);

            if (indexInAlphabet == -1) {
                encodeText.append(symbol);
            } else {
                int encodeIndex = (indexInAlphabet + key) % ALPHABET.BASIC.length();
                char encodeSymbol = ALPHABET.BASIC.charAt(encodeIndex);
                encodeText.append(encodeSymbol);
            }
        }
        return encodeText.toString();
    }
    public static String deCode(String encodeText, int key) {
        StringBuilder deCodeText = new StringBuilder();

        for (char symbol : encodeText.toCharArray()) {
            int indexInAlphabet = ALPHABET.BASIC.indexOf(symbol);

            if (indexInAlphabet == -1) {
                deCodeText.append(symbol);
            } else {
                int deCodeIndex = (indexInAlphabet - key) % ALPHABET.BASIC.length();
                if (deCodeIndex < 0) {
                    deCodeIndex += ALPHABET.BASIC.length();
                }
                deCodeText.append(ALPHABET.BASIC.charAt(deCodeIndex));
            }
        }

        return deCodeText.toString();
    }
}
