public class Whale extends Pet {

    public Whale() {
        super("Whale", 10, 12);
    }

    public void changeHp(int dHp) {
        if (dHp < - 3) {
            hp += dHp;
        }
        if (dHp > 0) {
            hp += dHp;
        }
    }

}
