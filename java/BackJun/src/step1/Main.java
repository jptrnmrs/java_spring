package step1;

import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> str = new ArrayList<String>();

        while(sc.hasNext()) {
        	str.add(sc.next());
        }
        sc.close();
        for (String s : str) {
            System.out.println(s);
        }
    }
}