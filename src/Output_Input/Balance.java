package Output_Input;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Balance {
    
    public Balance(){
        
    }
    
    public float Net_Balance(){
        return InCome_Balance() - OutCome_Balance();
    }
    
    public float OutCome_Balance(){
        float tprice = 0;
        
        try{
            FileInputStream File = new FileInputStream("Buy_Bill.txt");
            ObjectInputStream Obj = new ObjectInputStream(File);
            Buy_Bill bb;
            while((bb = (Buy_Bill) Obj.readObject()) != null){
                tprice+=bb.getProduct_Bill().getTotal_Price();
            }
            Obj.close();
            File.close();
        } catch (FileNotFoundException e) {
            
        } catch (IOException e) {
            
        } catch (ClassNotFoundException e) {
            
        }
        
        return tprice;
    }
    
    public float InCome_Balance(){
        float tprice = 0;
        
        try {
            FileInputStream File = new FileInputStream("Sell_Bill.txt");
            ObjectInputStream Obj = new ObjectInputStream(File);
            Sell_Bill sb;
            while((sb = (Sell_Bill) Obj.readObject()) != null){
                tprice+=sb.getProduct_Bill().getTotal_Price();
            }
            Obj.close();
            File.close();
        } catch (FileNotFoundException e) {
            
        } catch (IOException e) {
            
        } catch (ClassNotFoundException e) {
            
        }
        
        return tprice;
    }
    
}
