package jhotel;
/**
 * Write a description of class DoubleRoom here.
 *
 * @author Derni Ageng
 * @version 2018
 */
public class DoubleRoom extends jhotel.Room
{
    private Customer customer2;
    private static TipeKamar TIPE_KAMAR = TipeKamar.Tipe_2;

    /**
     * Constructor for objects of class DoubleRoom
     * @param hotel objek hotel
     * @param nomor_kamar nomor kamar
     */
    public DoubleRoom(Hotel hotel, String nomor_kamar)
    {
        super(hotel, nomor_kamar);
    }

    /**
     * Method untuk mengambil nilai objek customer2
     *
     * @return customer2
     */
    public Customer getCustomer2()
    {
        return customer2;
    }

    /**
     * Method untuk mengambil nilai tipe kamar
     *
     * @return TIPE_KAMAR
     */
    public TipeKamar getTipeKamar()
    {
        return TIPE_KAMAR;
        
    }

    /**
     * Method untuk menentukan nilai objek customer2
     *
     * @param customer2 objek customer2
     */
    public void setCustomer2(Customer customer2)
    {
        this.customer2=customer2;
        
    }

    /**
     * Method untuk menentukan daily tarif untuk class DoubleRoom
     *
     * @param dailytariff nilai daily tariff
     */
    public void setDailyTariff(double dailytariff)
    {
        dailyTariff = dailytariff;
    }
}
