package verto.analytic.exercise.string;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class StringControllerSearchIT {

    @Autowired
    private MockMvc mvc;

    /*
        Integration tests
     */
    @Test
    public void should_return_the_set_containing_the_string() throws Exception{
        ObjectMapper mapper = new ObjectMapper();

        List<String> setString= Arrays.asList("aaa", "bbb", "ccc");
        String contentSet = mapper.writeValueAsString(setString);
        mvc.perform(post("/verto-analytic/upload").content(contentSet).contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());

        String search = "bbb";
        String contentSearch = mapper.writeValueAsString(search);

        mvc.perform(post("/verto-analytic/search").content(contentSearch).contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0]").value(setString));
    }
    
    @Test
    public void should_return_all_the_set_containing_the_string() throws Exception{
        ObjectMapper mapper = new ObjectMapper();

        List<String> firstSet= Arrays.asList("aaa", "bbb", "ccc");
        String contentFirstSet = mapper.writeValueAsString(firstSet);
        mvc.perform(post("/verto-analytic/upload").content(contentFirstSet).contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
        
        List<String> secondSet= Arrays.asList("111", "bbb", "222");
        String contentSecondSet = mapper.writeValueAsString(secondSet);
        mvc.perform(post("/verto-analytic/upload").content(contentSecondSet).contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());

        String search = "bbb";
        String contentSearch = mapper.writeValueAsString(search);

        mvc.perform(post("/verto-analytic/search").content(contentSearch).contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0]").value(firstSet))
                .andExpect(jsonPath("$[1]").value(secondSet));
    }

    @Test
    public void should_return_empty_if_string_not_in_any_set() throws Exception{
        ObjectMapper mapper = new ObjectMapper();

        String search = "bbb";
        String contentSearch = mapper.writeValueAsString(search);

        mvc.perform(post("/verto-analytic/search").content(contentSearch).contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isEmpty());
    }
}
