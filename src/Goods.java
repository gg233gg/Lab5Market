
public class Goods {
    private final String name;
    private float price;
    private final int expireDays;
    private final Date productDate;
    private final Date expireDate;

    /**
     * 创建商品，并录入商品的各项信息，其中过期日期为实际过期日的前一天
     */
    Goods(String vname, float vprice, int vexpireDays, String vproductDate) {
        name = vname;
        price = vprice;
        expireDays = vexpireDays;
        productDate = new Date(vproductDate);
        expireDate = new Date(vproductDate, expireDays - 1);
    }

    Goods(String[] goodsInfo) {
        this(goodsInfo[0], Float.parseFloat(goodsInfo[1]), Integer.parseInt(goodsInfo[2]), goodsInfo[3]);
    }

    /**
     * 比较两个商品的过期日期
     */
    public int compareExpireDate(Goods goods) {
        return this.expireDate.compareTo(goods.expireDate);
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }
}
