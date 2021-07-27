import org.junit.jupiter.api.*;

public class Annotations
{
    @BeforeAll
    public static void beforeAll()
    {
        System.out.println("Executes before all");
    }

    @AfterAll
    public static void afterAll()
    {
        System.out.println("Executes After all");
    }

    @BeforeEach
    public  void beforeEach()
    {
        System.out.println("Executes before each ");
    }

    @AfterEach
    public  void afterEach() {
        System.out.println("Executes after each");
    }

    @Test
    public  void test1() {
        System.out.println("test1");
    }

    @Test
    public void test2() {
        System.out.println("test2");
    }

    @Test
    public  void test3() {
        System.out.println("test3");
    }

}