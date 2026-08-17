public final class Book {                            // ①
    private final String title;                      // ②
    private final List<String> authors;

    public Book(String title, List<String> authors) {
        if (title==null || title.isEmpty()) throw new IllegalArgumentException();
        if (authors==null || authors.isEmpty()) throw new IllegalArgumentException();
        for (String a : authors)
            if (a==null || a.isEmpty()) throw new IllegalArgumentException();
        this.title = title;
        this.authors = new ArrayList<>(authors);     // ⑤ ขาเข้า
        checkRep();
    }

    public List<String> authors() {
        return new ArrayList<>(this.authors);        // ⑥ ขาออก
    }

    // ③ ไม่มี setter
    public Book withAuthor(String a) {               // ④ producer
        if (a==null || a.isEmpty()) throw new IllegalArgumentException();
        List<String> next = new ArrayList<>(this.authors);
        next.add(a);
        return new Book(this.title, next);
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book b = (Book) o;
        return title.equals(b.title) && authors.equals(b.authors);
    }
    @Override public int hashCode() {
        return Objects.hash(title, authors);
    }
}
