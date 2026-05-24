// FileLoader.java
package exercises.Text_Analyzer_Exercise;

import java.io.BufferedReader;
import java.io.IOException;

public class FileLoader {
    public static String readFile(String filePath) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        }
        return content.toString();
    }
}

