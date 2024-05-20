import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class MyConfigBean
{
    //配置负载均衡实现RestTemplate
    @Bean
    @LoadBalanced //ribbon的作用
    public RestTemplate getRestTemplate()
    {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate;
    }

}