import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        Product[] products = {
                new Product(102, "Laptop", "Electronics"),
                new Product(205, "T-Shirt", "Clothing"),
                new Product(304, "Headphones", "Electronics"),
                new Product(401, "Shoes", "Footwear")
        };
        System.out.println("🔍 Linear Search for ID 304:");
        Product result1 = SearchAlgorithms.linearSearch(products, 304);
        System.out.println(result1 != null ? result1 : "Product not found");
        Arrays.sort(products);
        System.out.println("\n🔍 Binary Search for ID 304:");
        Product result2 = SearchAlgorithms.binarySearch(products, 304);
        System.out.println(result2 != null ? result2 : "Product not found");
        System.out.println("\n🔍 Binary Search for ID 999:");
        Product result3 = SearchAlgorithms.binarySearch(products, 999);
        System.out.println(result3 != null ? result3 : "Product not found");
    }
}
