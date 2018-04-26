package jhotel.controller;

import jhotel.*;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;

@RestController
public class PesananController
{
    @RequestMapping(value = "/pesanancustomer/{id_customer}", method = RequestMethod.GET)
    public Pesanan pesananCust(@PathVariable int id_customer)
    {
        return DatabasePesanan.getPesananAktif(DatabaseCustomer.getCustomer(id_customer));
    }

    @RequestMapping(value = "/pesanan/{id_pesanan}", method = RequestMethod.GET)
    public Pesanan getPesanan(@PathVariable int id_pesanan)
    {
        return DatabasePesanan.getPesananAktif(DatabaseCustomer.getCustomer(id_pesanan));
    }

    @RequestMapping(value = "/bookpesanan", method = RequestMethod.POST)
    public Pesanan buatPesanan(@RequestParam(value="jumlah_hari") int jumlah_hari,
                               @RequestParam(value="id_customer") int id_customer,
                               @RequestParam(value="id_hotel") int id_hotel,
                               @RequestParam(value="nomor_kamar") String nomor_kamar)
    {
        try{
            DatabasePesanan.addPesanan(new Pesanan(jumlah_hari, DatabaseCustomer.getCustomer(id_customer)));
        }
        catch(PesananSudahAdaException a){
            a.getPesan();
        }

        Pesanan pesanan = DatabasePesanan.getPesananAktif(
                DatabaseCustomer.getCustomer(id_customer));

        Room kamar = DatabaseRoom.getRoom(DatabaseHotel.getHotel(id_hotel), nomor_kamar);

        Administrasi.pesananDitugaskan(pesanan,kamar);
        if(kamar != null)
        {
            pesanan.setBiaya();
        }

        return pesanan;
    }

    @RequestMapping(value = "/cancelpesanan", method = RequestMethod.POST)
    public Pesanan batalkanPesanan(@RequestParam(value="id_pesanan") int id_pesanan)
    {
        Pesanan pesanan = DatabasePesanan.getPesananAktif(DatabaseCustomer.getCustomer(id_pesanan));
        if(pesanan!= null)
        {
            Administrasi.pesananDibatalkan(pesanan);
        }
        return pesanan;
    }

    @RequestMapping(value = "/finishpesanan", method = RequestMethod.POST)
    public Pesanan selesaikanPesanan(@RequestParam(value="id_pesanan") int id_pesanan)
    {
        Pesanan pesanan = DatabasePesanan.getPesananAktif(DatabaseCustomer.getCustomer(id_pesanan));
        if(pesanan!= null)
        {
            Administrasi.pesananSelesai(pesanan);
        }
        return pesanan;
    }
}