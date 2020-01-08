package Manage;

import Attributes.Essential_Attributes;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Manage_Products {

    /*
    This class has all the information of a product
    Product_Description : this is the description of this product (The Recipe)
    Product_Uses : all the deases we can use this product for
    Product_Id : the id of this product
    Product_Price : the price of this product
    Product_Name : the name of this product
    Product_Company : the manufacture company of this product
    Product_Type : the type of this product
     */
    private String Product_Description, Product_Uses;
    private int Product_Id;
    private float Prouct_Price;
    private String Product_Name, Product_Company, Product_Type;

    public Manage_Products() { // Constructure

    }

    public Manage_Products(String desc, String use, String name, String com, String type, int id, float price) { // Constructure
        this.Product_Description = desc;
        this.Product_Uses = use;
        this.Product_Name = name;
        this.Product_Company = com;
        this.Product_Type = type;
        this.Product_Id = id;
        this.Prouct_Price = price;
    }

    public Manage_Products(Manage_Products RP) { // Constructure
        this.Product_Description = RP.getProduct_Description();
        this.Product_Uses = RP.getProduct_Description();
        this.Product_Name = RP.getProduct_Name();
        this.Product_Company = RP.getProduct_Company();
        this.Product_Type = RP.getProduct_Type();
        this.Product_Id = RP.getProduct_Id();
        this.Prouct_Price = RP.getProduct_Price();

    }

    public String getProduct_Description() { //Get the description of this product
        return this.Product_Description;
    }

    public void setProduct_Description(String desc) { // Set the description of this product
        this.Product_Description = desc;
    }

    public String getProduct_Uses() { // Get the uses of this product
        return this.Product_Uses;
    }

    public void setProduct_Uses(String use) { // Set the uses of this product
        this.Product_Uses = use;
    }

    public int getProduct_Id() { // Get the id of this product
        return this.Product_Id;
    }

    public void setProduct_Id(int id) { // Set the id of this product
        this.Product_Id = id;
    }

    public float getProduct_Price() { // Get the price of this product
        return this.Prouct_Price;
    }

    public void setPdocur_Price(float price) { // Set the price of this product
        this.Prouct_Price = price;
    }

    public String getProduct_Name() { // Get the name of this product
        return this.Product_Name;
    }

    public void setProduct_Name(String name) { // Set the name of this product
        this.Product_Name = name;
    }

    public String getProduct_Company() { // Get the manufacture company of this product
        return this.Product_Company;
    }

    public void setProduct_Company(String p) { // Set the manufacture compant of this product
        this.Product_Company = p;
    }

    public String getProduct_Type() { // Get the type of this product
        return this.Product_Type;
    }

    public void setProduct_Type(String t) { // Set the type of this product
        this.Product_Type = t;
    }

    public boolean Verification_ProductName(String name) {

        /*
        This methode will verify if this name of product is exist of not
        by searching in "Products.txt" file
        this methode will return true if it exists , false if it doesn't
        */
        try {
            FileInputStream File = new FileInputStream("Products.txt");
            ObjectInputStream Obj = new ObjectInputStream(File);
            Manage_Products rp;
            while ((rp = (Manage_Products) Obj.readObject()) != null) {
                if (rp.getProduct_Name() == name) {
                    return true;
                }
            }
        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        } catch (ClassNotFoundException e) {

        }

        return false;
    }

    public void Creat_Product(Manage_Products Product) {

        /*
        This methode will add a product (Product) to "Products.txt"
        if this product is existing in "Products.txt" we won't add it
        if it doesn't we will
        */
        if (!Verification_ProductName(Product.getProduct_Name())) {

            try {
                FileInputStream File = new FileInputStream("Products.txt");
                ObjectInputStream Obj = new ObjectInputStream(File);
                FileOutputStream TFile = new FileOutputStream("TProducts.txt");
                ObjectOutputStream TObj = new ObjectOutputStream(TFile);
                Manage_Products rp;
                while ((rp = (Manage_Products) Obj.readObject()) != null) {
                    TObj.writeObject(rp);
                }
                Obj.close();
                File.close();
                TObj.close();
                TFile.close();
            } catch (FileNotFoundException e) {

            } catch (IOException e) {

            } catch (ClassNotFoundException e) {

            }

            try {
                FileInputStream File = new FileInputStream("TProducts.txt");
                ObjectInputStream Obj = new ObjectInputStream(File);
                FileOutputStream TFile = new FileOutputStream("Products.txt");
                ObjectOutputStream TObj = new ObjectOutputStream(TFile);
                Manage_Products rp;
                TObj.writeObject(Product);
                while ((rp = (Manage_Products) Obj.readObject()) != null) {
                    TObj.writeObject(rp);
                }
                Obj.close();
                File.close();
                TObj.close();
                TFile.close();
            } catch (FileNotFoundException e) {

            } catch (IOException e) {

            } catch (ClassNotFoundException e) {

            }
        }

    }

    public void Modify_ProductPrice(Manage_Products Product, int price) {

        /*
        This methode will modify the price of (Product)
        by searching for it in "Products.txt"
        if it exists we will modify th price to (price)
        if it doesn't
        */
        if (Verification_ProductName(Product.getProduct_Name())) {

            try {
                FileInputStream File = new FileInputStream("Products.txt");
                ObjectInputStream Obj = new ObjectInputStream(File);
                FileOutputStream TFile = new FileOutputStream("TProducts.txt");
                ObjectOutputStream TObj = new ObjectOutputStream(TFile);
                Manage_Products rp;
                while ((rp = (Manage_Products) Obj.readObject()) != null) {
                    if (rp.equals(Product)) {
                        rp.setPdocur_Price(price);
                        TObj.writeObject(rp);
                    } else {
                        TObj.writeObject(rp);
                    }
                }
                Obj.close();
                File.close();
                TObj.close();
                TFile.close();
            } catch (FileNotFoundException e) {

            } catch (IOException e) {

            } catch (ClassNotFoundException e) {

            }

            try {
                FileInputStream File = new FileInputStream("TProducts.txt");
                ObjectInputStream Obj = new ObjectInputStream(File);
                FileOutputStream TFile = new FileOutputStream("Products.txt");
                ObjectOutputStream TObj = new ObjectOutputStream(TFile);
                Manage_Products rp;
                while ((rp = (Manage_Products) Obj.readObject()) != null) {
                    TObj.writeObject(rp);
                }
                Obj.close();
                File.close();
                TObj.close();
                TFile.close();
            } catch (FileNotFoundException e) {

            } catch (IOException e) {

            } catch (ClassNotFoundException e) {

            }
        }
    }

}
