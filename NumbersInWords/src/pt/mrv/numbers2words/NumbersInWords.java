package pt.mrv.numbers2words;

import java.text.DecimalFormat;

public class NumbersInWords implements WordifiedNumber {

    private NumberType type;
    private String lang;
    private NumbersInLanguage words;

    public NumbersInWords() {
	type = NumberType.CARDINAL;
	lang = "EN";
	loadLanguage();
    }

    public NumbersInWords(NumberType type, String lang) {
	this.type = type;
	this.lang = lang;
	loadLanguage();
    }

    private void loadLanguage() {
	switch (lang) {
	case "EN":
	    words = new NumbersInEnglish();
	    break;
	case "FR":
	    // TODO for implementation of a french version
	    break;
	default:
	    words = new NumbersInEnglish();
	}

    }

    private String parseUpTo1000(int number) {
	String token;

	// first test if the mod 100 is up to twenty, if it is we have a direct convertion
	if (number % 100 < 20) {
	    token = words.getNumbers(type)[number % 100];
	    number /= 100;

	    // if it's not we have to break it down and parse the hundreds and the tens
	} else {
	    token = words.getNumbers(type)[number % 10];
	    number /= 10;

	    token = words.getTens()[number % 10] + " " + token;
	    number /= 10;
	}
	// if the remaining is zero than it's under one hundred then it's already parsed
	if (number == 0) {
	    return token;
	}

	String result = words.getNumbers(NumberType.CARDINAL)[number] + " hundred";
	if (!token.isEmpty()) {
	    result += " "+ words.getSeparator()+" " + token;
	}

	return result;
    }

    public String toWords(int number) {

	if (number == 0) {
	    return words.getZero();
	}

	String paddedNumber = Integer.toString(number);

	DecimalFormat df = new DecimalFormat("000000000");
	paddedNumber = df.format(number);

	int millions = Integer.parseInt(paddedNumber.substring(0, 3));
	int hundredThousands = Integer.parseInt(paddedNumber.substring(3, 6));
	int thousands = Integer.parseInt(paddedNumber.substring(6, 9));

	String result = null;
	if (millions == 0) {
	    result = "";
	} else {
	    result = parseUpTo1000(millions) + " " + words.getScaleNumbers()[1] + " ";
	}
	String token = null;
	if (hundredThousands == 0) {
	    token = "";
	} else if (hundredThousands == 1) {
	    token = words.getNumbers(NumberType.CARDINAL)[1] + " " + words.getScaleNumbers()[0]
		    + " ";
	} else {
	    token = parseUpTo1000(hundredThousands) + " " + words.getScaleNumbers()[0] + " ";
	}
	result += token;

	if ((millions == 0 && hundredThousands > 0 && thousands < 99)
		|| (millions > 0 && hundredThousands == 0 && thousands < 100)) {
	    result += words.getSeparator() + " ";
	}

	result += parseUpTo1000(thousands);

	return result;
    }

    public String getLang() {
	return lang;
    }

    public void setLang(String lang) {
	this.lang = lang;
    }

    public NumberType getType() {
	return type;
    }

    public void setType(NumberType type) {
	this.type = type;
    }
}
