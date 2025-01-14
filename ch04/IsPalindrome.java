import java.util.Random;

public class IsPalindrome {
    public static void main(String[] args) {
        Random random = new Random();
        String input = generateRandomString(random, 6); 
        boolean isPalindrome = isSpecial(input);
        int longestPalindromeLength = getPalindromeLength(input);
        System.out.println("Random String: " + input);
        System.out.println("Is it a palindrome? " + isPalindrome);
        System.out.println("Longest Palindromic Length: " + longestPalindromeLength);
    }

    public static boolean isSpecial(String text) {
        String tempText = alterText(text);
        return text.equals(tempText);
    }

    public static String alterText(String inputText) {
        if (inputText == null || inputText.isEmpty()) {
            return inputText;
        }
        return inputText.charAt(inputText.length() - 1) +
                alterText(inputText.substring(0, inputText.length() - 1));
    }

    public static String generateRandomString(Random random, int length) {
        String chars = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(chars.length());
            sb.append(chars.charAt(randomIndex));
        }
        return sb.toString();
    }

    public static int getPalindromeLength(String text) {
        String reversed = new StringBuilder(text).reverse().toString();
        int maxLength = 0;
        int currentLength = 0;
    
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == reversed.charAt(i)) {
                currentLength++;
                if (currentLength > maxLength) {
                    maxLength = currentLength;
                }
            } else {
                currentLength = 0;
            }
        }
        return maxLength;
    }
    


}




