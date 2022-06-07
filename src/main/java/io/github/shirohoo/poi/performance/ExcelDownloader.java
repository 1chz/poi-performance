package io.github.shirohoo.poi.performance;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/excel")
@RequiredArgsConstructor
public class ExcelDownloader {
    private final PersonJpaRepository repository;

    @GetMapping("/xssf")
    public ModelAndView forXSSF() {
        Map<String, Person> content = repository.findAll()
                .stream()
                .collect(toMap(Person::getName, identity()));

        return new ModelAndView(new XlsxViewV1(), content);
    }

    @GetMapping("/sxssf")
    public ModelAndView forSXSSF() {
        Map<String, Person> content = repository.findAll()
                .stream()
                .collect(toMap(Person::getName, identity()));

        return new ModelAndView(new XlsxViewV2(), content);
    }
}
