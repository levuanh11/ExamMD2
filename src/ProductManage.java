import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductManage {
   static String PATH_NAME = "products.csv";
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Product> productList = new ArrayList<>();
    static Validate validate = new Validate();
    public static ArrayList<Product> getProductList(){
        return productList;
    }



    //    ghi file
    public static void writeFile(ArrayList<Product> Products, String path) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path));
            for (Product Product : Products) {
                bufferedWriter.write(Product.getId() + "," +
                        Product.getName() + "," + Product.getPrice() + "," + Product.getAmount() + "," +
                        Product.getDescription() + "," + "\n");
            }
            bufferedWriter.close();
            System.out.println("Success");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }


    //    đọc file
    public static ArrayList<Product> readFile(String path) {
        ArrayList<Product> Products = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] strings = line.split(",");
                Products.add(new Product(strings[0], strings[1], strings[2], strings[3], strings[4]));
            }
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
        return Products;
    }

    //  tạo đối tượng
    public static Product createProduct() {
        System.out.println("Enter id");
        String id = scanner.nextLine();

        System.out.println("Enter product name");
        String name = scanner.nextLine();


        String price = enterPrice();


        String amount = enterAmount();

        System.out.println("Enter description");
        String description = scanner.nextLine();

        return new Product(id, name, price, amount, description);

    }

    // thêm đối tượng vaof mảng
    public static void addProduct() {
        productList.add(createProduct());
        writeFile(productList,PATH_NAME);
    }

    // hiển thị mảng
    public static void displayProduct() {
        for (Product product : productList) {
            System.out.println(product);
        }
    }

    // nhập giá
    public static String enterPrice() {
        String price;
        while (true) {
            System.out.print("Enter product price : ");
            String inputPrice = scanner.nextLine();
            if (!validate.validatePrice(inputPrice)) {
                System.out.println("Please use number only!!!");
            } else {
                price = inputPrice;
                break;
            }
        }
        return price;
    }

    // nhập số lượng
    public static String enterAmount() {
        String amount;
        while (true) {
            System.out.print("Enter product amount : ");
            String inputAmount = scanner.nextLine();
            if (!validate.validateAmount(inputAmount)) {
                System.out.println("Please use number only!!!");
            } else {
                amount = inputAmount;
                break;
            }
        }
        return amount;
    }

    public static void editProductByID(String id){
        for(Product product: productList){
            if(product.getId().equals(id)){
                updateProduct(product);
            }
        }
    }



    private static void updateProduct(Product product) {
        System.out.println("Enter new ID:");
        String productID = scanner.nextLine();
        product.setAmount(productID);

        System.out.println("Enter new name:");
        String name = scanner.nextLine();
        product.setName(name);

        System.out.println("Enter new amount:");
        String amount = scanner.nextLine();
        product.setAmount(amount);

        System.out.println("Enter new price:");
        String price = scanner.nextLine();
        product.setPrice(price);

        System.out.println("Enter new description");
        String des = scanner.nextLine();
        product.setDescription(des);
    }

    public static void removeProductById(){
        System.out.println("Enter id that you want to remove");
        String id = scanner.nextLine();
        for(Product product: productList){
            if(product.getId().equals(id)){
                productList.remove(product);
            }
        }
    }

    public static Product findHighestProduct(ArrayList<Product> productList){
        int max =Integer.parseInt(productList.get(0).getPrice()) ;
        for (int i =1;i<productList.size();i++) {
            if(max> Integer.parseInt(productList.get(i).getPrice())){
                max = Integer.parseInt(productList.get(i).getPrice());
            }
        }
        for(Product product: productList){
            if(Integer.parseInt(product.getPrice()) == max){
                return product;
            }
        }
    }


}