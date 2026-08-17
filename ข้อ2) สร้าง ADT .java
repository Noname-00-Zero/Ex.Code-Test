public class BoundedStack {              // กล่องทึบกองจาน (ADT)
    // ของลับในกล่อง (rep)
    private ArrayList<String> items;     // กองจาน
    private final int capacity;          // จุได้กี่ใบ

    // คำแปล (AF)
    // AF(items, capacity) = กองจานจุได้ capacity
    // items.get(0)              = ก้นกอง (จานแรกที่วาง)
    // items.get(items.size()-1) = บนสุด (เพิ่ง push)
    // ว่าง                      = กล่องว่าง
    
    // กติกา (RI)
    // items != null
    // capacity > 0
    // size <= capacity
    // ห้ามมี null ใน items
    private void checkRep() {            // แม่ตรวจหลังขยับ
        assert items != null;
        assert capacity > 0;
        assert items.size() <= capacity;
        for (String s : items) assert s != null;
    }
    // Creator = สร้างกล่องว่าง
    public BoundedStack(int capacity) {
        if (capacity <= 0) throw new IllegalArgumentException();
        this.capacity = capacity;
        this.items = new ArrayList<>();
        checkRep();
    }
    // Mutator = วางจานบนสุด
    public void push(String item) {
        if (item == null) throw new IllegalArgumentException();
        if (isFull()) throw new IllegalStateException();
        items.add(item);                 // วางบนสุด = ต่อท้ายลิสต์
        checkRep();
    }
    // Mutator = หยิบบนสุดออก
    public String pop() {
        if (isEmpty()) throw new IllegalStateException();
        String top = items.remove(items.size() - 1);
        checkRep();
        return top;
    }
    // Observer = ดูอย่างเดียว
    public int size() { return items.size(); }
    public boolean isEmpty() { return items.isEmpty(); }
    public boolean isFull() { return items.size() == capacity; }
    public String peek() {               // ดูจานบนสุด ไม่หยิบ
        if (isEmpty()) throw new IllegalStateException();
        return items.get(items.size() - 1);
    }
    // Producer = ถ่ายเอกสารกองจานใบใหม่
    public BoundedStack copy() {
        BoundedStack other = new BoundedStack(this.capacity);
        for (String s : this.items) other.push(s);
        checkRep();
        return other;                    // ห้าม return this
    }
}
