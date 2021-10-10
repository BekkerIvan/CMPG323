package com.cmpg.nwu.accsystem.project_functions;

import com.fasterxml.jackson.core.io.JsonStringEncoder;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProjectFunction {
    public static String hashPassword(String PasswordStr) {
        return BCrypt.hashpw(PasswordStr, BCrypt.gensalt());
    }

    public static boolean verifyPassword(String RawPasswordStr, String HashedPasswordStr) {
        return BCrypt.checkpw(RawPasswordStr, HashedPasswordStr);
    }

    public static String generateRandomString(int StringLengthInt) {
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";

        StringBuilder StringBuilderObj = new StringBuilder(StringLengthInt);

        for (int i = 0; i < StringLengthInt; i++) {
            int AlphaNumericIndexInt = (int) (AlphaNumericString.length() * Math.random());
            StringBuilderObj.append(AlphaNumericString.charAt(AlphaNumericIndexInt));
        }

        return StringBuilderObj.toString();
    }

    public static String typeOf(Object PassedObj) {
        return PassedObj.getClass().getName();
    }

    public static Map<String, String> initAPIMessage() {
        return new HashMap<String, String>();
    }

    public static void setAPIOutput(Map<String, String> APIMessageArr, Boolean SuccessResult) {
        APIMessageArr.put("Success", String.valueOf(SuccessResult));
    }

    public static void setAPIValue(Map<String, String> APIMessageArr, String KeyValueStr, String ValueStr) {
        APIMessageArr.put(KeyValueStr, ValueStr);
    }

    public static boolean validateEmailAddress(String EmailAddressToValidateStr) {
        Pattern RegexPatternObj = Pattern.compile("^[(a-zA-Z-0-9-\\_\\+\\.)]+@[(a-z-A-z)]+\\.[(a-zA-z)]{2,3}$");
        Matcher RegexMatchesObj = RegexPatternObj.matcher(EmailAddressToValidateStr);
        return RegexMatchesObj.matches();
    }

    public static boolean validateIdNumber(String IdNumberStr) {
        String RegexPatternStr = "([0-9][0-9])((?:[0][1-9])|(?:[1][0-2]))((?:[0-2][0-9])|(?:[3][0-1]))([0-9])([0-9]{3})([0-9])([0-9])([0-9])";
        Pattern RegexPatternObj = Pattern.compile(RegexPatternStr);

        Matcher RegexMatchesObj = RegexPatternObj.matcher(IdNumberStr);

        if (RegexMatchesObj.matches()) {

            int Total1 = 0;
            for (int i = 0; i < IdNumberStr.length() - 1; i += 2) {
                Total1 = Total1 + Integer.parseInt(IdNumberStr.substring(i, i + 1));
            }

            StringBuilder StringBuilderObj = new StringBuilder("");
            for (int i = 1; i < IdNumberStr.length(); i += 2) {
                StringBuilderObj.append(IdNumberStr.charAt(i));
            }

            String EvenNumberTotalsStr = (Long.parseLong(StringBuilderObj.toString()) * 2) + "";
            int Total2 = 0;
            for (int i = 0; i < EvenNumberTotalsStr.length(); i++) {
                Total2 = Total2 + Integer.parseInt(EvenNumberTotalsStr.substring(i, i + 1));
            }

            int LastDigitInt = (10 - ((Total1 + Total2) % 10)) % 10;
            int CheckDigitInt = Integer.parseInt(IdNumberStr.substring(12, 13));

            return CheckDigitInt == LastDigitInt;
        } else {
            return false;
        }
    }

}