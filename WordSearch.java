public class WordSearch {
    public static String findSentenceWithWord(String[] sentences, String word) {
        for (String sentence : sentences) {
            if (sentence.contains(word)) {
                return sentence;
            }
        }
        return "Not Found";
    }

    public static void main(String[] args) {
        String[] sentences = {
            "The sun is shining.",
            "It is a beautiful day.",
            "Programming is fun.",
            "Java is a powerful language."
        };
        String word = "Java";
        System.out.println(findSentenceWithWord(sentences, word));
    }
}
