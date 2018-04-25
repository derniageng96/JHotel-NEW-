package jhotel;
/**
 * Class Customer untuk menampilkan informasi customer.
 *
 * @author Derni Ageng
 * @version 03/01/2018
 */
import java.text.*;
import java.util.*;
import java.util.Date;
import java.util.regex.*;
public class Customer
{
    // instance variables - replace the example below with your own
    protected int id;
    protected String nama;
    protected Date dob;
    protected String email;
    private Pattern pattern;
    private Matcher matcher;
    /**
     * constructor dari customer 
     * @param
     */
    public Customer( String nama, int tanggal, int bulan, int tahun, String email )
    {
        id = DatabaseCustomer.getLastCustomerID()+1;
        this.nama = nama;
        this.dob = new GregorianCalendar(tahun,bulan-1,tanggal).getTime();
        this.email = email;
    }
    
    public Customer()
    {
        //this.id=id;
        //this.nama=nama;
        //this.dob=dob;
        //DatabaseCustomer a = new DatabaseCustomer();
        //id = DatabaseCustomer.getLastCustomerID()+1;
        //this.email=email;

    }
    
    
    //public class EmailValidator {

    //private Pattern pattern;
    //private Matcher matcher;

    //private static final String EMAIL_PATTERN = 
    //  "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
    //  + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    //public EmailValidator() {
    //  pattern = Pattern.compile(EMAIL_PATTERN);
    //}

    ///**
    // * Validate hex with regular expression
    // * 
     //* @param hex
     /*            hex for validation
     * @return true valid hex, false invalid hex
     */
    //public boolean validate(final String hex) {

    //  matcher = pattern.matcher(hex);
    //  return matcher.matches();

    //}
    //}
    /**
     * method untuk mendapatkan data ID 
     * @return id - mengembalikan nilai ID 
     */
    public int getID()
    {
      return id;
    }
    
    public String getEmail()
    {
        return email;
        
    }
    
    public Date getDOB()
    {
        DateFormat tanggal = new SimpleDateFormat("'DOB : ' dd MMMM YYYY");
        String keluaran = tanggal.format(dob);
        System.out.print(keluaran);
        return dob;
        
    }
    
    /**
     * method untuk mendapatkan data nama
     * @return nama - mendapatkan nilai nama
     */
    public String getNama()
    {
        return nama;

    }

    /**
     * method untuk menginput ID baru 
     * @param idNew 
     * 
     */
    public void setID(int id)
    {
        this.id=id;
    }

    /**
     * method untuk menginput NamaBaru
     * @param NamaBaru - nama baru 
     */
    public void setNama(String nama)
    {
        this.nama=nama;
    }
    
    public void setEmail(String email)
    {
    email=email;
    String EMAIL_PATTERN = 
    "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@+[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    pattern = Pattern.compile(EMAIL_PATTERN);
    matcher = pattern.matcher(email);   
        if (matcher.matches())
        {
            this.email=email;
        }
    }
    
    //public boolean validate(final String hex) 
    //{

    //matcher = pattern.matcher(hex);
    //return matcher.matches();

    //}
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static boolean validate(String email) 
    {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(email);
        return matcher.find();
    }
    
    public void setDOB(Date dob)
    {
        this.dob=dob;
        
        
    }
    
    public String toString()
    {
        if(DatabasePesanan.getPesananAktif(this) != null){
            return "\nCustomer\n"+
                    "\nCustomer ID   : " +id+
                    "\nName          : " +nama+
                    "\nE-Mail        : " +email+
                    "\nDate of Birth : " +getDOB()+
                    "\nBooking order is in progress";
        }

        else{
            return "\nCustomer\n"+
                    "\nCustomer ID   : " +id+
                    "\nName          : " +nama+
                    "\nE-Mail        : " +email+
                    "\nDate of Birth : " +getDOB();
        }
        //return string;
    }

    
    /**
     * method untuk mencetak data
     */
    public void printData()
    {
        System.out.println("ID : " + id);
        System.out.println("Nama : " + nama);
    }
}
