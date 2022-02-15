public class LaneWorldRunner {
    public static void main(String[] args) {
        Whale w = new Whale();
        Porcupine p = new Porcupine();

        System.out.println(w);
        System.out.println(p);
        w.attack(p);
    }
}
