package com.org.chandrabank;

import com.org.chandrabank.BankModel;
import com.org.chandrabank.Common;

import java.sql.*;

public class BankDao implements Common {

    public void savaData(BankModel bankPojoClass) {
        Connection connection;

        //Test Conflicts
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
            Integer commission = computeCommission(bankPojoClass.getAmount());
            PreparedStatement statement = connection.prepareStatement("insert into chandrabank( customerName, phoneNumber,amount,remarks,commision)values (?,?,?,?,?)");
            statement.setString(1, bankPojoClass.getCustomerName());
            statement.setLong(2,  bankPojoClass.getPhoneNumber());
            statement.setString(3, bankPojoClass.getAmount());
            statement.setString(4, bankPojoClass.getRemarks());
            statement.setInt(5, commission);

            statement.executeUpdate();
            ResultSet generatedKey = statement.getGeneratedKeys();
            while (generatedKey.next()) {
                System.out.println("you are transaction is successfull with id:" + generatedKey.getInt(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private Integer computeCommission(String amount) {
        if (null != amount) {

            long amt = Long.parseLong(amount);

            if (amt > 0 && amt <= 5000) {
                return 10;
            } else if (amt > 5000 && amt <= 10000) {
                return 100;
            } else if (amt > 10000) {
                return 150;
            }
        }
        return 0;
    }

    @Override
    public void getData(int transcationId) {
        Connection connection = null;
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select customerName,amount,phoneNumber,remarks,commision,transactionDate from chandrabank where transcationId=" + transcationId);
            BankModel obj = new BankModel();
            while (resultSet.next()) {
                obj.setCustomerName(resultSet.getString("customerName"));
                obj.setAmount(resultSet.getString("amount"));
                obj.setPhoneNumber(resultSet.getLong("phoneNumber"));
                obj.setRemarks(resultSet.getString("remarks"));
                obj.setCommision(resultSet.getInt("commision"));
                obj.setTransactionDate(resultSet.getTimestamp("transactionDate"));
                System.out.println(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
