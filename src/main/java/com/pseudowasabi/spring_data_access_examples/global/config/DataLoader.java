package com.pseudowasabi.spring_data_access_examples.global.config;

import com.pseudowasabi.spring_data_access_examples.model.jpa.Furniture;
import com.pseudowasabi.spring_data_access_examples.model.jpa.Manufacturer;
import com.pseudowasabi.spring_data_access_examples.repository.jpa.FurnitureRepository;
import com.pseudowasabi.spring_data_access_examples.repository.jpa.ManufacturerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner initData(FurnitureRepository furnitureRepository,
                               ManufacturerRepository manufacturerRepository) {
        return args -> {
            furnitureRepository.save(new Furniture("AIRCON", "SAMSUNG", 5, 12));
            furnitureRepository.save(new Furniture("FRIDGE", "SAMSUNG", 10, 36));
            furnitureRepository.save(new Furniture("AIRCON", "LG", 3, 6));
            furnitureRepository.save(new Furniture("FRIDGE", "LG", 12, 48));
            furnitureRepository.save(new Furniture("AIRCON", "DAEWOO", 0, 0));

            manufacturerRepository.save(new Manufacturer("SAMSUNG", "SUWON", "031-1234-5678"));
            manufacturerRepository.save(new Manufacturer("LG", "SEOUL", "02-1324-5768"));
        };
    }
}
