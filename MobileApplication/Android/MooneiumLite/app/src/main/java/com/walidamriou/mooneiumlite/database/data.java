package com.walidamriou.mooneiumlite.database;

public class data {
    public static final String TABLE_NAME = "mooneiumlite_data";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_PASSWORD = "password";
    public static final String COLUMN_MONEY = "money";
    public static final String COLUMN_CURRENCY = "currency";

    private int id;
    private int password;
    private double money;
    private String currency;

    //Create table SQL query
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_ID + " INTEGER,"
                    +COLUMN_PASSWORD + " INTEGER,"
                    +COLUMN_MONEY+" REAL,"
                    +COLUMN_CURRENCY+" TEXT"
                    +");";
    public data() {
    }

    public data(int id,int password, double money, String currency){
        this.id = id;
        this.password=password;
        this.money=money;
        this.currency=currency;
    }

    public int getId() {
        return id;
    }

    public double getMoney() {
        return money;
    }

    public int getPassword() {
        return password;
    }

    public String getCurrency() {
        return currency;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public void setPassword(int password) {
        this.password = password;
    }

}
