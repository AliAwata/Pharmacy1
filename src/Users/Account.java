package Users;

import Manage.Regist_Customer;

public class Account {

    private String Account_PassWord, Account_Email, Account_RecoveryMail;
    private Regist_Customer Account_Customer;

    public Account() {

    }

    public Account(String acpw, String e, String re, Regist_Customer AC) {
        this.Account_PassWord = acpw;
        this.Account_Email = e;
        this.Account_RecoveryMail = re;
        this.Account_Customer = new Regist_Customer();
        this.Account_Customer = AC;
    }

    public Account(Account A) {
        this.Account_PassWord = A.getAccount_PassWord();
        this.Account_Email = A.getAccount_Email();
        this.Account_RecoveryMail = A.getAccount_RecoveryMail();
        this.Account_Customer = new Regist_Customer();
        this.Account_Customer = A.getAccount_Customer();
    }

    public String getAccount_PassWord() {
        return this.Account_PassWord;
    }

    public void setAccount_PassWord(String pw) {
        this.Account_PassWord = pw;
    }

    public String getAccount_Email() {
        return this.Account_Email;
    }

    public void setAccount_Email(String e) {
        this.Account_Email = e;
    }

    public String getAccount_RecoveryMail() {
        return this.Account_RecoveryMail;
    }

    public void setAccount_RecoveryMail(String m) {
        this.Account_RecoveryMail = m;
    }

    public Regist_Customer getAccount_Customer() {
        return this.Account_Customer;
    }

    public void setAccount_Customer(Regist_Customer rc) {
        this.Account_Customer = new Regist_Customer();
        this.Account_Customer = rc;
    }

    public Account Log_In_Customer(Account Online_Customer) {
        return Online_Customer;
    }

    public Account Log_Out_Customer(Account Online_Customer) {
        return Online_Customer;
    }

    public void Store_Customer(Regist_Customer Account_Customer) {

    }

}
