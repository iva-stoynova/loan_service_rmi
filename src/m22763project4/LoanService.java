/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package m22763project4;

import java.rmi.*;
import java.util.*;

/**
 *
 * @author Iwa Stojnowa
 */
public interface LoanService extends Remote {

      public int clientConnect(String ipAddress) throws RemoteException;


    public HashMap<String, Double> getPayments(double annualInterestRate,
            int years, String currencyCode, double amount, int id, String s) throws RemoteException;

    // getpayments()
    // annualInterestRate - annual interest rate
    // years - loan period
    // currencyCode - currency code
    // hasmap - hashmap with monthly and total payments


    public String[] getCurrenciesCodes() throws RemoteException;

    // String array for dropdown list
}
