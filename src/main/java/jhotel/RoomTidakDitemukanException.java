package jhotel;
/**
 * Class RoomTidakDitemukanException
 *
 * @author Derni Ageng
 * @version 2018
 */
public class RoomTidakDitemukanException extends Exception
{
    private Hotel hotel_error;
    private String room_error;

    /**
     * Constructor dari kelas exception RoomTidakDitemukan
     * @param hotel_input, room_input
     */
    public RoomTidakDitemukanException(Hotel hotel_input, String room_input)
    {
        super("Kamar yang terletak di ");
        hotel_error=hotel_input;
        room_error=room_input;
    }

    /**
     * Method yang digunakan untuk mendapatkan pesan Exception.
     * @return String nilai pesan error.
     */
    public String getPesan()
    {
        return super.getMessage() + hotel_error + " dan dengan nomor kamar " + room_error + "tidak ditemukan.";
    }
}
