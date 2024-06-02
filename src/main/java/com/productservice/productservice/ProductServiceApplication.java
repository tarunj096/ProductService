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
//     q    Category category = new Category();
//        category.setName("Apple Devices");
//
//        Category savedCategory = categoryRepository.save(category);
//
//
////        Optional<Category> optionalCategory = categoryRepository.findById(UUID.fromString("f41ebf01-5cc5-4f4c-a8aa-6dcd149e481d"));
////        if (optionalCategory.isEmpty()) {
////            throw new Exception("Category was null");
////        }
//
////        Category category1 = savedCategory.get();
//        Product product = new Product();
//        product.setTitle("iPhone 15 pro");
//        product.setDescription("Best iPhone ever");
//        product.setCategory(savedCategory);
//
//        Product savedProduct = productRepository.save(product);
//
//
//       // Find all the products with category = Apple Devices.
////        List<Product> products = category.getProducts();
////        for (Product product1 : products) {
////            System.out.println(product.getTitle());
////        }
//
//        Price price = new Price();
//        price.setCurrency("INR");
//        price.setValue(100000);
//        //Price savedPrice = priceRepository.save(price);
//
//        Category category2 = new Category();
//        category2.setName("Apple Devices");
//        Category savedCategoy = categoryRepository.save(category2);
//
//        Product product1 = new Product();
//        product1.setTitle("iPhone 15 pro");
//        product1.setDescription("Best iPhone ever");
//        product1.setCategory(savedCategoy);
//        product1.setPrice(price);
//
//       q Product savedProduct1 = productRepository.save(product);




//            Price price = new Price();
//            price.setCurrency("GBP");
//            price.setValue(10000);

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

//        List<Product> productList = productRepository.findAllByPrice_ValueGreaterThan(500);
//
//        List<Product> products = productRepository.findAllByPrice_ValueBetween(100,10000);
        }
}
