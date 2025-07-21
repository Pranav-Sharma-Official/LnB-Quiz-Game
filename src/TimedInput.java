import java.util.Scanner;
import java.util.concurrent.*;

public class TimedInput {
    public static String readLineWithTimeout(int timeoutSeconds) throws TimeoutException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<String> future = executor.submit(() -> {
            Scanner scanner = new Scanner(System.in);
            return scanner.nextLine();
        });

        try {
            return future.get(timeoutSeconds, TimeUnit.SECONDS);
        } catch (TimeoutException e) {
            future.cancel(true);
            throw new TimeoutException("⏳ Time's up!");
        } catch (Exception e) {
            future.cancel(true);
            throw new RuntimeException(e);
        } finally {
            executor.shutdownNow();
        }
    }
}