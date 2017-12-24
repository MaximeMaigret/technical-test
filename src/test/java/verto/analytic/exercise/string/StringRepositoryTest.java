package verto.analytic.exercise.string;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.MockitoAnnotations.initMocks;

public class StringRepositoryTest {

    @InjectMocks
    private StringRepository repository;

    @Before
    public void setUp(){
        initMocks(this);
    }

    @Test
    public void should_addSet_add_string_into_the_stored(){
        Set<String> entry = new HashSet<>(Arrays.asList("aaa", "bbb", "ccc"));
        repository.addSet(entry);

        List<Set<String>> stored = repository.getAllStoredSetString();

        assertTrue("The stored strings must be the same as the entry one",stored.contains(entry));
    }

    @Test
    public void should_addSet_add_string_into_the_stored_set_if_not_empty(){
        Set<String> initialEntry = new HashSet<>(Arrays.asList("aaa", "bbb", "ccc"));
        repository.addSet(initialEntry);
        Set<String> secondEntry = new HashSet<>(Arrays.asList("111", "222", "333"));
        repository.addSet(secondEntry);

        List<Set<String>> stored = repository.getAllStoredSetString();

        assertTrue("The stored strings must be the same as the entry one",stored.contains(initialEntry));
        assertTrue("The stored strings must be the same as the entry one",stored.contains(secondEntry));
    }

    @Test
    public void should_return_true_if_delete_string_exists(){
        Set<String> initialEntry = new HashSet<>(Arrays.asList("aaa", "bbb", "ccc"));
        repository.addSet(initialEntry);
        Set<String> secondEntry = new HashSet<>(Arrays.asList("111", "222", "333"));
        repository.addSet(secondEntry);

        assertTrue("2 sets are stored in the stored set.", repository.getAllStoredSetString().size() == 2);

        boolean result = repository.deleteSet(secondEntry);

        assertTrue(result);
        assertTrue("Only 1 set left in the stored set.", repository.getAllStoredSetString().size() == 1);
        assertTrue("Initial entry left in the stored set.", repository.getAllStoredSetString().contains(initialEntry));
    }

    @Test
    public void should_return_false_if_delete_string_not_exists(){
        assertTrue("Empty stored set.", repository.getAllStoredSetString().size() == 0);

        Set<String> notExistingEntry = new HashSet<>(Arrays.asList("aaa", "bbb", "ccc"));
        boolean result = repository.deleteSet(notExistingEntry);

        assertFalse(result);
    }
}