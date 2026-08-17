private ArrayList<String> items;  // หน้าคิว = index 0, ท้ายคิว = ตัวสุดท้าย
private final int capacity;

// AF(items, capacity) = คิวจุได้ capacity
//   items.get(0) = ตัวหน้า (คนแรกที่จะออก)
//   items.get(size-1) = ตัวท้าย (เพิ่งเข้า)
//   ว่าง = คิวว่าง

// RI: items != null, capacity > 0, size <= capacity, ห้าม null ในลิสต์

private void checkRep() {
    assert items != null;
    assert capacity > 0;
    assert items.size() <= capacity;
    for (String s : items) assert s != null;
}

// creator
BoundedQueue(int capacity) {
    if (capacity <= 0) throw new IllegalArgumentException();
    this.capacity = capacity;
    this.items = new ArrayList<>();
    checkRep();
}

// mutator
void enqueue(String item) {
    if (item == null) throw new IllegalArgumentException();
    if (isFull()) throw new IllegalStateException();
    items.add(item);          // ท้ายคิว
    checkRep();
}
String dequeue() {
    if (isEmpty()) throw new IllegalStateException();
    String x = items.remove(0); // หน้าคิว
    checkRep();
    return x;
}

// observer
String front() {
    if (isEmpty()) throw new IllegalStateException();
    return items.get(0);
}

// producer — คืนตัวใหม่ ห้ามแก้ this
BoundedQueue reversed() {
    BoundedQueue q = new BoundedQueue(this.capacity);
    for (int i = items.size()-1; i >= 0; i--)
        q.enqueue(items.get(i));
    checkRep();
    return q;
}
