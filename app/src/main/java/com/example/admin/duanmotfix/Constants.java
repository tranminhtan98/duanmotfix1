package com.example.admin.duanmotfix;

public interface Constants {
    String TABLE_GIAY = "GIAY";

    // Ten Cot
    String COLUMN_ID = "ID";
    String COLUMN_TITLE = "Title";
    String COLUMN_SHORTDES = "ShortDesc";
    String COLUMN_PRICE = "Price";
    String COLUMN_RATING = "Rating";
    String COLUMN_IMG = "Img";


    // Cau lenh tao bang
    String CREATE_TABLE_GIAY = "CREATE TABLE " + TABLE_GIAY + "(" +
            COLUMN_ID + " NVARCHAR PRIMARY KEY," +
            COLUMN_TITLE + " NVARCHAR," +
            COLUMN_SHORTDES + " NVARCHAR," +
            COLUMN_PRICE + " NVARCHAR," +
            COLUMN_IMG + " NVARCHAR," +
            COLUMN_RATING + " NVARCHAR" +

            ")";

    String TABLE_CART = "Cart";
    String COLUMN_IDCART = "IdCart";
    String COLUMN_TITLECART = "TitleCart";
    String COLUMN_SHORTDESCCART = "ShortdescCart";
    String COLUMN_PRICECART = "PriceCart";
    String COLUMN_RATINGCART = "RatingCart";
    String COLUMN_IMGCART = "ImgCart";

    String CREATE_TABLE_CART = "CREATE TABLE " + TABLE_CART + "(" +

            COLUMN_IDCART + " NVARCHAR PRIMARY KEY," +

            COLUMN_TITLECART + " NVARCHAR," +

            COLUMN_SHORTDESCCART + " NVARCHAR," +

            COLUMN_RATINGCART + " NVARCHAR," +
            COLUMN_IMGCART + " NVARCHAR," +


            COLUMN_PRICECART + " NVARCHAR" +

            ")";

}
