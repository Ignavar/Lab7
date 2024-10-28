package FileSearch;

import java.io.File;

public class FileSearch {

    /**
     * Main entry point of the program.
     * Takes a directory path and file name as command-line arguments,
     * then searches for the specified file within the given directory and its subdirectories.
     *
     * @param args Command-line arguments where args[0] is the directory path and args[1] is the file name to search.
     */
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java FileSearch <directory> <filename>");
            return;
        }

        String directoryPath = args[0];
        String fileName = args[1];

        File directory = new File(directoryPath);
        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("The specified directory does not exist or is not a directory.");
            return;
        }

        // Call the recursive search method
        boolean found = searchFile(directory, fileName);
        
        if (!found) {
            System.out.println("File not found.");
        }
    }

    /**
     * Recursively searches for a specified file within a given directory and its subdirectories.
     *
     * @param directory The directory in which to start the search.
     * @param fileName The name of the file to search for.
     * @return true if the file is found; false otherwise.
     */
    static boolean searchFile(File directory, String fileName) {
        File[] files = directory.listFiles();
        if (files == null) {
            return false;
        }

        for (File file : files) {
            if (file.isDirectory()) {
                // Recursive call to search in subdirectories
                if (searchFile(file, fileName)) {
                    return true;
                }
            } else if (file.getName().equals(fileName)) {
                // File found
                System.out.println("File found: " + file.getAbsolutePath());
                return true;
            }
        }
        return false;
    }
}
