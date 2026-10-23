
/*
 * Student Name: Radmehr Vafadar
 * SID: 20421691
 * Date: 12/07/24
 * Description: This program takes a word and encodes it into a cypher.
 */

public class Section3 {
    public static void main(String[] args) {

        String message = "hello world!";
        int key = 3;
        
        String encoded = encode(message, key);
        System.out.println("Encoded: " + encoded);
        
        String decoded = decode(encoded, key);
        System.out.println("Decoded: " + decoded);
    }

    // This method encodes the text
    public static String encode(String message, int key) {
        StringBuilder result = new StringBuilder();
        
        for (char c : message.toCharArray()) {
            if (c >= 'a' && c <= 'z') {

                char encoded = (char) (((c - 'a' + key) % 26) + 'a');
                result.append(encoded);
            } else {

                result.append(c);
            }
        }
        
        return result.toString();
    }

    // this methods decodes the text
    public static String decode(String codedText, int key) {
        StringBuilder result = new StringBuilder();
        
        for (char c : codedText.toCharArray()) {
            if (c >= 'a' && c <= 'z') {

                char decoded = (char) (((c - 'a' - key + 26) % 26) + 'a');
                result.append(decoded);
            } else {
                result.append(c);
            }
        }
        
        return result.toString();
    }
}
