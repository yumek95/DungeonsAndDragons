public class Battle {

    public void fight(Person hero, Person monster, BattleResult battleResult) {
        //Runnable runnable = () -> {
            int turn = 1;
            boolean isFightEnded = false;

            while (!isFightEnded) {
                System.out.println("-----Ход: " + turn + " -----");
                if (turn % 2 != 0)
                    isFightEnded = makeHit(hero, monster, battleResult);
                else isFightEnded = makeHit(monster, hero, battleResult);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                turn ++;
            }
//        };
//        Thread thread = new Thread(runnable);
//        thread.start();

    }

    private boolean makeHit(Person attacker, Person defender, BattleResult battleResult) {
        int hit = attacker.attack();
        int defenderHP = defender.getHP() - hit;

        if (hit == 0) {
            System.out.println(String.format("Удача покинула %s, он промахнулся", attacker.getName()));
        } else {
            System.out.println(String.format("Вооу! %s собрал все силы в кулак и нанес удар в %d единиц",
                    attacker.getName(), hit));
            System.out.println(String.format("После точного удара у %s осталось %d здоровья... " +
                    "Возможно у него сотрясение, вызывайте скорую!", defender.getName(), defenderHP));
        }
        if (defenderHP <= 0 && defender instanceof Hero) {
            System.out.println("Закончилась история нашего героя :( и так нелепо... В общем, начинай все заново. " +
                    "И не допускай больше таких ошибок, хоть и не все зависит от тебя.");
            battleResult.fightLose();
            return true;

        } else if (defenderHP <= 0) {
            System.out.println(String.format("Ты храбро сражался, %s! Держи в награду %d золота и %d очков опыта!",
                    attacker.getName(), defender.getGold(), 100));
            //забираем у проигравшего золото
            attacker.setGold(attacker.getGold() + defender.getGold());
            //получаем 100 опыта
            attacker.setXP(attacker.getXP() + 100);
            battleResult.fightWin();
            return true;
        } else {
            defender.setHP(defenderHP);
            return false;
        }
    }
}
