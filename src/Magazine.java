public class Magazine extends ReadingItem{
    public Magazine(String name){
        super(name);
    }
    private String coverStoryTitle;
    private String printDate;

    public String getCoverStoryTitle() {
        return coverStoryTitle;
    }

    public void setCoverStoryTitle(String coverStoryTitle) {
        this.coverStoryTitle = coverStoryTitle;
    }

    public String getPrintDate() {
        return printDate;
    }

    public void setPrintDate(String printDate) {
        this.printDate = printDate;
    }

    @Override
    public void show() {
        super.show();
        System.out.println("Magazine{" +
                "coverStoryTitle='" + coverStoryTitle + '\'' +
                ", printDate='" + printDate + '\'' +
                '}');
    }
}
