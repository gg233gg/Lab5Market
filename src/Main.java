import java.util.Scanner;
import java.io.File;

public class Main {
    static void purchase(FamilyMart f, Scanner p) {
        p.nextLine();
        while (p.hasNext()) {
            f.purchase(p.nextLine().split("\\s"));
        }
        f.clear();
    }

    static void sell(FamilyMart f, Scanner s) {
        s.nextLine();
        while (s.hasNext()) {
            f.sell(s.nextLine().split("\\s"));
        }
        f.clear();
    }

    public static void main(String[] args) {
        try {
            FamilyMart f = new FamilyMart();
            int i = 0;
            for (i = 0; i <= 5; i++) {
                purchase(f, new Scanner(new File("test_cases\\test_cases\\" + i + "_pur.txt")));
                sell(f, new Scanner(new File("test_cases\\test_cases\\" + i + "_sel.txt")));
                f.eveningClear();
                System.out.printf("turnover:%.2f\n", f.getTurnover());
                f.nextDay();
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
