import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * FileHandler (Team Member B - Dan)
 * This class handles all file reading from the data folder.
 * It can list files and return the contents of a file.
 */
public class FileHandler {

    // Folder where all our text files are stored
    // we need to add a folder called data (with Gradle?)
    private final String dataFolder = "data";

    // Method to list all .txt files in the data folder
    public ArrayList<String> listFiles() {
        ArrayList<String> fileList = new ArrayList<>();
        File folder = new File(dataFolder);

        if (!folder.exists() || !folder.isDirectory()) {
            System.out.println("Error: data folder not found.");
            return fileList;
        }

        // Only get .txt files
        File[] files = folder.listFiles((dir, name) -> name.endsWith(".txt"));
        if (files == null || files.length == 0) {
            System.out.println("No files found in data folder.");
            return fileList;
        }

        // Add file names to list
        for (File file : files) {
            fileList.add(file.getName());
        }

        return fileList;
    }

    // Method to get file contents by file name
    public String getFileContent(String fileName) {
        File file = new File(dataFolder + "/" + fileName);

        if (!file.exists() || !file.isFile()) {
            return "Error: File " + fileName + " does not exist.";
        }

        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            return "Error: Could not read file " + fileName + ".";
        }

        return content.toString();
    }

    // Method to get file contents by index
    public String getFileContent(int fileIndex) {
        ArrayList<String> files = listFiles();
        if (fileIndex < 1 || fileIndex > files.size()) {
            return "Error: File index " + fileIndex + " is out of range.";
        }
        String fileName = files.get(fileIndex - 1);
        return getFileContent(fileName);
    }
}
