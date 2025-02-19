import java.util.*;

public class CircularBuffer {
    private int[] buffer;
    private int size, head, tail, count;
    
    public CircularBuffer(int size) {
        this.size = size;
        this.buffer = new int[size];
        this.head = 0;
        this.tail = 0;
        this.count = 0;
    }
    
    public void insert(int value) {
        buffer[tail] = value;
        tail = (tail + 1) % size;
        if (count == size) {
            head = (head + 1) % size;
        } else {
            count++;
        }
    }
    
    public List<Integer> getBufferContents() {
        List<Integer> contents = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            contents.add(buffer[(head + i) % size]);
        }
        return contents;
    }
    
    public static void main(String[] args) {
        CircularBuffer buffer = new CircularBuffer(3);
        buffer.insert(1);
        buffer.insert(2);
        buffer.insert(3);
        buffer.insert(4);
        System.out.println(buffer.getBufferContents());
    }
}
