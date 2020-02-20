package org;

public class View {

    public void printMainMenu()
    {
        System.out.println("With what functions you want work: ");
        System.out.println("1. Insert");
        System.out.println("2. Update");
        System.out.println("3. Delete");
        System.out.println("4. RandomFilling");
        System.out.println("5. Select all");
        System.out.println("6. Select by param(forAdministrators)");
        System.out.println("7. Select with where clause");
        System.out.println("8. Select from 2 tables");
        System.out.println("9. Full text search by word");
        System.out.println("10. Full text search by phrase");
        System.out.println("0. Exit");
    }

    public void tablesMenu(){
        System.out.println("Select table:");
        System.out.println("1. USERS");
        System.out.println("2. Gift Basket");
        System.out.println("3. Selected items");
        System.out.println("4. Stored items");
        System.out.println("0. Back to main menu");
        System.out.print("Your choice: ");
    }

    public void structOfTables(int choice) {
        switch (choice) {
            case 1: {
                System.out.println("'USERS' Columns: ");
                System.out.println("role|status_active|user_email_pk|user_name|user_password|phone_number");
                break;
            }
            case 2: {
                System.out.println("'Gift Basket' Columns: ");
                System.out.println("creation_data|user_email_fk|basket_name|status_active");
                break;
            }
            case 3: {
                System.out.println("'Selected Items' Columns: ");
                System.out.println("creation_data_fk|customer_email|salesman_email|quantity_in_order|item_barcode_fk");
                break;
            }
            case 4: {
                System.out.println("'Stored items' Columns: ");
                System.out.println("user_email_fk|price|description|adding_data|item_name|item_barcode");
                break;
            }
            default:
                System.out.println("Incorrect input");
        }
    }

}
