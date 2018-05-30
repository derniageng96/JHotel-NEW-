package jhotel;
/**
 * class PremiumRoom here.
 *
 * @author Derni Ageng
 * @version 2018
 */
public class PremiumRoom extends Room
{
    // instance variables - replace the example below with your own
    private static double DISCOUNT = 0.3;
    private static TipeKamar TIPE_KAMAR = TipeKamar.Tipe_3;

    /**
     * Constructor for objects of class PremiumRoom
     */
    public PremiumRoom(Hotel hotel, String nomor_kamar)
    {
        super(hotel, nomor_kamar);
        DISCOUNT = 0.3;
    }

    /**
     * mendaptkan nilai tipe kamar
     *
     * @return TIPE_KAMAR
     */
    public TipeKamar getTipeKamar()
    {
        // put your code here
        return TIPE_KAMAR;
    }

    /**
     * mendapatkan nilai diskon
     *
     * @return DISCOUNT
     */
    public double getDiscount()
    {
        return DISCOUNT;
        
    }

    /**
     * menentukan nilai tarif harian
     *
     * @param dailytariff nilai daily tariff
     */
    public void setDailyTariff(double dailytariff)
    {
        //this.dailytariff=dailytariff;
        this.dailyTariff = dailytariff * DISCOUNT;
        //dailytariff * DISCOUNT;
    }
}
