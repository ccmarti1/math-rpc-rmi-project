import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class MathServer {
    public static void main(String[] args) {
        try {
            MathService service = new MathServiceImpl();
            Registry registry = LocateRegistry.getRegistry(); // 1099 is default RMI port
            registry.rebind("MathService", service);
            System.out.println("MathServer is running...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
