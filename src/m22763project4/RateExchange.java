/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package m22763project4;

import java.io.Serializable;

/**
 *
 * @author Iwa Stojnowa
 */
public class RateExchange implements Serializable {

     private String rateCode;
    private double rate;

    public String getCode() {
        return rateCode;
    }

    public void setCode(String code) {
        this.rateCode = code;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double r) {
        this.rate = r;
    }

}
