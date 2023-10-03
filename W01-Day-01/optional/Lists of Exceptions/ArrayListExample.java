import java.util.ArrayList;

public class ArrayListExample {
    public static void main(String[] args) {
        ArrayList<Object> myList = new ArrayList<Object>();
        myList.add("13");
        myList.add("hello world");
        myList.add(48);
        myList.add("Goodbye World");

        for (int i = 0; i < myList.size(); i++) {
            try {
                Integer castedValue = Integer.parseInt((String) myList.get(i));
                System.out.println("Casted Integer value: " + castedValue);
            } catch (NumberFormatException e) {
                System.out.println("Unable to cast to Integer: " + myList.get(i));
            } catch (ClassCastException e) {
                System.out.println("ClassCastException: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("An unexpected exception occurred: " + e.getMessage());
            }
        }
    }
}
