public class TempTestClass {
    public static void main(String[] args) {
        Hero hero = new Hero("Igor", 15, 12, 12, 12, 12);

        int sum = 0;
        for (int i = 0; i < 10000; i++) {
            //System.out.println(hero.attack());
            sum += hero.attack();
        }
        System.out.println("avg = " + (float) sum/10000);

    }


}

