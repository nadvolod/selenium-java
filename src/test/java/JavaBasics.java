import org.junit.Test;


public class JavaBasics {
    @Test
    public void primitiveDataTypes()
    {
        //int is for storing integers
        int currentAge = 33;
        //The boolean data type has only two possible values: true and false.
        boolean isVisible = true;
        //The char data type is a single 16-bit Unicode character
        char singleCharacter = 'a';
        // Double precision (has width of 64), double has a larger range than float
        //Great for decimal values and default
        //0.0d
        double moneyInBank = 12.528758975d;
        //others
        //The float data type is a single-precision (has a width of 32)
        //This data type should never be used for precise values, such as currency
        float moneyInBankFloat = 12.52f;
        short goodForSavingMemory;
        //It has a minimum value of -128 and a maximum value of 127
        byte hasVeryTinyRange = 127;
    }

    @Test
    public void checkValues() {
        int currentAge = 10 / 3;
        double moneyInBank = 10d / 3d;
        float moneyInBankFloat = 10f / 3f;

        System.out.println("currentAge value = " + currentAge);
        System.out.println("moneyInBank value = " + moneyInBank);
        System.out.println("moneyInBankFloat value = " + moneyInBankFloat);
    }

    @Test
    public void variablesChallenge() {
        double weightInPounds = 100;
        double weightInKg = 0;
        final double CONVERSION_RATIO = .45359237;

        weightInKg = weightInPounds * CONVERSION_RATIO;
        System.out.println("weightInKg = " + weightInKg);
    }

    @Test
    public void strings() {
        String myName = "Nikolay";
        System.out.println("myName = " + myName);
        System.out.println("myName = " + myName +
                " and I love test " +
                "automation");
        String number1 = "100";
        String number2 = "200";
        System.out.println("number1 + number2 = " + number1 + number2);

        String ten = "10";
        int myInt = 50;
        ten = ten + myInt;
        System.out.println("ten = " + ten);
    }
}
