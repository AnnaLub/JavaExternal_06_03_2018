import java.util.concurrent.Semaphore;

public class AvailablePaydesk {
    private static boolean [] AVAILABLE_PAYDESK = new boolean[7];
    private static final Semaphore SEMAPHORE = new Semaphore(7,true);

    public static void setAvailablePaydesk(int i, boolean flag) {
        AVAILABLE_PAYDESK[i] = flag;
    }

    public static Semaphore getSEMAPHORE() {
        return SEMAPHORE;
    }

    public static boolean getAvailablePaydesk(int i) {
        return AVAILABLE_PAYDESK[i];
    }


    public static boolean[] getAvailablePaydesk() {
        return AVAILABLE_PAYDESK;
    }
}
