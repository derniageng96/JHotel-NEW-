package jhotel;
/**
 * class SingleRoom here.
 *
 * @author Derni Ageng
 * @version 2018
 */
public class SingleRoom extends Room
{
    // instance variables - replace the example below with your own
    private static TipeKamar TIPE_KAMAR = TipeKamar.Tipe_1;

    /**
     * Constructor for objects of class SingleRoom
     */
    public SingleRoom(Hotel hotel, String nomor_kamar)
    {
        // initialise instance variables
        super(hotel,nomor_kamar);
        setDailyTariff(50000);
    }

    /**
     * Method untuk mendapatkan nilai tipe kamar
     *
     * @return TIPE_KAMAR
     */
    public TipeKamar getTipeKamar()
    {
        return TIPE_KAMAR;
    }

    /**
     * menentukan nilai daily tarif
     *
     * @param dailytariff nilai daily tariff
     */
    public void setDailyTariff(double dailytariff)
    {
        dailyTariff = dailytariff;
    }
}
