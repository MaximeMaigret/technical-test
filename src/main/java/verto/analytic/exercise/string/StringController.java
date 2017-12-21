package verto.analytic.exercise.string;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/verto-analytic")
public class StringController {

    @Autowired
    private StringService service;

    @PostMapping("/upload/{newString}")
    public String uploadString(@PathVariable String newString){
        return service.upload(newString);
    }
}
