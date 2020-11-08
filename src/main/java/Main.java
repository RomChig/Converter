import converter.Converter;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Converter converter = new Converter();
        converter.saveToFile("output.txt", converter.convert("Рома"));
        converter.saveToFile("output.txt", converter.convert("Влад"));
        converter.saveToFile("output.txt", converter.convert("Настя"));
        converter.saveToFile("output.txt", converter.convert("Валя"));
        converter.saveToFile("output.txt", converter.convert("Юля"));
        converter.saveToFile("output.txt", converter.convert("Катя"));
        converter.saveToFile("output.txt", converter.convert("Ника"));
        converter.saveToFile("output.txt", converter.convert("Антон"));
        converter.saveToFile("output.txt", converter.convert("Саша"));
        converter.saveToFile("output.txt", converter.convert("Кристина"));
        converter.saveToFile("output.txt", converter.convert("Карина"));
    }
}
