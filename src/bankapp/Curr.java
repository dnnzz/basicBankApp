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
public enum Curr {
    US_DOLLAR(0),
    AUSTRALIAN_DOLLAR(1),
    DANISH_KRONE(2),
    EURO(3),
    POUND_STERLING(4),
    SWISS_FRANK(5),
    SWEDISH_KRONA(6),
    CANADIAN_DOLLAR(7),
    KUWAITI_DINAR(8),
    NORWEGIAN_KRONE(9),
    SAUDI_RIYAL(10),
    JAPANESE_YEN(11),
    BULGARIAN_LEV(12),
    NEW_LEU(13),
    RUSSIAN_ROUBLE(14),
    IRANIAN_RIAL(15),
    CHINESE_RENMINBI(16),
    PAKISTANI_RUPEE(17),
    QATARI_RIAL(18);


    int value;
    private Curr(int i){

        value = i;

    }
    
}
