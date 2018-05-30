package jhotel;
/**
  * Enumeration class TipeKamar
  *
  * @author Derni Ageng
  * @version 2018
  */
public enum TipeKamar
{
            Tipe_1("Single"),
            Tipe_2("Double"),
            Tipe_3("Premium") ;
    private String deskripsi;
    /**
     * Constructor for TipeKamar
     *
     * @param deskripsi tipe kamar
     *
     */
    TipeKamar(String deskripsi)
    {
        this.deskripsi = deskripsi;
    }

    /**
     * pengembalian nilai enum yang dipanggil
     *
     * @return deskripsi tipe kamar
     *
     */
    public String toString()
    {
        return deskripsi;
    }
}
