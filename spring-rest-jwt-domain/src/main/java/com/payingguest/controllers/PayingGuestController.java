package com.payingguest.controllers;

import com.payingguest.model.PayingGuest;
import com.payingguest.service.IPayingGuestService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("payingguest-api")
public class PayingGuestController {

    private IPayingGuestService iPayingGuestService;

    public PayingGuestController(IPayingGuestService iPayingGuestService) {
        this.iPayingGuestService = iPayingGuestService;
    }

    @PostMapping("/admin/payingguests")
    public ResponseEntity<Void> addPayingGuest(@RequestBody PayingGuest pg) {
        iPayingGuestService.addPayingGuest(pg);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "PayingGuest Has been added");
        return ResponseEntity.status(HttpStatus.CREATED).headers(headers).build();
    }


    @PutMapping("/admin/payingguests")
    public ResponseEntity<Void> updatePayingGuest(@RequestBody PayingGuest pg) {
        iPayingGuestService.updatePayingGuest(pg);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "PayingGuest Has been added");
        return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).build();
    }

    @DeleteMapping("/admin/payingguests/id/{id}")
    public ResponseEntity<Void> deletePayingGuest(@PathVariable("id") int id) {
        iPayingGuestService.deletePayingGuest(id);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "PayingGuest Has been deleted");
        return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).build();

    }

    @GetMapping("/payingguests")
    public ResponseEntity<List<PayingGuest>> showPayingGuests() {
        List<PayingGuest> pgList = iPayingGuestService.getAll();
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "PayingGuest Has been returned");
        return ResponseEntity.ok().headers(headers).body(pgList);

    }

    @GetMapping("/payingguests/city/{city}")
    public ResponseEntity<List<PayingGuest>> showPayingGuestsByLocation(@PathVariable("city") String city) {
        List<PayingGuest> pgList = iPayingGuestService.getByCity(city);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "PayingGuest Has been returned");
        return ResponseEntity.ok().headers(headers).body(pgList);

    }

    //2
    @GetMapping("/payingguests/city/{city}/address/{address}")
    public ResponseEntity<List<PayingGuest>> showPayingGuestsByCityAndLocation(@PathVariable("city") String city, @PathVariable("address") String address) {
        List<PayingGuest> pgList =  iPayingGuestService.getByCityAndAddress(city, address);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "PayingGuest Has been returned");
        return ResponseEntity.ok().headers(headers).body(pgList);

    }

    @GetMapping("/payingguests/city/{city}/name/{name}")
    public ResponseEntity<List<PayingGuest>> showPayingGuestsByCityAndName(@PathVariable("city") String city, @PathVariable("name") String name) {
        List<PayingGuest> pgList =  iPayingGuestService.getByCityAndName(city, name);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "PayingGuest Has been returned");
        return ResponseEntity.ok().headers(headers).body(pgList);

    }

    @GetMapping("/payingguests/rating/{rating}")
    public ResponseEntity<List<PayingGuest>> showPayingGuestsByRating(@PathVariable("rating") int rating) {
        List<PayingGuest> pgList =  iPayingGuestService.getByRating(rating);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "PayingGuest Has been returned");
        return ResponseEntity.ok().headers(headers).body(pgList);


    }

    @GetMapping("/payingguests/city/{city}/rating/{rating}")
    public ResponseEntity<List<PayingGuest>> showPayingGuestsByCityAndRating(@PathVariable("city") String city, @PathVariable("rating") int rating) {
        List<PayingGuest> pgList =  iPayingGuestService.getByCityAndRating(city, rating);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "PayingGuest Has been returned");
        return ResponseEntity.ok().headers(headers).body(pgList);

    }

    @GetMapping("/payingguests/roomShare/{roomShare}")
    public ResponseEntity<List<PayingGuest>> showByRoomShare(@PathVariable("roomShare") String roomShare) {
        List<PayingGuest> pgList= iPayingGuestService.getByRoomShare(roomShare);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "PayingGuest Has been returned");
        return ResponseEntity.ok().headers(headers).body(pgList);

    }

    @GetMapping("/payingguests/price/{price}/roomShare/{roomShare}")
    public ResponseEntity<List<PayingGuest>> showByPriceAndRoomShare(@PathVariable("price") double price, @PathVariable("roomShare") String roomShare) {
        List<PayingGuest>  pgList= iPayingGuestService.getByPriceAndRoomShare(price, roomShare);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "PayingGuest Has been returned");
        return ResponseEntity.ok().headers(headers).body(pgList);

    }


    @GetMapping("/payingguests/category/{category}")
    public ResponseEntity<List<PayingGuest>> showByCategory(@PathVariable("category") String category) {

        List<PayingGuest> pgList= iPayingGuestService.getByCategory(category);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "PayingGuest Has been returned");
        return ResponseEntity.ok().headers(headers).body(pgList);

    }

    @GetMapping("/payingguests/price/{price}")
    public ResponseEntity<List<PayingGuest>> showByPriceLessThan(@PathVariable("price") double price) {
        List<PayingGuest> pgList= iPayingGuestService.getByPriceLessThan(price);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "PayingGuest Has been returned");
        return ResponseEntity.ok().headers(headers).body(pgList);

    }


    @GetMapping("/payingguests/city/{city}/totalRooms/{totalRooms}")
    public ResponseEntity<List<PayingGuest>> showByCityAndTotalRooms(@PathVariable("city") String city, @PathVariable("totalRooms") int totalRooms) {
        List<PayingGuest> pgList= iPayingGuestService.getByCityAndTotalRooms(city, totalRooms);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "PayingGuest Has been returned");
        return ResponseEntity.ok().headers(headers).body(pgList);

    }


}
