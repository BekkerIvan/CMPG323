package com.cmpg.nwu.accsystem.project_functions;

import org.springframework.security.crypto.bcrypt.BCrypt;

import java.util.*;

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
}