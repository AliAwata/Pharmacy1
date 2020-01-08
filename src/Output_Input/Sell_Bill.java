package Output_Input;

import Attributes.Bill_Attributes;
import Attributes.Essential_Attributes;
import Manage.Regist_Products;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Sell_Bill {

    private ArrayList<Essential_Attributes> Products_Essential;
    private Bill_Attributes Product_Bill;
    private String Customer_Name;
    private float Bill_Discount;

    public Sell_Bill() {

    }

    public Sell_Bill(ArrayList<Essential_Attributes> EA, Bill_Attributes BA, String name, float bd) {
        this.Products_Essential = new ArrayList<>();
        this.Products_Essential = EA;
        this.Product_Bill = new Bill_Attributes();
        this.Product_Bill = BA;
        this.Customer_Name = name;
        this.Bill_Discount = bd;
    }

    public Sell_Bill(Sell_Bill B) {
        this.Products_Essential = new ArrayList<>();
        this.Products_Essential = B.getProduct_Essential();
        this.Product_Bill = new Bill_Attributes();
        this.Product_Bill = B.getProduct_Bill();
        this.Customer_Name = B.getCustomer_Name();
        this.Bill_Discount = B.getBill_Discount();
    }

    public ArrayList<Essential_Attributes> getProduct_Essential() {
        return this.Products_Essential;
    }

    public void setProduct_Essential(ArrayList<Essential_Attributes> EA) {
        this.Products_Essential = EA;
    }

    public Bill_Attributes getProduct_Bill() {
        return this.Product_Bill;
    }

    public void setProduct_Bill(Bill_Attributes BA) {
        this.Product_Bill = new Bill_Attributes();
        this.Product_Bill = BA;
    }

    public float getBill_Discount() {
        return this.Bill_Discount;
    }

    public void setBill_Discount(float b) {
        this.Bill_Discount = b;
    }

    public String getCustomer_Name() {
        return this.Customer_Name;
    }

    public void setCustomer_Name(String name) {
        this.Customer_Name = name;
    }

    public boolean Verification_CustomerName(String Customer_Name) {
        return true;
    }

    public void Creaete_Sell_Bill(Sell_Bill sb) {
        try {
            FileOutputStream File = new FileOutputStream("TSell_Bill.txt");
            ObjectOutputStream Obj = new ObjectOutputStream(File);
            FileInputStream TFile = new FileInputStream("Sell_Bill.txt");
            ObjectInputStream TObj = new ObjectInputStream(TFile);
            Sell_Bill s;
            while ((s = (Sell_Bill) TObj.readObject()) != null) {
                Obj.writeObject(s);
            }
            File.close();
            Obj.close();
            TFile.close();
            TObj.close();
        } catch (FileNotFoundException e) {
            
        } catch (IOException e) {
            
        } catch (ClassNotFoundException e) {
            
        }
        
        try {
            FileOutputStream File = new FileOutputStream("Buy_Bill.txt");
            ObjectOutputStream Obj = new ObjectOutputStream(File);
            FileInputStream TFile = new FileInputStream("TBuy_Bill.txt");
            ObjectInputStream TObj = new ObjectInputStream(TFile);
            Sell_Bill s;
            Obj.writeObject(sb);
            while ((s = (Sell_Bill) TObj.readObject()) != null) {
                Obj.writeObject(s);
            }
            File.close();
            Obj.close();
            TFile.close();
            TObj.close();
        } catch (FileNotFoundException e) {
            
        } catch (IOException e) {
            
        } catch (ClassNotFoundException e) {
            
        }
    }

    public void Write_On_File_Store_Room() {
        
    }
    
    public Essential_Attributes getEssential_Attributes_By_Name(String name) throws FileNotFoundException, IOException, ClassNotFoundException {
        
        try {
            FileInputStream File = new FileInputStream("Products.txt");
            ObjectInputStream Obj = new ObjectInputStream(File);
            Regist_Products rp;
            while((rp = (Regist_Products) Obj.readObject()) != null){
                if(rp.getProduct_Name() == name){
                    Essential_Attributes ea = new Essential_Attributes(rp.getProduct_Id(),0,rp.getProduct_Price(),rp.getProduct_Name(),rp.getProduct_Company(),rp.getProduct_Type());
                    return ea;
                }
            }
        } catch (FileNotFoundException e) {
            
        } catch (IOException e) {
            
        } catch (ClassNotFoundException e) {
            
        }
        
        return null;
    }

}
