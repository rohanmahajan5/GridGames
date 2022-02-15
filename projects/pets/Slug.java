/**
 * Slug has 2 HP 3 ATK
 * It deals damage to opponent when it 
 * takes damage
 */

public class Slug extends Pet {
    
    private int damageAmount;

    public Slug() {
        super("Slug", 2, 3);
    }

    public void changeHp(int dif) {
        super.changeHp(dif);
    }
 }