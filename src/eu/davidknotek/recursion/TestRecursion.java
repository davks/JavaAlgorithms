package eu.davidknotek.recursion;

public class TestRecursion {

    public static void main(String[] args) {
        exploration(0);
    }
    public static void exploration(int depth) {
        System.out.println("Rozhlizim se v hloubce " + depth + " m");

        if (depth >= 30) {
            System.out.println("Uz toho bylo dost!");

        } else {
            System.out.println("Zanoruji se z hloubky " + depth + " m");
            exploration(depth + 10);

            System.out.println("Vynoruji se na hloubku " + depth + " m");
        }
    }
}
