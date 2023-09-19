package nl.timo.semester3week2demo.weapon;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;

@RestController
public class WeaponController {
    private ArrayList<Weapon> weapons;

    public WeaponController() {
        weapons = new ArrayList<>();
        weapons.add(new Weapon("axe", 1));
        weapons.add(new Weapon("throwing axe", 2));
        weapons.add(new Weapon("triple axe", 3));
        weapons.add(new Weapon("makeup kit", 2));
    }

    @GetMapping("/weapons")
    public ResponseEntity<?> getAllWeapons() {
        return ResponseEntity.ok(weapons);
    }

    @GetMapping("/weapons/{index}")
    public ResponseEntity<Weapon> getWeapon(@PathVariable Integer index) {
        return ResponseEntity.ok(weapons.get(index));
    }

    @PostMapping("/weapons")
    public ResponseEntity<?> addNewWeapon(@RequestBody Weapon weapon) {
        weapons.add(weapon);

        URI uri = URI.create("/weapons/" + (weapons.size() + 1));
        return ResponseEntity.created(uri).build();
    }
}
