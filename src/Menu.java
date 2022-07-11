import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    public static void menu() {

        Scanner scanner = new Scanner(System.in);
int choice;
        do {
            System.out.println();
            System.out.println("---PRODUCT MANAGE PROGRAM---");
            System.out.println("1. Show product list");
            System.out.println("2. Add product");
            System.out.println("3. Update product");
            System.out.println("4. Remove product");
            System.out.println("5. Sort product");
            System.out.println("6.Find highest price product ");
            System.out.println("7.Read file");
            System.out.println("8.Write file");
            System.out.println("9.Exit");
            System.out.println("Enter choice");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    ProductManage.displayProduct();
                    break;
                case 2:
                    ProductManage.addProduct();
                    break;
                case 3:
                    System.out.println("Enter ID that you want to edit");
                    String id = scanner.nextLine();
                    ProductManage.editProductByID(id);
                    break;
                case 4:
                    ProductManage.removeProductById();
                    break;
                case 5:

                case 7:
                    ArrayList<Product> Product =ProductManage.readFile(ProductManage.PATH_NAME);
                    Product.forEach(System.out::println);
                    break;
                case 8: ProductManage.writeFile(ProductManage.getProductList(),ProductManage.PATH_NAME);
                    break;
                case 9: System.exit(0);
            }
        }
        while (choice != 0);
    }
}
