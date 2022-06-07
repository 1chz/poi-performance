package io.github.shirohoo.poi;

import io.github.shirohoo.poi.performance.Person;
import io.github.shirohoo.poi.performance.PersonJpaRepository;
import java.util.List;
import java.util.stream.IntStream;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class PoiPerformanceApplication {
    public static void main(String[] args) {
        SpringApplication.run(PoiPerformanceApplication.class, args);
    }

    @Component
    @RequiredArgsConstructor
    private static class ApplicationRunner implements CommandLineRunner {
        private final PersonJpaRepository repository;

        @Override
        public void run(String... args) throws Exception {
            List<Person> people = IntStream.range(0, 100_000)
                    .mapToObj(i -> new Person(
                            "person%s" .formatted(i),
                            i, i, i, i, i, i, i, i, i, i
                    ))
                    .toList();

            repository.saveAll(people);
        }
    }
}
