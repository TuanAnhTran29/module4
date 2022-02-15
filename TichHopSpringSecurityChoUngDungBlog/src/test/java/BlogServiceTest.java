import com.controller.BlogController;
import com.model.Blog;
import com.model.Category;
import com.repo.IBlogRepo;
import com.service.BlogService;
import com.service.IBlogService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.test.context.junit.jupiter.SpringJUnitJupiterConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringJUnitJupiterConfig(BlogServiceTestConfig.class)
public class BlogServiceTest {
    @Autowired
    private IBlogService blogService;

    @Autowired
    private IBlogRepo blogRepo;

    @AfterEach
    private void resetMock(){
        Mockito.reset(blogRepo);
    }

    @Test
    public void testFindAll(){
        Iterable<Blog> blogs= blogRepo.findAll();
        when(blogRepo.findAll()).thenReturn(blogs);

        Iterable<Blog> actual= blogService.findAll();

        assertEquals(blogs,actual);
    }

    @Test
    public void testFindAllPageable(){
        List<Blog> customers = new ArrayList<>();
        Pageable pageable= PageRequest.of(0,25);
        Page<Blog> blogPage= new PageImpl<Blog>(customers,pageable,1);
        when(blogRepo.findAll(pageable)).thenReturn(blogPage);

        Page<Blog> actual= blogService.findAll(pageable);

        assertEquals(blogPage,actual);
    }

    @Test
    public void testFindById(){
        Blog blog= new Blog(1L,"Tho va Rua","Tho va Rua","con cac",new Category("truyen ngan"));
        when(blogRepo.findById(1L)).thenReturn(Optional.of(blog));
        Optional<Blog> actual= blogService.findById(1L);
        verify(blogRepo).findById(1L);
        assertEquals(Optional.of(blog),actual);
    }




}
