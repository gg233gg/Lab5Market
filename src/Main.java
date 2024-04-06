import java.util.Scanner;
import java.io.File;
public class Main {
    public static void main(String[] args) {
        try {
            Date a = new Date("2023/1/5");
            Date b = new Date("2023/1/4");
            System.out.print(a.compareTo(b)+"\n");
            a.print();
            b.print();
        } catch(Exception e) {
            System.out.println(e.toString());
        }
    }
}
