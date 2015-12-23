package pt.mrv.numbers2words;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class NumberInWordsTest {

    @Test
    public void wordifiedWordReferenceTest() throws Exception {

	WordifiedNumber wordifiedNumber = new NumbersInWords();

	assertEquals("one", wordifiedNumber.toWords(1));
	assertEquals("twenty one", wordifiedNumber.toWords(21));
	assertEquals("one hundred and five", wordifiedNumber.toWords(105));
	assertEquals("one thousand and five", wordifiedNumber.toWords(1005));
	assertEquals("one hundred and ten thousand one hundred and five",
		wordifiedNumber.toWords(110105));
	assertEquals("one million and ninety nine", wordifiedNumber.toWords(1000099));
	assertEquals("one million one hundred", wordifiedNumber.toWords(1000100));
	assertEquals(
		"fifty six million nine hundred and forty five thousand seven hundred and eighty one",
		wordifiedNumber.toWords(56945781));
    }
}
