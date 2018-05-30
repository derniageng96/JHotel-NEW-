package jhotel;
import java.util.ArrayList;

/**
 * Class DatabaseHotel ini berisi database si booking
 * @author Derni Ageng
 * @version 2018.03.10
 */

public class DatabaseHotel
{
    private static ArrayList<Hotel> HOTEL_DATABASE = new ArrayList<Hotel>();
    private static int LAST_HOTEL_ID = 0;

    /**
     * Constructor for objects of class DatabaseHotel
     */
    public DatabaseHotel()
    {
        // initialise instance variables

    }
    /**
     * Metode untuk menambah Hotel
     *
     * @param baru hotel baru
     *
     */
    public static boolean addHotel(Hotel baru) throws HotelSudahAdaException
    {
        for (int i = 0; i < HOTEL_DATABASE.size(); i++) {
            Hotel tes = HOTEL_DATABASE.get(i);
            if (tes.getID()==baru.getID()||
                    (tes.getNama().equals(baru.getNama()) &&
                            tes.getLokasi().equals(baru.getLokasi()))){
                throw new HotelSudahAdaException(tes);
                //return false;
            }
        }
        LAST_HOTEL_ID=baru.getID();
        HOTEL_DATABASE.add(baru);
        return true;
    }

    /**
     * Metode untuk menghapus hotel
     *
     * @return LAST_HOTEL_ID id hotel
     *
     */
    public static int getLastHotelId(){
        return LAST_HOTEL_ID;
    }

    /**
     * Method untuk menghapus data hotel.
     *
     * @return false
     */
    public static boolean removeHotel(int id) throws HotelTidakDitemukanException
    {
        for (int i = 0; i < HOTEL_DATABASE.size(); i++) {
            Hotel tes = HOTEL_DATABASE.get(i);
            if (tes.getID()==id){
                ArrayList<Room> KAMAR_TEST = DatabaseRoom.getRoomsFromHotel(tes);
                for (int x = 0; x < KAMAR_TEST.size(); x++){
                    Room kamar = KAMAR_TEST.get(x);
                    try {
                        DatabaseRoom.removeRoom(tes, kamar.getNomorkamar());
                    } catch (RoomTidakDitemukanException test){
                        System.out.println(test.getPesan());
                    }
                }
                if(HOTEL_DATABASE.remove(tes))
                {
                    return true;
                }
            }
        }
        throw new HotelTidakDitemukanException(id);
    }

    /**
     * Method untuk mendapatkan hotel dengan id yang ditentukan
     *
     * @param id
     * @return hotel
     */
    public static Hotel getHotel(int id){
        for (int i = 0; i < HOTEL_DATABASE.size(); i++) {
            Hotel tes = HOTEL_DATABASE.get(i);
            if (tes.getID()==id){
                return tes;
            }
        }
        return null;
    }
    /**
     * Method untuk membuat arraylist berisi hotel
     *
     * @return HOTEL_DATABASE
     */
    public static ArrayList<Hotel> getHotelDatabase()
    {
        return HOTEL_DATABASE;
    }
}
