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
    private String password;

    /**
     * Overloading Constructor dari customer
     * @param nama berisi nama customer
     * @param tanggal berisi tanggal
     * @param bulan berisi bulan keberapa
     * @param tahun berisi tahun
     */
    public Customer( String nama, int tanggal, int bulan, int tahun, String email,String password )
    {
        this.id = DatabaseCustomer.getLastCustomerID()+1;
        this.nama = nama;
        this.dob = new GregorianCalendar(tahun,bulan,tanggal).getTime();
        this.email = email;
        this.password=password;
    }
    /**
     * Overloading Constructor dari customer
     * @param nama berisi nama customer
     * @param dob berisi waktu
     */
    public Customer(String nama, Date dob, String email)
    {
        //this.id=id;
        this.nama=nama;
        this.dob=dob;
        //DatabaseCustomer a = new DatabaseCustomer();
        //id = DatabaseCustomer.getLastCustomerID()+1;
        this.email=email;

    }

    /**
     * Accesor untuk objek dari class customer
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

    /**
     * Accessor untuk objek dob dari customer
     * @return dob - mengembalikan dob
     */
    public Date getDOB()
    {
        DateFormat formatter = new SimpleDateFormat("'DOB : 'dd MMMM yyyy");
        String output = formatter.format(dob);
        System.out.println(output);
        return dob;
    }
    
    /**
     * Accesor untuk mendapatkan data nama
     * @return nama - mendapatkan nilai nama
     */
    public String getNama()
    {
        return nama;

    }

    /**
     * Mutator untuk menginput ID baru
     * @param id berisi id
     * 
     */
    public void setID(int id)
    {
        this.id=id;
    }

    /**
     * mutator untuk menginput NamaBaru
     * @param nama berisi nama
     */
    public void setNama(String nama)
    {
        this.nama=nama;
    }

    /**
     * mutator untuk menginput password
     * @param password berisi password
     */
    public void setPassword(String password)
    {
        this.password=password;
    }

    /**
     * Accessor untuk mengembalikan password
     * @return password berisi password
     */
    public String getPassword()
    {
        return password;
    }
    /**
     * mutator untuk menginput email
     * @param email berisi email
     */
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

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    /**
     * Mutator untuk object dari class Customer
     * untuk validasi pattern email.
     *
     * @param email berisi email
     * berisi email yang ingin divaildasi.
     *
     * @return mathcer.find()
     */
    public static boolean validate(String email) 
    {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(email);
        return matcher.find();
    }

    /**
     * Mutator untuk object dari class Customer
     * untuk menentukan nilai tanggal
     *
     * @param dob
     * objek Date
     */
    public void setDOB(Date dob)
    {
        this.dob=dob;
    }

    /**
     * untuk mencetak String pada objek Customer
     *
     */
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

    }
    }

