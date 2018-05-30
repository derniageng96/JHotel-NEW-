package jhotel;
/**
 * Pesanan digunakan untuk pengisian dan pengambilan data biaya, nama, statusdiproses, statusselesai.
 *
 * @author Derni Ageng
 * @version 03/01/2018
 */
import java.text.*;
import java.util.*;
import java.util.Date;
import java.util.regex.*;
public class Pesanan
{
    // instance variables pada class Pesanan
    private int id;
    private double biaya;
    private double jumlahHari;
    private boolean isDiproses;
    private boolean isSelesai;
    private Customer pelanggan;
    private Room kamar;
    private Date tanggalPesan;
    private boolean isAktif;

    /**
     * Constructor dari kelas Pesanan
     */
    public Pesanan(double jumlahHari, Customer pelanggan)
    {
        //this.biaya=kamar.getDailyTariff()*jumlahHari;
        this.jumlahHari=jumlahHari;
        this.pelanggan=pelanggan;
        //this.kamar=kamar;
        //Date dob = new Date(tahun,bulan,hari);
        isAktif=true;
        id = DatabasePesanan.getLastPesananID()+1;
        tanggalPesan = new Date();
    }

    /**
     * Accessor for objects of class Pesanan
     * untuk meminta nilai pelanggan
     *
     * @return pelanggan.
     */
    public Customer getPelanggan()
    {
        return pelanggan;
    }

    /**
     * Accessor for objects of class Pesanan
     * untuk meminta nilai jumlah hari
     *
     * @return jumlahHari.
     */
    public double getJumlahHari()
    {
        return jumlahHari;
    }

    /**
     * Mutator for objects of class Pesanan
     * untuk memberi nilai jumlah hari
     *
     * @param jumlahHari
     */
    public void setJumlahHari(double jumlahHari)
    {
        this.jumlahHari=jumlahHari;
        
    }

    /**
     * Mutator for objects of class Pesanan
     * untuk memberi nilai pelanggan
     *
     * @param pelanggan
     */
    public void setPelanggan(Customer pelanggan)
    {
        this.pelanggan=pelanggan;
        
    }
    
    /**
     * method untuk mendapatkan nilai biaya
     * @retun biaya - mengembalikan nilai ke biaya
     */
    public double getBiaya()//mendapatkan data biaya
    {
        return biaya;

    }

    /**
     * Accessor for objects of class Pesanan
     * untuk meminta nilai ID
     *
     * @return id.
     */
    public int getID()
    {
        return id;
    }
    
    /**
     * method untuk mendapatkan data statusdiproses 
     * @return StatusDiproses - mengembalikan nilai StatusDiproses
     */
    public boolean getStatusDiproses(boolean StatusDiproses)//mendapatkan data statusdiproses
    {
        return StatusDiproses;
        
    }
    
    /**
     * method untuk mendapatkan data StatusSelesai
     * @return StatusSelesai - mengembalikan nilai StatusSelesai
     */
    public boolean getStatusSelesai(boolean StatusSelesai)
    {
        return StatusSelesai;
        
    }

    /**
     * Accessor for objects of class Pesanan
     * untuk meminta keterangan kamar
     *
     * @return kamar.
     */
    public Room getRoom()
    {
        return kamar;
    }

    /**
     * Mutator for objects of class Pesanan
     * untuk memberi nilai biaya
     *
     */
    public void setBiaya()
    {
        biaya = kamar.getDailyTariff() * jumlahHari;
        
    }

    /**
     * Mutator for objects of class Pesanan
     * untuk memberi nilai ID
     *
     *
     */
    public void setID()
    {
        this.id=id;
    }

    /**
     * method untuk menginput StatusDiproses
     * @param - sesuatu yang diproses pada pesanan
     */
    public void setStatusDiproses(boolean diproses)
    {
        isDiproses = diproses;
    }

    /**
     * method untuk menginput StatusSelesai
     * @param  - sesuatu yang telah selesai pada pesanan
     */
    public void setStatusSelesai(boolean diproses)
    {
        isSelesai = diproses;
    }

    public void setStatusAktif(boolean aktif)
    {
        this.isAktif=aktif;
    }
     
    public String toString()
    {
        String final_status = "KOSONG";
        if(isDiproses == true && isSelesai == false) final_status = "DIPROSES";
        else if(isDiproses == false && isSelesai == false) final_status = "KOSONG";
        else if(isDiproses == false && isSelesai == true) final_status = "SELESAI";

        if (getRoom() != null) {
            return "\n Pesanan" +
                    "\n pelanggan=" + pelanggan.getNama() +
                    "\n jumlah hari =" + jumlahHari +
                    "\n hotel=" + kamar.getHotel().getNama() +
                    "\n kamar=" + kamar.getNomorkamar() +
                    "\n tipeKamar=" + kamar.getTipeKamar() +
                    "\n status=" + final_status+
                    "\n ID= "+pelanggan.getID();

        }
        return "\n Pesanan" +
                "\n pelanggan=" + pelanggan.getNama() +
                "\n jumlah hari=" + jumlahHari +
                "\n hotel=null" +//kamar.getHotel().getNama()+
                "\n kamar=null" +//kamar.getNomorkamar() +
                "\n tipeKamar=" +//kamar.getTipeKamar() +
                "\n status=" + final_status+
                "\n ID= "+pelanggan.getID();
    }

    /**
     * Mutator for objects of class Pesanan
     * untuk memberi keterangan tanggal memesan
     *
     * @param tanggalPesan
     */
    public void setTanggalPesan(Date tanggalPesan)
    {
        this.tanggalPesan=tanggalPesan;
    }

    /**
     * Accessor for objects of class Pesanan
     * untuk meminta keterangan tanggal memesan
     *
     * @return tanggalPesan.
     */
    public Date getTanggalPesan()
    {
        DateFormat df = new SimpleDateFormat("'DOB : 'dd MMMM yyyy");
        String hasil = df.format(tanggalPesan);
        System.out.println(hasil);
        return tanggalPesan;
    }

    /**
     * Mutator for objects of class Pesanan
     * untuk memberi keterangan kamar
     *
     * @param kamar
     */
    public void setRoom(Room kamar)
    {
        this.kamar=kamar;
    }

    /**
     * Accessor for objects of class Pesanan
     * untuk meminta nilai status aktif
     *
     * @return isAktif.
     */
    public boolean getStatusAktif(){
        return isAktif;
    }
}
