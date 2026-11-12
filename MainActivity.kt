package id.openai.belajarlitpers

import android.app.Activity
import android.os.Bundle
import android.graphics.Typeface
import android.graphics.Color
import android.view.Gravity
import android.view.View
import android.widget.*
import android.content.Context

class MainActivity : Activity() {
    private lateinit var root: LinearLayout
    private val prefs by lazy { getSharedPreferences("litpers_progress", Context.MODE_PRIVATE) }

    data class Chapter(val title: String, val body: String, val questions: List<String>)

    private val chapters = listOf(
        Chapter("1. Memahami Litpers",
            "Litpers adalah singkatan dari penelitian personel. Dalam konteks seleksi, pemeriksaan personel dapat menjadi bagian proses untuk mengenal calon prajurit melalui identitas, riwayat hidup, lingkungan, sikap, serta konsistensi keterangan yang diberikan.\\n\\nPersiapkan identitas, riwayat pendidikan, informasi keluarga, kegiatan sehari-hari, wawasan kebangsaan, motivasi, dan kesiapan menjalankan tanggung jawab.\\n\\nPrinsip utama: jujur, konsisten, tenang, dan bertanggung jawab. Jangan mengarang atau menghafalkan jawaban yang tidak sesuai keadaan sebenarnya.",
            listOf("Apa yang kamu pahami tentang Litpers?", "Mengapa kejujuran penting dalam wawancara?")),
        Chapter("2. Pancasila",
            "Pancasila adalah dasar negara dan ideologi bangsa Indonesia. Lima sila Pancasila:\\n\\n1. Ketuhanan Yang Maha Esa.\\n2. Kemanusiaan yang adil dan beradab.\\n3. Persatuan Indonesia.\\n4. Kerakyatan yang dipimpin oleh hikmat kebijaksanaan dalam permusyawaratan/perwakilan.\\n5. Keadilan sosial bagi seluruh rakyat Indonesia.\\n\\nContoh penerapan: menghormati ibadah, memperlakukan sesama secara manusiawi, menjaga persatuan, bermusyawarah, dan bersikap adil.",
            listOf("Sebutkan lima sila Pancasila secara berurutan.", "Berikan contoh penerapan sila ketiga.")),
        Chapter("3. UUD 1945",
            "Undang-Undang Dasar Negara Republik Indonesia Tahun 1945 adalah hukum dasar tertulis negara Indonesia. UUD 1945 disahkan pada 18 Agustus 1945 oleh PPKI.\\n\\nUUD menjadi landasan penyelenggaraan negara, mengatur lembaga dan kewenangan negara, serta memuat hak dan kewajiban warga negara. UUD 1945 mengalami empat tahap perubahan pada 1999, 2000, 2001, dan 2002.",
            listOf("Kapan UUD 1945 disahkan?", "Siapa yang mengesahkan UUD 1945?", "Apa fungsi UUD 1945?")),
        Chapter("4. NKRI dan Wawasan Kebangsaan",
            "NKRI adalah Negara Kesatuan Republik Indonesia. Bentuk negara kesatuan berarti Indonesia merupakan satu negara dengan kedaulatan nasional yang satu.\\n\\nBhinneka Tunggal Ika berarti berbeda-beda tetapi tetap satu. Keberagaman suku, agama, bahasa, dan budaya harus dirawat dalam persatuan.\\n\\nCara menjaga persatuan: menghargai perbedaan, tidak menyebarkan hoaks, berdialog saat terjadi perselisihan, dan ikut menjaga kerukunan.",
            listOf("Apa arti NKRI?", "Apa makna Bhinneka Tunggal Ika?", "Bagaimana cara menjaga persatuan?")),
        Chapter("5. Sejarah Kemerdekaan",
            "Tanggal penting:\\n\\n1 Juni 1945: Soekarno menyampaikan pidato tentang dasar negara dalam sidang BPUPKI.\\n22 Juni 1945: Panitia Sembilan menyepakati Piagam Jakarta.\\n17 Agustus 1945: Proklamasi Kemerdekaan Indonesia.\\n18 Agustus 1945: PPKI mengesahkan UUD 1945 serta menetapkan Presiden dan Wakil Presiden.\\n10 November: diperingati sebagai Hari Pahlawan.\\n\\nIr. Soekarno dan Drs. Mohammad Hatta dikenal sebagai proklamator. Jenderal Sudirman adalah Panglima Besar TNI pertama.",
            listOf("Kapan Indonesia memproklamasikan kemerdekaan?", "Siapa proklamator Indonesia?", "Siapa Panglima Besar TNI pertama?")),
        Chapter("6. TNI dan Tugas Pokok",
            "TNI adalah Tentara Nasional Indonesia. TNI terdiri dari tiga matra:\\n\\n• TNI AD: pertahanan matra darat.\\n• TNI AL: pertahanan matra laut.\\n• TNI AU: pertahanan matra udara.\\n\\nSecara umum, tugas pokok TNI adalah menegakkan kedaulatan negara, mempertahankan keutuhan wilayah NKRI berdasarkan Pancasila dan UUD 1945, serta melindungi segenap bangsa dan seluruh tumpah darah Indonesia dari ancaman dan gangguan. Pelaksanaan tugas diatur oleh peraturan perundang-undangan.",
            listOf("Apa kepanjangan TNI?", "Sebutkan tiga matra TNI.", "Apa tugas pokok TNI?")),
        Chapter("7. Kepribadian dan Etika",
            "Sikap yang perlu dibangun: disiplin, jujur, tanggung jawab, kerja sama, pengendalian diri, dan menghormati orang lain.\\n\\nDisiplin berarti menaati aturan dan mengelola waktu. Jujur berarti menyampaikan fakta. Tanggung jawab berarti menyelesaikan tugas dan berani mengakui kesalahan.\\n\\nSaat ditanya kekurangan diri, sampaikan hal yang benar-benar kamu miliki dan jelaskan usaha nyata untuk memperbaikinya.",
            listOf("Apa arti disiplin menurut kamu?", "Bagaimana kamu menerima kritik?", "Apa yang kamu lakukan ketika melakukan kesalahan?")),
        Chapter("8. Riwayat Diri, Keluarga, dan Motivasi",
            "Siapkan cerita singkat dan runtut tentang identitas, pendidikan, kegiatan sehari-hari, pengalaman bekerja sama, dan informasi keluarga yang relevan. Jawab pertanyaan tentang keluarga berdasarkan fakta.\\n\\nUntuk menjelaskan motivasi, uraikan alasan pribadi secara jujur, pemahaman terhadap tanggung jawab prajurit, dan usaha nyata dalam mempersiapkan diri. Jangan hanya menghafalkan contoh jawaban.",
            listOf("Ceritakan riwayat pendidikanmu.", "Apa alasanmu ingin menjadi prajurit TNI?", "Apa kegiatanmu sehari-hari?")),
        Chapter("9. Isu Aktual dan Informasi",
            "Perkembangan pejabat dan isu nasional dapat berubah. Periksa informasi melalui sumber primer atau situs resmi lembaga terkait, perhatikan tanggal berita, bandingkan beberapa sumber tepercaya, dan bedakan fakta dari opini.\\n\\nJangan menyebarkan informasi yang belum jelas kebenarannya. Pelajari nama pejabat negara dan pimpinan TNI terbaru menjelang seleksi melalui sumber resmi.",
            listOf("Mengapa berita perlu diperiksa sebelum dibagikan?", "Apa perbedaan fakta dan opini?", "Di mana mencari informasi pejabat terbaru?")),
        Chapter("10. Teknik Menjawab Wawancara",
            "Dengarkan pertanyaan sampai selesai. Jawab inti pertanyaan terlebih dahulu, lalu tambahkan alasan atau contoh singkat jika diperlukan. Gunakan bahasa sopan dan jelas.\\n\\nJika belum mengetahui jawaban, sampaikan dengan jujur bahwa kamu belum mengetahuinya dan bersedia mempelajarinya. Jangan berdebat, mengarang, atau memberi jawaban terlalu panjang.",
            listOf("Bagaimana sikapmu saat mendapat pertanyaan sulit?", "Apa yang kamu lakukan jika tidak tahu jawaban?")),
        Chapter("11. Evaluasi dan Rencana Belajar",
            "Rencana belajar 7 hari:\\n\\nHari 1: Litpers dan riwayat diri.\\nHari 2: Pancasila.\\nHari 3: UUD 1945.\\nHari 4: NKRI dan sejarah.\\nHari 5: Tugas TNI.\\nHari 6: Kepribadian dan motivasi.\\nHari 7: Simulasi wawancara.\\n\\nSetelah membaca, tutup materi dan jelaskan kembali dengan kata-katamu sendiri. Catat materi yang belum dipahami dan periksa fakta dari sumber resmi."
            , listOf("Materi apa yang paling perlu kamu ulang?", "Bagaimana cara belajar agar tidak hanya menghafal?"))
    )

    private data class Quiz(val question: String, val options: List<String>, val answer: Int, val explanation: String)
    private val quizzes = listOf(
        Quiz("Apa kepanjangan NKRI?", listOf("Negara Kesatuan Republik Indonesia", "Negara Kedaulatan Rakyat Indonesia", "Nasional Kesatuan Republik Indonesia", "Negara Kerajaan Republik Indonesia"), 0, "NKRI adalah Negara Kesatuan Republik Indonesia."),
        Quiz("UUD 1945 disahkan pada tanggal...", listOf("17 Agustus 1945", "18 Agustus 1945", "1 Juni 1945", "10 November 1945"), 1, "PPKI mengesahkan UUD 1945 pada 18 Agustus 1945."),
        Quiz("Siapa yang mengesahkan UUD 1945?", listOf("BPUPKI", "KNIP", "PPKI", "DPR"), 2, "UUD 1945 disahkan oleh Panitia Persiapan Kemerdekaan Indonesia."),
        Quiz("Berapa jumlah sila Pancasila?", listOf("3", "4", "5", "6"), 2, "Pancasila terdiri dari lima sila."),
        Quiz("TNI terdiri dari berapa matra?", listOf("Dua", "Tiga", "Empat", "Lima"), 1, "TNI terdiri dari AD, AL, dan AU."),
        Quiz("Siapa Panglima Besar TNI pertama?", listOf("Jenderal Sudirman", "Jenderal Ahmad Yani", "Jenderal Gatot Soebroto", "Jenderal Soeharto"), 0, "Jenderal Sudirman dikenal sebagai Panglima Besar TNI pertama."),
        Quiz("Arti Bhinneka Tunggal Ika adalah...", listOf("Bersatu kita teguh", "Berbeda-beda tetapi tetap satu", "Satu bangsa satu bahasa", "Adil dan makmur"), 1, "Semboyan ini menegaskan persatuan dalam keberagaman."),
        Quiz("Sikap terbaik jika tidak mengetahui jawaban adalah...", listOf("Mengarang jawaban", "Diam tanpa respons", "Mengaku belum tahu dengan sopan", "Mengalihkan pembicaraan"), 2, "Kejujuran lebih baik daripada mengarang jawaban.")
    )

    private val interviewQuestions = listOf(
        "Coba perkenalkan diri kamu secara singkat dan runtut.",
        "Mengapa kamu ingin menjadi prajurit TNI?",
        "Apa yang kamu pahami tentang tugas pokok TNI?",
        "Apa makna Pancasila bagi kehidupan berbangsa?",
        "Bagaimana cara kamu menjaga persatuan di lingkunganmu?",
        "Apa kelebihan dan kekurangan dirimu?",
        "Bagaimana kamu menyikapi kritik dari orang lain?",
        "Apa yang kamu lakukan jika melakukan kesalahan?",
        "Bagaimana jika kamu ditempatkan jauh dari keluarga?",
        "Apa yang akan kamu lakukan jika belum berhasil dalam seleksi?"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        showHome()
    }

    private fun setup(title: String) {
        root = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setBackgroundColor(Color.rgb(246, 248, 251))
        }
        val header = TextView(this).apply {
            text = title
            textSize = 21f
            setTextColor(Color.WHITE)
            typeface = Typeface.DEFAULT_BOLD
            setPadding(20, 22, 20, 22)
            setBackgroundColor(Color.rgb(24, 49, 83))
        }
        root.addView(header)
        val scroll = ScrollView(this)
        val content = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(16, 16, 16, 24)
        }
        scroll.addView(content)
        root.addView(scroll, LinearLayout.LayoutParams(-1, 0, 1f))
        setContentView(root)
        content.tag = "content"
    }

    private fun content(): LinearLayout = (root.getChildAt(1) as ScrollView).getChildAt(0) as LinearLayout

    private fun addText(parent: LinearLayout, text: String, size: Float = 16f, bold: Boolean = false) {
        val tv = TextView(this).apply {
            this.text = text
            textSize = size
            setTextColor(Color.rgb(35, 45, 58))
            if (bold) typeface = Typeface.DEFAULT_BOLD
            setPadding(4, 8, 4, 8)
        }
        parent.addView(tv)
    }

    private fun addButton(parent: LinearLayout, text: String, action: () -> Unit) {
        val b = Button(this).apply {
            this.text = text
            isAllCaps = false
            setTextColor(Color.WHITE)
            backgroundTintList = android.content.res.ColorStateList.valueOf(Color.rgb(36, 82, 122))
            setOnClickListener { action() }
        }
        val lp = LinearLayout.LayoutParams(-1, -2)
        lp.setMargins(0, 6, 0, 6)
        parent.addView(b, lp)
    }

    private fun showHome() {
        setup("BELAJAR LITPERS TNI")
        val c = content()
        addText(c, "Belajar mandiri • Materi tersimpan di aplikasi • Dapat digunakan tanpa internet", 14f)
        val done = prefs.getInt("done_count", 0)
        addText(c, "Progres materi: $done dari ${chapters.size} bab selesai", 16f, true)
        addButton(c, "📚 Baca Materi (11 Bab)") { showChapters() }
        addButton(c, "📝 Kuis Pengetahuan") { startQuiz() }
        addButton(c, "🎤 Latihan Wawancara") { showInterview() }
        addButton(c, "📊 Progres Belajar") { showProgress() }
        addButton(c, "ℹ️ Tentang Aplikasi") { showAbout() }
        addText(c, "Catatan: aplikasi ini adalah bahan belajar umum, bukan aplikasi resmi TNI, bukan kisi-kisi resmi, dan bukan jaminan kelulusan.", 13f)
    }

    private fun showChapters() {
        setup("MATERI BELAJAR")
        val c = content()
        chapters.forEachIndexed { index, chapter ->
            val done = prefs.getBoolean("chapter_$index", false)
            addButton(c, (if (done) "✓ " else "") + chapter.title) { showChapter(index) }
        }
        addButton(c, "← Kembali ke Beranda") { showHome() }
    }

    private fun showChapter(index: Int) {
        val chapter = chapters[index]
        setup(chapter.title)
        val c = content()
        addText(c, chapter.body, 16f)
        addText(c, "PERTANYAAN UNTUK DIPIKIRKAN", 15f, true)
        chapter.questions.forEachIndexed { i, q -> addText(c, "${i + 1}. $q", 15f) }
        addButton(c, if (prefs.getBoolean("chapter_$index", false)) "Materi sudah ditandai selesai ✓" else "Tandai Materi Selesai") {
            prefs.edit().putBoolean("chapter_$index", true).putInt("done_count", chapters.indices.count { prefs.getBoolean("chapter_$it", false) }).apply()
            showChapter(index)
        }
        if (index > 0) addButton(c, "← Bab Sebelumnya") { showChapter(index - 1) }
        if (index < chapters.lastIndex) addButton(c, "Bab Berikutnya →") { showChapter(index + 1) }
        addButton(c, "Daftar Materi") { showChapters() }
    }

    private var quizIndex = 0
    private var quizScore = 0
    private fun startQuiz() {
        quizIndex = 0
        quizScore = 0
        showQuizQuestion()
    }

    private fun showQuizQuestion() {
        if (quizIndex >= quizzes.size) {
            prefs.edit().putInt("last_quiz_score", quizScore).apply()
            setup("HASIL KUIS")
            val c = content()
            addText(c, "Nilai latihan: $quizScore dari ${quizzes.size}", 23f, true)
            addText(c, if (quizScore >= 6) "Bagus! Tetap ulangi materi agar semakin paham." else "Ayo pelajari kembali bab terkait dan coba lagi.")
            addButton(c, "Ulangi Kuis") { startQuiz() }
            addButton(c, "Kembali ke Beranda") { showHome() }
            return
        }
        val q = quizzes[quizIndex]
        setup("KUIS ${quizIndex + 1}/${quizzes.size}")
        val c = content()
        addText(c, q.question, 19f, true)
        q.options.forEachIndexed { i, option ->
            addButton(c, "${'A' + i}. $option") {
                val correct = i == q.answer
                if (correct) quizScore++
                showQuizFeedback(correct, q.explanation)
            }
        }
        addButton(c, "Kembali ke Beranda") { showHome() }
    }

    private fun showQuizFeedback(correct: Boolean, explanation: String) {
        setup("PEMBAHASAN")
        val c = content()
        addText(c, if (correct) "✓ Jawaban benar" else "Jawaban belum tepat", 21f, true)
        addText(c, explanation)
        addButton(c, "Lanjutkan") { quizIndex++; showQuizQuestion() }
    }

    private fun showInterview() {
        setup("LATIHAN WAWANCARA")
        val c = content()
        addText(c, "Jawab pertanyaan berikut dengan suara lantang atau tulis di buku catatan. Utamakan jawaban jujur berdasarkan pengalamanmu.", 15f)
        interviewQuestions.forEachIndexed { i, q ->
            addText(c, "${i + 1}. $q", 16f, true)
            val answer = EditText(this).apply {
                hint = "Tulis kerangka jawabanmu di sini..."
                minLines = 2
                gravity = Gravity.TOP
                setText(prefs.getString("interview_$i", ""))
            }
            c.addView(answer, LinearLayout.LayoutParams(-1, -2))
            addButton(c, "Simpan Jawaban ${i + 1}") {
                prefs.edit().putString("interview_$i", answer.text.toString()).apply()
                Toast.makeText(this, "Jawaban tersimpan di perangkat", Toast.LENGTH_SHORT).show()
            }
        }
        addButton(c, "← Kembali ke Beranda") { showHome() }
    }

    private fun showProgress() {
        setup("PROGRES BELAJAR")
        val c = content()
        val count = chapters.indices.count { prefs.getBoolean("chapter_$it", false) }
        addText(c, "Materi selesai: $count dari ${chapters.size} bab", 20f, true)
        addText(c, "Nilai kuis terakhir: ${prefs.getInt("last_quiz_score", 0)} dari ${quizzes.size}")
        addText(c, "Jawaban latihan wawancara tersimpan secara lokal di perangkat ini.")
        addButton(c, "Kembali ke Beranda") { showHome() }
    }

    private fun showAbout() {
        setup("TENTANG APLIKASI")
        val c = content()
        addText(c, "Belajar Litpers TNI — versi 1.0")
        addText(c, "Aplikasi belajar mandiri yang memuat materi dasar, kuis, latihan wawancara, dan progres lokal.")
        addText(c, "Aplikasi ini tidak terhubung ke internet dan tidak mengirim jawaban atau data ke server.")
        addText(c, "Bukan aplikasi resmi TNI. Informasi yang dapat berubah, terutama nama pejabat dan aturan seleksi, harus diperiksa kembali melalui sumber resmi terbaru sebelum digunakan.")
        addButton(c, "Kembali ke Beranda") { showHome() }
    }
}
