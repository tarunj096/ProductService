package com.productservice.productservice;

import com.productservice.productservice.models.Category;
import com.productservice.productservice.models.Price;
import com.productservice.productservice.models.Product;
import com.productservice.productservice.repositories.PriceRepository;
import com.productservice.productservice.repositories.CategoryRepository;
import com.productservice.productservice.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@SpringBootApplication
    public class ProductServiceApplication implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    private final PriceRepository priceRepository;

    public ProductServiceApplication(CategoryRepository categoryRepository,
                                     ProductRepository productRepository,
                                     PriceRepository priceRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
        this.priceRepository = priceRepository;
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
//    @Transactional
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
//        Category category = new Category();
//        category.setName("Apple Devices");
//        Category savedCategory = categoryRepository.save(category);
//
//        Price price = new Price();
//        price.setCurrency("GBP");
//        price.setValue(10000);
//
//
//        Product product = new Product();
//        product.setPrice(price);
//        product.setTitle("Iphone 15 pro");
//        product.setDescription("Best IPhone");
//        product.setImage("IMG");
//        product.setCategory(category);
//        Product savedProduct = productRepository.save(product);

//        Optional<Category> optionalCategory = categoryRepository.findById(UUID.fromString("e79549fa-54db-47c4-9642-98b6418bc744"));
//        if (optionalCategory.isEmpty()){
//            throw new Exception("Category is null");
//        }
//
//        Category category = optionalCategory.get();
       //priceRepository.deleteById(UUID.fromString( "2a104b38-36be-4d97-a037-c03b8cdf1e7f"));

       // List<Product> productList = productRepository.findAllByTitle("Iphone 15 pro");

        List<Product> productList = productRepository.findAllByPrice_ValueGreaterThan(500);

        List<Product> products = productRepository.findAllByPrice_ValueBetween(100,10000);
    }
}
