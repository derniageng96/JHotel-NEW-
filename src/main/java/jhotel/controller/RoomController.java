package jhotel.controller;

import jhotel.DatabaseHotel;
import jhotel.Room;
import jhotel.DatabaseRoom;
import jhotel.Room;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
@RestController
public class RoomController {
    @RequestMapping(value="/vacantrooms", method = RequestMethod.GET)
    public ArrayList<Room> vacantRooms()
    {
        ArrayList<Room> room = DatabaseRoom.getVacantRooms();
        return room;
    }

    @RequestMapping(value="/room/{id_hotel}/{room_no}" , method = RequestMethod.GET)
    public Room getRoom(@PathVariable("id_hotel") int id,
                        @PathVariable("room_no") String nomor_kamar)
    {
        return DatabaseRoom.getRoom(DatabaseHotel.getHotel(id), nomor_kamar);
    }

}
