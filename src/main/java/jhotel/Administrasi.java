package jhotel;
/**
 * class Administrasi
 *
 * @author Derni Ageng
 * @version 2018
 */
public class Administrasi
{


    /**
     * Constructor for objects of class Administrasi
     */
    public Administrasi()
    {
        // initialise instance variables
        
    }
    /**
     *
     *
     * Class pesananDitugaskan untuk memproses pemesanan kamar hotel
     * @param pesan objek pesanan
     * @param kamar berisi objek Room
     * @
     */
    public static void pesananDitugaskan(Pesanan pesan, Room kamar)
    {
        if(pesan != null && kamar != null)
        {
            if(kamar.getStatusKamar() == StatusKamar.Status_3)
            {
                pesan.setStatusSelesai(false);
                pesan.setStatusDiproses(true);
                pesan.setRoom(kamar);

                roomAmbilPesanan(pesan, kamar);
            }
            else
            {
                pesan.setStatusAktif(false);
            }

        }
    }
    public static void roomAmbilPesanan(Pesanan pesan, Room kamar)
    {
        kamar.setStatusKamar(StatusKamar.Status_1);
    }

    public static void roomLepasPesanan(Room kamar)
    {
        kamar.setStatusKamar(StatusKamar.Status_3);
    }
    /**
     * untuk melakukan pembatalan pesanan.
     *
     * @param kamar berisi objek Room
     */
    public static void pesananDibatalkan(Room kamar)
    {
        Pesanan pesanTemp = DatabasePesanan.getPesananAktif(kamar);
        pesanTemp.setStatusSelesai(false);
        pesanTemp.setStatusDiproses(false);
        pesanTemp.setStatusAktif(false);

        roomLepasPesanan(kamar);

    }
    /**
     * untuk menandakan pesanan telah selesai.
     *
     * @param kamar berisi objek Room
     */
    public static void pesananSelesai(Room kamar)
    {
        Pesanan pesan = DatabasePesanan.getPesananAktif(kamar);
        pesan.setStatusSelesai(true);
        pesan.setStatusDiproses(false);
        pesan.setStatusAktif(false);
        roomLepasPesanan(kamar);
      
    }
    /**
     * untuk melakukan pembatalan pesanan.
     *
     * @param pesan berisi objek Pesanan
     */
    public static void pesananDibatalkan(Pesanan pesan) 
    {
        roomLepasPesanan(pesan.getRoom());
        pesan.setStatusSelesai(false);
        pesan.setStatusDiproses(false);
        pesan.setStatusAktif(false);
        //pesan.setRoom(null);
    }

    /**
     * untuk menandakan pesanan telah selesai.
     *
     * @param pesan berisi objek Pesanan
     */
    public static void pesananSelesai(Pesanan pesan)
    {
        //pesan.getRoom().setStatusKamar(StatusKamar.Status_3);
        roomLepasPesanan(pesan.getRoom());
        pesan.setStatusSelesai(true);
        pesan.setStatusDiproses(false);
        pesan.setStatusAktif(false);
        //pesan.setRoom(null);
    }
    
}



