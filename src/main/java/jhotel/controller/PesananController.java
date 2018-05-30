package jhotel.controller;

import jhotel.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class PesananController
{
    /**
     * method ini mengatur sisi server untuk melihat detail  pesanan customer berdasarkan id dari customer.
     *
     * @param id_customer
     */
    @RequestMapping(value = "/pesanancustomer/{id_customer}", method = RequestMethod.GET)
    public Pesanan pesananCust(@PathVariable int id_customer)
    {
        return DatabasePesanan.getPesananAktif(DatabaseCustomer.getCustomer(id_customer));
    }

    /**
     * method ini  mengatur sisi server untuk mengambil pesanan berdasarkan id pesanan.
     *
     * @param id_pesanan
     */
    @RequestMapping(value = "/pesanan/{id_pesanan}", method = RequestMethod.GET)
    public Pesanan getPesanan(@PathVariable int id_pesanan)
    {
        return DatabasePesanan.getPesanan(id_pesanan);
    }

    /**
     * method ini mengatur sisi server untuk melakukan pesanan oleh customer.
     *
     * @param jumlah_hari
     * @param id_customer
     * @param id_hotel
     * @param nomor_kamar
     */
    @RequestMapping(value = "/bookpesanan", method = RequestMethod.POST)
    public Pesanan buatPesanan(@RequestParam(value="jumlah_hari") int jumlah_hari,
                               @RequestParam(value="id_customer") int id_customer,
                               @RequestParam(value="id_hotel") int id_hotel,
                               @RequestParam(value="nomor_kamar") String nomor_kamar)
    {
        try
        {
            DatabasePesanan.addPesanan(new Pesanan(jumlah_hari,DatabaseCustomer.getCustomer(id_customer)));


        }
        catch(PesananSudahAdaException e)
        {
            e.getPesan();
        }
        Pesanan pesanan = DatabasePesanan.getPesananAktif(DatabaseCustomer.getCustomer(id_customer));
        Room kamar = DatabaseRoom.getRoom(DatabaseHotel.getHotel(id_hotel), nomor_kamar);
        Administrasi.pesananDitugaskan(pesanan,kamar);
        if(kamar != null) {
            pesanan.setBiaya();
        }
        return pesanan;
    }

    /**
     * method ini  mengatur sisi server untuk melakukan cancel pesanan berdasarkan id pesanan.
     *
     * @param id_pesanan
     */
    @RequestMapping(value = "/cancelpesanan", method = RequestMethod.POST)
    public Pesanan batalkanPesanan(@RequestParam(value="id_pesanan") int id_pesanan)
    {
        Pesanan pesanan = DatabasePesanan.getPesanan(id_pesanan);
        if(pesanan!= null)
        {
            Administrasi.pesananDibatalkan(pesanan);
        }
        return pesanan;
    }

    /**
     * method ini mengatur sisi server untuk menyelesaikan pesanan berdasarkan id pesanan.
     *
     * @param id_pesanan
     */
    @RequestMapping(value = "/finishpesanan", method = RequestMethod.POST)
    public Pesanan selesaikanPesanan(@RequestParam(value="id_pesanan") int id_pesanan)
    {
        Pesanan pesanan = DatabasePesanan.getPesanan(id_pesanan);
        if (pesanan != null) {
            Administrasi.pesananSelesai(pesanan);
        }

        return pesanan;
    }
}
