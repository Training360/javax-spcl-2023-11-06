package training.functionsdemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.function.context.FunctionCatalog;
import org.springframework.cloud.function.context.catalog.SimpleFunctionRegistry;

@SpringBootTest
class FunctionsDemoApplicationTests {

    @Autowired
    FunctionCatalog functionCatalog;

    @Test
    void contextLoads() {
        var function = (SimpleFunctionRegistry.FunctionInvocationWrapper) functionCatalog.lookup("uppercase|substring");
        System.out.println(function.getClass());

        var result = function.apply("john");
        System.out.println(result);

    }

}
