package com.org.chandrabank;

import com.org.chandrabank.BankMode;

public interface Common {
    String driver = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/chandra";
    String user = "root";
    String password = "chandra@123";

    public void savaData(BankModel bankPojoClasss);

    public void getData(int TranscationId);
}
