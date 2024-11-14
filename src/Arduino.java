public class Arduino extends ElectronicItem{
    public Arduino(String name){
        super(name);
    }
    private String version;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public void show() {
        super.show();
        System.out.println("Arduino{" +
                "version='" + version + '\'' +
                '}');
    }
}
