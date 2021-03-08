import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class World {
    private static BufferedReader bufferedReader;
    private static Person player = null;
    private static Battle battle = null;

    public static void main(String[] args) {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        battle = new Battle();
        System.out.print("Введите имя персонажа: ");
        try {
            command(bufferedReader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void command(String string) {
        if (player == null) {
            player = new Hero(string, 25, 350, 20, 10, 0);
            System.out.println(String.format("Сбылось пророчество! Пришел наш спаситель, имя которому - %s\n",
                    player.getName()));
            printMainMenu();
        }

        switch (string) {
            case "1": {
                System.out.println("Мы в средневековье, ЦУМ еще не придумали\n");
                printMainMenu();
                try {
                    command(bufferedReader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            case "2": {
                commitFight();
            }
            case "3": {
                System.exit(1);
            }
            case "да": {
                command("2");
            }
            case "нет": {
                printMainMenu();
                try {
                    command(bufferedReader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        try {
            command(bufferedReader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void commitFight() {
        battle.fight(player, createMonster(), new BattleResult() {
            @Override
            public void fightWin() {
                System.out.println(String.format("%s, ты одержал победу! И не забывай, ты не бессмертный. " +
                        "У тебя осталось %d единиц здоровья\n", player.getName(), player.getHP()));
                System.out.println("Есть силы продолжать путешествие? (да/нет)");
                System.out.println("P.S. да - биться дальше, нет - вернуться в город\n");
                try {
                    command(bufferedReader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void fightLose() {
                System.out.println(String.format("%s храбро сражался, но нелепо", player.getName()));
                System.exit(1);
            }
        });

        }

    private static Person createMonster() {
        int random = (int) (Math.random()*10);
        if (random % 2 == 0) {
            return new Goblin("Гоблин", 20, 150, 20, 15, 20);
        }
        else {
            return new Skeleton("Скелет", 15, 100, 10, 10, 10);
        }
    }

    private static void printMainMenu() {
        System.out.println("Куда держишь путь?");
        System.out.println("1. В ЦУМ к торговцу");
        System.out.println("2. На встречу к приключениям");
        System.out.println("3. Выход");
    }
}
