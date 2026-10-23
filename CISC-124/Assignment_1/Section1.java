import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/*
 * Student Name: Radmehr Vafadar
 * SID: 20421691
 * Date: 12/07/24
 * Description: This program reads a text file and using multiple methods, completes tasks.
 */

public class Section1 {

    public static void main(String[] args) {
        // Test Cases for Code
        Section1 wordCounter = new Section1();
        String script = "The belief that our destiny is shared; that this country only works when we accept certain obligations to one another and to future generations. The freedom which so many Americans have fought for and died for come with responsibilities as well as rights. And among those are love and charity and duty and patriotism. That's what makes America great.";
        int wordCount = wordCounter.countWords(script);
        int sentenceCount = wordCounter.countSentences(script);
        boolean wordIn = wordCounter.containsWord(script, "love");

        System.out.println("Word count: " + wordCount);
        System.out.println("Sentence count: " + sentenceCount);
        System.out.println("Contains the word 'love': " + wordIn);

        Map<String, Integer> frequentWordsMap = wordCounter.frequentWords(script);
        System.out.println("Frequent words: " + frequentWordsMap);

        // File name for the requent words
        String fileName = "PoliticalSpeech.txt";
        String outputFileName = "output.txt";
        
        try {
            String text = wordCounter.readFile(fileName);
            String[] individualWords = text.split("\\s+");

            // Create arrays to store unique words and their frequencies
            String[] uniqueWords = new String[individualWords.length];
            int[] wordFrequencies = new int[individualWords.length];
            int uniqueWordCount = 0;

            // Populate the uniqueWords array with unique words
            for (String word : individualWords) {
                boolean isUnique = true;
                for (int i = 0; i < uniqueWordCount; i++) {
                    if (word.equalsIgnoreCase(uniqueWords[i])) {
                        isUnique = false;
                        break;
                    }
                }
                if (isUnique) {
                    uniqueWords[uniqueWordCount] = word;
                    uniqueWordCount++;
                }
            }

            // Count the frequencies of each unique word
            for (String word : individualWords) {
                for (int i = 0; i < uniqueWordCount; i++) {
                    if (word.equalsIgnoreCase(uniqueWords[i])) {
                        wordFrequencies[i]++;
                        break;
                    }
                }
            }

            // Find the top 10 most frequent words using sort
            String[] topTenWords = new String[10];
            int[] topTenFrequencies = new int[10];
            for (int i = 0; i < uniqueWordCount; i++) {
                for (int j = 0; j < 10; j++) {
                    if (wordFrequencies[i] > topTenFrequencies[j]) {
                        for (int k = 9; k > j; k--) {
                            topTenWords[k] = topTenWords[k - 1];
                            topTenFrequencies[k] = topTenFrequencies[k - 1];
                        }
                        topTenWords[j] = uniqueWords[i];
                        topTenFrequencies[j] = wordFrequencies[i];
                        break;
                    }
                }
            }

            wordCounter.writeFile(outputFileName, topTenWords, topTenFrequencies);

            System.out.println("Top 10 most frequently used words have been written to " + outputFileName);
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    // Count the number of words in text
    public int countWords(String text) {
        String noPunctuation = text.replaceAll("[.,;?!]", " ");
        String[] individualWords = noPunctuation.split("\\s+");
        return individualWords.length;
    }


    // Count the number of sentences in text
    public int countSentences(String text) {
        String[] individualSentences = text.split("[.!?]+");
        return individualSentences.length;
    }

    public Map<String, Integer> frequentWords(String text) {
        Map<String, Integer> wordFrequencies = new HashMap<>();

        String noPunctuation = text.replaceAll("[.,;?!]", " ");
        String[] individualWords = noPunctuation.split("\\s+");

        for (String word : individualWords) {
            String lowerCaseWord = word.toLowerCase();
            wordFrequencies.put(lowerCaseWord, wordFrequencies.getOrDefault(lowerCaseWord, 0) + 1);
        }

        return wordFrequencies;
    }
    
    // Check if file contains a word
    public boolean containsWord(String text, String word) {
        String noPunctuation = text.replaceAll("[.,;?!]", "").toLowerCase();
        String[] individualWords = noPunctuation.split("\\s+");
        return Arrays.asList(individualWords).contains(word.toLowerCase());
    }

    private String readFile(String fileName) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line).append(" ");
        }
        br.close();
        return sb.toString();
    }

    private void writeFile(String fileName, String[] words, int[] frequencies) throws IOException {
        FileWriter writer = new FileWriter(fileName);
        writer.write("Top 10 most frequently used words:\n");
        for (int i = 0; i < words.length; i++) {
            writer.write((i + 1) + ". " + words[i] + ": " + frequencies[i] + " occurrences\n");
        }
        writer.close();
    }
}