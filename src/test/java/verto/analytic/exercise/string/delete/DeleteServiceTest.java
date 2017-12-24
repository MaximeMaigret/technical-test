package verto.analytic.exercise.string.delete;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import verto.analytic.exercise.string.SetNotFoundException;
import verto.analytic.exercise.string.StringRepository;
import verto.analytic.exercise.string.search.SearchService;

import java.util.*;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class DeleteServiceTest {

    @InjectMocks
    private DeleteService service;

    @Mock
    private StringRepository repository;

    @Before
    public void setUp() {
        initMocks(this);
    }

    @Test
    public void should_delete_set_if_exists(){
        Set<String> setString = new HashSet<>(Arrays.asList("111", "222", "333"));
        List<Set<String>> storedSet = Collections.singletonList(setString);

        when(repository.deleteSet(setString)).thenReturn(Boolean.TRUE);

        service.delete(setString);
    }

    @Test(expected = SetNotFoundException.class)
    public void should_delete_throws_exception_if_not_exists(){

        Set<String> setString = new HashSet<>(Arrays.asList("aaa", "bbb", "ccc"));

        when(repository.deleteSet(setString)).thenReturn(Boolean.FALSE);

        service.delete(setString);
    }

}
