package org.product.service;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import io.smallrye.mutiny.Uni;
import org.product.entity.Product;

import java.util.List;

@ApplicationScoped
public class ProductService {

    public Uni<Product> create(Product product) {
        return product.persist();
    }

    public Uni<List<Product>> listAll() {
        return Product.listAll();
    }

    public Uni<Product> getById(Integer id) {
        return Product.findById(id);
    }

    @Transactional
    public Uni<Product> update(Integer id, Product updated) {
        return Product.<Product>findById(id).onItem().ifNotNull().transformToUni(existing -> {
            existing.name = updated.name;
            existing.description = updated.description;
            existing.price = updated.price;
            existing.quantity = updated.quantity;
            return existing.persist();
        });
    }

    public Uni<Boolean> delete(Integer id) {
        return Product.deleteById(id);
    }

   /* public Uni<Boolean> checkAvailability(Integer id, int count) {
        return Product.findById(id)
                .map(product -> product != null && product.quantity >= count);
    }*/

    public Uni<List<Product>> getProductsSortedByPrice() {
        return Product.list("ORDER BY price ASC");
    }
}
