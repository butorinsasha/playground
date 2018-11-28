package readfile;

import java.io.*;

public class ReadFileWithBufferedReader {
    public static void main(String [] args) {

        // The name of the file to open.
        String fileName = "temp.txt";
        File file = new File(".\\src\\main\\java\\readfile\\temp.txt");

        // This will reference one line at a time
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader =
                    new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader =
                    new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                String[] words = line.split("[\\s]"); // spliting words in a line by spaces
                for (String word : words) {
                    System.out.println(word);
                }
            }

            // Always close files.
            bufferedReader.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" +
                            fileName + "'");
        }
        catch(IOException ex) {
            System.out.println(
                    "Error reading file '"
                            + fileName + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }
    }
}
