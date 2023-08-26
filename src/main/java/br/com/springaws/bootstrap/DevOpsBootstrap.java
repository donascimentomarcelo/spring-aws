package br.com.springaws.bootstrap;

import br.com.springaws.domain.Author;
import br.com.springaws.domain.Product;
import br.com.springaws.domain.ProductCategory;
import br.com.springaws.repositories.AuthorRepository;
import br.com.springaws.repositories.ProductCategoryRepository;
import br.com.springaws.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class DevOpsBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private ProductCategoryRepository productCategoryRepository;
    private ProductRepository productRepository;

    @Autowired
    public void setAuthorRepository(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Autowired
    public void setProductCategoryRepository(ProductCategoryRepository productCategoryRepository) {
        this.productCategoryRepository = productCategoryRepository;
    }

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        this.productRepository.deleteAll();
        this.authorRepository.deleteAll();
        this.productCategoryRepository.deleteAll();

        Author jt = new Author();
        jt.setFirstName("Marcelo");
        jt.setLastName("Sant'Anna");
        jt.setId(1);
        jt.setImage("instructor_jt.jpg");

        jt = authorRepository.save(jt);

        ProductCategory springIntroCat = new ProductCategory();
        springIntroCat.setId(1);
        springIntroCat.setCategory("Spring Introduction");

        springIntroCat = productCategoryRepository.save(springIntroCat);

        ProductCategory springCoreCat = new ProductCategory();
        springCoreCat.setId(2);
        springCoreCat.setCategory("Spring Core");

        springCoreCat = productCategoryRepository.save(springCoreCat);

        ProductCategory springBootCat = new ProductCategory();
        springBootCat.setId(3);
        springBootCat.setCategory("Spring Boot");

        springBootCat = productCategoryRepository.save(springBootCat);

        ProductCategory thymeleafCat = new ProductCategory();
        thymeleafCat.setId(4);
        thymeleafCat.setCategory("Thymeleaf");

        thymeleafCat = productCategoryRepository.save(thymeleafCat);

        ProductCategory geapCat = new ProductCategory();
        geapCat.setId(5);
        geapCat.setCategory("G.E.A.P");

        geapCat = productCategoryRepository.save(geapCat);

        Product springIntro = new Product();
        springIntro.setId(1);
        springIntro.setName("Introduction to Spring");
        springIntro.setSubtitle("Start Learning Spring!");
        springIntro.setAuthor(jt);
        springIntro.setDescription("Why would you want to learn about the Spring Framework? Simple, Spring is the most widely used framework in the enterprise today. Major companies all over the world are hiring programmers who know the Spring Framework.\n" +
                "\n" +
                "My Introduction Spring Framework Tutorial is designed to give you an introduction to the Spring Framework. This  is written for beginners. Ideally before taking the , you should already have a foundation with the Java programming language. You don't need to be an expert in Java, but you should the basics of Object Oriented Programming with Java.\n" +
                "\n" +
                "You will learn what Dependency Injection is, and how Spring uses Inversion of Control to leverage Dependency Injection. Next in my , I will walk you step by step through building your very first Spring Framework application. I'll show you hot to use the Spring Initializer and Spring Boot to jumpstart your Spring Framework project. Ideally, you can follow along and create your own Spring project. I know it can be frustrating to follow along in a  and run into errors. So don't worry, I have the complete source code examples in Git for you to checkout and use.");
        springIntro.setPrice(new BigDecimal("0"));
        springIntro.getProductCategories().add(springIntroCat);
        springIntro.getProductCategories().add(springBootCat);
        springIntro.setVersion(1);

        springIntro = productRepository.save(springIntro);

        Product springCoreUltimate = new Product();
        springCoreUltimate.setId(2);
        springCoreUltimate.setName("Spring Core Ultimate");
        springCoreUltimate.setSubtitle("Ultimate Bundle of Spring Core!");
        springCoreUltimate.setAuthor(jt);
        springCoreUltimate.setDescription("Why would you want to learn about the Spring Framework? Simple, Spring is the most widely used framework in the enterprise today. Major companies all over the world are hiring programmers who know the Spring Framework.\n" +
                "\n" +
                "My Introduction Spring Framework Tutorial is designed to give you an introduction to the Spring Framework. This  is written for beginners. Ideally before taking the , you should already have a foundation with the Java programming language. You don't need to be an expert in Java, but you should the basics of Object Oriented Programming with Java.\n" +
                "\n" +
                "You will learn what Dependency Injection is, and how Spring uses Inversion of Control to leverage Dependency Injection. Next in my , I will walk you step by step through building your very first Spring Framework application. I'll show you hot to use the Spring Initializer and Spring Boot to jumpstart your Spring Framework project. Ideally, you can follow along and create your own Spring project. I know it can be frustrating to follow along in a  and run into errors. So don't worry, I have the complete source code examples in Git for you to checkout and use.");
        springCoreUltimate.setPrice(new BigDecimal("199"));
        springCoreUltimate.getProductCategories().add(springCoreCat);
        springCoreUltimate.getProductCategories().add(springBootCat);
        springCoreUltimate.setVersion(5);

        springCoreUltimate = productRepository.save(springCoreUltimate);

        Product thymeleaf = new Product();
        thymeleaf.setId(3);
        thymeleaf.setName("Thymeleaf");
        thymeleaf.setSubtitle("Thymeleaf and Spring!");
        thymeleaf.setAuthor(jt);
        thymeleaf.setDescription("Why would you want to learn about the Spring Framework? Simple, Spring is the most widely used framework in the enterprise today. Major companies all over the world are hiring programmers who know the Spring Framework.\n" +
                "\n" +
                "My Introduction Spring Framework Tutorial is designed to give you an introduction to the Spring Framework. This  is written for beginners. Ideally before taking the , you should already have a foundation with the Java programming language. You don't need to be an expert in Java, but you should the basics of Object Oriented Programming with Java.\n" +
                "\n" +
                "You will learn what Dependency Injection is, and how Spring uses Inversion of Control to leverage Dependency Injection. Next in my , I will walk you step by step through building your very first Spring Framework application. I'll show you hot to use the Spring Initializer and Spring Boot to jumpstart your Spring Framework project. Ideally, you can follow along and create your own Spring project. I know it can be frustrating to follow along in a  and run into errors. So don't worry, I have the complete source code examples in Git for you to checkout and use.");
        thymeleaf.setPrice(new BigDecimal("399"));
        thymeleaf.getProductCategories().add(thymeleafCat);
        thymeleaf.setVersion(3);

        thymeleaf = productRepository.save(thymeleaf);

        Product springCore = new Product();
        springCore.setId(4);
        springCore.setName("Spring Core");
        springCore.setSubtitle("Spring Core - mastering Spring!");
        springCore.setAuthor(jt);
        springCore.setDescription("Why would you want to learn about the Spring Framework? Simple, Spring is the most widely used framework in the enterprise today. Major companies all over the world are hiring programmers who know the Spring Framework.\n" +
                "\n" +
                "My Introduction Spring Framework Tutorial is designed to give you an introduction to the Spring Framework. This  is written for beginners. Ideally before taking the , you should already have a foundation with the Java programming language. You don't need to be an expert in Java, but you should the basics of Object Oriented Programming with Java.\n" +
                "\n" +
                "You will learn what Dependency Injection is, and how Spring uses Inversion of Control to leverage Dependency Injection. Next in my , I will walk you step by step through building your very first Spring Framework application. I'll show you hot to use the Spring Initializer and Spring Boot to jumpstart your Spring Framework project. Ideally, you can follow along and create your own Spring project. I know it can be frustrating to follow along in a  and run into errors. So don't worry, I have the complete source code examples in Git for you to checkout and use.");
        springCore.setPrice(new BigDecimal("499"));
        springCore.getProductCategories().add(springCoreCat);
        springCore.getProductCategories().add(springBootCat);
        springCore.setVersion(2);

        springCore = productRepository.save(springCore);

        Product springCoreAdv = new Product();
        springCoreAdv.setId(5);
        springCoreAdv.setName("Spring Core Advanced");
        springCoreAdv.setSubtitle("Advanced Spring Core!");
        springCoreAdv.setAuthor(jt);
        springCoreAdv.setDescription("Why would you want to learn about the Spring Framework? Simple, Spring is the most widely used framework in the enterprise today. Major companies all over the world are hiring programmers who know the Spring Framework.\n" +
                "\n" +
                "My Introduction Spring Framework Tutorial is designed to give you an introduction to the Spring Framework. This  is written for beginners. Ideally before taking the , you should already have a foundation with the Java programming language. You don't need to be an expert in Java, but you should the basics of Object Oriented Programming with Java.\n" +
                "\n" +
                "You will learn what Dependency Injection is, and how Spring uses Inversion of Control to leverage Dependency Injection. Next in my , I will walk you step by step through building your very first Spring Framework application. I'll show you hot to use the Spring Initializer and Spring Boot to jumpstart your Spring Framework project. Ideally, you can follow along and create your own Spring project. I know it can be frustrating to follow along in a  and run into errors. So don't worry, I have the complete source code examples in Git for you to checkout and use.");
        springCoreAdv.setPrice(new BigDecimal("699"));
        springCoreAdv.getProductCategories().add(springCoreCat);
        springCoreAdv.getProductCategories().add(springBootCat);
        springCoreAdv.setVersion(7);

        springCoreAdv = productRepository.save(springCoreAdv);

        Product springCoreDevOps = new Product();
        springCoreDevOps.setId(6);
        springCoreDevOps.setName("Spring Core Dev-Ops");
        springCoreDevOps.setSubtitle("Deploying Spring in the Enterprise and the cloud!");
        springCoreDevOps.setAuthor(jt);
        springCoreDevOps.setDescription("Why would you want to learn about the Spring Framework? Simple, Spring is the most widely used framework in the enterprise today. Major companies all over the world are hiring programmers who know the Spring Framework.\n" +
                "\n" +
                "My Introduction Spring Framework Tutorial is designed to give you an introduction to the Spring Framework. This  is written for beginners. Ideally before taking the , you should already have a foundation with the Java programming language. You don't need to be an expert in Java, but you should the basics of Object Oriented Programming with Java.\n" +
                "\n" +
                "You will learn what Dependency Injection is, and how Spring uses Inversion of Control to leverage Dependency Injection. Next in my , I will walk you step by step through building your very first Spring Framework application. I'll show you hot to use the Spring Initializer and Spring Boot to jumpstart your Spring Framework project. Ideally, you can follow along and create your own Spring project. I know it can be frustrating to follow along in a  and run into errors. So don't worry, I have the complete source code examples in Git for you to checkout and use.");
        springCoreDevOps.setPrice(new BigDecimal("999"));
        springCoreDevOps.getProductCategories().add(springCoreCat);
        springCoreDevOps.getProductCategories().add(springBootCat);
        springCoreDevOps.setVersion(9);

        springCoreDevOps = productRepository.save(springCoreDevOps);
    }
}
