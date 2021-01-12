package exceptionmulticatch.converter;

public class AnswerStat {

    private final BinaryStringConverter converter;

    public AnswerStat(BinaryStringConverter converter) {
        this.converter = converter;
    }

    public boolean[] convert(String checkboxes) {
        try {
            return converter.binaryStringToBooleanArray(checkboxes);
        } catch (NullPointerException | IllegalArgumentException ex){
//            ex.printStackTrace();
            throw new InvalidBinaryStringException(ex);
        }
    }

    public int answerTruePercent(String answers) {
        boolean[] booleans = convert(answers);
        int numberOfTrue = 0;
        for (boolean aBoolean : booleans) {
            if (aBoolean) {
                numberOfTrue++;
            }
        }
        return (int) Math.round((double) numberOfTrue / booleans.length * 100);
    }

}
