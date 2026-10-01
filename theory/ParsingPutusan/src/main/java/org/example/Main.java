package org.example;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import com.google.gson.JsonObject;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.io.FileWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        String inputPdf = "putusan_1012_pid.sus_2026_pn_sby_20260928093625.pdf";
        String outputJson = "hasil_seleksi.json";

        extractPdfToJson(inputPdf, outputJson);
    }


    public static void extractPdfToJson(String pdfPath, String jsonPath) {
        try (PDDocument document = PDDocument.load(new File(pdfPath))) {

                                                                    // extract semua text pdf
            PDFTextStripper stripper = new PDFTextStripper();
            String extractedText = stripper.getText(document);
            String watermarkKotor = "Mah\r\nka\r\nm\r\nah\r\n A\r\ngung R\r\nep\r\nublik\r\n In\r\ndones\r\nia\r\n";
            extractedText = extractedText.replace(watermarkKotor, "");
            extractedText = extractedText.replaceAll("Mah[\\r\\n\\s]*ka[\\r\\n\\s]*m[\\r\\n\\s]*ah[\\r\\n\\s]*A[\\r\\n\\s]*gung[\\r\\n\\s]*R[\\r\\n\\s]*ep[\\r\\n\\s]*ublik[\\r\\n\\s]*In[\\r\\n\\s]*dones[\\r\\n\\s]*ia", "");

            extractedText = extractedText.replace("Direktori Putusan Mahkamah Agung Republik Indonesia\nputusan.mahkamahagung.go.id\n", ""); // hapus watermark dari footer dan header pd file
            extractedText = extractedText.replaceAll("Disclaimer[\\s\\S]*?Email: kepaniteraan@mahkamahagung\\.go\\.id Telp: 021-384 3348 \\(ext\\.318\\)", "");
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("isi_putusan", extractedText.trim());
            jsonObject.addProperty("isi_putusan", extractedText);
            Gson gson = new GsonBuilder().setPrettyPrinting().create();        // tulis json ke file
            try (FileWriter writer = new FileWriter(jsonPath)) {
                gson.toJson(jsonObject, writer);
            }

            System.out.println("extract json berhasil.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}