/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankapp;

/**
 *
 * @author Dnz
 */
public interface Currency {
    /**
     *
     * @return String current Date
     */
    String getDate();

    /**
     *
     * @return String Money Name
     */
    String getName();

    /**
     *
     * @return float Buying Price
     */
    float getBuyingPrice();

    /**
     *
     * @return float Selling Price
     */
    float getSellingPrice();

    /**
     *
     * @return boolean is Forex
     */
    boolean isForex();
    
}
