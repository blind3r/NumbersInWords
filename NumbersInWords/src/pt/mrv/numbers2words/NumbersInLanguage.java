package pt.mrv.numbers2words;

public interface NumbersInLanguage {
    
    String getZero();

    String[] getNumbers(NumberType type);

    String[] getTens();

    String[] getScaleNumbers();
    
    String getSeparator();
}
