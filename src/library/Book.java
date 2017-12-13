package library;


class Book extends Item {

    private final String author;
    private final int pages;

    public Book(String title, String author, int pages, String... keywords) {

        super(title, keywords);
        this.author = author;
        this.pages = pages;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return String.format("-Book-\nauthor:   %s\n# pages:  %d\n%s", author, pages, super.toString());
    }
}




