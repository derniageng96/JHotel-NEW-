package jhotel;
/**
 * class Hotel untuk menampilkan dan menginput data hotel .
 *
 * @author Derni Ageng
 * @version 03/01/2018
 */
public class Hotel
{
    private String nama;
    private Lokasi lokasi;
    private int bintang;
    private int id;

    /**
     * Constructor for objects of class Hotel
     * @param lokasi, bintang
     * @param nama
     */
    public Hotel(String nama, Lokasi lokasi, int bintang)
    {
        this.nama = nama;
        this.lokasi =lokasi;
        this.bintang = bintang;
        //DatabaseHotel a = new DatabaseHotel();
        id = DatabaseHotel.getLastHotelId()+1;
        
    }

    /**
     * Accessor for objects of class Hotel
     * untuk mendapatkan nilai id
     *
     * @return id
     */
    public int getID()
    {
        return id;
    }

    /**
     * method untuk mendapatkan data bintang dari suatu hotel 
     * @return bintang - jumlah bintang
     */
    public int getBintang()
    {
        return bintang;
        
    }
    
    /**
     * method untuk mendapatkan data nama
     * @return nama - nama hotel 
     */
    public String getNama()
    {
        return nama;
    
    }
    
    /**
     * method untuk mendapatkan data lokasi 
     * @return lokasi - lokasi dari suatu hotel 
     */
    public Lokasi getLokasi()
    {
        return lokasi;
    }

    /**
     * mutator untuk memberikan nilai pada id
     * @param id berisi id
     */
    public void setID(int id)
    {
        this.id=id;
    }
    /**
     * method untuk memasukkan data nama 
     * @param nama - nama hotel 
     */

    /**
     * Mutator for objects of class Hotel
     * untuk menentukan nilai nama.
     *
     * @param nama
     */
    public void setNama(String nama)
    {
        this.nama = nama;
    }
    
    /**
     * method untuk memasukkan data lokasi suatu hotel 
     * @param lokasi - lokasi hotel 
     */
    public void setLokasi(Lokasi lokasi)
    {
        this.lokasi = lokasi;
    }
    
    /**
     * method untuk memasukkan data bintang dari suatu hotel
     * @param bintang - jumlah bintang
     */
    public void setBintang(int bintang)
    {
        this.bintang = bintang;
    }

    /**
     * untuk mengembalikan nilai menjadi string
     * @return nama, bintang, lokasi
     */
    public String toString()
    {
        return "\nNama Hotel : "+nama+ "\nBintang : "+bintang+ "\nLokasi : "+lokasi.getDeskripsi();
    }

}



