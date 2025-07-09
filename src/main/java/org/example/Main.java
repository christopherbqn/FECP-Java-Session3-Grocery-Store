package org.example;
import java.awt.image.ImageProducer;
import java.util.*;


public class Main {

    private static HashMap<String, Integer> products = new HashMap<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String productName;
        int quantity=0;
        int choice=0;

        while(true){
            System.out.println("\n===== Welcome to the Grocery Menu! ======");
            System.out.println("1. View Inventory \n2. Add Product \n3. Check Product \n4. Update Stock \n5. Remove Product \n6. Exit");
            System.out.print("Enter your chosen option: ");

            try{
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("> [ERR: Invalid Input]");
                continue;
            }

            switch(choice){
                case 1:
                    viewInventory();
                    break;
                case 2:
                    // add products
                    System.out.println("\n> [Add Product to Inventory]");
                    System.out.print("Enter Product Name: ");
                    productName = scanner.nextLine();

                    if(productName.isEmpty()){
                        System.out.println("> [ERR: Product Name is Empty]");
                        break;
                    }else{
                        System.out.print("Enter Quantity of " + productName + ": ");
                        try{
                            quantity = Integer.parseInt(scanner.nextLine());
                            addProduct(productName, quantity);
                        } catch (NumberFormatException e) {
                            System.out.println("> [ERR: Invalid Input for Quantity]");
                            break;
                        }
                    }

                    break;
                case 3:
                    // check product
                    System.out.println("> [Check Product in Inventory]");
                    System.out.print("Enter Product Name: ");
                    productName = scanner.nextLine();

                    if(productName.isEmpty()){
                        System.out.println("> [ERR: Product Name is Empty]");
                        break;
                    }else{
                        checkProduct(productName);
                    }

                    break;
                case 4:
                    // update product

                    System.out.println("> [Update Product in Inventory]");
                    System.out.print("Enter Product Name to Update: ");
                    productName = scanner.nextLine();

                    if(productName.isEmpty()){
                        System.out.println("> [ERR: Product Name is Empty]");
                        break;
                    }else{
                        System.out.print("Enter New Quantity of " + productName + ": ");
                        try{
                            quantity = Integer.parseInt(scanner.nextLine());
                            updateProduct(productName, quantity);
                        } catch (NumberFormatException e) {
                            System.out.println("> [ERR: Invalid Input for Quantity]");
                            break;
                        }
                    }

                    break;
                case 5:
                    //remove product

                    System.out.println("> [Remove Product From Inventory]");
                    System.out.print("Enter Product to Remove: ");
                    productName = scanner.nextLine();

                    if(productName.isEmpty()){
                        System.out.println("> [ERR: Product Name is Empty]");
                        break;
                    }else{
                        removeProduct(productName);
                        System.out.println("Removed " + productName +" from inventory");
                    }

                    break;
                case 6:
                    // exit
                    System.out.println("----- Exiting Grocery Menu -----");
                    return;
                default:
                    System.out.println("> [ERR: Invalid Input. Please Enter Choice between 1-6]");
                    break;
            }



        }
    }

    public static boolean addProduct(String name, int quantity){

        if(checkExistingProduct(name)){
            System.out.println("> [ERR: Product Already Exists]");
            return false;
        }else if(quantity <= 0){
            System.out.println("> [ERR: Quantity must be greater than 0]");
            return false;
        }else{
            products.put(name, quantity);
            return true;
        }
    }

    public static boolean viewInventory(){
        System.out.println("\n> [Current Products in Inventory]");

        if(products.isEmpty()){
            System.out.println("Inventory is Empty");
            return false;
        }else{
            for (String name: products.keySet()) {
                String quantity = products.get(name).toString();
                System.out.println(name + " -- " + quantity + "pcs");
            }
            return true;

        }
    }


    public static boolean checkProduct(String name){

        if(checkExistingProduct(name)){
            int quantity = products.get(name);
            System.out.println("Quantity of " + name + ": " + quantity);
            return true;
        }else{
            System.out.println("> [ERR: Product is not in Inventory]");
            return false;
        }

    }


    public static boolean updateProduct(String name, int quantity){
        if(checkExistingProduct(name)){

            if(quantity<= 0){
                System.out.println("> [ERR: Quantity must be greater than 0]");
                return false;
            }else{
                products.replace(name, quantity);
                return true;
            }

        }else{
            System.out.println("> [ERR: Product is not in Inventory]");
            return false;
        }
    }

    public static boolean removeProduct(String name){

        if(checkExistingProduct(name)){
            products.remove(name);
            return true;
        }else{
            return false;
        }

    }


    // helper method to check for exsiting products
    public static boolean checkExistingProduct(String name){
        return products.get(name) != null;
    }

    // helper method to get product quantity
    public static int getProductQuantity(String name){
        return products.get(name);
    }



}
