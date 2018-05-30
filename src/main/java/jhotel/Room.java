package jhotel;
/**
 * Write a description of class Room here.
 *
 * @author Derni Ageng
 * @version 2018
 */
public abstract class Room {
    // instance variables - replace the example below with your own
    private Hotel hotel;
    private String nomor_kamar;
    protected double dailyTariff;
    private StatusKamar status_kamar;
    //private Pesanan pesan;

    /**
     * Constructor for objects of class Room
     * @param hotel hotel yang ditempati.
     * @param nomor_kamar nomor kamar hotel.
     */
    public Room(Hotel hotel, String nomor_kamar) {
        this.hotel = hotel;
        this.nomor_kamar = nomor_kamar;
        //this.isAvailable=isAvailable;
        //this.status_kamar=status_kamar;
        //this.dailyTariff = dailyTariff;
        status_kamar = StatusKamar.Status_3;

    }

    /**
     * Accessor for objects of class Room
     * untuk meminta keterangan hotel
     *
     * @return hotel.
     */
    public Hotel getHotel() {
        // put your code here
        return hotel;
    }

    /**
     * Accessor for objects of class Room
     * untuk meminta keterangan nomor kamar
     *
     * @return nomor_kamar.
     */
    public String getNomorkamar() {
        return nomor_kamar;
    }

    /**
     * Accessor for objects of class Room
     * untuk meminta keterangan tarif
     *
     * @return dailyTariff.
     */
    public double getDailyTariff() {
        return dailyTariff;
    }

    /**
     * Accessor for objects of class Room
     * untuk meminta keterangan status kamar
     *
     * @return status_kamar.
     */
    public StatusKamar getStatusKamar() {
        return status_kamar;
    }

    /**
     * Mutator untuk objek hotel
     * @param hotel
     */
    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    /**
     * Mutator untuk objek nomor_kamar
     * @param nomor_kamar
     */
    public void setNomorKamar(String nomor_kamar) {
        this.nomor_kamar = nomor_kamar;
    }

    /**
     * mutator untuk objek dailyTariff
     * @param dailytariff
     */
    public void setDailyTariff(double dailytariff) {
        this.dailyTariff = dailytariff;
    }

    /**
     * mutator untuk objek StatusKamar
     * @param status_kamar
     */
    public void setStatusKamar(StatusKamar status_kamar) {
        this.status_kamar = status_kamar;
    }

    public abstract TipeKamar getTipeKamar();


    public String toString() {
        if (DatabasePesanan.getPesananAktif(this) == null) {
            return "\nNama hotel  : " + getHotel().getNama() +
                    "\nTipe kamar  : " + getTipeKamar() +
                    "\nHarga       : " + getDailyTariff() +
                    "\nStatus kamar: " + getStatusKamar();
        } else {
            return "\nNama hotel  : " + getHotel().getNama() +
                    "\nTipe kamar  : " + getTipeKamar() +
                    "\nHarga       : " + getDailyTariff() +
                    "\nStatus kamar: " + getStatusKamar() +
                    "\nPelanggan   : " + DatabasePesanan.getPesananAktif(this).getPelanggan().getNama();
        }
    }
}
