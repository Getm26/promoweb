package com.mercadona.promoweb.promotion;

public interface PromotionRepository extends CrudRepository<Promotion, Long> {

    Promotion findByLabelname(String labelname);

    Promotion findByDescription(String description);

    Promotion findByPicture(ImageIcon picture);

    Promotion findByPrice(Integer price);

    Promotion findByDiscount(Integer discount);

    Promotion findByCategory(String category);
    
    
}
