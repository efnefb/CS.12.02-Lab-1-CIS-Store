public class ReadingItem extends CISItem{
    public ReadingItem(String name){
        super(name);
    }
    private int wordCount;
    private String datePublished;
    private String author;

    public int getWordCount() {
        return wordCount;
    }

    public void setWordCount(int wordCount) {
        this.wordCount = wordCount;
    }

    public String getDatePublished() {
        return datePublished;
    }

    public void setDatePublished(String datePublished) {
        this.datePublished = datePublished;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public void show() {
        super.show();
        System.out.println("ReadingItem{" +
                "wordCount=" + wordCount +
                ", datePublished='" + datePublished + '\'' +
                ", author='" + author + '\'' +
                '}');
    }
}
