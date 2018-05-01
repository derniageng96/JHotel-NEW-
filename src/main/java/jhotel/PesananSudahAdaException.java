package jhotel;
public class PesananSudahAdaException extends Exception {

    private Customer pelanggan_error;
    //super.getMessage()
    public PesananSudahAdaException(Customer pelanggan_input)
    {
        super("Pesanan yang dipesan oleh: ");
        pelanggan_error=pelanggan_input;
    }
    public String getPesan()
    {
        return super.getMessage() + pelanggan_error.getNama() + "sudah melakukan pemesanan.";
    }
}
