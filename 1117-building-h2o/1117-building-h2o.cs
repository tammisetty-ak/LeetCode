using System.Threading;

public class H2O {
    private int counter;
    private Semaphore hydrogen;
    private Semaphore oxygen;

    public H2O() {
        counter = 0;
        hydrogen = new Semaphore(1, 1);
        oxygen = new Semaphore(0, 1);
    }

    public void Hydrogen(Action releaseHydrogen) {
        hydrogen.WaitOne();
        counter++;
        releaseHydrogen();
        if(counter % 2 == 0)
            oxygen.Release();
        else
            hydrogen.Release();
    }

    public void Oxygen(Action releaseOxygen) {
        oxygen.WaitOne();
		releaseOxygen();
        hydrogen.Release();
    }
}