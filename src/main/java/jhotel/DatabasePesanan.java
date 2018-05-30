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
    private static ArrayList<Pesanan> PESANAN_DATABASE = new ArrayList<Pesanan>();
    private static int LAST_PESANAN_ID = 0;


    public static ArrayList<Pesanan> getPesananDatabase() {
        return PESANAN_DATABASE;
    }

    /**
     * Method untuk membuat ArrayList berisi pesanan
     *
     * @return PESANAN_DATABASE
     */
    public static int getLastPesananId() {
        return LAST_PESANAN_ID;
    }

    /**
     * Method untuk menambah pesanan ke database
     *
     * @param baru
     *
     */
    public static boolean addPesanan(Pesanan baru) throws PesananSudahAdaException {
        for(Pesanan pesanan : PESANAN_DATABASE)
        {
            if(pesanan.getID() == baru.getID())
            {
                if(pesanan.getStatusAktif() == true)
                {
                    throw new PesananSudahAdaException(pesanan);
                    //return false;
                }
                else
                {
                    LAST_PESANAN_ID = baru.getID();
                    PESANAN_DATABASE.add(baru);
                    return true;
                }
            }
        }
        LAST_PESANAN_ID = baru.getID();
        PESANAN_DATABASE.add(baru);
        return true;

    }

    /**
     * method untuk menghapus data pesanan
     * @param pesan
     * @return false
     */
    public static boolean removePesanan(Pesanan pesan) throws PesananTidakDitemukanException
    {
        for(Pesanan pesanan : PESANAN_DATABASE)
        {
            if(pesanan.equals(pesan))
            {
                if(pesanan.getRoom() != null)
                {
                    Administrasi.pesananDibatalkan(pesanan);
                }
                else
                {
                    if(pesanan.getStatusAktif())
                    {
                        pesanan.setStatusAktif(false);
                    }
                }

                if(PESANAN_DATABASE.remove(pesanan))
                {
                    return true;
                }
            }
        }

        throw new PesananTidakDitemukanException(pesan.getPelanggan());

    }


    /**
     * untuk mengambil data pesanan aktif
     *
     * @param kamar
     * @return pesanan
     */
    public static Pesanan getPesananAktif(Room kamar) {
        for (Pesanan pesanan : PESANAN_DATABASE) {
            if (pesanan.getRoom().equals(kamar) && pesanan.getStatusAktif()) {
                if (pesanan.getStatusAktif() == true) {
                    return pesanan;
                }
            }
        }
        return null;
    }

    /**
     * untuk mengambil data pesanan aktif
     *
     * @param pelanggan berisi objek Customer
     * @return pesanan
     */
    public static Pesanan getPesananAktif(Customer pelanggan) {
        for(Pesanan pesanan : PESANAN_DATABASE){
            if(pesanan.getPelanggan()==pelanggan && pesanan.getStatusAktif()){
                return pesanan;
            }
        }
        return null;
    }

    /**
     * Method untuk mendapatkan ID dari pesanan terakhir
     *
     * @return LAST_PESANAN_ID
     */
    public static int getLastPesananID() {
        return LAST_PESANAN_ID;
    }

    /**
     * Metode untuk mengambil data pesanan
     *
     * @param id
     * @return pesanan
     */
    public static Pesanan getPesanan(int id) {
        for(Pesanan pesanan : PESANAN_DATABASE){
            if(pesanan.getID() == id){
                return pesanan;
            }
        }
        return null;
    }
}

