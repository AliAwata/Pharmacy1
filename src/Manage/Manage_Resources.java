package Manage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Manage_Resources {

    private String Company_Name, Company_Location, Company_Email;
    private int Company_Phone;

    public Manage_Resources() {

    }

    public Manage_Resources(String name, String loc, String e, int num) {
        this.Company_Name = name;
        this.Company_Location = loc;
        this.Company_Email = e;
        this.Company_Phone = num;
    }

    public Manage_Resources(Manage_Resources R) {
        this.Company_Name = R.getCompany_Name();
        this.Company_Location = R.getComapany_Location();
        this.Company_Email = R.getCompany_Email();
        this.Company_Phone = R.getCompany_Phone();
    }

    public String getCompany_Name() {
        return this.Company_Name;
    }

    public void setCompany_Name(String name) {
        this.Company_Name = name;
    }

    public String getComapany_Location() {
        return this.Company_Location;
    }

    public void setCompany_Location(String l) {
        this.Company_Location = l;
    }

    public int getCompany_Phone() {
        return this.Company_Phone;
    }

    public void setCompany_Phone(int n) {
        this.Company_Phone = n;
    }

    public String getCompany_Email() {
        return this.Company_Email;
    }

    public void setCompany_Email(String e) {
        this.Company_Email = e;
    }

    public void Delete_Resources(String name) {

        try {
            FileInputStream File = new FileInputStream("Resources.txt");
            ObjectInputStream Obj = new ObjectInputStream(File);
            FileOutputStream TFile = new FileOutputStream("TResources.txt");
            ObjectOutputStream TObj = new ObjectOutputStream(TFile);
            Manage_Resources rr;
            while ((rr = (Manage_Resources) Obj.readObject()) != null) {
                if (rr.getCompany_Name() != name) {
                    TObj.writeObject(rr);
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
            FileInputStream File = new FileInputStream("TResources.txt");
            ObjectInputStream Obj = new ObjectInputStream(File);
            FileOutputStream TFile = new FileOutputStream("Resources.txt");
            ObjectOutputStream TObj = new ObjectOutputStream(TFile);
            Manage_Resources rr;
            while ((rr = (Manage_Resources) Obj.readObject()) != null) {
                TObj.writeObject(rr);
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
