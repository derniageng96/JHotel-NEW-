package jhotel;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

/**
 * class DatabasePesanan untuk menampilkan database pesanan.
 *
 * @author Derni Ageng
 * @version 03/01/2018
 */

public class DatabasePesanan {
    // instance variables - replace the example below with your own
    //private String[] list_pesanan;
    private static ArrayList<Pesanan> PESANAN_DATABASE = new ArrayList<Pesanan>();
    private static int LAST_PESANAN_ID = 0;

    public static ArrayList<Pesanan> getPesananDatabase(){
        return PESANAN_DATABASE;
    }
    public static int getLastPesananId(){
        return LAST_PESANAN_ID;
    }

    /**
     * method untuk menambah pesanan baru
     *
     * @return false
     */
    public static boolean addPesanan(Pesanan baru) throws PesananSudahAdaException {
        for (int i = 0; i < PESANAN_DATABASE.size(); i++) {
            Pesanan tes = PESANAN_DATABASE.get(i);
            if (tes.getStatusAktif()==true&&tes.getID()==baru.getID()){
                //return false;
                throw new PesananSudahAdaException(tes);
            }

        }
        LAST_PESANAN_ID=baru.getID();
        PESANAN_DATABASE.add(baru);
        return true;
    }

    /**
     * method untuk menghapus data pesanan
     *
     * @return false
     */

    public static boolean removePesanan(Customer cust) throws PesananTidakDitemukanException
    {
        for(Pesanan pesanan : PESANAN_DATABASE){
            if(pesanan.getPelanggan().equals(cust)){
                if(pesanan.getRoom() != null){
                    Administrasi.pesananDibatalkan(pesanan);
                }
                else{
                    if(pesanan.getStatusAktif()){
                        pesanan.setStatusAktif(false);
                    }
                }
                if(PESANAN_DATABASE.remove(pesanan)){
                    return true;
                }
            }
        }
        throw new PesananTidakDitemukanException(cust);
        //return false;
    }

    /**
     * method untuk mendapatkan data pesanan
     *
     * @param
     */

    public static Pesanan getPesanan(Room kamar) {
        for (int i = 0; i < PESANAN_DATABASE.size(); i++) {
            Pesanan tes = PESANAN_DATABASE.get(i);
            if (tes.getRoom().equals(kamar)){
                return tes;
            }
        }
        return null;
        }

        public static Pesanan getPesananAktif (Customer pelanggan)
        {
            for (int i = 0; i < PESANAN_DATABASE.size(); i++) {
                Pesanan tes = PESANAN_DATABASE.get(i);
                if (tes.getStatusAktif()==true&&tes.getPelanggan().equals(pelanggan)){
                    return tes;
                }
            }
            return null;
        }
        /**
         * method untuk mendapatkan data pesanan database
         * @return list_pesanan - list dari pesanan
         */

        /**
         * method untuk membatakan pesanan
         * @param - pesanan
         */

        public static int getLastPesananID ()
        {
            return LAST_PESANAN_ID;
        }
        public Pesanan getPesanan ( int id)
        {
            for (int i = 0; i < PESANAN_DATABASE.size(); i++) {
                Pesanan tes = PESANAN_DATABASE.get(i);
                if (tes.getID()==id){
                    return tes;
                }
            }
            return null;
        }
        public static void pesananDibatalkan(Pesanan pesan)
        {

        }
    }

