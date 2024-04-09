import java.util.Scanner;
import java.io.*;

public class Main {
    static void purchase(FamilyMart f, Scanner p) {
        p.nextLine();
        while (p.hasNext()) {
            f.purchase(p.nextLine().split("\\s"));
        }
    }

    static void sell(FamilyMart f, Scanner s) {
        s.nextLine();
        while (s.hasNext()) {
            f.sell(s.nextLine().split("\\s"));
        }
    }

    public static void main(String[] args) {
        try {
            FamilyMart f = new FamilyMart();
            PrintWriter output = new PrintWriter("result.txt");
            int i = 0;
            for (i = 0; i <= 5; i++) {
                purchase(f, new Scanner(new File("test_cases\\" + i + "_pur.txt")));
                sell(f, new Scanner(new File("test_cases\\" + i + "_sel.txt")));
                f.eveningClear();
                output.printf("%d day : turnover:%.2f\n", i, f.getTurnover());
                //System.out.printf("%d day : turnover:%.2f\n", i, f.getTurnover());
                f.nextDay();
            }
            output.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
