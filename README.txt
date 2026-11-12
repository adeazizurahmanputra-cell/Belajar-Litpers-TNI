BELAJAR LITPERS TNI — PROYEK ANDROID STUDIO
===========================================

Isi:
- Materi dasar Litpers dalam 11 bab
- Kuis pilihan ganda dengan pembahasan
- Latihan wawancara dengan penyimpanan jawaban lokal
- Penanda bab selesai dan progres belajar
- Tidak memakai izin internet; konten tersedia di dalam aplikasi

CARA MEMBUAT APK:
1. Ekstrak ZIP ini di komputer.
2. Pasang Android Studio versi stabil dan Android SDK Platform 35.
3. Buka Android Studio > Open, pilih folder BelajarLitpersTNI.
4. Tunggu Gradle Sync selesai. Saat proses build pertama, Android Studio mungkin perlu internet untuk mengunduh Gradle dan plugin.
5. Pilih Build > Build Bundle(s) / APK(s) > Build APK(s).
6. Setelah selesai, klik "locate" pada notifikasi untuk menemukan app-debug.apk.
7. Pindahkan APK ke HP Android dan pasang. Izinkan pemasangan dari sumber tersebut jika Android meminta.
8. Setelah terpasang, aplikasi dapat digunakan tanpa internet.

PERSYARATAN:
- Android Studio
- JDK 17 (Android Studio biasanya menyediakan JBR)
- Android SDK Platform 35
- Gradle plugin 8.6.1 dan Kotlin plugin 2.0.21 akan diunduh saat sinkronisasi pertama.

CATATAN:
Ini proyek contoh aplikasi belajar umum, bukan aplikasi resmi TNI dan bukan kisi-kisi resmi seleksi. Periksa informasi terkini melalui sumber resmi. Jawablah wawancara dengan jujur; jangan mengarang informasi pribadi.


BUILD APK DARI HP TANPA KOMPUTER (GITHUB ACTIONS):
1. Buat akun atau masuk ke github.com lewat browser HP.
2. Buat repository baru, misalnya bernama BelajarLitpersTNI. Pilih Public atau Private.
3. Ekstrak ZIP proyek di HP jika aplikasi pengelola file mendukung ZIP.
4. Unggah semua isi folder proyek ke repository GitHub, termasuk folder tersembunyi .github/workflows/build-apk.yml. Pastikan file workflow ikut terunggah.
5. Buka tab Actions pada repository. Pilih workflow "Build APK Offline Litpers", lalu tekan Run workflow.
6. Tunggu sampai workflow selesai dengan tanda hijau.
7. Buka hasil run, cari bagian Artifacts, lalu unduh "Belajar-Litpers-TNI-APK".
8. Ekstrak ZIP artifact, lalu pasang app-debug.apk di HP.

Catatan: Proses cloud build memerlukan internet dan akun GitHub. Setelah APK terpasang, fitur materi, kuis, dan jawaban tersimpan berjalan offline.
