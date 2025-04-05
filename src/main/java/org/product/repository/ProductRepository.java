package org.product.repository;
import io.quarkus.hibernate.reactive.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.product.entity.Product;

@ApplicationScoped
public class ProductRepository implements PanacheRepository<Product> {
}