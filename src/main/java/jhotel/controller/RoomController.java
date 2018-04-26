package jhotel.controller;
import jhotel.DatabaseHotel;
import jhotel.DatabaseRoom;
import jhotel.Room;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class RoomController
{
    @RequestMapping(value = "/vacantrooms")
    public ArrayList<Room> vacantRooms()
    {
        return DatabaseRoom.getVacantRooms();
    }

    @RequestMapping(value = "/room/{id_hotel}/{room_no}")
    public Room getRoom(@PathVariable("id_hotel") int id,
                        @PathVariable("room_no") String nomor_kamar)
    {
        return DatabaseRoom.getRoom(DatabaseHotel.getHotel(id), nomor_kamar);
    }
}
