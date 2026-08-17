interface ReportRepo { void save(String title, double avg, String grade); }
interface Mailer { void send(String to, String body); }
interface Exporter { void export(String title, double avg, String grade, int[] scores); }

class GradeCalculator {
    String grade(int[] scores) { /* คำนวณอย่างเดียว */ }
}

class ReportService {
    private final ReportRepo repo;
    private final Mailer mailer;
    private final Exporter exporter;
    ReportService(ReportRepo r, Mailer m, Exporter e) { // ฉีด
        this.repo = r; this.mailer = m; this.exporter = e;
    }
    void create(String title, int[] scores) {
        String g = new GradeCalculator().grade(scores);
        repo.save(...);
        mailer.send(...);
        exporter.export(...);  // เพิ่มชนิดใหม่ = class ใหม่ ไม่แก้ที่นี่
    }
}

class PdfExporter implements Exporter { ... }
class CsvExporter implements Exporter { ... }
class MySqlRepo implements ReportRepo { ... }
class SmtpMailer implements Mailer { ... }
