package jhotel;
/**
 * Write a description of class SingleRoom here.
 *
 * @author
 * @version (a version number or a date)
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

    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param
     * @return    the sum of x and y
     */
    public TipeKamar getTipeKamar()
    {
        return TIPE_KAMAR;
    }
}
