import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MathService extends Remote {
    double magicAdd(double a, double b) throws RemoteException;
    double magicSubtract(double a, double b) throws RemoteException;
    int magicFindMin(int a, int b, int c) throws RemoteException;
    int magicFindMax(int a, int b, int c) throws RemoteException;
    void printOperationCounts() throws RemoteException;
}
