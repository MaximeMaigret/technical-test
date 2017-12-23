package verto.analytic.exercise.string;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Repository
public class StringRepository {

    private List<Set<String>> storedStrings = new ArrayList<>();

    public List<Set<String>> getAllStoredSetString() {
        return storedStrings;
    }

    public void addSet(Set<String> toUpload) {
        storedStrings.add(toUpload);
    }
}
