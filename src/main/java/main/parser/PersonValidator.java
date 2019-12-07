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
        return checkPersonCharacteristicCount(personString) &&
                checkPersonCharacteristicForEmpty(personString) &&
                checkPersonCharacteristicForProperMark(personString, maxMark);
    }

    private boolean checkPersonCharacteristicCount(String personString){
        String[] characteristic = personString.split("\\s*\\|\\s*");
        if (characteristic.length == 4) {
            return true;
        }
        else{
            invalidStrings.add(personString);
            return false;
        }
    }

    private boolean checkPersonCharacteristicForEmpty(String personString){
        List<String> characteristic = Arrays.asList(personString.split("\\s*\\|\\s*"));
        if (!characteristic.stream().anyMatch(line -> line.isEmpty())) {
            return true;
        }
        else{
            invalidStrings.add(personString);
            return false;
        }
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
