package HW1;

public class Player {
    /**
     * Класс для описания игрока
     */
    private String name;     //имя игрока

    private boolean risk;    //стратегия игрока, если true игрок меняет дверь

    public Player(String name, boolean risk) {
        this.name = name;
        this.risk = risk;
    }

    public String getName() {
        return name;
    }

    public boolean getRisk() {
        return risk;
    }
}
