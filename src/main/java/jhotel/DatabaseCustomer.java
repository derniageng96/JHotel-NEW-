package jhotel;
import java.util.ArrayList;
/**
 * class DatabaseCustomer untuk melihat dan memodifikasi database customer.
 *
 * @author Derni Ageng
 * @version 03/01/2018
 */
public class DatabaseCustomer
{
    // instance variables - replace the example below with your own
    private static ArrayList<Customer> CUSTOMER_DATABASE = new ArrayList<Customer>();
    private static int LAST_CUSTOMER_ID = 0;

    /**
     * Accessor untuk object dari class DatabaseCustomer
     * untuk membuat ArrayList berisi customer
     *
     * @return CUSTOMER_DATABASE
     */
    public static ArrayList<Customer> getCustomerDatabase() {
        return CUSTOMER_DATABASE;
    }

    /**
     * Accessor untuk object dari class DatabaseCustomer
     * untuk mendapatkan ID dari customer terakhir
     *
     * @return LAST_CUSTOMER_ID ID
     *
     */
    public static int getLastCustomerID() {
        return LAST_CUSTOMER_ID;
    }

    /**
     * Metode untuk menambah data Customer
     *
     * @param baru
     * @return true
     */
    public static boolean addCustomer(Customer baru) throws PelangganSudahAdaException
    {
        for(Customer customer : CUSTOMER_DATABASE){
            if(customer.getID() == baru.getID() || customer.getEmail().equals(baru.getEmail())){
                throw new PelangganSudahAdaException(baru);

            }
        }
        CUSTOMER_DATABASE.add(baru);
        LAST_CUSTOMER_ID = baru.getID();
        return true;
    }
    /**
     * Accessor untuk object dari class DatabaseCustomer
     * untuk mendapatkan customer dengan id yang ditentukan
     *
     * @param id
     * @return customer
     */
    public static Customer getCustomer(int id)
    {
        for(Customer customer : CUSTOMER_DATABASE){
            if(customer.getID() == id){
                return customer;
            }
        }
        return null;
    }
    /**
     * Accessor untuk object dari class DatabaseCustomer
     * untuk mendapatkan data login customer yang menggunakan email dan password
     *
     * @param email menentukan nilai email
     * @param password menentukan nilai password
     * @return customer
     */
    public static Customer getCustomerLogin(String email, String password)
    {
        for(Customer customer : CUSTOMER_DATABASE )
        {
            if(customer.getEmail().equals(email) && customer.getPassword().equals(password))
            {
                return customer;
            }

        }
        return null;
    }
    /**
     * untuk menghapus data customer.
     *
     * @return true
     */
    public static boolean removeCustomer(int id) throws PelangganTidakDitemukanException
    {
        for(Customer pelanggan : CUSTOMER_DATABASE)
        {
            if(pelanggan.getID() == id)
            {
                try
                {
                    DatabasePesanan.removePesanan(
                            DatabasePesanan.getPesananAktif(pelanggan));
                }
                catch(PesananTidakDitemukanException a)
                {
                    throw new PelangganTidakDitemukanException(id);
                }

                if(CUSTOMER_DATABASE.remove(pelanggan))
                {
                    return true;
                }
            }
        }

        throw new PelangganTidakDitemukanException(id);

    }
}