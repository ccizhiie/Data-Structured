import java.util.Scanner;
enum FoodCategory {
    FOOD, BEVERAGE, DESSERT
}
class Customer<T> {
    private String name;
    private T id;

    public Customer(String name, T id) {
        this.name = name;
        this.id = id;
    }

    public String getName() { return name; }
    public T getId() { return id; }
}

// Kriteria 2: Membuat Class FoodOrder
class FoodOrder {
    private String orderCode;
    private String menuName;
    private FoodCategory category;

    public FoodOrder(String orderCode, String menuName, FoodCategory category) {
        this.orderCode = orderCode;
        this.menuName = menuName;
        this.category = category;
    }

    public String getOrderCode() { return orderCode; }
    public String getMenuName() { return menuName; }
    public FoodCategory getCategory() { return category; }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Food Ordering System ===");
        System.out.print("Enter Customer Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Customer ID: ");

        long id = scanner.nextLong();
        scanner.nextLine();

        System.out.print("Enter Order Code: ");
        String orderCode = scanner.nextLine();

        System.out.print("Enter Menu Name: ");
        String menuName = scanner.nextLine();

        System.out.println("Select Food Category:");
        System.out.println("1. FOOD");
        System.out.println("2. BEVERAGE");
        System.out.println("3. DESSERT");
        System.out.print("Enter choice: ");
        int choice = scanner.nextInt();

        FoodCategory selectedCategory;
        switch (choice) {
            case 1: selectedCategory = FoodCategory.FOOD; break;
            case 2: selectedCategory = FoodCategory.BEVERAGE; break;
            case 3: selectedCategory = FoodCategory.DESSERT; break;
            default: selectedCategory = FoodCategory.FOOD;
        }

        Customer<Long> customer = new Customer<>(name, id);
        FoodOrder order = new FoodOrder(orderCode, menuName, selectedCategory);
        displayOrderInfo(customer, order);
    }
    public static void displayOrderInfo(Customer<?> customer, FoodOrder order) {
        System.out.println("\n=== Order Information ===");
        System.out.println("Order Code        : " + order.getOrderCode());
        System.out.println("Customer Name     : " + customer.getName());
        System.out.println("Customer ID       : " + customer.getId());
        System.out.println("Customer ID Type  : " + customer.getId().getClass().getSimpleName());

        System.out.println("Menu Name         : " + order.getMenuName());
        System.out.println("Food Category     : " + order.getCategory());
    }
}
