package jhotel;
/**
 * class Lokasi untuk memasukkan dan melihat data dari lokasi suatu hotel.
 *
 * @author Derni Ageng
 * @version 03/01/2018
 */
public class Lokasi
{
    // instance variables - replace the example below with your own
    private float x_coord;
    private float y_coord;
    private String deskripsiLokasi;

    /**
     * Constructor for objects of class Lokasi
     * @param x_coord, y_coord, deskripsiLokasi - x dan y koordinat, dan deskripsi lokasi hotel
     */
    public Lokasi(float x_coord, float y_coord, 
    String deskripsiLokasi)
    {
        this.x_coord = x_coord;
        this.y_coord = y_coord;
        this.deskripsiLokasi = deskripsiLokasi;
    }

    /**
     * method untuk mendapatkan nilai x 
     *
     * 
     * @return x_coord - mengembalikkan nilai x_coord
     */
    public float getX()
    {
        return x_coord;
    }
    
    /**
     * method untuk mendapatkan nilai Y 
     * @return y_coord - mengembalikkan nilai koordinat y 
     */
    public float getY()
    {
        return y_coord;
        
    }
    
    /**
     * method untuk mendaptkan data deskripsi 
     * @return deskripsiLokasi
     */
    public String getDeskripsi()
    {
        // put your code here
        return deskripsiLokasi;
    }
    
    /**
     * method untuk menginput nilai x 
     */
    public void setX(float x_coord)
    {
        // put your code here
        this.x_coord = x_coord;
    }
    
    /**
     * method untuk memasukka nilai y 
     * @param y_coord
     */
    public void setY(float y_coord)
    {
        // put your code here
        this.y_coord = y_coord;
    }
    
    public void setDeskripsi(String deskripsi)
    {
        this.deskripsiLokasi = deskripsi;
        
    }
    
    public String toString()
    {
        return x_coord+ ""+y_coord+ ""+deskripsiLokasi;
    }
    
    public void printData()
    {
        System.out.println("Koordinat x: " + x_coord);
        System.out.println("Koordinat y: " + y_coord);
        System.out.println("Deskripsi : " + deskripsiLokasi);
        
    }
}
