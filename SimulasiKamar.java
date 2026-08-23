// 1. Enum: Membatasi pilihan rak agar tidak ada input asal-asalan (tanpa modifier public)
enum JenisRak {
    GANTUNG, LIPAT, LACI
}

// 2. Generic Class: Cetakan lemari. Huruf <T> adalah label kosong.
class Lemari<T> {
    private T barang;
    private JenisRak rak;

    public Lemari(T barang, JenisRak rak) {
        this.barang = barang;
        this.rak = rak;
    }

    public T getBarang() { return barang; }
    public JenisRak getRak() { return rak; }
}

// 3. Class Utama
public class SimulasiKamar {

    // Generic Method
    public static <E> void sebutkanIsi(E[] daftar) {
        for (E item : daftar) {
            System.out.println("- " + item);
        }
    }

    // Wildcard <?>
    public static void cekLemari(Lemari<?> lemari) {
        System.out.println("Isi Lemari : " + lemari.getBarang());
        System.out.println("Lokasi Rak : " + lemari.getRak());
        System.out.println("-------------------------");
    }

    public static void main(String[] args) {
        // Pembuatan Objek 1: <String>
        Lemari<String> lemariBaju = new Lemari<>("Kemeja Flanel", JenisRak.GANTUNG);

        // Pembuatan Objek 2: <Integer>
        Lemari<Integer> lemariSepatu = new Lemari<>(5, JenisRak.LACI);

        System.out.println("=== Inspeksi Lemari ===");
        cekLemari(lemariBaju);
        cekLemari(lemariSepatu);

        System.out.println("=== Daftar Bawaan Tambahan ===");
        String[] aksesoris = {"Topi", "Sabuk", "Jam Tangan"};
        sebutkanIsi(aksesoris);
    }
}
