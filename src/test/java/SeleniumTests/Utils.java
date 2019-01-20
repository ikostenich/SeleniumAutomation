package SeleniumTests;

import org.apache.commons.lang3.RandomStringUtils;

public class Utils {
    public static String generateRandomString(int length, boolean useLetters, boolean useNumbers) {
        String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
        return generatedString;
    }


}
