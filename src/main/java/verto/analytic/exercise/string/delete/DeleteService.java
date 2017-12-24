package verto.analytic.exercise.string.delete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import verto.analytic.exercise.string.SetNotFoundException;
import verto.analytic.exercise.string.StringRepository;

import java.util.Set;

@Service
public class DeleteService {

    @Autowired
    StringRepository repository;

    public void delete(Set<String> setString) {
        boolean isDeleteSuccess = repository.deleteSet(setString);
        if(!isDeleteSuccess){
            throw new SetNotFoundException("Failed to delete the set : "+setString);
        }
    }
}
