import java.util.Scanner;

public class Person implements Fighter {
    private String name;
    private int agility, hp, gold, power, xp;

//    public Person() {
//        System.out.print("Введите имя персонажа: ");
//        name = new Scanner(System.in).nextLine();
//        agility = 23;
//        hp = 300;
//        gold = 50;
//        power = 70;
//        xp = 10;
//        System.out.println(name + " создан!");
//    }


    public void setHP(int hp) {
        this.hp = hp;
    }

    public int getHP() {
        return hp;
    }

    public int getGold() {
        return gold;
    }

    public int getXP() {
        return xp;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public void setXP(int xp) {
        this.xp = xp;
    }

    public String getName() {
        return name;
    }

    public Person(String name, int agility, int hp, int gold, int power, int xp) {
        this.name = name;
        this.agility = agility;
        this.hp = hp;
        this.gold = gold;
        this.power = power;
        this.xp = xp;
    }

    private int getRandomValue() {
        return (int) (Math.random() * 101);
    }

    @Override
    public int attack() {
        if ((agility * 3 > getRandomValue()) && (getRandomValue() > 0) && (getRandomValue() <= 12)) return power * 2;
        else if (agility * 3 > getRandomValue()) return power;
        else return 0;
    }

    @Override
    public String toString() {
        return String.format("%s здоровье:%d", name, hp);
    }

}
