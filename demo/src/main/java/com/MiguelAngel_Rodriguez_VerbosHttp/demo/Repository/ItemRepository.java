package com.MiguelAngel_Rodriguez_VerbosHttp.demo.Repository;

import com.MiguelAngel_Rodriguez_VerbosHttp.demo.Model.GroceryItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends MongoRepository<GroceryItem, String> {
    // No es necesario agregar métodos personalizados para las operaciones CRUD básicas.
}
