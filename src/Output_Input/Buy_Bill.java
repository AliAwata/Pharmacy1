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

public class Buy_Bill {
    
    private ArrayList<Essential_Attributes> Products_Essential;
    private Bill_Attributes Product_Bill;
    
    public Buy_Bill() {
        
    }
    
    public Buy_Bill(ArrayList<Essential_Attributes> EA, Bill_Attributes BA) {
        this.Products_Essential = new ArrayList<>();
        this.Products_Essential = EA;
        this.Product_Bill = new Bill_Attributes();
        this.Product_Bill = BA;
    }
    
    public Buy_Bill(Buy_Bill B) {
        this.Products_Essential = new ArrayList<>();
        this.Products_Essential = B.getProduct_Essential();
        this.Product_Bill = new Bill_Attributes();
        this.Product_Bill = B.getProduct_Bill();
    }
    
    public ArrayList<Essential_Attributes> getProduct_Essential() {
        return this.Products_Essential;
    }
    
    public void setProduct_Essential(ArrayList<Essential_Attributes> EA) {
        this.Products_Essential = new ArrayList<>();
        this.Products_Essential = EA;
    }
    
    public Bill_Attributes getProduct_Bill() {
        return this.Product_Bill;
    }
    
    public void setProduct_Bill(Bill_Attributes BA) {
        this.Product_Bill = new Bill_Attributes();
        this.Product_Bill = BA;
    }
    
    public boolean Verification_User_Name(String name) throws FileNotFoundException, IOException, ClassNotFoundException  {
        
        try {
            FileInputStream File = new FileInputStream("Buy_Bill.txt");
            ObjectInputStream Obj = new ObjectInputStream(File);
            Buy_Bill bb;
            while ((bb = (Buy_Bill) Obj.readObject()) != null) {
                if (bb.getProduct_Bill().getUser_Name() == name) {
                    return true;
                }
            }
            File.close();
            Obj.close();
        } catch (FileNotFoundException e) {
            
        } catch (IOException e) {
            
        } catch (ClassNotFoundException e) {
            
        }
        
        return false;
    }
    
    public void Create_Buy_Bill(Buy_Bill bb) throws FileNotFoundException, IOException, ClassNotFoundException  {
        
        try {
            FileOutputStream File = new FileOutputStream("TBuy_Bill.txt");
            ObjectOutputStream Obj = new ObjectOutputStream(File);
            FileInputStream TFile = new FileInputStream("Buy_Bill.txt");
            ObjectInputStream TObj = new ObjectInputStream(TFile);
            Buy_Bill b;
            while ((b = (Buy_Bill) TObj.readObject()) != null) {
                Obj.writeObject(b);
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
            Buy_Bill b;
            Obj.writeObject(bb);
            while ((b = (Buy_Bill) TObj.readObject()) != null) {
                Obj.writeObject(b);
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
    
}
