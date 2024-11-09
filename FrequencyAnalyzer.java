import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FrequencyAnalyzer {

    // Метод для запроса пути к входному файлу
    public static File getInputFileFromUser(Scanner scanner) {
        System.out.print("Введите путь к входному файлу (или нажмите Enter для использования файла по умолчанию): ");
        if (!scanner.hasNextLine()) {
            throw new IllegalStateException("Поток ввода был закрыт.");
        }
        String inputPath = scanner.nextLine().trim();
        return inputPath.isEmpty() ? new File("src/input.txt") : new File(inputPath);
    }

    // Метод для вычисления частоты символов в указанном файле
    public static HashMap<Character, Long> calculateLettersFrequency(File file) throws FileNotFoundException, IOException {
        HashMap<Character, Long> frequencyDictionary = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            int c;
            while ((c = reader.read()) != -1) {
                char ch = (char) c;
                if (Character.isLetter(ch)) {
                    frequencyDictionary.put(ch, frequencyDictionary.getOrDefault(ch, 0L) + 1);
                }
            }
        }
        return frequencyDictionary;
    }

    // Метод для экспорта результатов анализа в выходной файл
    public static void exportAnalysisResults(HashMap<Character, Long> frequencyDictionary, Scanner scanner) {
        System.out.print("Введите путь к выходному файлу (или нажмите Enter для использования файла по умолчанию): ");
        if (!scanner.hasNextLine()) {
            throw new IllegalStateException("Поток ввода был закрыт.");
        }
        String outputPath = scanner.nextLine().trim();

        // Если путь пустой, используем путь по умолчанию
        if (outputPath.isEmpty()) {
            outputPath = "src/output.txt"; // Установите путь по умолчанию
            System.out.println("Путь не был указан. Используется файл по умолчанию: " + outputPath);
        }

        try (PrintWriter writer = new PrintWriter(new FileWriter(outputPath))) {
            for (Map.Entry<Character, Long> entry : frequencyDictionary.entrySet()) {
                writer.println(entry.getKey() + ": " + entry.getValue());
            }
            System.out.println("Результаты успешно экспортированы в " + outputPath);
        } catch (IOException e) {
            System.err.println("Ошибка при записи в файл: " + e.getMessage());
        }
    }

}
