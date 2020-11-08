package converter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Converter {
    private static final Map<String, String> alphabet = new HashMap<>();

    static {
        alphabet.put(" ", " ");
        alphabet.put("а", "a");
        alphabet.put("б", "b");
        alphabet.put("в", "v");
        alphabet.put("г", "g");
        alphabet.put("д", "d");
        alphabet.put("е", "e");
        alphabet.put("ё", "e");
        alphabet.put("ж", "zh");
        alphabet.put("з", "z");
        alphabet.put("и", "i");
        alphabet.put("й", "i");
        alphabet.put("к", "k");
        alphabet.put("л", "l");
        alphabet.put("м", "m");
        alphabet.put("н", "n");
        alphabet.put("о", "o");
        alphabet.put("п", "p");
        alphabet.put("р", "r");
        alphabet.put("с", "s");
        alphabet.put("т", "t");
        alphabet.put("у", "u");
        alphabet.put("ф", "f");
        alphabet.put("х", "kh");
        alphabet.put("ц", "ts");
        alphabet.put("ч", "ch");
        alphabet.put("ш", "sh");
        alphabet.put("щ", "shch");
        alphabet.put("ъ", "ie");
        alphabet.put("ы", "y");
        alphabet.put("ь", "'");
        alphabet.put("э", "e");
        alphabet.put("ю", "yu");
        alphabet.put("я", "ya");
    }

    /*
    Method returns a string which was converted from russian to english letters
    (it gets a russian letter from map(key) and returns an english(value)
     */
    public String convert(String name) {
        Objects.requireNonNull(name, "name must not be a null");
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < name.length(); i++) {
            String englishLetterOrLetters = alphabet.get(String.valueOf(name.charAt(i)).toLowerCase());
            if (englishLetterOrLetters == null) {
                throw new IllegalArgumentException("Incorrect input data");
            } else if (name.indexOf(name.charAt(i)) == 0) {
                if (Character.isLowerCase(name.charAt(i))) {
                    throw new IllegalArgumentException("First letter must be in upper case");
                }
                builder.append(getUpperCase(englishLetterOrLetters));
            } else {
                builder.append(englishLetterOrLetters);
            }
        }
        return String.valueOf(builder);
    }

    /*
    Method receives >= one letter and return a string in upper case
    (if letter.length > 1 -> convert only first letter in upper case)
    */
    private String getUpperCase(String letter) {
        return letter.length() == 1
                ? letter.toUpperCase()
                : letter.substring(0, 1)
                .toUpperCase()
                .concat(letter.substring(1));
    }

    /*
     Method saves a data to a file.
     */
    public void saveToFile(String file, String data) throws IOException {
        Objects.requireNonNull(file, "Path to file can not be a null");
        Objects.requireNonNull(data, "Data can not be a null");
        String withTab = data;
        if (Files.notExists(Paths.get(file))) {
            throw new IOException("Couldn't find a file by path");
        } else {
            if (Files.size(Paths.get(file)) >= 0) {
                withTab = data.concat("\n");
            }
            Files.write(Paths.get(file), withTab.getBytes(), StandardOpenOption.APPEND);
        }
    }
}
