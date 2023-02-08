package DanilaZaytsev.car_numbers.numberGeneration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/number")
public class NumberGenerationController {
    private final NumberGenerationService numberGenerationService;
    @Autowired
    public NumberGenerationController(NumberGenerationService numberGenerationService) {
        this.numberGenerationService = numberGenerationService;
    }


    @GetMapping("/random")
    public String random() {
        return numberGenerationService.getRandom();
    }

    @GetMapping("/next")
    public String next() {
        return numberGenerationService.getNext();
    }
}
