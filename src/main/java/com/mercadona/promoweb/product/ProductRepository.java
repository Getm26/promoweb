package com.mercadona.promoweb.product;

import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
        
        Product findByCode(String code);

        Product findByLabelname(String labelname);

        Product findByDescription(String description);

        Product findByPicture(ImageIcon picture);

        Product findByPrice(Integer price);

        Product findByDiscount(Integer discount);

        Product findByCategory(String category);


    
}
