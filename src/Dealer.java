public class Dealer implements Seller {
//    private int smallHPBottle = 10;
//    private int mediumHPBottle = 25;
//    private int bigHPBottle = 50;

    @Override
    public String sell(Goods goods) {
        String result = "";
        int moneyByHero = 0;
        if (goods == Goods.SMALL_POTION)
            result = "Small potion";
        if (goods == Goods.MEDIUM_POTION)
            result = "Medium potion";
        if (goods == Goods.BIG_POTION)
            result = "Big potion";
        return result;
    }

    public enum Goods {
        SMALL_POTION,
        MEDIUM_POTION,
        BIG_POTION
    }
}
