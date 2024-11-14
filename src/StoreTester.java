import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class StoreTester {
    public void testStore() throws IllegalAccessException, InvocationTargetException{
        addBookTest();
        addBookPhoneTest();
        testUpdatePhonesLocationGetAllPhones();
        testGetItems();
        testUpdateItems();
    }

    @Test
    public void addBookTest(){
        Store store = new Store();
        Book book = new Book("book");
        store.addItem(book);
        Assertions.assertTrue(true);
    }

    @Test
    public void addBookPhoneTest(){
        Store store = new Store();
        Book book = new Book("book");
        Phone phone = new Phone("phone");
        store.addItem(book);
        store.addItem(phone);
        Assertions.assertTrue(true);
    }

    @Test
    public void testUpdatePhonesLocationGetAllPhones() throws IllegalAccessException, InvocationTargetException {
        Store store = new Store();
        Phone phone1 = new Phone("phone1");
        Phone phone2 = new Phone("phone2");
        Phone phone3 = new Phone("phone3");
        store.addItem(phone1);
        store.addItem(phone2);
        store.addItem(phone3);

        store.updateItems("Phone", "Location", "Room 512");

        ArrayList<CISItem> phones = store.getItems("Phone");

        for (CISItem phone : phones) {
            Assertions.assertTrue(phone.getLocation().equals("Room 512"));
        }

    }

    @Test
    public void testGetItems(){
        Store store = new Store();

        Phone phone1 = new Phone("phone1");
        Phone phone2 = new Phone("phone2");
        Phone phone3 = new Phone("phone3");

        store.addItem(phone1);
        store.addItem(phone2);
        store.addItem(phone3);

        Book book1 = new Book("book1");
        Book book2 = new Book("book2");
        Book book3 = new Book("book3");

        store.addItem(book1);
        store.addItem(book2);
        store.addItem(book3);

        ArrayList<CISItem> itemsPhone = store.getItems("Phone");
        Assertions.assertTrue(itemsPhone.contains(phone1));
        Assertions.assertTrue(itemsPhone.contains(phone2));
        Assertions.assertTrue(itemsPhone.contains(phone3));

        ArrayList<CISItem> itemsBook = store.getItems("Book");

        Assertions.assertTrue(itemsBook.contains(book1));
        Assertions.assertTrue(itemsBook.contains(book2));
        Assertions.assertTrue(itemsBook.contains(book3));
    }


    @Test
    public void testUpdateItems() throws IllegalAccessException, InvocationTargetException{
        Store store = new Store();

        Arduino ard1 = new Arduino("ard1");
        Arduino ard2 = new Arduino("ard2");
        Magazine mag1 = new Magazine("mag1");
        Magazine mag2 = new Magazine("mag2");
        Phone phone1 = new Phone("phone1");
        Phone phone2 = new Phone("phone2");
        Book book1 = new Book("book1");
        Book book2 = new Book("book2");

        store.addItem(ard1);
        store.addItem(mag1);
        store.addItem(phone1);
        store.addItem(book1);
        store.addItem(ard2);
        store.addItem(mag2);
        store.addItem(phone2);
        store.addItem(book2);

        store.updateItems("Book", "location", "Room 100");
        ArrayList<CISItem> books = store.getItems("Book");
        for (int i = 0; i < books.size(); i++) {
            CISItem book = books.get(i);
            Assertions.assertTrue(book.getLocation().equals("Room 100"));
        }

        store.updateItems("Arduino", "price", "1000000");
        ArrayList<CISItem> ards = store.getItems("Arduino");
        for (CISItem ard: ards){
            Assertions.assertTrue(ard.getPrice()==1000000);
        }

        store.updateItems("Phone", "model", "model100");
        ArrayList<CISItem> phones = store.getItems("Phone");
        for (CISItem phone: phones){
            Phone phonePhone = (Phone) phone;
            Assertions.assertTrue(phonePhone.getModel().equals("model100"));
        }

        store.updateItems("Magazine", "printDate", "1900");
        ArrayList<CISItem> mags = store.getItems("Magazine");
        for (CISItem mag: mags){
            Magazine magMag = (Magazine) mag;
            Assertions.assertTrue(magMag.getPrintDate().equals("1900"));
        }

    }

    @Test
    public void testShowAllInfo() throws IllegalAccessException, InvocationTargetException{
        Store store = new Store();
        store.addItem(new Phone("phone1"));
        store.addItem(new Phone("phone2"));
        store.addItem(new Magazine("mag1"));
        store.addItem(new Magazine("mag2"));
        store.addItem(new Book("book1"));
        store.addItem(new Book("book2"));
        store.updateItems("Phone", "screenSize", "78");
        store.updateItems("Magazine", "printDate", "1800");
        store.updateItems("Book", "Location", "Room 80");
        store.showAllInfo();

    }


}
