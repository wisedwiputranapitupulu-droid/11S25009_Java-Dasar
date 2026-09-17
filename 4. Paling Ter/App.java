import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> nilaiList = new ArrayList<>();

        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.equals("---")) break;
            if (line.isEmpty()) continue;
            nilaiList.add(Integer.parseInt(line));
        }

        if (nilaiList.isEmpty()) {
            return;
        }

        Map<Integer, Integer> freq = new HashMap<>();
        for (int v : nilaiList) freq.put(v, freq.getOrDefault(v, 0) + 1);

        int tertinggi = nilaiList.get(0), terendah = nilaiList.get(0);
        for (int v : nilaiList) {
            if (v > tertinggi) tertinggi = v;
            if (v < terendah) terendah = v;
        }

        Integer terbanyak = null, tersedikit = null;
        for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
            int nilai = e.getKey(), f = e.getValue();
            if (terbanyak == null || f > freq.get(terbanyak) || (f == freq.get(terbanyak) && nilai > terbanyak)) terbanyak = nilai;
            if (tersedikit == null || f < freq.get(tersedikit) || (f == freq.get(tersedikit) && nilai < tersedikit)) tersedikit = nilai;
        }

        Integer jTinggi = null, jRendah = null;
        for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
            int nilai = e.getKey();
            int hasil = nilai * e.getValue();
            if (jTinggi == null) jTinggi = nilai;
            else {
                int hasilLama = jTinggi * freq.get(jTinggi);
                if (hasil > hasilLama || (hasil == hasilLama && nilai > jTinggi)) jTinggi = nilai;
            }
            if (jRendah == null) jRendah = nilai;
            else {
                int hasilLama = jRendah * freq.get(jRendah);
                if (hasil < hasilLama || (hasil == hasilLama && nilai < jRendah)) jRendah = nilai;
            }
        }

        System.out.println("Tertinggi: " + tertinggi);
        System.out.println("Terendah: " + terendah);
        System.out.println("Terbanyak: " + terbanyak + " (" + freq.get(terbanyak) + "x)");
        System.out.println("Tersedikit: " + tersedikit + " (" + freq.get(tersedikit) + "x)");
        System.out.println("Jumlah Tertinggi: " + jTinggi + " * " + freq.get(jTinggi) + " = " + (jTinggi * freq.get(jTinggi)));
        System.out.println("Jumlah Terendah: " + jRendah + " * " + freq.get(jRendah) + " = " + (jRendah * freq.get(jRendah)));
    }
}
