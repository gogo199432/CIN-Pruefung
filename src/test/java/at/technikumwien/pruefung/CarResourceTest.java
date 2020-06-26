package at.technikumwien.pruefung;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
@Tag("integration-test")
public class CarResourceTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Test
    public void testRetrieve() throws Exception{
        var requestBuilder = MockMvcRequestBuilders.get("/resources/cars/1").accept(MediaType.APPLICATION_JSON);

        mockMvc
            .perform(requestBuilder)
            .andExpect(status().isOk())
            .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.id").value(1));
    }

    @Test
    public void testRetrieveAll() throws Exception{
        var requestBuilder = MockMvcRequestBuilders.get("/resources/cars").accept(MediaType.APPLICATION_JSON);

        var response = mockMvc.perform(requestBuilder).andReturn().getResponse();

        var cars = objectMapper.readValue(response.getContentAsString(), new TypeReference<List<Car>>() {});

        assertEquals(HttpStatus.OK.value(),response.getStatus());
        assertThat(response.getContentType()).containsIgnoringCase(MediaType.APPLICATION_JSON_VALUE);
        assertEquals(2,cars.size());
    }
}
