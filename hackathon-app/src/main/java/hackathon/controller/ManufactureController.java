package hackathon.controller;

import hackathon.model.Manufacture;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/manufacture")
public class ManufactureController {


    @GetMapping("/getData")
    public List<Manufacture> sayHi() {
        Manufacture manufacture = new Manufacture();
        manufacture.setId("ООО \"ЛЕРАН\"");
        manufacture.setAddress("ул. Пушкина, д. 65, ПОМЕЩЕНИЕ 6");
        manufacture.setCity("Челябинск");
        manufacture.setCoords(String.format(
                "%s, %s" ,
                BigDecimal.valueOf(55.1937143),
                BigDecimal.valueOf(61.3648531)));
        manufacture.setType("Медицинское оборудование и техника");
        manufacture.setInn("7453210048");
        manufacture.setLicense("№59 от 22.04.2013");
        return Collections.singletonList(manufacture);
    }

}
