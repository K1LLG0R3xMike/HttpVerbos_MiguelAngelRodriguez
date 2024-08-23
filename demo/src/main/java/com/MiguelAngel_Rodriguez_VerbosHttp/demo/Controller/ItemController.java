package com.MiguelAngel_Rodriguez_VerbosHttp.demo.Controller;

import com.MiguelAngel_Rodriguez_VerbosHttp.demo.Model.GroceryItem;
import com.MiguelAngel_Rodriguez_VerbosHttp.demo.Services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
@RestController
@RequestMapping("item")
public class ItemController {

    @Autowired
    ItemService itemService;

    // 1. método de ejemplo para verbo GET
    @GetMapping("/getAll")
    public String getAll(){
        return itemService.getAll().toString();
    }

    // 2. método de ejemplo para verbo POST
    @PostMapping("/insert")
    public GroceryItem insert(@RequestBody GroceryItem groceryItem){
        return itemService.insert(groceryItem);
    }

    // 3. método de ejemplo para verbo UPDATE
    @PutMapping("/update")
    public GroceryItem update(@RequestBody GroceryItem groceryItem){
        return itemService.update(groceryItem);
    }

    // 4. método de ejemplo para verbo DELETE
    @DeleteMapping("/delete/{id}")
    public String deleteItem(@PathVariable("id") String id) {
        return itemService.delete(id);
    }

    // 5. método de ejemplo para verbo PATCH
    @PatchMapping("/updateData/{id}")
    public GroceryItem updateData(@PathVariable String id, @RequestBody GroceryItem groceryItem){
        return itemService.updateData(id, groceryItem);
    }

    // 6. método de ejemplo para verbo HEAD
    @RequestMapping(value = "/getAll", method = RequestMethod.HEAD)
    public ResponseEntity<?> handleHeadRequest() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(headers, HttpStatus.OK);
    }
}
*/

@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/getAll")
    public ResponseEntity<List<GroceryItem>> getAll() {
        List<GroceryItem> items = itemService.getAll();
        return ResponseEntity.ok(items);
    }

    @PostMapping("/insert")
    public ResponseEntity<GroceryItem> insert(@RequestBody GroceryItem groceryItem) {
        GroceryItem insertedItem = itemService.insert(groceryItem);
        return ResponseEntity.status(HttpStatus.CREATED).body(insertedItem);
    }

    @PutMapping("/update")
    public ResponseEntity<GroceryItem> update(@RequestBody GroceryItem groceryItem) {
        GroceryItem updatedItem = itemService.update(groceryItem);
        if (updatedItem != null) {
            return ResponseEntity.ok(updatedItem);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteItem(@PathVariable("id") String id) {
        String result = itemService.delete(id);
        if (result.equals("---ITEM ELIMINADO---")) {
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
    }

    @PatchMapping("/updateData/{id}")
    public ResponseEntity<GroceryItem> updateData(@PathVariable String id, @RequestBody GroceryItem groceryItem) {
        GroceryItem updatedItem = itemService.updateData(id, groceryItem);
        if (updatedItem != null) {
            return ResponseEntity.ok(updatedItem);
        }
        return ResponseEntity.notFound().build();
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.HEAD)
    public ResponseEntity<Void> handleHeadRequest() {
        List<GroceryItem> items = itemService.getAll();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        if (items.isEmpty()) {
            return new ResponseEntity<>(headers, HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(headers, HttpStatus.OK);
    }



}

