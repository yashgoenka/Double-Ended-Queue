import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    CharacterComparator obo = new OffByOne();

    @Test
    public void testIsPalindrome() {
        assertTrue(palindrome.isPalindrome("noon"));
        assertFalse(palindrome.isPalindrome("persiflage"));
        assertTrue(palindrome.isPalindrome("racecar"));
        assertFalse(palindrome.isPalindrome("aaaaab"));
        assertTrue(palindrome.isPalindrome("I"));
        assertTrue(palindrome.isPalindrome(""));

        assertTrue(palindrome.isPalindrome("flake", obo));
        assertFalse(palindrome.isPalindrome("noon", obo));
        assertFalse(palindrome.isPalindrome("racecar", obo));
        assertTrue(palindrome.isPalindrome("I", obo));
        assertTrue(palindrome.isPalindrome("", obo));
        assertTrue(palindrome.isPalindrome("tops", obo));
        assertTrue(palindrome.isPalindrome("smelt", obo));
        assertTrue(palindrome.isPalindrome("flame", obo));
        assertTrue(palindrome.isPalindrome("climb", obo));
        assertTrue(palindrome.isPalindrome("tutu", obo));
        assertTrue(palindrome.isPalindrome("abwab", obo));
        assertTrue(palindrome.isPalindrome("yadwxcbz", obo));
        assertTrue(palindrome.isPalindrome("%&", obo));
        assertTrue(palindrome.isPalindrome("13689542", obo));
    }

}
