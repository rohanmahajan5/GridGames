public abstract class Pet {
    
    // fields
    protected String name;
    protected int hp;
    protected int atk;
    

    public Pet(String name, int hp, int atk) {
        this.name = name;
        this.hp = hp;
        this.atk = atk;
    }

    public String toString() {
        return String.format("Name: %s\tHP:%d\tAtk:%d", name, hp, atk);
    }

    public int getHp() {
        return hp;
    }
    
    public void changeHp(int dHp) {
        hp += dHp;
        if (dHp > 0) {
            // heal ability
        }
    }

    public int calculateDamage(Pet opponent) {
        return atk;// - opponent.getDef();
    }

    public void attack(Pet opponent) {
        int damage = opponent.calculateDamage(this);
        this.changeHp(-damage);
    }

    //public abstract void doAbility();

    
    
}
