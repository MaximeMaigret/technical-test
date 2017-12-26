package verto.analytic.exercise.string.delete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import verto.analytic.exercise.string.search.SearchService;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/verto-analytic")
public class DeleteController {

    @Autowired
    private DeleteService service;

    /**
     * Delete one of the stored set previously uploaded
     *
     * @param  deleteString  the exact set previously uploaded
     */

    @PostMapping("/delete")
    public void deleteSet(@RequestBody Set<String> deleteString){
        service.delete(deleteString);
    }

}
