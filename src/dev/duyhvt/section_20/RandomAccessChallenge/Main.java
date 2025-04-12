package dev.duyhvt.section_20.RandomAccessChallenge;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.*;

record Employee(int employeeID, String firstName, String lastName, double salary) {}
public class Main {
    private static final Map<Integer, Long> indexedIds = new HashMap<>();

    static {
        int recordInFile = 0;
        try (RandomAccessFile ra =
                new RandomAccessFile("src/dev/duyhvt/section_20/files/employees.dat", "r")) {
            recordInFile = ra.readInt();
            System.out.println(recordInFile + " records in file");
            for (int i = 0; i < recordInFile; i++) {
                indexedIds.put(ra.readInt(), ra.readLong());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        try (RandomAccessFile ra =
                new RandomAccessFile("src/dev/duyhvt/section_20/files/employees.dat", "rw")) {
            Scanner scanner = new Scanner(System.in);
            List<Integer> ids = new ArrayList<>(indexedIds.keySet());
            Collections.sort(ids);

            while (true) {
                System.out.println(ids);
                System.out.println("Enter a student ID or 0 to exit");
                if (!scanner.hasNextInt()) break;
                int employeeID = Integer.parseInt(scanner.nextLine());
                if (employeeID < 1) break;
                if (!ids.contains(employeeID)) continue;
                Employee e = readRecord(ra, employeeID);
                System.out.println("Enter new salary, nothing if no change:");
                try {
                    double newSalary = Double.parseDouble(scanner.nextLine());
                    ra.seek(indexedIds.get(employeeID) + 4);
                    ra.writeDouble(newSalary);
                    readRecord(ra, employeeID);
                } catch (NumberFormatException nfe) {
                    // If the entered input is not a valid number, I'll ignore it.
                    //System.out.println("Invalid salary");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Employee readRecord(RandomAccessFile ra, int employeeID) throws IOException {
        ra.seek(indexedIds.get(employeeID));
        int id = ra.readInt();
        double salary = ra.readDouble();
        String first = ra.readUTF();
        String last = ra.readUTF();

        Employee e = new Employee(id, first, last, salary);
        System.out.println(e);

        return e;
    }
}
