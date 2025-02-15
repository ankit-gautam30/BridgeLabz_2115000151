import java.io.*;

public class CompareStringOperations {
    public static void main(String[] args) {
        compareStringBuilders();
        compareFileReaders("sample.txt");
    }
    
    public static void compareStringBuilders() {
        int iterations = 1_000_000;
        
        long startTime = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sbf.append("hello");
        }
        long stringBufferTime = System.nanoTime() - startTime;
        
        startTime = System.nanoTime();
        StringBuilder sbd = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sbd.append("hello");
        }
        long stringBuilderTime = System.nanoTime() - startTime;
        
        System.out.println("Time taken by StringBuffer: " + stringBufferTime + " ns");
        System.out.println("Time taken by StringBuilder: " + stringBuilderTime + " ns");
    }
    
    public static void compareFileReaders(String filePath) {
        long startTime, fileReaderTime, inputStreamReaderTime;
        int wordCount;
        
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            startTime = System.nanoTime();
            wordCount = 0;
            String line;
            while ((line = br.readLine()) != null) {
                wordCount += line.split("\\s+").length;
            }
            fileReaderTime = System.nanoTime() - startTime;
            System.out.println("FileReader word count: " + wordCount + " in " + fileReaderTime + " ns");
        } catch (IOException e) {
            System.out.println("Error reading file with FileReader: " + e.getMessage());
        }
        
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "UTF-8"))) {
            startTime = System.nanoTime();
            wordCount = 0;
            String line;
            while ((line = br.readLine()) != null) {
                wordCount += line.split("\\s+").length;
            }
            inputStreamReaderTime = System.nanoTime() - startTime;
            System.out.println("InputStreamReader word count: " + wordCount + " in " + inputStreamReaderTime + " ns");
        } catch (IOException e) {
            System.out.println("Error reading file with InputStreamReader: " + e.getMessage());
        }
    }
}
