package Store;

public class Store_Room {
    
    private String Store_ProductName,Store_ExpirationDate,Store_RecieveDate;
    private int Store_Entity;
    
    public Store_Room(){
        
    }
    
    public Store_Room(String name,String ExpirDate,String RecieveD,int entity){
        this.Store_ProductName = name;
        this.Store_ExpirationDate = ExpirDate;
        this.Store_RecieveDate = RecieveD;
        this.Store_Entity = entity;
    }
    
    public Store_Room(Store_Room sr){
        this.Store_ProductName = sr.getStore_ProductName();
        this.Store_ExpirationDate = sr.getStore_ExpirationDate();
        this.Store_RecieveDate = sr.getStore_RecieveDate();
        this.Store_Entity = sr.getStore_Entity();
    }
    
    public String getStore_ProductName(){
        return this.Store_ProductName;
    }
    
    public void setStore_ProductName(String name){
        this.Store_ProductName = name;
    }
    
    public String getStore_ExpirationDate(){
        return this.Store_ExpirationDate;
    }
    
    public void setStore_ExpirationDate(String Date){
        this.Store_ExpirationDate = Date;
    }
    
    public String getStore_RecieveDate(){
        return this.Store_RecieveDate;
    }
    
    public void setStore_RecieveDate(String Date){
        this.Store_RecieveDate = Date;
    }
    
    public int getStore_Entity(){
        return this.Store_Entity;
    }
    
    public void setStore_Entity(int entity){
        this.Store_Entity = entity;
    }
    
}
