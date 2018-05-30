/**
 *
 * @author Derni Ageng
 * @version 2018.03.10
 */
package jhotel;
import java.util.*;


/**
 * Class DatabaseRoom
 *
 * @author Derni Ageng
 * @version 2018
 */
public class DatabaseRoom
{

    private static ArrayList<Room> ROOM_DATABASE = new ArrayList<Room>();


    public DatabaseRoom()
    {
        // initialise instance variables

    }
    /**
     * Metode untuk menambah Room ada database
     * @return boolean mengembalikan apakah penambahan berhasil atau tidak.
     * @param baru room baru
     *
     */
    public static boolean addRoom(Room baru) throws RoomSudahAdaException
    {
        for(Room kamar : ROOM_DATABASE)
        {
            if(kamar.getHotel().equals(baru.getHotel()) &&
                    kamar.getNomorkamar().equals(baru.getNomorkamar()))
            {
                throw new RoomSudahAdaException(kamar);
                //return false;
            }
        }

        ROOM_DATABASE.add(baru);
        return true;
    }

    /**
     * Method yang digunakan untuk mencari kamar dari database.
     * @param hotel
     * @param nomor_kamar input customer yang akan dimasukkan kedalam database
     * @return kamar
     */
    public static Room getRoom(Hotel hotel, String nomor_kamar){
        for (int i = 0; i < ROOM_DATABASE.size(); i++) {
            Room tes = ROOM_DATABASE.get(i);
            if (tes.getHotel().equals(hotel)&&tes.getNomorkamar().equals(nomor_kamar)){
                return tes;
            }
        }
        return null;
    }

    /**
     * Method yang digunakan untuk mengambil ArrayList room yang berasal dari hotel
     *
     * @param hotel berisi objek Hotel
     * @return tempRoom
     */
    public static ArrayList<Room> getRoomsFromHotel(Hotel hotel){
        ArrayList<Room> REQUEST_ROOM = new ArrayList<Room>();
        for (int i = 0; i < ROOM_DATABASE.size(); i++) {
            Room tes = ROOM_DATABASE.get(i);
            if (tes.getHotel().equals(hotel)){
                REQUEST_ROOM.add(tes);
            }
        }
        return REQUEST_ROOM;
    }

    /**
     * Method yang digunakan untuk mencari kamar kosong dari database.
     *
     * @return tempRoom
     */
    public static ArrayList<Room> getVacantRooms(){
        ArrayList<Room> REQUEST_ROOM = new ArrayList<Room>();
        for (int i = 0; i < ROOM_DATABASE.size(); i++) {
            Room tes = ROOM_DATABASE.get(i);
            if (tes.getStatusKamar()==StatusKamar.Status_3){
                REQUEST_ROOM.add(tes);
            }
        }
        return REQUEST_ROOM;
    }

    /**
     * Method yang digunakan untuk menghapus kamar dari dalam database.
     * @param hotel
     * @param nomor_kamar
     * input nomor kamar yang akan dihapus dari database
     *
     * @return true
     */
    public static boolean removeRoom(Hotel hotel, String nomor_kamar) throws RoomTidakDitemukanException
    {
        for (int i = 0; i < ROOM_DATABASE.size(); i++) {
            Room tes = ROOM_DATABASE.get(i);
            if (tes.getHotel().equals(hotel) && tes.getNomorkamar() == nomor_kamar) {
                if (DatabasePesanan.getPesananAktif(tes) != null) {
                    Administrasi.pesananDibatalkan(tes);
                }

                if (ROOM_DATABASE.remove(tes)) {
                    return true;
                }
            }
        }
        throw new RoomTidakDitemukanException(hotel,nomor_kamar);

    }

    /**
     * Method yang digunakan untuk mengembalikan database kamar.
     * @return ArrayList<Room> mengembalikan database kamar.
     */
    public static ArrayList<Room> getRoomDatabase()
    {
        return ROOM_DATABASE;
    }
}
