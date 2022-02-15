/**
 * Snail has 3HP and 2 ATK
 * It heals 2 HP each time it attacks
 */

public class Snail extends Pet {

    private int healAmount = 2;

    public Snail() {
        super("Snail", 3, 2);
    }

    public void attack(Pet opponent) {
        super.attack(opponent);
        this.changeHp(healAmount);
    }

    /**
     * A side effect means that a variable 
     * changes in the middle of the code
    */

    /**
     * Functional programming does not have
     * side effects
     * work only with constants
     * const b = new Bee(5);
     */

}
