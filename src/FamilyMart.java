import java.util.ArrayList;

public class FamilyMart {
   private Date date = new Date("2022/5/2");
   private float turnover;
   private ArrayList<Goods> shelf;
   FamilyMart() {
       shelf = new ArrayList<>();
   }

    /**
     * goodsInfo里包括商品的各项信息，创建该商品，并按其过期日期放入货架，确保货架上最前面的商品是最快过期的
     */
   public void purchase(String[] goodsInfo) {
       Goods goods = new Goods(goodsInfo);
       int i=0;
       while(i<shelf.size()) {
           if(goods.compareExpireDate(shelf.get(i))<=0) {
               break;
           }
           i++;
       }
       shelf.add(i,goods);
   }

    /**
     * goodsInfo里包括商品名称和可能的打折力度，并挑选货架上最临期的商品贩卖
     */
    public void sell(String[] goodsInfo) {
        String goodsName = goodsInfo[0];
        float discount;
        int i = 0;
        if (goodsInfo.length == 1) {
            discount = 1;
        } else {
            discount = Float.parseFloat(goodsInfo[1]);
        }
        while (i < shelf.size()) {
            if (shelf.get(i).getName().equals(goodsName)) {
                turnover += shelf.get(i).getPrice() * discount;
                shelf.remove(i);
                break;
            }
            i++;
        }
   }

    /**
     * 清理当日货架上过期的商品
     */
   public void eveningClear() {
       int key = 0;
       while (key < shelf.size()) {
           if (shelf.get(key).getExpireDate().compareTo(date) > 0) {
               break;
           }
           key++;
       }
       for (int i = 0; i < key; i++)
           shelf.removeFirst();
   }

   public void clear() {
       int key = 0;
       while(key<shelf.size()) {
           if(shelf.get(key).getExpireDate().compareTo(date)>=0) {
               break;
           }
           key++;
       }
       for (int i = 0; i < key; i++)
           shelf.removeFirst();
   }

   public void nextDay() {
       date.nextDay();
   }

    /**
     * 返回营业额
     */
   public float getTurnover() {
       return turnover;
   }

    /**
     * 打印货架上的商品和过期日期
     */
   public void printShelf() {
       for(Goods i : shelf) {
           System.out.print(i.getName()+"\t\t"+i.getPrice()+"\t\t");
           i.getExpireDate().print();
       }
   }
}
