package main.parser;

import main.utils.NumberUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PersonValidator {

    private ArrayList<String> invalidStrings;

    public ArrayList<String> getInvalidStrings() {
        return invalidStrings;
    }

    public PersonValidator(){

    }

    public boolean isValidPersonString(String personString, int maxMark){
        return checkStringFormat(personString) && checkPersonCharacteristicForProperMark(personString, maxMark);
    }

    private boolean checkStringFormat(String personString){
        boolean result = personString.matches("(\\S+\\s*\\|\\s*){3}\\d");
        if(result){
            return true;
        }
        invalidStrings.add(personString);
        return false;
    }

    private boolean checkPersonCharacteristicForProperMark(String personString, int maxMark){
        List<String> characteristic = Arrays.asList(personString.split("\\s*\\|\\s*"));

        String stringMark = characteristic.get(3);

        if(NumberUtils.isStringADigit(stringMark)){
            Integer mark = Integer.parseInt(stringMark);
            if (mark > 0 & mark <= maxMark){
                return true;
            }
        }
        invalidStrings.add(personString);
        return false;
    }


}
