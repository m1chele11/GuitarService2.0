package edu.iu.mbarrant.C322Homework2.controllers;


import edu.iu.mbarrant.C322Homework2.Guitar;
import edu.iu.mbarrant.C322Homework2.Inventory;
import edu.iu.mbarrant.C322Homework2.model.GuitarData;
import edu.iu.mbarrant.C322Homework2.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/inventory")
public class InventoryController{

    private InventoryRepository inventoryRepository;
    public InventoryController(InventoryRepository inventoryRepository){
        this.inventoryRepository = inventoryRepository;
    }


    @GetMapping
    public List<GuitarData> findAll(){
        try{
            return inventoryRepository.findAll();
        } catch (IOException e){
            return null;
        }
    }


    @PostMapping
    public boolean add(@RequestBody GuitarData data){
        try{
            System.out.println("Adding guitar to inventory: " + data.serialNumber());
            return inventoryRepository.add(data);
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/{serialNumber}")
    public ResponseEntity<GuitarData> find(@PathVariable String serialNumber){
        try{
            GuitarData guitar = inventoryRepository.find(serialNumber);
            if(guitar != null){
                return ResponseEntity
                        .status(HttpStatus.FOUND)
                        .body(guitar);
            } else {
                return ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body(null);
            }
        } catch (IOException e){
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

//    @GetMapping("/find")
//    public GuitarData getGuitar(@RequestParam String serialNumber) {
//        try {
//            FileReader r = new FileReader("guitars_database.txt");
//            BufferedReader bufferedReader = new BufferedReader(r);
//
//            String line;
//            while ((line = bufferedReader.readLine()) != null) {
//                String[] guitarData = line.split(",");
//                if (guitarData[0].equals(serialNumber)) {
//                    return new GuitarData(guitarData[0], Double.parseDouble(guitarData[1]), guitarData[2],
//                            guitarData[3], guitarData[4], guitarData[5], guitarData[6]);
//                }
//            }
//            bufferedReader.close();
//            r.close();
//            return null;
//        } catch (IOException e) {
//            System.err.println("Error reading file: " + e.getMessage());
//            return null;
//        }
//    }

}
