// ✗ ร้านคนเดียว (ผิด S + O + D)
class ReportManager {
    void createPdf(...) {
        // คนเดียวคิดเกรด + เซฟตู้ + ส่งจดหมาย + พิมพ์
        MySqlDb db = new MySqlDb();     // ผูกตู้ยี่ห้อเดียว (ผิด D)
        SmtpEmail email = new SmtpEmail();
        if (title.endsWith(".csv")) ...  // เติม "ถ้า" ในสมุดเก่า (ผิด O)
        else if (title.endsWith(".html")) ...
        else exportPdf(...);
    }
}
// ✓ ร้านแบ่งงาน
interface Exporter { void export(...); }     // สัญญา "พิมพ์ใบประกาศ"
class PdfExporter implements Exporter { ... }
class CsvExporter implements Exporter { ... }
class XlsxExporter implements Exporter { ... } // จ้างคนใหม่ ไม่แก้ของเก่า

class ReportService {                        // ร้านใหญ่
    private final Exporter exporter;         // รู้จักแค่สัญญา ไม่รู้จักยี่ห้อ
    ReportService(Exporter e) {              // ฉีดคนทำงานเข้ามา (D)
        this.exporter = e;
    }
    void create(...) {
        exporter.export(...);                // ไม่มี if ตามชนิดไฟล์
    }
}
// ✗ ลูกแทนพ่อแล้วนับซ้ำ (ผิด L) — CountingSet
// add นับ+1 , addAll นับ+size แต่ addAll แอบเรียก add อีก → 3 กลายเป็น 6

// ✓ ถือคนนับไว้ข้างใน แล้วส่งงานต่อ (lab: CountingNotifier)
class CountingNotifier implements Notifier {
    private final Notifier inner;            // กล่องเล็กถือคนทำงานไว้ (has-a)
    void send(String msg) {
        count++;                             // เธอนับ
        inner.send(msg);                     // ฉันส่งของต่อ
    }
}
