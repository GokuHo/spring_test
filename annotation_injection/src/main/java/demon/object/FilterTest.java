package demon.object;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Component
public class FilterTest {
    public FilterTest() {
        System.out.println("Component class: non-parameter constructor");
    }
}

@Repository
class RepositoryClass {
    public RepositoryClass() {
        System.out.println("Repository class: non-parameter constructor");
    }
}

@Service
class ServiceClass {
    public ServiceClass() {
        System.out.println("Service class: non-parameter constructor");
    }
}

@Controller
class ControllerClass {
    public ControllerClass() {
        System.out.println("Controller class: non-parameter constructor");
    }
}
