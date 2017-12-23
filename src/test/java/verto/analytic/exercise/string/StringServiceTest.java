package verto.analytic.exercise.string;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

import javax.xml.ws.WebFault;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class StringServiceTest {

    @InjectMocks
    private StringService service;

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