package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.WompiUI;
import utils.Wait;

import java.time.Duration;

public class WompiSteps {

    private WebDriver robot;

    private WompiUI wompiUI;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/win/chrome/chromedriver.exe");
        robot = new ChromeDriver();
    }

    @Given("Accedo a la pagina {string}")
    public void accedoALaPagina(String url){
        robot.navigate().to(url);
    }

    @When("Ingreso el monto a pagar {int}")
    public void ingresoElMontoAPagar(int monto){
        wompiUI = new WompiUI();
        robot.findElement(wompiUI.inputMontoAPagar).sendKeys(String.valueOf(monto));
        robot.findElement(wompiUI.btnContinuar).click();
        Wait.forMilliseconds(1000);

    }

    @When("Selecciono pago por tarjeta de credito {string} {string} {string}")
    public void seleccionoPagoPorTarjeta(String correo, String nombres, String telefono){
        robot.findElement(wompiUI.btnPagarConTarjeta).click();
        robot.findElement(wompiUI.inputCorreo).sendKeys(correo);
        robot.findElement(wompiUI.inputNombres).sendKeys(nombres);
        robot.findElement(wompiUI.inputTelefono).sendKeys(telefono);
        Wait.forMilliseconds(1000);
        robot.findElement(wompiUI.btnContinuar).click();
    }

    @When("Realizo el pago por tarjeta de credito {string} {string} {string} {string} {string} {string} {string} {int}")
    public void realizoElPagoPorTarjeta(String numeroTarjeta, String cvc, String mes, String ano, String nombre, String tipoIdentificacion, String numeroDocumento, int numeroCuotas){
        robot.findElement(wompiUI.inputNumeroTarjeta).sendKeys(numeroTarjeta);
        robot.findElement(wompiUI.inputCVC).sendKeys(cvc);
        new Select(robot.findElement(wompiUI.selectMes)).selectByVisibleText(mes);
        new Select(robot.findElement(wompiUI.selectAno)).selectByVisibleText(ano);
        robot.findElement(wompiUI.inputNombreTarjeta).sendKeys(nombre);
        new Select(robot.findElement(wompiUI.selectTipoIdentificacion)).selectByVisibleText(tipoIdentificacion);
        robot.findElement(wompiUI.inputNumeroDocumento).sendKeys(numeroDocumento);
        new Select(robot.findElement(wompiUI.selectNumeroCuotas)).selectByVisibleText(String.valueOf(numeroCuotas));
        robot.findElement(wompiUI.checkboxAceptarTerminos).click();
        Wait.forMilliseconds(1000);
        robot.findElement(wompiUI.btnContinuar).click();
        Wait.forMilliseconds(20000);
    }

    @When("Selecciono el pago por PSE {string} {string} {string}")
    public void seleccionoElPagoPorPSE(String correo, String nombres, String telefono){
        robot.findElement(wompiUI.btnPagarConPSE).click();
        robot.findElement(wompiUI.inputCorreo).sendKeys(correo);
        robot.findElement(wompiUI.inputNombres).sendKeys(nombres);
        robot.findElement(wompiUI.inputTelefono).sendKeys(telefono);
        Wait.forMilliseconds(1000);
        robot.findElement(wompiUI.btnContinuar).click();
        Wait.forMilliseconds(1000);
    }

    @When("Realizo el pago por PSE {string} {string} {string}")
    public void realizoElPagoPorPSE(String banco, String tipoIdentificacion, String numeroIdentificacion){
        new Select(robot.findElement(wompiUI.selectBanco)).selectByVisibleText(banco);
        new Select(robot.findElement(wompiUI.selectTipoIdentificacionPSE)).selectByVisibleText(tipoIdentificacion);
        robot.findElement(wompiUI.inputNumeroDocumentoPSE).sendKeys(numeroIdentificacion);
        robot.findElement(wompiUI.checkboxAceptarTerminos).click();
        Wait.forMilliseconds(1000);
        robot.findElement(wompiUI.btnContinuar).click();
        Wait.forMilliseconds(20000);
    }

    @When("Selecciono el pago por NEQUI {string} {string} {string}")
    public void seleccionoElPagoPorNEQUI(String correo, String nombres, String telefono){
        robot.findElement(wompiUI.btnPagarConNEQUI).click();
        robot.findElement(wompiUI.inputCorreo).sendKeys(correo);
        robot.findElement(wompiUI.inputNombres).sendKeys(nombres);
        robot.findElement(wompiUI.inputTelefono).sendKeys(telefono);
        Wait.forMilliseconds(1000);
        robot.findElement(wompiUI.btnContinuar).click();
        Wait.forMilliseconds(1000);
    }

    @When("Realizo el pago por NEQUI {string}")
    public void realizoElPagoPorNEQUI(String numero){
        robot.findElement(wompiUI.inputNumeroNEQUI).sendKeys(numero);
        robot.findElement(wompiUI.checkboxAceptarTerminos).click();
        Wait.forMilliseconds(1000);
        robot.findElement(wompiUI.btnContinuar).click();
        Wait.forMilliseconds(20000);
    }

    @Then("Espero a que la transaccion sea aprobada")
    public void esperoQueLaTransaccionSeaAprobada(){
        WebDriverWait wait = new WebDriverWait(robot, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(robot.findElement(wompiUI.labelTransaccionAprobada)));
    }

    @After
    public void tearDown(){
        robot.quit();
    }
}
