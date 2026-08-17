public class BoundedStack {   // กล่องทึบของแม่มด (ADT)

    // ของลับในกล่อง ห้ามคนนอกควาน (rep)
    private ArrayList<String> items;   // กองลูกบอล
    private final int capacity;        // จุได้กี่ลูก (ห้ามเกิน)

    // คำแปลภาษาคน (AF) ไม่ใช่กติกา
    // AF(items, capacity) = สแตกจุได้ capacity
    // items.get(0)              = ก้นกอง (ลูกเข้าก่อน)
    // items.get(items.size()-1) = ลูกบนสุด (เพิ่งใส่)
    // ว่าง                      = กล่องว่าง

    // กติกาในกล่อง (RI) ผิดแล้วกล่องพัง
    // items != null            (กล่องห้ามหาย)
    // capacity > 0
    // size <= capacity         (ห้ามเกินห้าลูก)
    // ห้ามมี null ใน items     (ห้ามลูกเน่า)

    private void checkRep() {          // แม่เดินมาตรวจหลังขยับ
        assert items != null;
        assert capacity > 0;
        assert items.size() <= capacity;
        for (String s : items) assert s != null;  // มีลูกเน่าไหม
    }

    // Creator = สร้างกล่องว่างจากศูนย์
    public BoundedStack(int capacity) {
        if (capacity <= 0) throw new IllegalArgumentException();
        this.capacity = capacity;
        this.items = new ArrayList<>();
        checkRep();                    // แม่ตรวจหลังสร้าง
    }

    // Mutator = กดปุ่มใส่ แก้ใบเดิม
    public void push(String item) {    // ปุ่ม "ใส่"
        if (item == null) throw new IllegalArgumentException(); // ลูกเน่าห้ามเข้า
        if (isFull()) throw new IllegalStateException();        // เกินจุ
        items.add(item);
        checkRep();                    // แม่ตรวจหลังใส่
    }

    // Observer = ดูอย่างเดียว ห้ามขยับกอง
    public int size() { return items.size(); }

    // Producer = เครื่องถ่ายเอกสาร ได้ใบใหม่ ใบเดิมห้ามขยับ
    public BoundedStack copy() {
        BoundedStack other = new BoundedStack(this.capacity); // ใบใหม่
        for (String s : this.items) other.push(s);
        checkRep();
        return other;                  // ยื่นใบใหม่ ห้าม return this (ยื่นใบเดิม)
    }
}
