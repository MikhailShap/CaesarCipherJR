package utils;

public enum ALPHABET {
    RUSSIAN,
    ENGLISH,
    UKRAINIAN;
    private static String languageName = "Русский";
    private static String basicAlphabet = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯабвгдеёжзийклмнопрстуфхцчшщъыьэюя.,\":-!? ";


    public static String getBasicAlphabet() {
        return basicAlphabet;
    }

    public static String getLanguageName() {
        return languageName;
    }

    public static void setBasicAlphabet(ALPHABET language) {
        switch (language) {
            case ENGLISH -> {
                languageName = "Английский";
                basicAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz.,\":-!? ";
            }
            case UKRAINIAN -> {
                languageName = "Украинский";
                basicAlphabet = "АБВГҐДЕЄЖЗИІЇЙКЛМНОПРСТУФХЦЧШЩЬЮЯабвгґдеєжзиіїйклмнопрстуфхцчшщьюя.,\":-!? ";
            }
            case RUSSIAN -> {
                languageName = "Русский";
                basicAlphabet = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯабвгдеёжзийклмнопрстуфхцчшщъыьэюя.,\":-!? ";
            }
        }
    }
}