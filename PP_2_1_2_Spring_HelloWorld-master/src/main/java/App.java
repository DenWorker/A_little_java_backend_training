import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(AppConfig.class);
        HelloWorld beanHelloWorld1 =
                (HelloWorld) applicationContext.getBean("helloworld");
        HelloWorld beanHelloWorld2 =
                (HelloWorld) applicationContext.getBean("helloworld");

        Cat beanCat1 = (Cat) applicationContext.getBean("cat");
        Cat beanCat2 = (Cat) applicationContext.getBean("cat");

        System.out.println(beanHelloWorld1.getMessage());


        System.out.println(beanHelloWorld1);
        System.out.println(beanHelloWorld2);
        System.out.println(beanCat1);
        System.out.println(beanCat2);
        System.out.println();

        System.out.println(beanHelloWorld1.equals(beanHelloWorld2));
        System.out.println(beanCat1.equals(beanCat2));

    }
}