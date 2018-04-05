package ru.kda.re;

import java.util.regex.Pattern;

public class TestRe {

    private final String re = "\\+|\\*|\\/|\\-";

    public static void main (String [] args) {
        TestRe te = new TestRe();
        te.printRes (te.doRe("123++456-678*(555-490)"));
        te.printRes (te.doReStr("123++456-678*(555-490)"));
    }

    public String [] doRe (String arg) {
        Pattern pt = Pattern.compile(re);
        String [] res = pt.split(arg);

        return res;
    }

    public String [] doReStr (String arg) {
        String [] res = arg.split(re);

        return res;
    }

    public void printRes (String [] res) {
        System.out.println("\nNext test...");
        for (String s : res) {
            System.out.println(s);
        }

    }

}
