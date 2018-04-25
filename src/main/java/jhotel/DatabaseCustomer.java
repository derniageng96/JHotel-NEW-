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

    public static ArrayList<Customer> getCustomerDatabase() {
        return CUSTOMER_DATABASE;
    }

    public static int getLastCustomerID() {
        return LAST_CUSTOMER_ID;
    }

    /**
     * untuk menambahkan data customer.
     *
     * @return false
     */
    public static boolean addCustomer(Customer baru) throws PelangganSudahAdaException
    {
        for(Customer customer : CUSTOMER_DATABASE){
            if(customer.getID() == baru.getID() || customer.getEmail().equals(baru.getEmail())){
                throw new PelangganSudahAdaException(baru);
                //System.out.println();
                //return false;
            }
        }
        CUSTOMER_DATABASE.add(baru);
        LAST_CUSTOMER_ID = baru.getID();
        return true;
    }

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
     * untuk menghapus data customer.
     *
     * @return false
     */
    public static boolean removeCustomer(int id) throws PelangganTidakDitemukanException
    {
        for(Customer customer : CUSTOMER_DATABASE){
            if (customer.getID() == id){
                Pesanan pesan = DatabasePesanan.getPesananAktif(customer);
                try {
                    DatabasePesanan.removePesanan(customer);
                }
                catch (PesananTidakDitemukanException e){
                    System.out.println(e.getPesan());
                }
                if (CUSTOMER_DATABASE.remove(customer)){
                    return true;
                }
            }
        }
        return false;
    }
}