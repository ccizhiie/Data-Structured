package org.example;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import java.io.File;

public class Main {

    public static void main(String[] args) {
        String inputPdf = "putusan_1012_pid.sus_2026_pn_sby_20260928093625.pdf";
        extractPdfToJson(inputPdf);
    }

    public static void extractPdfToJson(String pdfPath) {
        try (PDDocument document = PDDocument.load(new File(pdfPath))) {

            PDFTextStripper stripper = new PDFTextStripper();
            String extractedText = stripper.getText(document);

            String watermarkKotor = "Mah\r\nka\r\nm\r\nah\r\n A\r\ngung R\r\nep\r\nublik\r\n In\r\ndones\r\nia\r\n";
            extractedText = extractedText.replace(watermarkKotor, "");
            extractedText = extractedText.replaceAll("Mah[\\r\\n\\s]*ka[\\r\\n\\s]*m[\\r\\n\\s]*ah[\\r\\n\\s]*A[\\r\\n\\s]*gung[\\r\\n\\s]*R[\\r\\n\\s]*ep[\\r\\n\\s]*ublik[\\r\\n\\s]*In[\\r\\n\\s]*dones[\\r\\n\\s]*ia", "");

            extractedText = extractedText.replace("Direktori Putusan Mahkamah Agung Republik Indonesia\nputusan.mahkamahagung.go.id\n", "");
            extractedText = extractedText.replaceAll("Disclaimer[\\s\\S]*?Email: kepaniteraan@mahkamahagung\\.go\\.id Telp: 021-384 3348 \\(ext\\.318\\)", "");

            String teksBersih = extractedText.trim();

            Parsing.parsePutusanToTXT(teksBersih);

            System.out.println("Proses ekstraksi selesai.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}