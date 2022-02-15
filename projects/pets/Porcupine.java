public class Porcupine extends Pet {

    public Porcupine() {
        super("Porcupine", 5, 2);
    }

    public void attack(Pet opponent) {
        int damage = opponent.calculateDamage(this);
        this.changeHp(-damage);
        Pet pets[] = {opponent};
        doAbility(pets);
    }

    public void doAbility(Pet[] pets) {
        for (int i = 0; i < pets.length; i++) {
            pets[i].changeHp(-1);
        }
    }
}
