package interfaces.animal;

public class Lion implements Animal{

    public static final int NUBER_OF_LEGS = 4;

    @Override
    public int getNumberOfLegs() {
        return NUBER_OF_LEGS;
    }

    @Override
    public String getName() {
        return "Lion";
    }
}
