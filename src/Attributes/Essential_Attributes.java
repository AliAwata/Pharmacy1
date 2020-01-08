package Attributes;

import Manage.Manage_Products;
import java.io.*;

public class Essential_Attributes {

    /*
    This class expresses all the attributes of one product
    Product_Id : The id of the product
    Prouct_NumberOfProduct : The Total number of this product in a bill
    Product_Price : The price of this product
    Product_TotalProductPrice : The Total price of this product in a bill (Product_Price * Prouct_NumberOfProduct)
    Product_Name : The name of this product
    Product_Company : The manufacture company of this product
    Product_Type : The type of this product (This product will be used for this disease)
     */
    private int Product_Id, Product_NumberOfProduct;
    private float Prouct_Price, Product_TotalProductPrice;
    private String Product_Name, Product_Company, Product_Type;

    public Essential_Attributes() { // Constructure

    }

    public Essential_Attributes(int id, int num, float pri, String name, String com, String type) { // Constructure
        this.Product_Id = id;
        this.Product_NumberOfProduct = num;
        this.Prouct_Price = pri;
        this.Product_TotalProductPrice = num * pri;
        this.Product_Name = name;
        this.Product_Company = com;
        this.Product_Type = type;
    }

    public Essential_Attributes(Essential_Attributes EA) { // Constructure
        this.Product_Id = EA.getProduct_Id();
        this.Product_NumberOfProduct = EA.getProduct_NumverOfProduct();
        this.Prouct_Price = EA.getProduct_Price();
        this.Product_TotalProductPrice = EA.getProduct_NumverOfProduct() * EA.getProduct_Price();
        this.Product_Name = EA.getProduct_Name();
        this.Product_Company = EA.getProduct_Company();
        this.Product_Type = EA.getProduct_Type();
    }

    public int getProduct_Id() { // Get the id of this product
        return this.Product_Id;
    }

    public void setProuct_Id(int id) { // Set the id of this product
        this.Product_Id = id;
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

    public void setProduct_Company(String p) { // Set the manufacture company of this product
        this.Product_Company = p;
    }

    public String getProduct_Type() { // Get the typ of this product
        return this.Product_Type;
    }

    public void setProduct_Type(String t) { // Set the type of this product
        this.Product_Type = t;
    }

    public float getProduct_Price() { // Get the price of this product
        return this.Prouct_Price;
    }

    public void setProduct_Price(float n) { // Set the price of this product
        this.Prouct_Price = n;
    }

    public int getProduct_NumverOfProduct() { // Get the total number of this product in a bill
        return this.Product_NumberOfProduct;
    }

    public void setProduct_NumberOfProduct(int n) { // Set the total number of this prouct in a bill
        this.Product_NumberOfProduct = n;
    }

    public float getProduct_TotalProductPrice() { // Get the total price of this product in a bill
        return this.Product_TotalProductPrice;
    }

    public void setProduct_TotalProductPrice(float n) { // Set the total price of this product in a bill
        this.Product_TotalProductPrice = n;
    }

    public boolean Verification_ProductName(String Product_Name) throws FileNotFoundException, IOException, ClassNotFoundException {

        /*
        This methode make sure that this product is already exist by product's name
        First : open the text file of all products
        Second : search in the text file for the product name
        Third : if the name exist , it will return true if the product is already exist
        false if it doesn't exist
         */
        try {
            FileInputStream File = new FileInputStream("Products.txt");
            ObjectInputStream Obj = new ObjectInputStream(File);
            Manage_Products rp;
            while ((rp = (Manage_Products) Obj.readObject()) != null) {
                if (rp.getProduct_Name() == Product_Name) {
                    return true;
                }
            }
        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        } catch (ClassNotFoundException e) {

        }

        return false;
    }
}
