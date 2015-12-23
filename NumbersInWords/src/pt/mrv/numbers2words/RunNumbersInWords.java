package pt.mrv.numbers2words;

public class RunNumbersInWords {
    public static void main(String[] args) {
	WordifiedNumber wordifiedNumber = new NumbersInWords();

	System.out.println(wordifiedNumber.toWords(1));
	System.out.println(wordifiedNumber.toWords(21));
	System.out.println(wordifiedNumber.toWords(105));
	System.out.println(wordifiedNumber.toWords(1005));
	System.out.println(wordifiedNumber.toWords(110105));
	System.out.println(wordifiedNumber.toWords(1000099));
	System.out.println(wordifiedNumber.toWords(1000100));
	System.out.println(wordifiedNumber.toWords(56945781));
    }
}
