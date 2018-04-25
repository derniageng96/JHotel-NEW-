package jhotel;
/**
 * Write a description of class Room here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Room {
    // instance variables - replace the example below with your own
    private Hotel hotel;
    private String nomor_kamar;
    protected double dailyTariff;
    private StatusKamar status_kamar;
    private Pesanan pesan;

    /**
     * Constructor for objects of class Room
     */
    public Room(Hotel hotel, String nomor_kamar) {
        this.hotel = hotel;
        this.nomor_kamar = nomor_kamar;
        //this.isAvailable=isAvailable;
        //this.status_kamar=status_kamar;
        this.dailyTariff = dailyTariff;
        this.status_kamar = status_kamar;

    }


    public Hotel getHotel() {
        // put your code here
        return hotel;
    }

    public String getNomorkamar() {
        return nomor_kamar;
    }

    //public boolean getStatusAvailable()
    //{
    //return isAvailable;
    //}

    public double getDailyTariff() {
        return dailyTariff;
    }

    public StatusKamar getStatusKamar() {
        return status_kamar;
    }

    public Pesanan getPesanan() {
        return pesan;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public void setNomorKamar(String nomor_kamar) {
        this.nomor_kamar = nomor_kamar;
    }

    //public void setStatusAvailable(boolean isAvailable)
    //{
    //this.isAvailable=isAvailable;
    //}

    public void setDailyTariff(double dailytariff) {
        this.dailyTariff = dailytariff;
    }

    public void setStatusKamar(StatusKamar status_kamar) {
        this.status_kamar = status_kamar;
    }

    public void setPesanan(Pesanan pesan) {
        this.pesan = pesan;
    }

    public abstract TipeKamar getTipeKamar();

    public void printData() {

        System.out.println(hotel.getNama());
        System.out.println(nomor_kamar);
        //System.out.println(isAvailable);
        System.out.println(dailyTariff);
        System.out.println(status_kamar);
        //System.out.println(TipeKamar);


    }

    public String toString() {
        if (DatabasePesanan.getPesanan(this) == null) {
            return "\nNama hotel  : " + getHotel().getNama() +
                    "\nTipe kamar  : " + getTipeKamar() +
                    "\nHarga       : " + getDailyTariff() +
                    "\nStatus kamar: " + getStatusKamar();
        } else {
            return "\nNama hotel  : " + getHotel().getNama() +
                    "\nTipe kamar  : " + getTipeKamar() +
                    "\nHarga       : " + getDailyTariff() +
                    "\nStatus kamar: " + getStatusKamar() +
                    "\nPelanggan   : " + DatabasePesanan.getPesanan(this).getPelanggan().getNama();
        }
    }
}
