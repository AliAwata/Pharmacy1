package Manage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Manage_Customer {

    /*
    This class has all the information of a customer
    Customer_Name : the name of the customer
    Customer_Location : living location of the customer
    Customer_HealthProblems : the deases of the customer
    Customer_DateOfCreation : the date when we saved this customer in "Customers.txt" file
    Customer_Gender : the gender of this customer
    Customer_Age : the age of this customer
    Customer_PhoneNumber : the number of customer's phone
     */
    private String Customer_Name, Customer_Location, Customer_HealthProblems, Customer_DateOfCreation;
    private char Customer_Gender;
    private int Customer_Age, Customer_PhoneNumber;

    public Manage_Customer() { // Constructure

    }

    public Manage_Customer(String name, String loc, String hp, String d, char g, int age, int num) { // Constructure
        this.Customer_Name = name;
        this.Customer_Location = loc;
        this.Customer_HealthProblems = hp;
        this.Customer_DateOfCreation = d;
        this.Customer_Gender = g;
        this.Customer_Age = age;
        this.Customer_PhoneNumber = num;
    }

    public Manage_Customer(Manage_Customer RC) { // Constructure
        this.Customer_Name = RC.getCustomer_Name();
        this.Customer_Location = RC.getCustomer_Location();
        this.Customer_HealthProblems = RC.getCustomer_HealthProblems();
        this.Customer_DateOfCreation = RC.getCustomer_DateOfCreation();
        this.Customer_Gender = RC.getCustomer_Gender();
        this.Customer_Age = RC.getCustomer_Age();
        this.Customer_PhoneNumber = RC.getCustomer_PhoneNumber();
    }

    public String getCustomer_Name() { // Get the name of this customer
        return this.Customer_Name;
    }

    public void setCustomer_Name(String name) { // Set the name of this customer
        this.Customer_Name = name;
    }

    public String getCustomer_Location() { // Get the location of this customer
        return this.Customer_Location;
    }

    public void setCustomer_Location(String l) { // Set the location of this customer
        this.Customer_Location = l;
    }

    public int getCustomer_Age() { // Get the age of this customer
        return this.Customer_Age;
    }

    public void setCustomer_Age(int age) { // Set the age of this customer
        this.Customer_Age = age;
    }

    public char getCustomer_Gender() { // Get the gender of this customer
        return this.Customer_Gender;
    }

    public void setCustomer_Gender(char g) { // Set the gender of this customer
        this.Customer_Gender = g;
    }

    public int getCustomer_PhoneNumber() { // Get the phone number of this customer
        return this.Customer_PhoneNumber;
    }

    public void setCustomer_PhoneNumber(int n) { // Set the phone number of this customer
        this.Customer_PhoneNumber = n;
    }

    public String getCustomer_HealthProblems() { // Get the problems of this customer (Health problms)
        return this.Customer_HealthProblems;
    }

    public void setCustomer_HealthProblems(String h) { // Set the problems of this customer
        this.Customer_HealthProblems = h;
    }

    public String getCustomer_DateOfCreation() { // Get the Date of creation , when we saved this customer in "Customer.txt" file
        return this.Customer_DateOfCreation;
    }

    public void setCustomer_DateOfCreation(String d) { // Set the date of creation
        this.Customer_DateOfCreation = d;
    }

    public boolean Verification_Name(String name) {

        /*
        This methode will verify if the name of this customer is already exist in "Customer.txt" file of not
        it will return true of it exists , false if it doesn't
         */
        try {
            FileInputStream File = new FileInputStream("Customers.txt");
            ObjectInputStream Obj = new ObjectInputStream(File);
            Manage_Customer rc;
            while ((rc = (Manage_Customer) Obj.readObject()) != null) {
                if (rc.getCustomer_Name() == name) {
                    return true;
                }
            }
            Obj.close();
            File.close();
        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        } catch (ClassNotFoundException e) {

        }

        return false;
    }

    public void Modify_CustomerLocation(Manage_Customer Customer, String loc) {

        /*
        This methode for modify the location of a customer
        First of all : we will verify if this customer is saved in "Customer.txt" file
        if it exists , we will search for this customer in the file and we will modify the location to the variable "loc"
        we are using "TCustomer.txt" file
         */
        if (Verification_Name(Customer.getCustomer_Name())) {
            try {
                FileInputStream File = new FileInputStream("Customers.txt");
                ObjectInputStream Obj = new ObjectInputStream(File);
                FileOutputStream TFile = new FileOutputStream("TCustomers.txt");
                ObjectOutputStream TObj = new ObjectOutputStream(TFile);
                Manage_Customer rc;
                while ((rc = (Manage_Customer) Obj.readObject()) != null) {
                    if (rc.equals(Customer)) {
                        rc.setCustomer_Location(loc);
                        TObj.writeObject(rc);
                    } else {
                        TObj.writeObject(rc);
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
                FileInputStream File = new FileInputStream("TCustomers.txt");
                ObjectInputStream Obj = new ObjectInputStream(File);
                FileOutputStream TFile = new FileOutputStream("Customers.txt");
                ObjectOutputStream TObj = new ObjectOutputStream(TFile);
                Manage_Customer rc;
                while ((rc = (Manage_Customer) Obj.readObject()) != null) {
                    TObj.writeObject(rc);
                }
                Obj.close();
                File.close();
                TObj.close();
                TFile.close();
            } catch (FileNotFoundException e) {

            } catch (IOException e) {

            } catch (ClassNotFoundException e) {

            }
        } else {
            System.out.println("Not Found");
        }

    }

    public void Modify_CustomerAge(Manage_Customer Customer, int age) {

        /*
        This methode will modify the age of a customer
        first we will verify if this customer is existing in "Customer.txt" or not
        if it exists we will modify the age
         */
        if (Verification_Name(Customer.getCustomer_Name())) {
            try {
                FileInputStream File = new FileInputStream("Customers.txt");
                ObjectInputStream Obj = new ObjectInputStream(File);
                FileOutputStream TFile = new FileOutputStream("TCustomers.txt");
                ObjectOutputStream TObj = new ObjectOutputStream(TFile);
                Manage_Customer rc;
                while ((rc = (Manage_Customer) Obj.readObject()) != null) {
                    if (rc.equals(Customer)) {
                        rc.setCustomer_Age(age);
                        TObj.writeObject(rc);
                    } else {
                        TObj.writeObject(rc);
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
                FileInputStream File = new FileInputStream("TCustomers.txt");
                ObjectInputStream Obj = new ObjectInputStream(File);
                FileOutputStream TFile = new FileOutputStream("Customers.txt");
                ObjectOutputStream TObj = new ObjectOutputStream(TFile);
                Manage_Customer rc;
                while ((rc = (Manage_Customer) Obj.readObject()) != null) {
                    TObj.writeObject(rc);
                }
                Obj.close();
                File.close();
                TObj.close();
                TFile.close();
            } catch (FileNotFoundException e) {

            } catch (IOException e) {

            } catch (ClassNotFoundException e) {

            }
        } else {
            System.out.println("Not Found");
        }

    }

    public void Modify_CustomerPhoneNumber(Manage_Customer Customer, int phone_num) {

        /*
        This methode will moify the Phone Number of a customer
        first we will verify if this customer is existing in "Customer.txt"
        if it exists we will modify it
         */
        if (Verification_Name(Customer.getCustomer_Name())) {
            try {
                FileInputStream File = new FileInputStream("Customers.txt");
                ObjectInputStream Obj = new ObjectInputStream(File);
                FileOutputStream TFile = new FileOutputStream("TCustomers.txt");
                ObjectOutputStream TObj = new ObjectOutputStream(TFile);
                Manage_Customer rc;
                while ((rc = (Manage_Customer) Obj.readObject()) != null) {
                    if (rc.equals(Customer)) {
                        rc.setCustomer_PhoneNumber(phone_num);
                        TObj.writeObject(rc);
                    } else {
                        TObj.writeObject(rc);
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
                FileInputStream File = new FileInputStream("TCustomers.txt");
                ObjectInputStream Obj = new ObjectInputStream(File);
                FileOutputStream TFile = new FileOutputStream("Customers.txt");
                ObjectOutputStream TObj = new ObjectOutputStream(TFile);
                Manage_Customer rc;
                while ((rc = (Manage_Customer) Obj.readObject()) != null) {
                    TObj.writeObject(rc);
                }
                Obj.close();
                File.close();
                TObj.close();
                TFile.close();
            } catch (FileNotFoundException e) {

            } catch (IOException e) {

            } catch (ClassNotFoundException e) {

            }
        } else {
            System.out.println("Not Found");
        }

    }

    public void Modify_CustomerHealthProblems(Manage_Customer Customer, String healthp) {

        /*
        This methode will modify the health problems of a customer
         */
        if (Verification_Name(Customer.getCustomer_Name())) {
            try {
                FileInputStream File = new FileInputStream("Customers.txt");
                ObjectInputStream Obj = new ObjectInputStream(File);
                FileOutputStream TFile = new FileOutputStream("TCustomers.txt");
                ObjectOutputStream TObj = new ObjectOutputStream(TFile);
                Manage_Customer rc;
                while ((rc = (Manage_Customer) Obj.readObject()) != null) {
                    if (rc.equals(Customer)) {
                        rc.setCustomer_HealthProblems(healthp);
                        TObj.writeObject(rc);
                    } else {
                        TObj.writeObject(rc);
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
                FileInputStream File = new FileInputStream("TCustomers.txt");
                ObjectInputStream Obj = new ObjectInputStream(File);
                FileOutputStream TFile = new FileOutputStream("Customers.txt");
                ObjectOutputStream TObj = new ObjectOutputStream(TFile);
                Manage_Customer rc;
                while ((rc = (Manage_Customer) Obj.readObject()) != null) {
                    TObj.writeObject(rc);
                }
                Obj.close();
                File.close();
                TObj.close();
                TFile.close();
            } catch (FileNotFoundException e) {

            } catch (IOException e) {

            } catch (ClassNotFoundException e) {

            }
        } else {
            System.out.println("Not Found");
        }

    }

    public void Create_Customer(Manage_Customer Customer) {

        /*
        This methode will add a customer to the file "Customer.txt"
        first of all : we will make sure if this customer is exising in "Customer.txt" of not
        if it doesn't exisit we will add
        if it does we won't
         */
        if (!Verification_Name(Customer.getCustomer_Name())) {
            try {
                FileInputStream File = new FileInputStream("Customers.txt");
                ObjectInputStream Obj = new ObjectInputStream(File);
                FileOutputStream TFile = new FileOutputStream("TCustomers.txt");
                ObjectOutputStream TObj = new ObjectOutputStream(TFile);
                Manage_Customer rc;
                while ((rc = (Manage_Customer) Obj.readObject()) != null) {
                    TObj.writeObject(rc);
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
                FileInputStream File = new FileInputStream("TCustomers.txt");
                ObjectInputStream Obj = new ObjectInputStream(File);
                FileOutputStream TFile = new FileOutputStream("Customers.txt");
                ObjectOutputStream TObj = new ObjectOutputStream(TFile);
                Manage_Customer rc;
                TObj.writeObject(Customer);
                while ((rc = (Manage_Customer) Obj.readObject()) != null) {
                    TObj.writeObject(rc);
                }
                Obj.close();
                File.close();
                TObj.close();
                TFile.close();
            } catch (FileNotFoundException e) {

            } catch (IOException e) {

            } catch (ClassNotFoundException e) {

            }
        } else {
            System.out.println("Already Here!!!!");
        }
    }

}
