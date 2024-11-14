public class Phone extends ElectronicItem{
    public Phone(String name){
        super(name);
    }
    private String networkType;
    private int screenSize;

    public String getNetworkType() {
        return networkType;
    }

    public void setNetworkType(String networkType) {
        this.networkType = networkType;
    }

    public int getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(int screenSize) {
        this.screenSize = screenSize;
    }

    @Override
    public void show() {
        super.show();
        System.out.println("Phone{" +
                "networkType='" + networkType + '\'' +
                ", screenSize=" + screenSize +
                '}');
    }
}
