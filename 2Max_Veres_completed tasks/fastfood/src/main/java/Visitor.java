import java.util.concurrent.Semaphore;

public class Visitor implements Runnable{
    private int visitorNumber;

    public Visitor(int visitorNumber) {
        this.visitorNumber = visitorNumber;
    }

    @Override
    public void run() {
        System.out.println("Visitor # " + visitorNumber + " entered McDonald's");
        try
        {
        AvailablePaydesk.getSEMAPHORE().acquire();
        int availablePaydesk = -1;
        int threadPause = -1;
            for (int i = 0; i < 7; i++)
                if (!AvailablePaydesk.getAvailablePaydesk(i)) {
                AvailablePaydesk.setAvailablePaydesk(i, true);
                availablePaydesk = i;
                threadPause = i;
                System.out.println("Paydesk # " + availablePaydesk + " accepted order from Visitor # " + visitorNumber);
                break;
                }
                if(threadPause%2!=0||threadPause==0){
                Thread.sleep(4000);
                }
                else {
                Thread.sleep(5100);
                }
                AvailablePaydesk.setAvailablePaydesk(availablePaydesk, false);
                AvailablePaydesk.getSEMAPHORE().release();
                System.out.println("Visitor # " + visitorNumber + " finished his order");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
