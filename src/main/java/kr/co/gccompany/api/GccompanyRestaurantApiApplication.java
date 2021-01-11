package kr.co.gccompany.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// https://hantsy.medium.com/reactive-accessing-rdbms-with-spring-data-r2dbc-d6e453f2837e
// https://medium.com/@thomasandolf/r2dbc-getting-started-d0afcfc05be2
@SpringBootApplication
public class GccompanyRestaurantApiApplication {

  public static void main(String[] args) {
    SpringApplication.run(GccompanyRestaurantApiApplication.class, args);
  }

}
