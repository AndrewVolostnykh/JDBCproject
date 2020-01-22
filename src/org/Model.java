package org;

import java.sql.*;
import java.time.LocalDate;

public class Model {
    Connection connect = null;

    /**Mistake of realisation MVC is a logic of outputting in Model class.*/

    public void connection() throws ClassNotFoundException {
        try{
            String name = "postgres";
            String password = "1679438520";
            String dburl = "jdbc:postgresql://localhost:5432/training_market";
            Class.forName("org.postgresql.Driver");
            connect = DriverManager.getConnection(dburl, name, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertIntoUsers(String role, String user_email, String user_name, String password, String phone)
    {
        try{
            PreparedStatement preparedStatement = connect.prepareStatement("insert into \"USERS\"(\"role\", \"status_active\", \"user_email_pk\", \"user_name\", \"user_password\", \"phone_number\") values (?,?,?,?,?,?)");
            preparedStatement.setString(1, role);
            preparedStatement.setBoolean(2, true);
            preparedStatement.setString(3, user_email);
            preparedStatement.setString(4, user_name);
            preparedStatement.setString(5, password);
            preparedStatement.setString(6, phone);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void insertIntoGiftBasket(LocalDate creation_data, String user_email_fk, String basket_name, boolean status_active)
    {
        try{
            PreparedStatement preparedStatement = connect.prepareStatement("insert into \"Gift_Basket\"(\"creation_data\", \"user_email_fk\", \"basket_name\", \"status_active\") values (?,?,?,?) ;");
            preparedStatement.setObject(1, creation_data);
            preparedStatement.setString(2, user_email_fk);
            preparedStatement.setString(3, basket_name);
            preparedStatement.setBoolean(4, status_active);
            preparedStatement.executeUpdate();
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
    public void insertIntoStoredItems(String user_email_fk, int price, String description, LocalDate adding_data, String item_name, int barcode)
    {
        try{
            PreparedStatement preparedStatement = connect.prepareStatement("insert into \"Stored_items\" (\"user_email_fk\", \"price\", \"description\", \"adding_data\", \"item_name\", \"item_barcode\") values(?,?,?,?,?,?);");
            preparedStatement.setString(1, user_email_fk);
            preparedStatement.setInt(2, price);
            preparedStatement.setString(3, description);
            preparedStatement.setObject(4, adding_data);
            preparedStatement.setString(5, item_name);
            preparedStatement.setInt(6, barcode);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void insertIntoSelectedItems(LocalDate creation_data, String customer_email, String salesman_email, int quantity_in_order, int item_barcode)
    {
        try {
            PreparedStatement preparedStatement = connect.prepareStatement("insert into \"Selected_items\" (\"creation_data_fk\", \"customer_email\", \"salesman_email\", \"quantity_in_order\", \"item_barcode_fk\") values (?,?,?,?,?); ");
            preparedStatement.setObject(1, creation_data);
            preparedStatement.setString(2, customer_email);
            preparedStatement.setString(3, salesman_email);
            preparedStatement.setInt(4, quantity_in_order);
            preparedStatement.setInt(5, item_barcode);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void deleteFrom(String table, String whereColumn, String whereClause)
    {
        try {
            Statement statement = connect.createStatement();
            statement.executeUpdate("delete from " + table + " where " + whereColumn + " = " +"'"+ whereClause + "'" + ";");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void selectAll(String table, int countColumns){
        try {
            Statement statement =  connect.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from " +"\""+ table + "\"" );
            while(resultSet.next())
            {
                int i = 1;
                while(i<countColumns) {
                    System.out.print(resultSet.getString(i) + " | ");
                    i++;
                }
                System.out.println(resultSet.getString(i));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void selectWithNoWhere(String table, String param, int countColumns)
    {
        try {
            Statement statement = connect.createStatement();
            ResultSet resultSet = statement.executeQuery(" select " + param + " from \"" + table + "\";");
            while(resultSet.next())
            {
                int i = 1;
                while(i<countColumns)
                {
                    System.out.println(resultSet.getString(i) + "|");
                    i++;
                }
                System.out.println(resultSet.getString(i));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void selectWithWhere(String table, String param, String whereClause, int countColumns) {
        try {
            Statement statement = connect.createStatement();
            ResultSet resultSet = statement.executeQuery("Select " + param + " from \""+ table + "\" where "+whereClause+ ";");
            while (resultSet.next()) {
                int i = 1;
                while (i < countColumns) {
                    System.out.print(resultSet.getString(i) + "|");
                    i++;
                }
                System.out.println(resultSet.getString(i));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateIn(String table, String column, String where)
    {
        try {
            Statement statement = connect.createStatement();
            statement.executeUpdate("update " + table + " set " + column + " where " + where + ";");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    // function that have already inserted TABLE_NAME
    public void joinSelect(int priceBetween, int priceAnd, boolean status_active, int countColumns)
    {
        try {
            PreparedStatement preparedStatement = connect.prepareStatement("select * from \"USERS\" us inner join \"Stored_items\" sti on us.\"user_email_pk\" = sti.\"user_email_fk\"" +
                    " where (\"status_active\" = ?) and (\"price\" between ? and ?)");
            preparedStatement.setBoolean(1, status_active);
            preparedStatement.setInt(2, priceBetween);
            preparedStatement.setInt(3, priceAnd);

            ResultSet resultSet = preparedStatement.executeQuery(); // forming ResultSet by executeQuery method of resultSet

            while(resultSet.next())
            {
                int i = 1;
                while(i<countColumns)
                {
                    System.out.print(resultSet.getString(i)+"|");
                    i++;
                }
                System.out.println(resultSet.getString(i));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void wordSearch(String word) // this function searching only in Stored_items
    {
        try {
            PreparedStatement preparedStatement = connect.prepareStatement("select \"user_email_fk\", ts_headline(\"description\", q, 'StartSel=>, StopSel=<') from \"Stored_items\" , to_tsquery(?) as q " +
                    "where to_tsvector(\"description\") @@ q");
            preparedStatement.setString(1, word);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next())
            {
                System.out.print(resultSet.getString(1)+"|");
                System.out.println(resultSet.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void phraseSearch(String phrase)
    {
        try {
            PreparedStatement preparedStatement = connect.prepareStatement("select \"user_email_fk\", ts_headline(\"description\", q, 'StartSel=>, StopSel=<') from \"Stored_items\" , phraseto_tsquery(?) as q " +
                    "where to_tsvector(\"description\") @@ q");
            preparedStatement.setString(1, phrase);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next())
            {
                System.out.print(resultSet.getString(1)+"|");
                System.out.println(resultSet.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
