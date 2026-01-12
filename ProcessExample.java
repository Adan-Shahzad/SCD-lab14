import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProcessExample {
    public static void main(String[] args) throws IOException , InterruptedException {
        long startTime = System.currentTimeMillis();

        // Set the classpath to the folder containing compiled class files
        String classpath = "C:\\Users\\Hafsa\\AppData\\Roaming\\Code\\User\\workspaceStorage\\58520445e66f1c02a4ccb4559642f310\\redhat.java\\jdt_ws\\SCD";

        // Create process builders for worker processes
        ProcessBuilder pb1 = new ProcessBuilder("java", "-cp", classpath, "WorkerProcess");
        ProcessBuilder pb2 = new ProcessBuilder("java", "-cp", classpath, "WorkerProcess");

        // Start the processes
        Process p1 = pb1.start();
        Process p2 = pb2.start();

        // Print stdout and stderr for each process
        printProcessOutput("Process 1", p1);
        printProcessOutput("Process 2", p2);

        // Wait for both processes to complete
        p1.waitFor();
        p2.waitFor();

        long endTime = System.currentTimeMillis();
        System.out.println("Total time with Processes: " + (endTime - startTime) + " ms");
    }

    private static void printProcessOutput(String processName, Process process) throws IOException {
        // Read stdout
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        System.out.println("Output of " + processName + ":");
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }

        // Read stderr
        BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
        while ((line = errorReader.readLine()) != null) {
            System.err.println(line);
        }
    }
}


