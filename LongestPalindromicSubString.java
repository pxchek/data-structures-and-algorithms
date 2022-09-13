import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * "Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000".
 *
 * @author Panindra Chekoori
 */

public final class LongestPalindromicSubString {
    public static void main(String[] args) {
        System.out.print("The longest palindromic substring is : ");
        longestPalindromicSubString("saippuakivikauppiastattarrattatmalayalam");
    }

    private static void longestPalindromicSubString(final String word) {
        if(Objects.isNull(word)) {
            throw new IllegalArgumentException("string cannot be null.");
        }
        
        final List<Triple> triples = new ArrayList<>();
        int nextCharacterIndex = 0, firstOccurenceIndex = 0, lastOccurenceIndex;

        while (firstOccurenceIndex < word.length() - 1) {
            final Character character = word.charAt(nextCharacterIndex);
            int nextOccurenceIndex = word.length() - 1;
            firstOccurenceIndex = word.indexOf(character, nextCharacterIndex);

            while (word.lastIndexOf(character, nextOccurenceIndex) > 0) {
                lastOccurenceIndex = word.lastIndexOf(character, nextOccurenceIndex);
                if (firstOccurenceIndex != lastOccurenceIndex) {
                    int difference = lastOccurenceIndex - firstOccurenceIndex;
                    triples.add(new Triple(firstOccurenceIndex, lastOccurenceIndex, difference));
                }
                nextOccurenceIndex = lastOccurenceIndex - 1;
            }
            nextCharacterIndex++;
        }

        Collections.sort(triples, (var t1, var t2) -> Integer.compare(t2.getDifference(), t1.getDifference()));

        printLongestPalindromicSubString(word, triples);
    }

    private static void printLongestPalindromicSubString(final String word, final List<Triple> triples) {
        for (final Triple triple : triples) {
            if (isValidPalindrome(word, triple.getLeftIndex(), triple.getRightIndex())) {
                System.out.println(word.substring(triple.getLeftIndex(), triple.getRightIndex() + 1));
                break;
            }
        }
    }


    private static boolean isValidPalindrome(final String word, final int firstOccurrence, final int nextOccurrence) {
        final StringBuilder subString = new StringBuilder(word.substring(firstOccurrence, nextOccurrence + 1));
        final String match = new String(subString);
        return match.equals(subString.reverse().toString());
    }

}

final class Triple {
    private final int leftIndex;
    private final int rightIndex;
    private final int difference;

    public Triple(final int leftIndex, final int rightIndex, final int difference) {
        this.leftIndex = leftIndex;
        this.rightIndex = rightIndex;
        this.difference = difference;
    }

    public int getLeftIndex() {
        return leftIndex;
    }

    public int getRightIndex() {
        return rightIndex;
    }

    public int getDifference() {
        return difference;
    }
}
