package org.example;

import java.io.FileWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parsing {

    public static void parsePutusanToTXT(String cleanText) {
        StringBuilder txtOutput = new StringBuilder();

        Matcher mNomor = Pattern.compile("Nomor\\s+([\\d]+/Pid\\.Sus/[\\d]+/PN\\s+[A-Za-z]+)").matcher(cleanText);
        txtOutput.append("Nomor Putusan: ").append(mNomor.find() ? mNomor.group(1) : "Tidak ditemukan").append("\n");

        Matcher mTingkat = Pattern.compile("(Pengadilan Negeri\\s+[A-Za-z]+)").matcher(cleanText);
        txtOutput.append("Tingkat Peradilan: ").append(mTingkat.find() ? mTingkat.group(1) : "Tidak ditemukan").append("\n");

        txtOutput.append("Klasifikasi Perkara: ").append(cleanText.contains("Pid.Sus") ? "Pidana Khusus" : "Lainnya").append("\n");

        Matcher mNama = Pattern.compile("Nama lengkap[\\s\\S]*?:\\s*([A-Za-z\\s]+)(?:Bin|Binti)").matcher(cleanText);
        txtOutput.append("Nama Terdakwa: ").append(mNama.find() ? mNama.group(1).trim() : "Tidak ditemukan").append("\n");

        Matcher mTanggal = Pattern.compile("tanggal\\s*([0-9]+\\s+[a-zA-Z]+\\s+[0-9]{4})").matcher(cleanText);
        txtOutput.append("Tanggal Putusan: ").append(mTanggal.find() ? mTanggal.group(1).trim() : "Tidak ditemukan").append("\n\n");

        txtOutput.append("=== DAKWAAN ===\n");
        txtOutput.append(extractBlock(cleanText, "dakwaan sebagai berikut\\s*:", "untuk membuktikan dakwaannya")).append("\n\n");

        txtOutput.append("=== KRONOLOGI ===\n");
        txtOutput.append(extractBlock(cleanText, "fakta hukum sebagai berikut\\s*:", "Majelis Hakim akan mempertimbangkan")).append("\n\n");

        try (FileWriter writer = new FileWriter("hasil_seleksi.txt")) {
            // Konversi \n menjadi \r\n agar format ganti baris dirender rapi oleh Windows Notepad
            writer.write(txtOutput.toString().replace("\n", "\r\n"));
            System.out.println("Berhasil membuat dan menulis ke file hasil_seleksi.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String extractBlock(String text, String startRegex, String endRegex) {
        String regex = "(?i)(?s)" + startRegex + "(.*?)" + endRegex;
        Matcher matcher = Pattern.compile(regex).matcher(text);

        if (matcher.find()) {
            return matcher.group(1).trim();
        }
        return " narasi tidak ditemukan.";
    }
}