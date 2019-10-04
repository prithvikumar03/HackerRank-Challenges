package hackerrank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class JavaCurrencyFormatter {

    static public final Locale INDIA = new Locale("en","INDIA");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        scanner.close();

        // Write your code here.
        NumberFormat nf_france = NumberFormat.getInstance(Locale.FRENCH);
        String france = nf_france.format(payment);
        NumberFormat nf_us = NumberFormat.getInstance(Locale.US);
        String us = nf_us.format(payment);
        NumberFormat nf_china = NumberFormat.getInstance(Locale.CHINA);
        String china = nf_china.format(payment);
        NumberFormat nf_India = NumberFormat.getInstance(INDIA);
        String india = nf_India.format(payment);

        System.out.println("US: $" + nf_us.format(payment));
        System.out.println("India: Rs." + nf_India.format(payment));
        System.out.println("China: " + nf_china.format(payment));
        System.out.println("France: " + nf_france.format(payment));

        System.out.println("US: $" + us);
        System.out.println("India: Rs." + india);
        System.out.println("China: ¥" + china);
        System.out.println("France: " + france +" €");
    }
}