import java.io.*;

public class ConvertByteStreamToCharStream {
    public static void main(String[] args) {
        String filePath = "sample.txt";
        
        try (InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath), "UTF-8");
             BufferedReader br = new BufferedReader(isr)) {
            
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
