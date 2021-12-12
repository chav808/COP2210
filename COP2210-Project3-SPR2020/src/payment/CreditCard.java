/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payment;
import client.Person;
import goods.Item;
import java.util.ArrayList;
import java.util.Date;
public class CreditCard {

 Person cardHolder;
 String type;

 String cardNumber;

 double creditLimit;
 double currentBalance;
 double nextPaymentAmount;

 ArrayList<Item> transactions;
 ArrayList<Date> transactionsTimeStamps;

 //---------------------------------------------------------------------------
 // Constructor
 //---------------------------------------------------------------------------

 public CreditCard(Person cardHolder, String type, double creditLimit) {


 // assign the input to the instance variables
 // YOUR CODE HERE
this.cardHolder = cardHolder;
this.type = type;
this.creditLimit = creditLimit;

 transactions = new ArrayList<Item>();
 transactionsTimeStamps = new ArrayList<Date>();
 }

 //---------------------------------------------------------------------------
 // Setters and Getters
 //---------------------------------------------------------------------------
 public Person getCardHolder() {
 return cardHolder;
 }
 public String getType() {
 return type;
 }
 public String getCardNumber() {
 return cardNumber;
 }
 public double getCreditLimit() {
 return creditLimit;
 }
 public void setCreditLimit(double creditLimit, String personal) {
 this.creditLimit = creditLimit;
 }
 public double getCurrentBalance() {
 return currentBalance;
 }
 public double getNextPaymentAmount() {
 return nextPaymentAmount;
 }
 //---------------------------------------------------------------------------
 // Utility Methods
 //---------------------------------------------------------------------------

 public void makeCharge(Item item){
 

 if(creditLimit - currentBalance >= item.getPrice() ){
 transactions.add(item);
 Date date = new Date();
 transactionsTimeStamps.add(date);
 currentBalance += item.getPrice();


 System.out.println("");
 System.out.println("Charging: " + item.getName());
 System.out.println("Transaction completed successfully");
 System.out.println("Please remove your " + type );
 System.out.println("");
 }else{
 System.out.println("");
 System.out.println("Charging: " + item.getName());
 System.out.println("Transaction was not successful");
 System.out.println("Credit Limit Issue");
 System.out.println("Please remove your " + type );
 System.out.println("");
 }

 }//end makeCharge


 public void transactionsReport(){

 System.out.println("");

 System.out.println("============================================================================");
 System.out.println(type + " Transaction Report" );

 System.out.println("============================================================================");
 System.out.printf("%-20s $%-10.2f\n", "Credit Limit:",creditLimit);

 // you need ound the Avaiable Credit
 // YOUR CODE HERE
 System.out.printf("%-20s $%-10.2f\n", "Available Credit:", -currentBalance + creditLimit);

 System.out.printf("%-20s $%-10.2f\n", "Current Balance:", currentBalance);
 System.out.println("------------------------------------------------------------------------");

 double totalCharges = 0.0;

 for(int i=0; i<transactions.size();i++){


 Item item = transactions.get(i);
 Date date = transactionsTimeStamps.get(i);
 System.out.printf("%-20s %-10s $%-10.2f %-10s\n",item.getName(),
 item.getCatagory(),
item.getPrice(),
date.toString() );
 totalCharges += item.getPrice();
 }//end for

 System.out.println("------------------------------------------------------------------------");
 System.out.printf("%-15s Total Charges: $%-10.2f\n","", totalCharges);

 }//end transactionsReport


}