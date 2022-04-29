package com.app.project;

import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import javax.swing.JOptionPane;
import com.app.project.models.Category;
import com.app.project.models.Product;
import com.app.project.models.ShoppingCart;

public class Application {
    private static final String TITLE_INFORMATION = "Information";

    private static Optional<Integer> showMenus(int typeMenu) {
        if (typeMenu == 1) {
        	return Optional.ofNullable(Integer.parseInt(JOptionPane.showInputDialog(null, "========= Welcome to our app ========="
                                                                                                + "\n=== Menu:"
                                                                                                + "\n1. Register new product"
                                                                                                + "\n2. Register new category"
                                                                                                + "\n3. Show all categories"
                                                                                                + "\n4. Show all products"
                                                                                                + "\n5. Register invoice"
                                                                                                + "\n6. Exit",
                                                                                                "Management", JOptionPane.INFORMATION_MESSAGE)));
        } else if (typeMenu == 2) {
            return Optional.ofNullable(Integer.parseInt(JOptionPane.showInputDialog(null, "========= All available categories ========="
                                                                                                + "\n1. Select category"
                                                                                                + "\n2. Close",
                                                                                                "Management", JOptionPane.INFORMATION_MESSAGE)));
        } else if (typeMenu == 3) {
            return Optional.ofNullable(Integer.parseInt(JOptionPane.showInputDialog(null, "========= All available products ========="
                                                                                                + "\n1. Select product"
                                                                                                + "\n2. Close",
                                                                                                "Management", JOptionPane.INFORMATION_MESSAGE)));
        } else {
        	return Optional.empty();        	
        }
    }
    
    private static Set<Category> loadCategory() {
    	Set<Category> categories = new TreeSet<>();
    	categories.add(new Category("Grains"));
    	categories.add(new Category("Vegetables"));
    	categories.add(new Category("Fruits"));
    	categories.add(new Category("Dairy products"));
    	categories.add(new Category("Proteins"));
    	categories.add(new Category("Meats"));
    	return categories;
    }

    private static Product registerNewProduct(Long productCode, String productName, Double price, int amount, Set<Category> categories) {
        Set<Category> productCategories = new HashSet<>();

        int indexCategory;
        do {
            indexCategory = showMenus(2).orElseGet(() -> 2);

            if (indexCategory == 1) {
                Category newCategory = (Category) JOptionPane.showInputDialog(null, "All available categories", "Information", JOptionPane.QUESTION_MESSAGE, null, categories.toArray(), categories.toArray()[0]);
                Optional<Category> optionalCategory = categories.stream().filter(c -> c.getCategoryId().equals(newCategory.getCategoryId())).findAny();
                productCategories.add(optionalCategory.orElseGet(() -> null));
            }
        } while (indexCategory != 2);

        return new Product(productCode, productName, price, amount, productCategories);
    }

    private static void registerNewShoppingCart(Set<Product> products) {
        Map<Integer, Product> shoppingProducts = new TreeMap<>();
        Set<Product> userProducts = new TreeSet<>();

        int indexCart;
        do {
            indexCart = showMenus(3).orElseGet(() -> 2);

            if (indexCart == 1) {
                Product product = (Product) JOptionPane.showInputDialog(null, "All available products", "Information", JOptionPane.QUESTION_MESSAGE, null, products.toArray(), products.toArray()[0]);
                userProducts.add(product);
                //int amountUnits = Integer.parseInt(JOptionPane.showInputDialog(null, "Amount of the product:"));
            }
        } while (indexCart != 2);

        userProducts.forEach(p -> {
            int units = Integer.parseInt(JOptionPane.showInputDialog(null, "Amount of the product:"));
            shoppingProducts.put(units, p);
        });
        
        shoppingProducts.forEach((k, v) -> System.out.println("Units: " + k + ", Value: " + v));
    }

    public static void main(String[] args) {
        Set<ShoppingCart> shoppingCarts = new TreeSet<>();
        Set<Product> products = new TreeSet<>();
        Set<Category> categories = loadCategory();
        
        int option;
        do {
        	option = showMenus(1).orElseGet(() -> 5);
        	
            switch (option) {
                case 1:
                	long productCode = Long.parseLong(JOptionPane.showInputDialog(null, "Enter product code:"));
                	String productName = JOptionPane.showInputDialog(null, "Enter product name:");
                	double price = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter price"));
                	int amount = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter amount"));

                    products.add(registerNewProduct(productCode, productName, price, amount, categories));
                    break;
                case 2:
                    String description = JOptionPane.showInputDialog(null, "Description");
                    categories.add(new Category(description));
                    break;
                case 3:
                    System.out.println("=> All available categories");
                	categories.forEach(Category::showCategories);
                	break;
                case 4:
                    System.out.println("=> All available products");
                    products.forEach(Product::showProducts);
                    break;
                case 5:
                    registerNewShoppingCart(products);
                    break;
                case 6:
                    JOptionPane.showMessageDialog(null, "Thanks for your time", TITLE_INFORMATION, JOptionPane.INFORMATION_MESSAGE);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid Option", "Error", JOptionPane.ERROR_MESSAGE);
                    break;
            }
        } while (option != 6);
    }   
}
