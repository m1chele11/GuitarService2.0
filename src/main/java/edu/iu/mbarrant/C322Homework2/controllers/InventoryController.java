package edu.iu.mbarrant.C322Homework2.controllers;


import edu.iu.mbarrant.C322Homework2.Guitar;
import edu.iu.mbarrant.C322Homework2.Inventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    private final Inventory inventory;

    @Autowired
    public InventoryController(Inventory inventory) {
        this.inventory = inventory;
    }

    @GetMapping("/search")
    public List<Guitar> searchGuitars(
            @RequestParam(required = false) String serialNumber,
            @RequestParam(required = false) String builder,
            @RequestParam(required = false) String model,
            @RequestParam(required = false) String type,
            @RequestParam(required = false) Integer numStrings,
            @RequestParam(required = false) String backWood,
            @RequestParam(required = false) String topWood,
            @RequestParam(required = false) double price

    ) {
        Guitar searchGuitar = new Guitar(null, price, builder, model, type, backWood, topWood, numStrings);
        return inventory.search(searchGuitar);
    }

    @PostMapping("/add")
    public void addGuitar(@RequestBody Guitar guitar) {
        inventory.addGuitar(guitar);
    }

    @GetMapping("/find/{serialNumber}")
    public Guitar findGuitar(@PathVariable String serialNumber) {
        return inventory.getGuitar(serialNumber);
    }



    public enum Builder {
        FENDER, MARTIN, GIBSON, COLLINGS, OLSON, RYAN, PRS, ANY;
        public String toString() {
            switch(this) {
                case FENDER:   return "Fender";
                case MARTIN:   return "Martin";
                case GIBSON:   return "Gibson";
                case COLLINGS: return "Collings";
                case OLSON:    return "Olson";
                case RYAN:     return "Ryan";
                case PRS:      return "PRS";
                default:       return "Unspecified";
            }
        }
    }

    public enum Type {
        ACOUSTIC, ELECTRIC;
        public String toString() {
            switch(this) {
                case ACOUSTIC: return "acoustic";
                case ELECTRIC: return "electric";
                default:       return "Unspecified";
            }
        }
    }

    public enum Wood {
        INDIAN_ROSEWOOD, BRAZILIAN_ROSEWOOD, MAHOGANY, MAPLE,
        COCOBOLO, CEDAR, ADIRONDACK, ALDER, SITKA;
        public String toString() {
            switch(this) {
                case INDIAN_ROSEWOOD:    return "Indian Rosewood";
                case BRAZILIAN_ROSEWOOD: return "Brazilian Rosewood";
                case MAHOGANY:           return "Mahogany";
                case MAPLE:              return "Maple";
                case COCOBOLO:           return "Cocobolo";
                case CEDAR:              return "Cedar";
                case ADIRONDACK:         return "Adirondack";
                case ALDER:              return "Alder";
                case SITKA:              return "Sitka";
                default:                 return "Unspecified";
            }
        }
    }
}
