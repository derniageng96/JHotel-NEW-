package jhotel.controller;
import org.springframework.web.bind.annotation.RequestMethod;
import jhotel.Hotel;
import jhotel.DatabaseHotel;
import jhotel.Hotel;
import jhotel.Pesanan;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
@RestController
public class HotelController {


    @RequestMapping(value = "/hotel", method = RequestMethod.GET)
    public ArrayList<Hotel> hotelsList()
    {
        return DatabaseHotel.getHotelDatabase();
    }

    @RequestMapping(value = "/hotel/{id_hotel}")
    public Hotel getHotel(@PathVariable int id_hotel)
    {
        return DatabaseHotel.getHotel(id_hotel);
    }


}
