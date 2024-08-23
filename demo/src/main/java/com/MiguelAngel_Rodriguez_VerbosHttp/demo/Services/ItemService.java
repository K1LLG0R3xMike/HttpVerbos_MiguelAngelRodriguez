package com.MiguelAngel_Rodriguez_VerbosHttp.demo.Services;

import com.MiguelAngel_Rodriguez_VerbosHttp.demo.Model.GroceryItem;
import com.MiguelAngel_Rodriguez_VerbosHttp.demo.Repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public List<GroceryItem> getAll() {
        return itemRepository.findAll(); // Cambié el tipo de retorno a List<GroceryItem> para mejorar la estructura de la respuesta.
    }

    public GroceryItem insert(GroceryItem groceryItem) {
        return itemRepository.save(groceryItem); // Devuelve el objeto guardado.
    }

    public GroceryItem update(GroceryItem groceryItem) {
        Optional<GroceryItem> optionalItem = itemRepository.findById(groceryItem.getId());
        if (optionalItem.isPresent()) {
            GroceryItem item = optionalItem.get();
            item.setName(groceryItem.getName());
            item.setQuantity(groceryItem.getQuantity());
            item.setCategory(groceryItem.getCategory());
            return itemRepository.save(item); // Devuelve el objeto actualizado.
        }
        return null; // Es mejor retornar null o lanzar una excepción en caso de que el ítem no se encuentre.
    }

    public String delete(String id) {
        if (itemRepository.existsById(id)) {
            itemRepository.deleteById(id);
            return "---ITEM ELIMINADO---";
        }
        return "---ITEM NO ENCONTRADO---";
    }

    public GroceryItem updateData(String id, GroceryItem groceryItem) {
        Optional<GroceryItem> optionalItem = itemRepository.findById(id);
        if (optionalItem.isPresent()) {
            GroceryItem item = optionalItem.get();

            if (groceryItem.getName() != null) {
                item.setName(groceryItem.getName());
            }

            if (groceryItem.getCategory() != null) {
                item.setCategory(groceryItem.getCategory());
            }

            if (groceryItem.getQuantity() > 0) {
                item.setQuantity(groceryItem.getQuantity());
            }

            return itemRepository.save(item); // Devuelve el objeto actualizado.
        }
        return null; // Es mejor retornar null o lanzar una excepción en caso de que el ítem no se encuentre.
    }


    public String optionsUpdate() {
        return "OPTIONS: Insert a new grocery item. If the grocery item doesn't exist, it will be created automatically.";
    }
}
