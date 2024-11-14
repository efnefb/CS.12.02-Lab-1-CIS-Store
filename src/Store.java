import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.reflect.Method;
import java.lang.reflect.Field;
public class Store {

    private ArrayList<CISItem> cisItems;

    public Store() {
        cisItems = new ArrayList<>();
    }
    public void addItem(CISItem item) {
        cisItems.add(item);
    }

    public ArrayList<CISItem> getItems(String itemType) {
        ArrayList<CISItem> items = new ArrayList<>();
        for (CISItem obj : cisItems) {
            if (obj.getClass().getSimpleName().toLowerCase().equals(itemType.toLowerCase())) {
                items.add(obj);
            }
        }
        return items;
    }


    public void updateItems(String itemType, String property, String value) throws IllegalAccessException, InvocationTargetException {
        String methodName = ("set" + property).toLowerCase();
        Class<?> clazz;
        boolean valueIsInt = false;
        int intValue = 0;

        for (CISItem cisItem : cisItems) {
            clazz = cisItem.getClass();
            if (clazz.getSimpleName().toLowerCase().equals(itemType.toLowerCase())) {
                Method[] methods = clazz.getMethods(); //get array of obj's methods

                //get array list of obj's fields
                ArrayList<Field> fields = new ArrayList<>();
                while (clazz != null) {
                    Field[] classFields = clazz.getDeclaredFields();
                    for (Field classField : classFields) {
                        fields.add(classField);
                    }
                    clazz = clazz.getSuperclass();
                }

                //check if the queried field is int or string
                for (Field field : fields) {
                    if (field.getName().toLowerCase().equals(property.toLowerCase()) &&
                            field.getType() == int.class) {
                        valueIsInt = true;
                        intValue = Integer.parseInt(value);
                    }
                }

                //loop through methods[] --> if method name matches what was queried, call it to set attribute
                for (Method method : methods) {
                    if (method.getName().toLowerCase().equals(methodName)) {
                        if (!valueIsInt) method.invoke(cisItem, value);
                        else method.invoke(cisItem, intValue);
                    }
                }
            }
        }
    }

    public void showAllInfo() throws IllegalAccessException{
        for (CISItem cisItem: cisItems){
            System.out.println(cisItem.getName() + ":");
            cisItem.show();
            System.out.println("----");
        }
    }





}




