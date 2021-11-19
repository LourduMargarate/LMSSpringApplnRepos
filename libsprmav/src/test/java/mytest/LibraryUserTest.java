package mytest;

import java.text.SimpleDateFormat;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import com.mph.controller.LibraryUserController;

import com.mph.entity.LibraryUser;
import com.mph.service.LibraryUserService;


@WebMvcTest(value =LibraryUserController.class)
@ContextConfiguration(classes = {LibraryUserController.class})
@AutoConfigureMockMvc
public class LibraryUserTest {
	private MockMvc mockMvc;
    @InjectMocks
    LibraryUserController libraryUserController;
    
    @Mock
    LibraryUserService libraryUserService;

    @Before
    public void setUp(){
    	MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(libraryUserController)
                .build();
    }
    @Test
    public void testgetUser() throws Exception{
    	/*SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
    	java.util.Date myDate = new java.util.Date("2009-10-10");
    	java.sql.Date date = new java.sql.Date(myDate.getTime());
    	  */
    	
    	LibraryUser  l = new LibraryUser(1,"margarate","margarate@gmail.com","female",8296393803L);
        Mockito.when(libraryUserService.getLibraryUserById(1)).thenReturn(l);
        mockMvc.perform(MockMvcRequestBuilders.get("/user/userById/1")
        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.userid", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name",Matchers.is("margarate")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email",Matchers.is("margarate@gmail.com")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.gender",Matchers.is("female")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.phno",Matchers.is(8296393803L)));
        
                
                
        Mockito.verify(libraryUserService).getLibraryUserById(1);
    }

}