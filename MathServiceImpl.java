import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.util.concurrent.atomic.AtomicInteger;

public class MathServiceImpl extends UnicastRemoteObject implements MathService {
    private AtomicInteger addCount = new AtomicInteger(0);
    private AtomicInteger subtractCount = new AtomicInteger(0);
    private AtomicInteger minCount = new AtomicInteger(0);
    private AtomicInteger maxCount = new AtomicInteger(0);

    protected MathServiceImpl() throws RemoteException {
        super();
    }

    public double magicAdd(double a, double b) throws RemoteException {
        addCount.incrementAndGet();
        return a + b;
    }

    public double magicSubtract(double a, double b) throws RemoteException {
        subtractCount.incrementAndGet();
        return a - b;
    }

    public int magicFindMin(int a, int b, int c) throws RemoteException {
        minCount.incrementAndGet();
        return Math.min(a, Math.min(b, c));
    }

    public int magicFindMax(int a, int b, int c) throws RemoteException {
        maxCount.incrementAndGet();
        return Math.max(a, Math.max(b, c));
    }
    
    public void printOperationCounts() throws RemoteException {
        System.out.println("=== Operation Counts ===");
        System.out.println("Add operations: " + addCount.get());
        System.out.println("Subtract operations: " + subtractCount.get());
        System.out.println("Min operations: " + minCount.get());
        System.out.println("Max operations: " + maxCount.get());
        System.out.println("=========================");
    }
    
}
