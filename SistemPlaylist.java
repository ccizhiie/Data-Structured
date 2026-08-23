import java.util.ArrayList;

// 1. Blueprint Node untuk LinkedList (Antrean Dinamis)
class NodeLagu {
    String judul;
    NodeLagu next;

    public NodeLagu(String judul) {
        this.judul = judul;
        this.next = null;
    }
}

// 2. Custom LinkedList untuk simulasi antrean "Next Track"
class AntreanLagu {
    NodeLagu head;
    NodeLagu tail;

    // Menambah lagu ke akhir antrean (Opsi: Insertion di Tail)
    public void tambahKeAntrean(String judul) {
        NodeLagu laguBaru = new NodeLagu(judul);
        if (head == null) {
            head = tail = laguBaru;
        } else {
            tail.next = laguBaru;
            tail = laguBaru;
        }
    }

    // Memutar dan menghapus lagu dari urutan pertama (Opsi: Deletion di Head)
    public String putarSelanjutnya() {
        if (head == null) return "Antrean Kosong!";
        String laguDiputar = head.judul;
        head = head.next; // Pointer bergeser, lagu pertama otomatis terhapus dari antrean
        if (head == null) tail = null;
        return laguDiputar;
    }
}

// 3. Class Utama
public class SistemPlaylist {
    public static void main(String[] args) {
        // === IMPLEMENTASI ARRAYLIST ===
        // Menyimpan daftar lagu favorit (Cocok untuk akses acak/get index)
        ArrayList<String> favorit = new ArrayList<>();
        favorit.add("What If I Call - alex ");
        favorit.add("Please Dont Call - bleachers");
        favorit.add(1, "Lagu C - Jazz"); // Menyelipkan di tengah 

        System.out.println("=== Daftar Lagu Favorit (ArrayList) ===");
        for (int i = 0; i < favorit.size(); i++) {
            System.out.println((i + 1) + ". " + favorit.get(i));
        }

        // === IMPLEMENTASI LINKEDLIST ===
        // Mengelola antrean yang butuh eksekusi dan modifikasi cepat di ujung
        AntreanLagu antrean = new AntreanLagu();
        antrean.tambahKeAntrean(favorit.get(0)); // Ambil dari favorit
        antrean.tambahKeAntrean("I Miss You"); // Lagu baru

        System.out.println("\n=== Memutar Antrean (LinkedList) ===");
        System.out.println("Now Playing : " + antrean.putarSelanjutnya());
        System.out.println("Now Playing : " + antrean.putarSelanjutnya());
        System.out.println("Status      : " + antrean.putarSelanjutnya());
    }
}
