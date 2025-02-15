import java.io.*;

public class ReadUserInputWriteToFile {
    public static void main(String[] args) {
        String filePath = "sample.txt";
        
        try (InputStreamReader isr = new InputStreamReader(System.in);
             BufferedReader br = new BufferedReader(isr);
             FileWriter fw = new FileWriter(filePath)) {
            
            System.out.println("Enter text (type 'exit' to stop):");
            String line;
            while (!(line = br.readLine()).equalsIgnoreCase("exit")) {
                fw.write(line + "\n");
            }
            
            System.out.println("Input saved to " + filePath);
        } catch (IOException e) {
            System.out.println("Error handling file: " + e.getMessage());
        }
    }
}
