package verto.analytic.exercise.string.upload;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import verto.analytic.exercise.string.StringRepository;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

public class UploadServiceTest {

    @InjectMocks
    private UploadService service;

    @Mock
    private StringRepository repository;

    @Before
    public void setUp(){
        initMocks(this);
    }

    @Test
    public void should_take_any_number_of_string_on_upload() {
        List<String> entry = (Arrays.asList("aaa", "bbb", "ccc"));

        service.upload(entry);

        verify(repository).addSet(new HashSet<>(entry));
    }
}
