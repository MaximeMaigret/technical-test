package verto.analytic.exercise.string.search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/verto-analytic")
public class SearchController {

    @Autowired
    private SearchService service;

    /**
     * Returns the list of all the the stored set who contain the searched string
     *
     * @param  searchString  the string searched
     * @return      the list of all the set containing the searched string
     */
    @PostMapping("/search")
    public List<Set<String>> searchString(@RequestBody String searchString){
        return service.search(searchString);
    }

}
