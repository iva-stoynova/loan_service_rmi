/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package m22763project4;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import javax.swing.JTextArea;

/**
 *
 * @author Iwa Stojnowa
 */
public class LoanServiceImpl  extends UnicastRemoteObject implements LoanService{

     private Logs log;
    private HashMap<String, RateExchange> rates;
   // private static int id;
  

     // Initializes log

    public LoanServiceImpl(JTextArea aServerLog) throws RemoteException {
        super();
        log = new Logs(aServerLog);

        rates = Rates.loadRates(log);
    }

   
   // Get currency codes
    
    public String[] getCurrenciesCodes() throws RemoteException {
        String[] codes = rates.keySet().toArray(new String[rates.keySet().size()]);
        return codes;
    }

   
    // getPayments method for get information about amounts


    public HashMap<String, Double> getPayments(double aAnnualInterestRate, int aYears, String aCurrencyCode, double aAmount, int id, String s)
            throws RemoteException {


        log.log("New loan calculation request. Client IP " + s +"Client ID:" + id);

        double totalAmount = (aAmount + aAmount * aYears * aAnnualInterestRate / 100) * rates.get(aCurrencyCode).getRate();
        HashMap<String, Double> result = new HashMap<String, Double>();
        result.put("monthly", totalAmount / (aYears * 12));
        result.put("total", totalAmount);

        log.log(String.format(
                "Annual interest rate: %.2f\nYears: %d\nCurrency: %s\nAmmount: %.2f\nMonthly amount: %.2f\nTotal amount: %.2f\n\n",
                aAnnualInterestRate, aYears, aCurrencyCode, aAmount, result.get("monthly"), result.get("total")));
        return result;
    }

    private static int cntconn;
    public int clientConnect(String ipAddress) throws RemoteException {
        cntconn++;
        log.log("Client connected from ip address: " + ipAddress);
        return cntconn;
    }
}
