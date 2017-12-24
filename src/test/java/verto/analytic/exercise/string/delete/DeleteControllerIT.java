package verto.analytic.exercise.string.delete;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.springframework.test.annotation.DirtiesContext.MethodMode.BEFORE_METHOD;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class DeleteControllerIT {


    @Autowired
    private MockMvc mvc;

    /*
        Integration tests
     */
    @Test
    @DirtiesContext(methodMode = BEFORE_METHOD)
    public void should_return_ok_if_string_exist_and_deleted() throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        List<String> setString = Arrays.asList("aaa", "bbb", "ccc");
        String contentSet = mapper.writeValueAsString(setString);
        mvc.perform(post("/verto-analytic/upload").content(contentSet).contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());

        mvc.perform(post("/verto-analytic/delete").content(contentSet).contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());

        mvc.perform(post("/verto-analytic/search").content("bbb").contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isEmpty());

    }

    @Test
    @DirtiesContext(methodMode = BEFORE_METHOD)
    public void should_return_404_if_string_not_exist() throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        List<String> setString = Arrays.asList("aaa", "bbb", "ccc");
        String contentSet = mapper.writeValueAsString(setString);


        mvc.perform(post("/verto-analytic/delete").content(contentSet).contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotFound());

    }
}
