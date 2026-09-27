 # Apa itu struktur data?
struktur data adalah cara untuk mengatur dan menyimpan data yang fleksibel dan aman untuk semua tipe data secara efisien dengan tujuan dapat diakses dan dimodif dg efektif. contoh beberapa komponen struktur data adalah array, linked list, stack, queue, tree, dan graph.

# Analogi Struktur Data
generics sebagai kotak dengan label kosong yang dapat diisi dengan semua jenis barang,label ditulis saat kotak akan digunakan, sehingga penjaga bisa menolak jika barang tidak sesuai dengan label yg ditentukan.

## 1. Generics </T>
 adalah parameter tipedata umum yang digunakan untuk membuat class, method, dan struktur data yang dapat bekerja dengan berbagai tipe data tanpa harus menulis kode yang berbeda untuk setiap tipe data.
 ## Parameter Generics
 - E: Element, digunakan untuk koleksi elemen (misal: ArrayList, LinkedList)
 - K: Key, digunakan untuk pasangan key-value (misal: Map)
 - V: Value, digunakan untuk pasangan key-value (misal: Map)
  - N: Number, digunakan untuk tipe data numerik (misal: Integer, Double)
- T: Type, digunakan untuk tipe data umum (misal: Tipe data apa saja)

 dengan Generics, satu class dapat digunakan ulang untuk menyimpan berbagai macam tipe data tanpa perlu menulis kode duplikat atau memaksa penggunaan tipe data Object secara primitif

## 2. Wildcard <?>
 adalah simbol yang digunakan dalam generics untuk mewakili tipe data yang tidak diketahui. sifatnya read-only, artinya kita dapat membaca data dari struktur data tersebut, dilarangu untuk menambah data baru.




## 3. Enumerated
  adalah tipe data khusus sekumpulan konstanta(tetap) untuk memastikan nilai var tidak melenceng dari pilihan yg ada.
  Enumerated sering digunakan untuk merepresentasikan status, kategori, atau pilihan terbatas dalam program.
  > Fungsi <T> (Generics): Membangun struktur data yang fleksibel saat diciptakan, tapi ketat saat digunakan (misal: mendesain lemari khusus baju).
  > Fungsi <?> (Wildcard): Membuat method baca yang sangat luas cakupannya (misal: menugaskan inspektur yang bebas mengecek semua lemari di gudang, entah itu lemari baju atau lemari sepatu).


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
### Struktur LinkedList
| Struct | Desc |
| :--- | :--- |
| Node | Blok fundamental (satu gerbong) yang terdiri dari 2 hal: Data dan Pointer.|
| Data | Nilai yang disimpan dalam node, bisa berupa tipe data apapun.|
| Next | Pointer yang mengarah ke node berikutnya dalam linkedlist.|
|Previous | Pointer yang mengarah ke node sebelumnya dalam linkedlist (hanya ada di doubly linkedlist).|
| Pointer | Alamat referensi yang bertugas merantai satu node ke node lainnya agar tetap terhubung meski memori fisiknya terpencar.|
| Head | Node pertama dalam linkedlist, menjadi titik awal untuk menelusuri seluruh node.|
| Tail | Node terakhir dalam linkedlist, menjadi titik akhir dari linkedlist, biasanya menunjuk ke NULL.|
### important linkedlist operations
| method | Desc |
| :--- | :--- |
| Insertion | Proses menambahkan node baru (bisa di awal/Head, tengah, atau akhir/Tail).|
| Deletion | Menghapus node dari linkedlist, bisa di awal, akhir, atau posisi tertentu.|
| Traversal | Proses mengunjungi setiap node satu per satu, yang wajib dimulai dari Head berlanjut terus mengikuti pointer hingga node terakhir.|
| Searching | Proses mencari data tertentu dengan melakukan traversal secara linier dari awal rantai sampai datanya ditemukan.|
| Updating | Mengubah data di dalam sebuah node tanpa mengubah struktur rantainya. Proses ini mengharuskan kita melakukan traversal dahulu untuk menemukan target, baru nilainya diubah.|
| Count Nodes | Menghitung jumlah node yang ada dalam linkedlist dengan melakukan traversal dari Head hingga Tail.|
## 6. Stack
  stack adalah struktur data yang mengikuti prinsip LIFO (Last In First Out), artinya elemen terakhir yang ditambahkan akan menjadi elemen pertama yang dihapus. stack dapat diimplementasikan menggunakan array atau linkedlist.=
  > contoh penggunaan adalah fitur undo pada aplikasi, dimana aksi terakhir yang dilakukan akan dibatalkan terlebih dahulu.
