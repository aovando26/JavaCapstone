import java.util.Scanner;

public class Main {
    private static final Scanner input = new Scanner(System.in);
    private static final GroceryList groceryList = new GroceryList();

    public static void main(String[] args) {
        boolean quit = false;
        int choice = 0;
        printInstructions();

        while(!quit) {
            System.out.println("Enter your choice: ");
            choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 0 -> printInstructions();
                case 1 -> groceryList.printGroceryList();
                case 2 -> addItem();
                case 3 -> modifyItem();
                case 4 -> removeItem();
                case 5 -> searchForItem();
                case 6 -> quit = true;
            }
        }
    }
    public static void printInstructions() {
        System.out.println("\nPress ");
        System.out.println("\t 0 - to print choice options");
        System.out.println("\t 1 - to print the list of grocery items");
        System.out.println("\t 2 - to add an item to the list");
        System.out.println("\t 3 - to modify an item in the list");
        System.out.println("\t 4 - to remove an items from the list");
        System.out.println("\t 5 - to search for an item in the list");
        System.out.println("\t 6 - to quit the application");
    }
    public static void addItem() {
        System.out.println("Please enter the grocery item");
        groceryList.addGroceryItem(input.nextLine());
    }
    public static void modifyItem() {
        System.out.println("Enter the item number: ");
        int itemNum = input.nextInt();
        input.nextLine();
        System.out.println("Enter replacement item: ");
        String newItem = input.nextLine();
        groceryList.modifyGroceryList(itemNum - 1, newItem);
    }
    public static void removeItem() {
        System.out.println("Enter item number: ");
        int itemNum = input.nextInt();
        input.nextLine();
        groceryList.removerGroceryList(itemNum -1);
    }
    public static void searchForItem() {
        System.out.println("Item to search for: ");
        String searchItem = input.nextLine();

        if(groceryList.findItem(searchItem) != null) {
            System.out.println("Found " + searchItem + " in grocery list");
        }
        else {
            System.out.println(searchItem + " is not in the groceries list");
        }
    }
}
