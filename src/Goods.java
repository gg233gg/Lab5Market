
public class Goods {
    private String name;
    private int price;
    private int expireDays;
    private Date productDate;
    private Date expireDate;

    Goods(String vname, int vprice, int vexpireDays, String vproductDate) {
        name = vname;
        price = vprice;
        expireDays = vexpireDays;
        productDate = new Date(vproductDate);
        expireDate = new Date (vproductDate, expireDays-1);
    }
}
