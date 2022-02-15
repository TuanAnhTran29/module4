import com.repo.IBlogRepo;
import com.service.BlogService;
import com.service.IBlogService;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BlogServiceTestConfig {
    @Bean
    public IBlogService blogService(){
        return new BlogService();
    }

    @Bean
    public IBlogRepo blogRepo(){
        return Mockito.mock(IBlogRepo.class);
    }
}
