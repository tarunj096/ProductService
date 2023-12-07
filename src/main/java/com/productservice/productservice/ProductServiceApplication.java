package com.productservice.productservice;

import com.productservice.productservice.models.Category;
import com.productservice.productservice.models.Price;
import com.productservice.productservice.models.Product;
import com.productservice.productservice.repositories.PriceRepository;
import com.productservice.productservice.repositories.CategoryRepository;
import com.productservice.productservice.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
    public class ProductServiceApplication implements CommandLineRunner {

    private final PriceRepository priceRepository;
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    public ProductServiceApplication(PriceRepository priceRepository,
                                     CategoryRepository categoryRepository,
                                     ProductRepository productRepository) {
        this.priceRepository = priceRepository;
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

//    private final CategoryRepository categoryRepository;
//    private final ProductRepository productRepository;

//    public ProductServiceApplication(CategoryRepository categoryRepository,
//                                     ProductRepository productRepository,
//                                     PriceRepository priceRepository) {
//        this.categoryRepository = categoryRepository;
//        this.productRepository = productRepository;
//        this.priceRepository = priceRepository;
//    }

    //    private MentorRepository mentorRepository;
//
//    ProductServiceApplication(@Qualifier("tpc") MentorRepository mentorRepository){
//        this.mentorRepository = mentorRepository;
//    }
    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
//        Mentor mentor = new Mentor();
//        mentor.setName("Tarun J");
//        mentor.setEmail("tarun_j@gmail.com");
//        mentor.setAvgRating(4.8);
//        mentorRepository.save(mentor);
//
//        Mentor mentor = new Mentor();
//        mentor.setName("Tarun J");
//        mentor.setEmail("tarun_j@gmail.com");
//        mentor.setAvgRating(4.6);
//        mentorRepository.save(mentor);
//        Category category = new Category();
//        category.setName("Apple");
//        Category savedCategory = categoryRepository.save(category);

//        Optional<Category> optionalCategory = categoryRepository.findById(UUID.fromString("edc39d27-9a94-412d-bb6b-ac1ded88bfca"));
//
//        if(optionalCategory.isEmpty()){
//            throw new Exception("Category is null");

//        Product product = new Product();
//        product.setTitle("Iphone 15 Pro");
//        product.setDescription("Best Iphone ever");
//        product.setCategory(category.get());

//       Product savedProduct =  productRepository.save(product);
//        List<Product> products = optionalCategory.get().getProducts();
//        for(Product product:products){
//            System.out.println(product.getTitle());
//        }

        Price price  = new Price();
        price.setCurrency("INR");
        price.setValue(100000);
       Price savedPrice =  priceRepository.save(price);

       Category category = new Category();
       category.setName("Apple Devices");
        Category savedCategory = categoryRepository.save(category);

        Product product = new Product();
        product.setTitle("Iphone 15 Pro");
        product.setDescription("Best Iphone ever");
        product.setCategory(savedCategory);
        product.setPrice(savedPrice);
        Product savedProduct = productRepository.save(product);


    }
}
