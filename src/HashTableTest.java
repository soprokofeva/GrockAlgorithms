import java.util.Hashtable;
import java.util.Map;

public class HashTableTest {
    public static void main(String[] args) {
        Hashtable<String, Integer> products = new Hashtable<>();
        products.put("apple", 7);
        products.put("milk", 1);
        products.put("milk", 4);

        for (Map.Entry<String, Integer> product : products.entrySet()) {
            System.out.println(product.getKey() + " : " + product.getValue() + " hashcode " + product.hashCode());
        }
    }
}
