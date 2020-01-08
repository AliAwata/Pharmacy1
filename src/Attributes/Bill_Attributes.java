package Attributes;

public class Bill_Attributes {

    /*
    This class expresses all attributes of bill
    User_Name : The name of customer
    Bill_Date : The date of creation bill
    Bill_Id : ID of a bill
    Total_Price : The completly price of all products in the bill
    */
    
    private String User_Name, Bill_Date;
    private int Bill_Id;
    private float Total_Price;

    public Bill_Attributes() { // Constructure

    }

    public Bill_Attributes(String name, String bd, int id, float tp) { // Constructure
        this.User_Name = name;
        this.Bill_Date = bd;
        this.Bill_Id = id;
        this.Total_Price = tp;
    }

    public Bill_Attributes(Bill_Attributes BA) {  // Constructure
        this.User_Name = BA.getUser_Name();
        this.Bill_Date = BA.getBill_Date();
        this.Bill_Id = BA.getBill_Id();
        this.Total_Price = BA.getTotal_Price();
    }

    public String getUser_Name() { // Get User_Name
        return this.User_Name;
    }

    public void setUser_Name(String name) { // Set User_Name
        this.User_Name = name;
    }

    public int getBill_Id() { // Get the ID of the bill
        return this.Bill_Id;
    }

    public void setBill_Id(int id) { // Set the ID of the bill
        this.Bill_Id = id;
    }

    public String getBill_Date() { // Get the date of the Bill
        return this.Bill_Date;
    }

    public void setBill_Date(String d) { // Set the ID of the bill
        this.Bill_Date = d;
    }

    public float getTotal_Price() { // Get the Total Price of all Products in the Bill
        return this.Total_Price;
    }

    public void setTotal_Price(float t) { // Set the Total Price of all Products in the Bill
        this.Total_Price = t;
    }

}
