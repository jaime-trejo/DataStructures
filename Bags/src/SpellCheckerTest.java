/*
 *  Name:Jaime Trejo
 *  Date: 1/18/14
 *  	SpellCheckerTest class will create an object and try to test with the original dictionary to get misspelled words
 *
 */

import java.io.IOException;

public class SpellCheckerTest
{
    public static void main(String[] args) throws IOException
    {
        SpellChecker testerSC = new SpellChecker();

        testerSC.checkAgainstDictionary();
    }


}
