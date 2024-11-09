import java.io.*;
import java.util.HashMap;
import java.util.Scanner;
public class Main { // Добавлен класс Main
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            File inputFile = FrequencyAnalyzer.getInputFileFromUser(scanner);
            if (!inputFile.exists()) {
                System.err.println("Ошибка: файл не найден.");
                return;
            }

            HashMap<Character, Long> frequencyDictionary = FrequencyAnalyzer.calculateLettersFrequency(inputFile);
            FrequencyAnalyzer.exportAnalysisResults(frequencyDictionary, scanner);
        } catch (IllegalStateException e) {
            System.err.println("Ошибка: поток ввода был закрыт.");
        } catch (FileNotFoundException e) {
            System.err.println("Ошибка: файл не найден. " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
