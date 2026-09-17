import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine().trim());
        int[][] matrix = new int[n][n];

        // Input matrix
        for (int i = 0; i < n; i++) {
            String[] tokens = sc.nextLine().trim().split("\\s+");

            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(tokens[j]);
            }
        }

        // Jika matrix 1 x 1
        if (n == 1) {
            System.out.println("Nilai L: Tidak Ada");
            System.out.println("Nilai Kebalikan L: Tidak Ada");
            System.out.println("Nilai Tengah: " + matrix[0][0]);
            System.out.println("Perbedaan: Tidak Ada");
            System.out.println("Dominan: " + matrix[0][0]);
            return;
        }

        // Jika matrix 2 x 2
        if (n == 2) {
            int total = matrix[0][0] + matrix[0][1]
                      + matrix[1][0] + matrix[1][1];

            System.out.println("Nilai L: Tidak Ada");
            System.out.println("Nilai Kebalikan L: Tidak Ada");
            System.out.println("Nilai Tengah: " + total);
            System.out.println("Perbedaan: Tidak Ada");
            System.out.println("Dominan: " + total);
            return;
        }

        // Menghitung Nilai L
        int nilaiL = 0;

        for (int i = 0; i < n; i++) {
            nilaiL += matrix[i][0];
        }

        for (int j = 1; j <= n - 2; j++) {
            nilaiL += matrix[n - 1][j];
        }

        // Menghitung Nilai Kebalikan L
        int nilaiKebalikanL = 0;

        for (int i = 0; i < n; i++) {
            nilaiKebalikanL += matrix[i][n - 1];
        }

        for (int j = 1; j <= n - 2; j++) {
            nilaiKebalikanL += matrix[0][j];
        }

        // Menghitung Nilai Tengah
        int nilaiTengah;

        if (n % 2 == 1) {
            // Matrix ganjil
            nilaiTengah = matrix[n / 2][n / 2];

        } else {
            // Matrix genap
            int mid = n / 2;

            nilaiTengah = matrix[mid - 1][mid - 1]
                        + matrix[mid - 1][mid]
                        + matrix[mid][mid - 1]
                        + matrix[mid][mid];
        }

        // Menghitung perbedaan
        int perbedaan = Math.abs(nilaiL - nilaiKebalikanL);

        // Menentukan nilai dominan
        int dominan;

        if (perbedaan == 0) {
            dominan = nilaiTengah;
        } else {
            dominan = Math.max(nilaiL, nilaiKebalikanL);
        }

        // Output
        System.out.println("Nilai L: " + nilaiL);
        System.out.println("Nilai Kebalikan L: " + nilaiKebalikanL);
        System.out.println("Nilai Tengah: " + nilaiTengah);
        System.out.println("Perbedaan: " + perbedaan);
        System.out.println("Dominan: " + dominan);
    }
}