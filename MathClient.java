import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Random;

public class MathClient {
    public static void main(String[] args) {
        try {
            String serverIP = (args.length >= 1) ? args[0] : "localhost";
            Registry registry = LocateRegistry.getRegistry(serverIP, 1099);
            MathService service = (MathService) registry.lookup("MathService");

            Random random = new Random();
            for (int i = 0; i < 1000; i++) {
                int operation = random.nextInt(4);
                switch (operation) {
                    case 0:
                        service.magicAdd(random.nextDouble(), random.nextDouble());
                        break;
                    case 1:
                        service.magicSubtract(random.nextDouble(), random.nextDouble());
                        break;
                    case 2:
                        service.magicFindMin(random.nextInt(100), random.nextInt(100), random.nextInt(100));
                        break;
                    case 3:
                        service.magicFindMax(random.nextInt(100), random.nextInt(100), random.nextInt(100));
                        break;
                }
            }

            System.out.println("Client finished sending 1000 requests!");
            service.printOperationCounts();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
