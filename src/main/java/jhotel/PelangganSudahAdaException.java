package jhotel;
/**
 * Class PelangganSudahAdaException
 *
 * @author Derni Ageng
 * @version 2018
 */
public class PelangganSudahAdaException extends Exception
{
    private Customer pelanggan_error;

    /**
     * Constructor dari kelas exception PelangganSudahAda
     * @param pelanggan_input nilai pesanan yang dicek.
     */
    public PelangganSudahAdaException(Customer pelanggan_input)
    {
        super("Data Customer dengan ID: ");
        pelanggan_error=pelanggan_input;
    }

    /**
     * Method yang digunakan untuk mendapatkan pesan Exception.
     * @return String nilai pesan error.
     */
    public String getPesan()
    {
        return super.getMessage()+
                "\nID       : "+ pelanggan_error.getID()+
                "\nNama     : "+pelanggan_error.getNama()+
                "\nEmail    : "+pelanggan_error.getEmail()+
                "\nSudah terdaftar.";
    }
}
