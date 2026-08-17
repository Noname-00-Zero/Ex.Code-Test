public final class Book {              // ① ห้ามทำสมุดเล่มพิเศษที่ลบได้ (final class)
    private final String title;        // ② ชื่อปกเปลี่ยนไม่ได้ (private final)
    private final List<String> authors; // กระดาษรายชื่อข้างใน
    public Book(String title, List<String> authors) {
        // ตรวจก่อนรับ
        if (title == null || title.isEmpty()) throw new IllegalArgumentException();
        if (authors == null) throw new IllegalArgumentException();
        this.title = title;
        // ⑤ ลอกรายชื่อเข้าสมุดตัวเอง ห้ามเย็บกระดาษเพื่อน (copy ขาเข้า)
        //    ผิด: this.authors = authors;
        this.authors = new ArrayList<>(authors);
    }
    // ③ ไม่มียางลบ (ไม่มี setter)
    public List<String> authors() {
        // ⑥ เพื่อนขอดู → ถ่ายเอกสารให้ ห้ามยื่นสมุดจริง (copy ขาออก)
        //    ผิด: return authors;
        return new ArrayList<>(this.authors);
    }
    // ④ อยากเพิ่มชื่อ → ถ่ายเล่มใหม่ เล่มเดิมห้ามขยับ (producer)
    public Book withAuthor(String a) {
        List<String> next = new ArrayList<>(this.authors);
        next.add(a);
        return new Book(this.title, next);  // เล่มใหม่
    }
    // สองเล่มคนละเล่ม แต่ชื่อเรื่อง+รายชื่อเหมือน = เท่ากัน
    @Override
    public boolean equals(Object o) {       // ต้องเป็น Object ห้าม equals(Book o)
        if (this == o) return true;         // เป็นเล่มเดียวกันเลย
        if (!(o instanceof Book)) return false;
        Book b = (Book) o;
        return title.equals(b.title)
            && authors.equals(b.authors);  // เนื้อหาเหมือนกันไหม
    }
    @Override
    public int hashCode() {
        return Objects.hash(title, authors); // คู่กับ equals เสมอ
    }
}
// กาวที่ปก (final) ≠ นิ่งทั้งเล่ม เพราะกระดาษรายชื่อยังขีดเพิ่มได้ ต้องครบ 6 ข้อ
