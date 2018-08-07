public class Palindrome {

    public Deque<Character> wordToDeque(String word) {
        int wordLength = word.length();
        Deque<Character> d = new LinkedListDeque<Character>();
        int i = 0;
        while (i < wordLength) {
            d.addLast(word.charAt(i));
            i += 1;
        }
        return d;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {

        int length = word.length();
        if (length <= 1) {
            return true;
        } else {
            if (!cc.equalChars(word.charAt(0), word.charAt(length - 1))) {
                return false;
            } else {
                return isPalindrome(word.substring(1, length - 1), cc);
            }
        }
    }

    /** Recursive implementation */
    public boolean isPalindrome(String word) {
        int length = word.length();
        if (length <= 1) {
            return true;
        } else {
            if (word.charAt(0) != word.charAt(length - 1)) {
                return false;
            } else {
                return isPalindrome(word.substring(1, length - 1));
            }
        }
    }

    /* A non recursive implementation that uses get */
    /*
    public boolean isPalindrome(String word) {
        if (word.length() <= 1) {
            return true;
        }
        Deque d = wordToDeque(word);
        int i = 0;
        int j = d.size() - 1;
        while (j > i) {
            if (d.get(i) != d.get(j)){
                return false;
            }
            i += 1;
            j -= 1;
        }
        return true;
    }
     */


}
