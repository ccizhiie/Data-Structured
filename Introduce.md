 # Apa itu struktur data?
struktur data adalah cara untuk mengatur dan menyimpan data yang fleksibel dan aman untuk semua tipe data secara efisien dengan tujuan dapat diakses dan dimodif dg efektif. contoh beberapa komponen struktur data adalah array, linked list, stack, queue, tree, dan graph.

# Analogi Struktur Data
generics sebagai kotak dengan label kosong yang dapat diisi dengan semua jenis barang,label ditulis saat kotak akan digunakan, sehingga penjaga bisa menolak jika barang tidak sesuai dengan label yg ditentukan.

## 1. Generics </T>
 adalah parameter tipedata umum yang digunakan untuk membuat class, method, dan struktur data yang dapat bekerja dengan berbagai tipe data tanpa harus menulis kode yang berbeda untuk setiap tipe data.

 dengan Generics, satu class dapat digunakan ulang untuk menyimpan berbagai macam tipe data tanpa perlu menulis kode duplikat atau memaksa penggunaan tipe data Object secara primitif

## 2. Wildcard <?>
 adalah simbol yang digunakan dalam generics untuk mewakili tipe data yang tidak diketahui. sifatnya read-only, artinya kita dapat membaca data dari struktur data tersebut, dilarangu untuk menambah data baru.

> gambaran flow struktur data generics:

[ Wadah: Box<String> ]
       |
       +--> Input : Masukkan "Buku" (String) -> Diterima.
       |
       +--> Input : Masukkan Angka 100 -> DITOLAK COMPILER (Red Squiggle). *ditolak karna label box string tidak bisa diisi angka
       |
       +--> Output: Langsung diambil sebagai String. Bebas Casting.
       |
       +--> HASIL : Aman, siap diproses.

## 3. Enumerated
  adalah tipe data khusus sekumpulan konstanta(tetap) untuk memastikan nilai var tidak melenceng dari pilihan yg ada.
  Enumerated sering digunakan untuk merepresentasikan status, kategori, atau pilihan terbatas dalam program.
  Fungsi <T> (Generics): Membangun struktur data yang fleksibel saat diciptakan, tapi ketat saat digunakan (misal: mendesain lemari khusus baju).
  Fungsi <?> (Wildcard): Membuat method baca yang sangat luas cakupannya (misal: menugaskan inspektur yang bebas mengecek semua lemari di gudang, entah itu lemari baju atau lemari sepatu).


## 4. Arraylist
  array dinamis yg ukurannya bisa berubah sesuai kebutuhan, dengan membuat array baru dan menyalin data lama. dan data disimpan secara berurutan, arraylist dapat menampung berbagai tipe data.
  arraylist memiliki kelebihan dalam hal akses data yang cepat, namun memiliki kelemahan dalam hal penambahan dan penghapusan data di tengah-tengah arraylist karena memerlukan shifting atau penggeseran elemen setelahnya.

| method | Desc |
| :--- | :--- |
| add() | menambahkan data ke akhir arraylist |
| add(index, data) | Menyelipkan data di posisi tengah, yang memaksa data di sebelah kanannya bergeser |
| get(index) | Mengambil data dari posisi tertentu |
| set(index, data) | Mengubah data lama dengan data baru di posisi yang sama persis tanpa menggeser posisi lainnya |
| remove(index) | Menghapus data di posisi tertentu, yang memaksa data di sebelah kanannya bergeser ke kiri |
| size() | Menghitung jumlah data yang tersimpan di arraylist |
| isEmpty() | Mengecek apakah arraylist kosong atau tidak |
| clear() | Menghapus semua data di arraylist |




## 5. LinkedList
  linkedlist adalah data yang terdiri dari node yang saling terhubung, dimana setiap node menyimpan data dan referensi ke node berikutnya. linkedlist dapat menampung berbagai tipe data.
  linkedlist memiliki kelebihan dalam hal tambah dan hapus data ditengah" linkedlist karna hanya perlu mengubah node referensi, namun memiliki kelemahan dalam hal akses data yang lebih lambat dibandingkan arraylist karena harus menelusuri node satu per satu dari awal (HEAD) hingga node yang diinginkan.
  linkedlist memiliki kelebihan dalam hal penambahan dan penghapusan data di tengah-tengah linkedlist karena hanya perlu mengubah referensi node, namun memiliki kelemahan dalam hal akses data yang lebih lambat dibandingkan arraylist karena harus menelusuri node satu per satu.

-------------------------------------------------------------------------------------------------------------------------------------------------------
> ARRAYLIST (ambil cpu 1)
[Sebelum]  | CPU_1 | CPU_2 | CPU_3 | (kosong) |
[Proses]             >>> Geser CPU_2 dan CPU_3 ke kanan >>>
[Sesudah]  | CPU_1 | INT_A | CPU_2 | CPU_3    |
# Kesimpulan: Membutuhkan komputasi ekstra untuk pergeseran (shifting).

>  LINKED LIST ( Menyisipkan Data di Tengah)
[Sebelum]  [CPU_1 | Pointer] ---> [CPU_2 | Pointer] ---> NULL

[Proses]   1. Putus koneksi dari CPU_1 ke CPU_2.
           2. Arahkan Pointer CPU_1 ke INT_A.
           3. Arahkan Pointer INT_A ke CPU_2.

[Sesudah]  [CPU_1 | Pointer] ---> [INT_A | Pointer] ---> [CPU_2 | Pointer] ---> NULL
# Kesimpulan: Nol pergeseran memori. Hanya relokasi arah alamat (pointer) `
