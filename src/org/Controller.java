package org;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view){
        this.model = model;
        this.view = view;
    }

    public void mainMenu() // main method, drawing menu and calling functions
    {
        try {
            int choice = 1;
            Scanner scanner = new Scanner(System.in);

            while (choice != 0) {
                view.printMainMenu();
                System.out.print("Input your choice: ");
                choice = scanner.nextInt();
                switch (choice) { // switching main menu
                    case 1: { //insert func
                        System.out.println("Insert Function");
                        view.tablesMenu();
                        int nextChoice = scanner.nextInt();
                        insertInto(nextChoice);
                        break;
                    }
                    case 2: { // update func
                        System.out.println("Update Function");
                        view.tablesMenu();
                        int nextChoice = scanner.nextInt();
                        updateIn(nextChoice);
                        break;
                    }
                    case 3: { // delete func FINISHED
                        System.out.println("Delete Function");
                        view.tablesMenu();
                        int nextChoice = scanner.nextInt();
                        deleteFunc(nextChoice);
                        break;
                    }
                    case 4: { // random filling
                        System.out.println("Random filling Function(in USERS)");
                        randomFilling();
                        break;
                    }
                    case 5: { // select all func FINISHED
                        System.out.println("Select ALL Function");
                        view.tablesMenu();
                        int nextChoice = scanner.nextInt();
                        selectAllFunc(nextChoice);
                        break;
                    }
                    case 6: { //select only by columns
                        System.out.println("Select by param Function");
                        view.tablesMenu();
                        int nextChoice = scanner.nextInt();
                        selectWithoutWhere(nextChoice);
                        break;
                    }
                    case 7: { // select with where
                        System.out.println("Select by param with where Function");
                        view.tablesMenu();
                        int nextChoice = scanner.nextInt();
                        selectWithWhere(nextChoice);
                        break;
                    }
                    case 8: { // inner join
                        System.out.println("Inner Join from USERS and Stored items");
                        innerSelect();
                        break;
                    }
                    case 9: { // text search by word
                        System.out.println("Full text search by word");
                        wordSearch();
                        break;
                    }
                    case 10: { // text search by phrase
                        System.out.println("Full text search by phrase");
                        phraseSearch();
                        break;
                    }
                    case 0: // finish app
                        System.out.println("Good luck!");
                        break;
                    default:
                        System.out.println("Incorrect input!");
                        break;
                }
            }
        } catch(Exception executeExcept) {
            executeExcept.printStackTrace();
        }
    }

    private void deleteFunc(int nextChoice)
    {
        try {
            Scanner scanner = new Scanner(System.in);
            String table;
            view.structOfTables(nextChoice);
            if (nextChoice == 1) {
                table = "\"USERS\"";
            } else if (nextChoice == 2) {
                table = "\"Gift_Basket\"";
            } else if (nextChoice == 3) {
                table = "\"Selected_items\"";
            } else {
                table = "\"Stored_items\"";
            }
            System.out.print("Choose column to set condition: ");
            String column = scanner.nextLine();
            System.out.print("Choose your condition: ");
            String clause = scanner.nextLine();
            model.deleteFrom(table, column, clause);
        } catch(Exception executiveException){
            executiveException.printStackTrace();
        }
    }
    private void selectAllFunc(int nextChoice){
        try {
            if (nextChoice == 1) {
                view.structOfTables(1);
                model.selectAll("USERS", 6);
            } else if (nextChoice == 2) {
                view.structOfTables(2);
                model.selectAll("Gift_Basket", 4);
            } else if (nextChoice == 3) {
                view.structOfTables(3);
                model.selectAll("Selected_items", 5);
            } else if (nextChoice == 4) {
                view.structOfTables(4);
                model.selectAll("Stored_items", 6);
            } else {
                System.out.println("Incorrect input :(");
            }
        } catch (Exception executiveException)
        {
            executiveException.printStackTrace();
        }
    }

    private void testingFilling(int nextChoice) { // "random" filling DB
        try {
            switch (nextChoice) {
                case 0: {
                    System.out.println("Back to main menu");
                    break;
                }
                case 1: {
                    System.out.println("Random filling for USERS");
                    model.insertIntoUsers("salesman", "saller@mail.ru", "SallerBe", "9638526aa", "02050896");
                    model.insertIntoUsers("salesman", "kikito@ukr.net", "KiKiBuy", "forgottenpassword", "+629538");
                    model.insertIntoUsers("customer", "gabSally@ukr.net", "Sally", "mypass3434", "30873526899");
                    model.insertIntoUsers("customer", "vikasobol@mail.ru", "Viktoria", "pass1212120", "3806565852");
                    model.insertIntoUsers("customer", "allanovikova@mail.ru", "AllaNovikova", "allamolodezz", "13553552");
                    model.insertIntoUsers("customer", "lizaPodliza@gmail.com", "Liza Verun", "albert456", "01000036");
                    model.insertIntoUsers("example", "example@example.com", "Example", "examplepassword", "987987987");
                    break;
                }
                case 2: {
                    System.out.println("Random filling Gift_Basket");
                    model.insertIntoGiftBasket(LocalDate.of(2019, 05, 12), "gabSally@ukr.net", "Sally's Second Basket", true);
                    model.insertIntoGiftBasket(LocalDate.of(2018, 03, 16), "gabSally@ukr.net", "Sally's OldBasket", true);
                    model.insertIntoGiftBasket(LocalDate.of(2017, 12, 17), "solomia_tokar@mail.ru", "Unnamed", true);
                    model.insertIntoGiftBasket(LocalDate.of(2015, 05, 25), "customA@gmail.com", "MyBasket", true);
                    model.insertIntoGiftBasket(LocalDate.of(2016, 12, 14), "bizAlex@gmail.com", "First Basket", true);
                    model.insertIntoGiftBasket(LocalDate.of(2014, 12, 30), "bizAlex@gmail.com", "second Dasket", true);
                    model.insertIntoGiftBasket(LocalDate.of(2014, 12, 30), "vikassobol@mail.ru", "erpokerfg", true);
                    model.insertIntoGiftBasket(LocalDate.of(2014, 12, 30), "allanovikova@mail.ru", "AlkaBest", true);
                    model.insertIntoGiftBasket(LocalDate.of(2019, 10, 1), "lizaPodliza@gmail.com", "Basket", true);
                    break;
                }
                case 3: {
                    System.out.println("Random filling Selected_items");
                    model.insertIntoSelectedItems(LocalDate.of(2019, 05, 12), "gabSally@ukr.net", "saller@mail.ru", 3, 10000025);
                    model.insertIntoSelectedItems(LocalDate.of(2017, 12, 17), "solomia_tokar@mail.ru", "kikito@ukr.net", 5, 100000129);
                    model.insertIntoSelectedItems(LocalDate.of(2019, 10, 1), "lizaPodliza@gmail.com", "trainingMarket@gmail.com", 20, 10000096);
                    model.insertIntoSelectedItems(LocalDate.of(2019, 05, 12), "gabSally@ukr.net", "trainingMarket@gmail.com", 1, 10000099);
                    model.insertIntoSelectedItems(LocalDate.of(2017, 12, 17), "solomia_tokar@mail.ru", "kikito@ukr.net", 100, 100000124);
                    break;
                }
                case 4: {
                    System.out.println("Random filling Stored_items");
                    model.insertIntoStoredItems("saller@mail.ru", 10, "The Best Choice! Nice T-Shorts!", LocalDate.of(2014, 1, 10), "SoT-Shorts", 10000025);
                    model.insertIntoStoredItems("saller@mail.ru", 10, "Example, Example, Example,Example.", LocalDate.of(2014, 1, 11), "SoShorts", 100000026);
                    model.insertIntoStoredItems("saller@mail.ru", 5, "pdsafposkdfpo kspok fposkpokfpow kepof kposkfepo ksrojkg s.", LocalDate.of(2014, 01, 22), "Glasses", 100000027);
                    model.insertIntoStoredItems("kikito@ukr.net", 150, "dsaijsoijf", LocalDate.of(2015, 7, 15), "wsf", 100000124);
                    model.insertIntoStoredItems("kikito@ukr.net", 150, "iwerfowejf", LocalDate.of(2015, 7, 15), "wio", 100000125);
                    model.insertIntoStoredItems("kikito@ukr.net", 100, "seiosef", LocalDate.of(2015, 8, 18), "oiewjf", 100000129);
                    model.insertIntoStoredItems("trainingMarket@gmail.com", 10, "euiofh", LocalDate.of(2014, 9, 13), "uwerih", 10000096);
                    model.insertIntoStoredItems("trainingMarket@gmail.com", 40, "soerh", LocalDate.of(2014, 9, 14), "suhfgs", 10000099);
                    model.insertIntoStoredItems("trainingMarket@gmail.com", 35, "siuhf", LocalDate.of(2014, 10, 1), "uioerh", 10000100);
                    break;
                }
                default:
                    System.out.println("Have no choice?");
                    break;
            }

        } catch (Exception executiveException) {
            executiveException.printStackTrace();
        }
    }

    private void randomFilling()
    {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        System.out.print("Input quantity columns to generate: ");
        int quantityOfRows = scanner.nextInt();

        while(quantityOfRows>0) {

            List<String> users = new ArrayList<>();

            char[] randWord = new char[rand.nextInt((10) + 1) + 20]; //  massive with random size from 20 to 30
            int randInt;
            for(int columns = 0; columns < 5; columns++) {// loop to filling collection
                for (int i = 0; i < randWord.length; i++) { // loop to create random words
                    randInt = rand.nextInt((122 - 48) + 1) + 48;
                    randWord[i] = (char) randInt;
                }
                users.add(columns, String.valueOf(randWord));
            }

            //System.out.println(users.get(0)+" | "+users.get(1)+" | "+users.get(2)+" | "+users.get(3));
            model.insertIntoUsers("test", users.get(0), users.get(1), users.get(2), users.get(3));

            quantityOfRows--;
        }
    }

    private void insertInto(int nextChoice)
    {
        switch (nextChoice)
        {
            case 1: {
                insertIntoUSERS();
                break;
            }
            case 2: {
                insertIntoGiftBasket();
                break;
            }
            case 3: {
                insertIntoSelectedItems();
                break;
            }
            case 4:
            {
                insertIntoStoredItems();
                break;
            }
            case 0:
                System.out.println("Back to main menu");
                break;
                default: {
                    System.out.println("Incorrect input! ");
                    break;
                }
        }
    }
    private void updateIn(int nextChoice)
    {
        Scanner scanner = new Scanner(System.in);
        String table;
        if(nextChoice == 1)
        {
            table = "\"USERS\"";
            view.structOfTables(1);
        } else if(nextChoice == 2){
            table = "\"Gift_Basket\"";
            view.structOfTables(2);
        } else if(nextChoice == 3) {
            table = "\"Selected_items\"";
            view.structOfTables(3);
        } else if(nextChoice == 4){
            table = "\"Stored_items\"";
            view.structOfTables(4);
        } else {
            System.out.println("Incorrect input!");
            return;
        }
                System.out.print("Input column and present value: ");
                String where = scanner.nextLine();
                System.out.print("Input your column and new value: ");
                String column = scanner.nextLine();
                //System.out.println(where);
                model.updateIn(table, column, where);
    }
    private void selectWithoutWhere(int nextChoice) // training func ( Un-using for users in real store )
    {
        Scanner scanner = new Scanner(System.in);
        String param; int countColumns;
        try { // must be optimized!!!
            if(nextChoice == 1001)
            {
                view.structOfTables(1);
                System.out.print("Input columns to Select: "); param = scanner.nextLine();
                System.out.println("Input quantity of inputed columns: "); countColumns = scanner.nextInt();
                model.selectWithNoWhere("USERS", param, countColumns);
            } else if (nextChoice == 2002) {
                view.structOfTables(2);
                System.out.print("Input columns to Select: "); param = scanner.nextLine();
                System.out.println("Input quantity of inputed columns: "); countColumns = scanner.nextInt();
                model.selectWithNoWhere("Gift_Basket", param, countColumns);
            } else if (nextChoice == 3003) {
                view.structOfTables(3);
                System.out.print("Input columns to Select: "); param = scanner.nextLine();
                System.out.println("Input quantity of inputed columns: "); countColumns = scanner.nextInt();
                model.selectWithNoWhere("Selected_items", param, countColumns);
            } else if (nextChoice == 4004) {
                view.structOfTables(4);
                System.out.print("Input columns to Select: "); param = scanner.nextLine();
                System.out.println("Input quantity of inputed columns: "); countColumns = scanner.nextInt();
                model.selectWithNoWhere("Stored_items", param, countColumns);
            } else {
                System.out.println("Incorrect input!");
            }

        } catch(Exception executiveException)
        {
            executiveException.printStackTrace();
        }
    }
    private void selectWithWhere(int nextChoice)
    {
        String param, whereClause; int countColumns;
        Scanner scanner = new Scanner(System.in);

        view.structOfTables(nextChoice);
        try {
        System.out.print("Input columns to select: ");
        param = scanner.nextLine();
        System.out.print("Quantity of inputted columns: ");
        countColumns = scanner.nextInt(); scanner.nextLine(); // nextLine() here to clean buffer
        System.out.print("Input where clause: ");
        whereClause = scanner.nextLine();
            if (nextChoice == 1){
                model.selectWithWhere("USERS", param, whereClause, countColumns);
            } else if (nextChoice == 2) {
                model.selectWithWhere("Gift_Basket", param, whereClause, countColumns);
            } else if (nextChoice == 3) {
                model.selectWithWhere("Selected_items", param, whereClause, countColumns);
            } else if (nextChoice == 4) {
                model.selectWithWhere("Stored_items", param, whereClause, countColumns);
            } else {
                return;
            }
        } catch(Exception executiveException)
        {
            executiveException.printStackTrace();
        }
    }


    private void insertIntoGiftBasket()
    {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Input creation date (YYYY-MM-DD): ");
            String creationDate = scanner.nextLine();
            LocalDate convertedCreationDate = LocalDate.parse(creationDate);
            System.out.println("Input your email: ");
            String user_email_fk = scanner.nextLine();
            System.out.println("Input basket name: ");
            String basket_name = scanner.nextLine();
            model.insertIntoGiftBasket(convertedCreationDate, user_email_fk, basket_name, true);
        } catch(Exception executeException) {
            executeException.printStackTrace();
        }
    }
    private void insertIntoUSERS()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input your role (customer/salesman): ");
        String role = scanner.nextLine();
        System.out.print("Input your email: ");
        String user_email = scanner.nextLine();
        System.out.print("Input your Name: ");
        String user_name = scanner.nextLine();
        System.out.print("Input your password: ");
        String password = scanner.nextLine();
        System.out.print("Input your phone: ");
        String phone = scanner.nextLine();
        //String role, String user_email, String user_name, String password, String phone
        model.insertIntoUsers(role, user_email, user_name, password, phone);
    }
    private void insertIntoStoredItems()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input your email: ");
        String user_email = scanner.nextLine();
        System.out.print("Input item name: ");
        String item_name = scanner.nextLine();
        System.out.print("Input cost of item: ");
        int price = scanner.nextInt();
        System.out.print("Input description to item: ");
        scanner.nextLine(); // cleaning stream
        String description = scanner.nextLine();
        System.out.print("Input barcode (!WARNING! there is PK, be carefully) :");
        int barcode = scanner.nextInt();

        model.insertIntoStoredItems(user_email, price, description, LocalDate.now(), item_name, barcode);
    }
    private void insertIntoSelectedItems() // trial function to test program, we inputting dates, that must be selected from other tables!
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Customer email: ");
            String customer_email = scanner.nextLine();
        System.out.print("Input item barcode to add: ");
            int item_barcode = scanner.nextInt();
        System.out.print("Quantity in order: ");
            int quantity_in_order = scanner.nextInt(); scanner.nextLine();
        System.out.print("Input salesman email: ");
            String salesman_email = scanner.nextLine();
        System.out.print("Input creation date of your basket: ");
            String creation_date = scanner.nextLine();
        LocalDate prepared_creation_date = LocalDate.parse(creation_date);

        model.insertIntoSelectedItems(prepared_creation_date, customer_email, salesman_email, quantity_in_order, item_barcode);
    }
    private void innerSelect()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input price from: ");
        int priceBetween = scanner.nextInt();
        System.out.print("Input price to: ");
        int priceAnd = scanner.nextInt();
        //boolean status_active = scanner.nextBoolean(); // for me its unnecessary param
        int countColumns = 12;

        model.joinSelect(priceBetween, priceAnd, true, countColumns);
    }
    private void wordSearch()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input desired word: ");
        String word = scanner.nextLine();
        model.wordSearch(word);
    }
    private void phraseSearch()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input desired phrase: ");
        String phrase = scanner.nextLine();
        model.phraseSearch(phrase);
    }
}

