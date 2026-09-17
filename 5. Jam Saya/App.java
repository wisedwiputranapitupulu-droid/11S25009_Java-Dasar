import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String jamAwalStr = sc.nextLine().trim();

        String[] parts = jamAwalStr.split(":");
        if (parts.length != 2) {
            System.out.println("Jam tidak valid");
            return;
        }

        int jam, menit;
        try {
            jam = Integer.parseInt(parts[0].trim());
            menit = Integer.parseInt(parts[1].trim());
        } catch (NumberFormatException e) {
            System.out.println("Jam tidak valid");
            return;
        }

        if (jam < 0 || jam > 23 || menit < 0 || menit > 59) {
            System.out.println("Jam tidak valid");
            return;
        }

        int totalMenit = jam * 60 + menit;
        int totalGeser = 0;
        int pergantianHari = 0;

        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.equals("---")) break;
            if (line.isEmpty()) continue;

            if (line.length() < 2 || (line.charAt(0) != '+' && line.charAt(0) != '-')) {
                System.out.println("Perintah tidak valid");
                continue;
            }

            int n;
            try {
                n = Integer.parseInt(line.substring(1));
                if (line.charAt(0) == '-') n = -n;
            } catch (NumberFormatException e) {
                System.out.println("Perintah tidak valid");
                continue;
            }

            totalMenit += n;
            totalGeser += n;

            while (totalMenit >= 1440) { totalMenit -= 1440; pergantianHari++; }
            while (totalMenit < 0)     { totalMenit += 1440; pergantianHari++; }
        }

        int jamAkhir = totalMenit / 60;
        int menitAkhir = totalMenit % 60;

        String totalMenitStr = (totalGeser > 0) ? ("+" + totalGeser) : String.valueOf(totalGeser);

        System.out.printf("Jam Awal: %02d:%02d%n", jam, menit);
        System.out.printf("Jam Akhir: %02d:%02d%n", jamAkhir, menitAkhir);
        System.out.println("Total Menit: " + totalMenitStr);
        System.out.println("Pergantian Hari: " + pergantianHari);
    }
}
