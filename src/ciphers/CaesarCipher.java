package ciphers;

import utils.ALPHABET;

public class CaesarCipher {
    public static String enCode(String text, int key) {
        StringBuilder encodeText = new StringBuilder();

        for (char symbol : text.toCharArray()) {
            int indexInAlphabet = ALPHABET.getBasicAlphabet().indexOf(symbol);

            if (indexInAlphabet == -1) {
                encodeText.append(symbol);
            } else {
                int encodeIndex = (indexInAlphabet + key) % ALPHABET.getBasicAlphabet().length();
                char encodeSymbol = ALPHABET.getBasicAlphabet().charAt(encodeIndex);
                encodeText.append(encodeSymbol);
            }
        }
        return encodeText.toString();
    }
    public static String deCode(String encodeText, int key) {
        StringBuilder deCodeText = new StringBuilder();

        for (char symbol : encodeText.toCharArray()) {
            int indexInAlphabet = ALPHABET.getBasicAlphabet().indexOf(symbol);

            if (indexInAlphabet == -1) {
                deCodeText.append(symbol);
            } else {
                int deCodeIndex = (indexInAlphabet - key) % ALPHABET.getBasicAlphabet().length();
                if (deCodeIndex < 0) {
                    deCodeIndex += ALPHABET.getBasicAlphabet().length();
                }
                deCodeText.append(ALPHABET.getBasicAlphabet().charAt(deCodeIndex));
            }
        }

        return deCodeText.toString();
    }
}
