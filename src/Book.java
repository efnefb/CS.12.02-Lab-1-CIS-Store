public class Book extends ReadingItem{
    public Book(String name){
        super(name);
    }
    private String isbn;
    private String edition;
    private String title;

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public void show() {
        super.show();
        System.out.println("Book{" +
                "isbn='" + isbn + '\'' +
                ", edition='" + edition + '\'' +
                ", title='" + title + '\'' +
                '}');
    }
}
