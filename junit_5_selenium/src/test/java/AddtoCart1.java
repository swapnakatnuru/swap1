import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AddtoCart1 {

    public static WebDriver driver;
    String homepageExpectedTitle="nopCommerce demo store";
    String homepageActualTitle;
  @BeforeAll
       public static void setup()
      {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.navigate().to("https://demo.nopcommerce.com");
        driver.manage().window().maximize();
      }
    @Test
    @Order(1)
       public void addToCart()
        {
        homepageActualTitle=driver.getTitle();
        Assertions.assertEquals(homepageExpectedTitle,homepageActualTitle);
        System.out.println("Homepage Title matches ");
        }
    @Test
    @Order(2)
        public void computersLink()
       {
        WebElement e1 = driver.findElement(By.linkText("Computers"));
        Actions actions = new Actions(driver);
        actions.moveToElement(e1).perform();
        driver.findElement(By.linkText("Desktops")).click();
        String dsktitle = driver.getTitle();
        System.out.println("Title of page: " + dsktitle);
        System.out.println("---------------------------");
        }
    @Test
    @Order(3)
    public void addToCartBtn() throws InterruptedException {
      Thread.sleep(1000);
        driver.findElement(By.xpath("(//button[text()='Add to cart'])[1]")).click();
        String add = driver.getTitle();
        System.out.println("Add cart page Title: "+add);
        System.out.println("---------------------------");
       // driver.navigate().refresh();
    }
    @Test
    @Order(4)
    public void processorDropDown(){
      driver.navigate().refresh();
        WebDriverWait w11 =new WebDriverWait(driver,10);
        w11.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='product_attribute_label_1'] ")));
        String s2=driver.findElement(By.xpath("//*[@id='product_attribute_label_1']")).getText();
        System.out.println("Select Name: "+s2);
        Select s1=new Select(driver.findElement(By.name("product_attribute_1")));
        s1.selectByValue("1");
        WebElement option=s1.getFirstSelectedOption();
        String a1=option.getText();
        System.out.println("option selected in Processor: "+ a1);
        System.out.println("---------------------------");
        }
        @Test
        @Order(5)
        public void ramDropDown()  {
          WebDriverWait w11 =new WebDriverWait(driver,10);
         w11.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='product_attribute_label_2']")));
         String s3=driver.findElement(By.xpath("//*[@id='product_attribute_label_2']")).getText();
         System.out.println("Select Name: "+s3);
         System.out.println("---------------------------");
        WebDriverWait w2 =new WebDriverWait(driver,20);
         w2.until(ExpectedConditions.visibilityOfElementLocated(By.name("product_attribute_2")));
        Select s4=new Select(driver.findElement(By.name("product_attribute_2")));
        s4.selectByValue("3");
         WebElement option1= s4.getFirstSelectedOption();
         String a2=option1.getText();
         System.out.println("RAM option selected is: "+a2);
    }
      @Test
      @Order(6)
       public void radioBtn1() {
        WebDriverWait w3 = new WebDriverWait(driver, 10);
        w3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='product_attribute_label_3']")));
        String s5 = driver.findElement(By.xpath("//*[@id='product_attribute_label_3']")).getText();
        System.out.println("Select Name: " + s5);
        System.out.println("---------------------------");

        driver.findElement(By.xpath("//input[@id='product_attribute_3_6']")).click();
        boolean b1 = driver.findElement(By.xpath("//input[@id='product_attribute_3_6']")).isEnabled();
        Assertions.assertTrue(b1, "radio button 320gb is Enabled");
        System.out.println("Radio button1 for HDD is enabled:  " + b1);
        System.out.println("---------------------------");
    }
       @Test
       @Order(7)
        public void radioBtn2(){
        WebDriverWait w4 =new WebDriverWait(driver,10);
        w4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='product_attribute_label_4']")));
        String s6=driver.findElement(By.xpath("//*[@id='product_attribute_label_4']")).getText();
        System.out.println("Select Name: "+s6);
        driver.findElement(By.xpath("//input[@id='product_attribute_4_8']")).click();
        boolean b2=driver.findElement(By.xpath("//input[@id='product_attribute_4_8']")).isEnabled();
        Assertions.assertTrue(b2,"os radio button is enabled");
        System.out.println("Radio button1 for OS is enabled:  "+b2);
        System.out.println("---------------------------");
    }
    @Test
    @Order(8)
    public void checkBoxText(){
        WebDriverWait w5 =new WebDriverWait(driver,10);
        w5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='product_attribute_label_5']")));
        String s7=driver.findElement(By.xpath("//*[@id='product_attribute_label_5']")).getText();
        System.out.println("Select Name: "+s7);
        System.out.println("---------------------------");
    }
    @Test
    @Order(9)
    public void chechBox1() {
        WebElement chck1 = driver.findElement(By.xpath("//label[text()='Microsoft Office [+$50.00]']"));
        boolean c1 = chck1.isSelected();
        Assertions.assertFalse(c1,"checkbox1 is selected");

        System.out.println("First checkbox is Selected:" + c1);
        System.out.println("First checkbox is clicked");
        boolean c5= chck1.isDisplayed();
        Assertions.assertTrue(c5,"checkbox1 is displayed");
        System.out.println("First checkbox is Dispalyed:"+chck1.isDisplayed());
        System.out.println("-------------------------------");    }
    @Test
    @Order(10)
    public void chechBox2(){
        WebDriverWait w6 =new WebDriverWait(driver,35);
        w6.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='product_attribute_5_11']")));
        WebElement chck2=driver.findElement(By.xpath("//label[text()='Acrobat Reader [+$10.00]']"));
        chck2.click();
        boolean c3=chck2.isSelected();

        Assertions.assertFalse(c3,"second checkbox is selected");

        System.out.println("Second checkbox is selected:"+chck2.isSelected());
        System.out.println("Second Checkbox is clicked ");
        boolean c4 = chck2.isDisplayed();
       Assertions.assertTrue(c4,"second checkbox is displayed");
        System.out.println("Second Checkbox is displayed: "+chck2.isDisplayed());
        System.out.println("--------------------------------");

    }
    @Test
    @Order(11)
    public void chechBox3(){
        WebElement chck3=driver.findElement(By.xpath("//label[text()='Total Commander [+$5.00]']"));
        chck3.click();
        boolean c6=chck3.isSelected();
        Assertions.assertFalse(c6,"chechbx3 is selected");
        System.out.println("Third checkbox is selected:"+chck3.isSelected());
        System.out.println("Third Checkbox is clicked ");
        boolean c7=chck3.isDisplayed();
        Assertions.assertTrue(c7,"checkbox is displayed");
        System.out.println("Third Checkbox is displayed: "+chck3.isDisplayed());
        System.out.println("--------------------------------");
       }
       @Test
       @Order(12)
       public void productQty() {
           WebElement inputbox = driver.findElement(By.id("product_enteredQuantity_1"));
           inputbox.clear();
           inputbox.sendKeys("3");
           String i1 = inputbox.getAttribute("value");
           Assertions.assertEquals(3, 3);
           System.out.println("Number of items to be added in the cart: " + i1);
       }
       @Test
       @Order(13)
       public void AddtoCartBtn(){
           WebElement btn=driver.findElement(By.cssSelector("button#add-to-cart-button-1"));
           WebDriverWait w7 =new WebDriverWait(driver,45);
           w7.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button#add-to-cart-button-1")));
           btn.click();
           boolean bt1=btn.isEnabled();
           Assertions.assertTrue(bt1,"add to cart is enabled");
           System.out.println("Add to cart button is clicked: "+btn.isEnabled());
           WebDriverWait w8 =new WebDriverWait(driver,55);
           w8.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='bar-notification']")));


       }@Test
       @Order(14)
       public void itemaddedtoCart(){
         String s1="The product has been added to your shopping cart";
         String s2;
        WebElement s8=driver.findElement(By.xpath("//*[@id='bar-notification']"));
        s2= s8.getText();
        Assertions.assertEquals(s1,s2);
        System.out.println("Confirmation of Suceesfully item added in the cart:  "+s8.getText());

       }
       @Test
       @Order(15)

       public void WishlistBtn(){
           WebElement btn1=  driver.findElement(By.id("add-to-wishlist-button-1"));
           btn1.click();
           boolean bt2=btn1.isEnabled();
           Assertions.assertTrue(bt2,"wishlist button is enabled");
           WebDriverWait w9 =new WebDriverWait(driver,25);
           w9.until(ExpectedConditions.visibilityOfElementLocated(By.id("add-to-wishlist-button-1")));
           System.out.println("Wishlist button clicked: "+btn1.isEnabled());
  }

           @Test
           @Order(16)
           public void wishlistMessage(){
           String s11="The product has been added to your shopping cart";
           String s12;
           WebElement link= driver.findElement(By.xpath("//div[@class='bar-notification success']"));
           s12=link.getText();
           Assertions.assertEquals(s11,s12);
           String l1=link.getText();
           System.out.println(l1);
       }

    @AfterAll
    public static void tearDown()
    {
        driver.close();
    }
}
