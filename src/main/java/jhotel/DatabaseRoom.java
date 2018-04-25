/**
 *
 * @author Derni Ageng
 * @version 2018.03.10
 */
package jhotel;
import java.util.*;
// Class ini digunakan untuk memproses data Room

public class DatabaseRoom
{

    private static ArrayList<Room> ROOM_DATABASE = new ArrayList<Room>();
    /*
     * Deklarasi variable
     */

    /**
     * Metode untuk menambah Room
     *
     * @param baru room baru
     *
     */
    public static boolean addRoom(Room baru) throws RoomSudahAdaException
    {
        for (int i = 0; i < ROOM_DATABASE.size(); i++) {
            Room tes = ROOM_DATABASE.get(i);
            if (tes.getHotel().equals(baru.getHotel())&&tes.getNomorkamar().equals(baru.getNomorkamar())){
                throw new RoomSudahAdaException(tes);
                //return false;
            }
        }
        ROOM_DATABASE.add(baru);
        return true;
    }

    /**
     * Metode untuk menghapus room
     *
     * @param hotel Hotel
     * @param nomor_kamar nomer
     * @return null
     *
     */
    public static Room getRoom(Hotel hotel, String nomor_kamar){
        for(Room kamar : ROOM_DATABASE)
        {
            if(kamar.getHotel().equals(hotel) &&
                    kamar.getNomorkamar().equals(nomor_kamar))
            {
                return kamar;
            }
        }

        return null;
    }

    /**
     * Metode untuk menghapus room
     *
     * @param hotel Hotel
     * @return null
     *
     */
    public static ArrayList<Room> getRoomsFromHotel(Hotel hotel){
        ArrayList<Room> tempRoom = new ArrayList<Room>();

        for(Room kamar : ROOM_DATABASE)
        {
            if(kamar.getHotel().equals(hotel))
            {
                tempRoom.add(kamar);
            }
        }

        return tempRoom;
    }

    /**
     * Metode untuk menghapus room
     *
     * @return null
     *
     */
    public static ArrayList<Room> getVacantRooms(){
        ArrayList<Room> tempRoom = new ArrayList<Room>();

        for(Room kamar : ROOM_DATABASE)
        {
            if(kamar.getStatusKamar().equals(StatusKamar.Status_3))
            {
                tempRoom.add(kamar);
            }
        }

        return tempRoom;
    }

    /**
     * Metode untuk menghapus room
     *
     * @param hotel Hotel
     * @param nomor_kamar nomer
     *
     */
    public static boolean removeRoom(Hotel hotel, String nomor_kamar) throws RoomTidakDitemukanException
    {
        for(Room kamar : ROOM_DATABASE)
        {
            if(kamar.getHotel().equals(hotel) &&
                    kamar.getNomorkamar().equals(nomor_kamar))
            {
                Administrasi.pesananDibatalkan(kamar);
                if(ROOM_DATABASE.remove(kamar))
                {
                    return true;
                }
            }
        }
        throw new RoomTidakDitemukanException(hotel, nomor_kamar);
        //return false;
    }

    /**
     * Metode untuk mengambil data di database
     *
     */
    public static ArrayList<Room> getRoomDatabase()
    {
        return ROOM_DATABASE;
    }
}
