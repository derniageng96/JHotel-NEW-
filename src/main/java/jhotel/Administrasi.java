package jhotel;
/**
 * Write a description of class Administrasi here.
 *
 * @author Derni Ageng
 * @version (a version number or a date)
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
    public static void pesananDibatalkan(Room kamar)
    {
        //Pesanan pesanTemp = new Pesanan();

        Pesanan pesanTemp = DatabasePesanan.getPesananAktif(kamar);
        pesanTemp.setStatusSelesai(false);
        pesanTemp.setStatusDiproses(false);

        pesanTemp.setStatusAktif(false);

        roomLepasPesanan(kamar);

    }

    public static void pesananSelesai(Room kamar)
    {
        //Pesanan pesan = new Pesanan();
        Pesanan pesan = DatabasePesanan.getPesananAktif(kamar);
        pesan.setStatusSelesai(true);
        pesan.setStatusDiproses(false);
        pesan.setStatusAktif(false);
        roomLepasPesanan(kamar);
      
    }

    public static void pesananDibatalkan(Pesanan pesan) 
    {
        //roomLepasPesanan(pesan.getRoom());
        
        //pesan.setStatusSelesai(false);
        //pesan.setStatusDiproses(false);
        //pesan.setStatusAktif(false);
        //pesan.setRoom(null);
        roomLepasPesanan(pesan.getRoom());

        pesan.setStatusSelesai(false);
        pesan.setStatusDiproses(false);
        pesan.setStatusAktif(false);
    }

    public static void roomLepasPesanan(Room kamar)
    {
        kamar.setStatusKamar(StatusKamar.Status_3);
    }
    public static void pesananSelesai(Pesanan pesan)
    {
        //roomLepasPesanan(pesan.getRoom());
        //Pesanan pesan1 = new Pesanan();
        //pesan1.setStatusAktif(false);
        roomLepasPesanan(pesan.getRoom());

        pesan.setStatusSelesai(true);
        pesan.setStatusDiproses(false);
        pesan.setStatusAktif(false);
    }
    
}



