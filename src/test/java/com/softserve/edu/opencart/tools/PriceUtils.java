package com.softserve.edu.opencart.tools;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class PriceUtils {
    private PriceUtils() {

    }

    public static double getCurrency(String str) {
        String str1 = str.replaceAll("[,]", "");
        List<String> result = new ArrayList<String>();
        Pattern pattern = Pattern.compile("[0-9]*[.][0-9]*");
        Matcher matcher = pattern.matcher(str1);
        while (matcher.find()) {
            result.add(matcher.group());
        }

        return Double.parseDouble(result.get(0));
    }

    public static double getMultiply(double num1, double num2) {
        DecimalFormat df = new DecimalFormat("#.##");
        double rezult = num1 * num2;
        return Double.parseDouble(df.format(rezult));

    }
}
