package Users;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class User {
    
    private String User_Name, Type, PassWord;
    
    public User() {
        
    }
    
    public User(String name, String Pw, String type) {
        this.User_Name = name;
        this.PassWord = Pw;
        this.Type = type;
    }
    
    public User(User u) {
        this.User_Name = u.getUser_Name();
        this.PassWord = u.getPassWord();
        this.Type = u.getType();
    }
    
    public String getUser_Name() {
        return this.User_Name;
    }
    
    public void setUser_Name(String name) {
        this.User_Name = name;
    }
    
    public void setPassWord(String PW) {
        this.PassWord = PW;
    }
    
    public String getPassWord() {
        return this.PassWord;
    }
    
    public String getType() {
        return this.Type;
    }
    
    public void setType(String t) {
        this.Type = t;
    }
    
    public void Create_User(User us) throws FileNotFoundException, IOException, ClassNotFoundException {
        boolean OK = false;
        try {
            FileInputStream File1 = new FileInputStream("Users.txt");
            ObjectInputStream Obj1 = new ObjectInputStream(File1);
            User tu;
            while ((tu = (User) Obj1.readObject()) != null) {
                if (tu.equals(us)) {
                    OK = true;
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            
        } catch (IOException e) {
            
        } catch (ClassNotFoundException e) {
            
        }
        
        if (!OK) {
            try {
                FileOutputStream File = new FileOutputStream("TUsers.txt");
                FileInputStream TFile = new FileInputStream("Users.txt");
                ObjectOutputStream Obj = new ObjectOutputStream(File);
                ObjectInputStream TObj = new ObjectInputStream(TFile);
                User u;
                while ((u = (User) TObj.readObject()) != null) {
                    Obj.writeObject(u);
                }
                File.close();
                TFile.close();
                Obj.close();
                TObj.close();
            } catch (FileNotFoundException e) {
                
            } catch (IOException e) {
                
            } catch (ClassNotFoundException e) {
                
            }
            
            try {
                FileOutputStream File = new FileOutputStream("Users.txt");
                FileInputStream TFile = new FileInputStream("TUsers.txt");
                ObjectOutputStream Obj = new ObjectOutputStream(File);
                ObjectInputStream TObj = new ObjectInputStream(TFile);
                User u;
                Obj.writeObject(us);
                while ((u = (User) TObj.readObject()) != null) {
                    Obj.writeObject(u);
                }
                File.close();
                TFile.close();
                Obj.close();
                TObj.close();
            } catch (FileNotFoundException e) {
                
            } catch (IOException e) {
                
            } catch (ClassNotFoundException e) {
                
            }
        }
    }
    
    public boolean Log_in(User us) throws FileNotFoundException, IOException, ClassNotFoundException {
        
        try {
            FileInputStream File = new FileInputStream("Users.txt");
            ObjectInputStream Obj = new ObjectInputStream(File);
            User u;
            while ((u = (User) Obj.readObject()) != null) {
                if (u.equals(us)) {
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
    
    public void Log_Out() {
        
    }
    
}
