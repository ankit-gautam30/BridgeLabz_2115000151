public class CompareStringBufferAndBuilder {
    public static void main(String[] args) {
        int iterations = 1_000_000;
        
        long startTime = System.nanoTime();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            stringBuffer.append("hello");
        }
        long stringBufferTime = System.nanoTime() - startTime;
        
        startTime = System.nanoTime();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            stringBuilder.append("hello");
        }
        long stringBuilderTime = System.nanoTime() - startTime;
        
        System.out.println("Time taken by StringBuffer: " + stringBufferTime + " ns");
        System.out.println("Time taken by StringBuilder: " + stringBuilderTime + " ns");
    }
}
