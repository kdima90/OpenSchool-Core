package kdima90.openschool.school.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Locale;
import java.util.UUID;
import kdima90.openschool.school.request.entity.SchoolRequestEntity;
import kdima90.openschool.school.response.SchoolResponseEntity;
import kdima90.openschool.school.service.SchoolServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(SchoolController.class)
class SchoolControllerTest {
  @MockBean private SchoolServiceImpl schoolServiceImpl;
  @Autowired private MockMvc mockMvc;
  @Autowired private ObjectMapper objectMapper;

  @Test
  void createSchoolShouldBeHttp200() throws Exception {
    String request =
        """
                        {
                            "name":"test school",
                            "street":"test street",
                            "streetNumber": 1,
                            "city":"test city",
                            "postalCode":"123456A",
                            "federalState":"test federal state",
                            "locale": "de"
                        }
                """;

    SchoolResponseEntity schoolResponseEntity =
        new SchoolResponseEntity(
            UUID.randomUUID(),
            "test school",
            "test street",
            1,
            "test city",
            "123456A",
            "test federal state",
            Locale.GERMANY);

    BDDMockito.when(schoolServiceImpl.save(BDDMockito.any(SchoolRequestEntity.class)))
        .thenReturn(schoolResponseEntity);

    mockMvc
        .perform(
            MockMvcRequestBuilders.post("/api/school")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(request))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(
            MockMvcResultMatchers.content()
                .json(objectMapper.writeValueAsString(schoolResponseEntity)))
        .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));
  }
}
