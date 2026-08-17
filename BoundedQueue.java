public class BoundedQueue {              // แถวซื้อขนม (ADT)
    private ArrayList<String> items;     // แถวคน
    private final int capacity;          // ยืนได้กี่คน
    // AF(items, capacity) = แถวจุได้ capacity
    // items.get(0)              = คนหน้า (ออกก่อน)
    // items.get(items.size()-1) = คนท้าย (เพิ่งเข้า)
    // ว่าง                      = ไม่มีคน

    // RI เหมือนสแตก: ห้าม null, capacity>0, ห้ามเกินจุ, ห้ามคนเน่า
    private void checkRep() {
        assert items != null;
        assert capacity > 0;
        assert items.size() <= capacity;
        for (String s : items) assert s != null;
    }
    public BoundedQueue(int capacity) {  // Creator
        if (capacity <= 0) throw new IllegalArgumentException();
        this.capacity = capacity;
        this.items = new ArrayList<>();
        checkRep();
    }
    public void enqueue(String item) {   // Mutator = ไปต่อท้าย
        if (item == null) throw new IllegalArgumentException();
        if (isFull()) throw new IllegalStateException();
        items.add(item);                 // ต่อท้ายแถว
        checkRep();
    }

    public String dequeue() {            // Mutator = คนหน้าได้ออก
        if (isEmpty()) throw new IllegalStateException();
        String x = items.remove(0);      // ออกหน้า = ลบ index 0
        checkRep();
        return x;
    }
    public String front() {              // Observer = ดูคนหน้า ไม่ให้ออก
        if (isEmpty()) throw new IllegalStateException();
        return items.get(0);
    }
    public int size() { return items.size(); }
    public boolean isEmpty() { return items.isEmpty(); }
    public boolean isFull() { return items.size() == capacity; }

    public BoundedQueue reversed() {     // Producer = แถวใบใหม่ ลำดับกลับ
        BoundedQueue q = new BoundedQueue(this.capacity);
        for (int i = items.size() - 1; i >= 0; i--)
            q.enqueue(items.get(i));
        checkRep();
        return q;                        // แถวเดิมห้ามขยับ
    }
}
