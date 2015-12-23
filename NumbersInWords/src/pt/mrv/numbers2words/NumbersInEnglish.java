package pt.mrv.numbers2words;

public class NumbersInEnglish implements NumbersInLanguage {
    // Small number names up to twenty
    public static final String[] NUMBERS_CARDINAL = new String[] { "", "one", "two", "three",
	    "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen",
	    "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen" };

    // TODO for future versions with ordinal values
    public static final String[] NUMBERS_ORDINAL = new String[] {};

    // Tens number names up to one hundred
    public static final String[] TENS = new String[] { "", "", "twenty", "thirty", "forty", "fifty",
	    "sixty", "seventy", "eighty", "ninety" };

    // Scale number names
    public static final String[] SCALE_NUMBERS = new String[] { "thousand", "million", "billion" };

    @Override
    public String[] getNumbers(NumberType type) {
	if (type == NumberType.CARDINAL) {
	    return NUMBERS_CARDINAL;
	} else {
	    return NUMBERS_ORDINAL;
	}
    }

    @Override
    public String[] getTens() {
	return TENS;
    }

    @Override
    public String[] getScaleNumbers() {
	return SCALE_NUMBERS;
    }

    @Override
    public String getZero() {
	return "zero";
    }

    @Override
    public String getSeparator() {
	return "and";
    }

}
