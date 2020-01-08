package Buy;

import Users.Account;

public class Buy_Online {

    /*
    This class allow customer to buy a product online by credit card
    Card_Number : the number of the credit card
     */
    private int Card_Number;

    public Buy_Online() { // Constructure

    }

    public Buy_Online(int num) { // Constructure
        this.Card_Number = num;
    }

    public int getCard_Number() { // Get the Number of the credit card
        return this.Card_Number;
    }

    public void setCard_Number(int n) { // Set the Number of the credit card
        this.Card_Number = n;
    }

    public void Buy_Oberation() {

        /*
        This methode will allow the customer to buy a product online
         */
    }

    public boolean Verification_Account(Account Email) {

        /*
        This methode will make sure that if the Email of the customer is exist or not
        this methode will return true of it exists , and false if it doesn't
         */
        return true;
    }

    public boolean Verification_Card(int Card_Number) {

        /*
        This methode will make sure that if the Card Number of the credit card is exist or not
        this methode will return true of it exists , and false if it doesn't
         */
        return true;
    }

}
