package ui;

import org.openqa.selenium.By;

public class WompiUI {

    public By inputMontoAPagar = By.xpath("//input");

    public By btnContinuar = By.xpath("//button");

    public By btnPagarConTarjeta = By.xpath("//a[div[text()='Paga con tus tarjetas']]");

    public By btnPagarConPSE = By.xpath("//a[div[text()='Transfiere con tu cuenta de ahorros o corriente']]");

    public By btnPagarConNEQUI = By.xpath("//a[div[text()='Paga con tu cuenta Nequi']]");

    public By inputCorreo = By.id("email");

    public By inputNombres = By.id("fullName");

    public By inputTelefono = By.id("number");

    public By inputNumeroTarjeta = By.id("cardNumber");

    public By inputCVC = By.id("code");

    public By selectMes = By.id("expirationMonth");

    public By selectAno = By.id("expirationYear");

    public By inputNombreTarjeta = By.id("cardHolder");

    public By selectTipoIdentificacion = By.id("legal_id_option");

    public By inputNumeroDocumento = By.id("legal_id_number");

    public By selectNumeroCuotas = By.id("installments");

    public By checkboxAceptarTerminos = By.id("acceptance");

    public By selectBanco = By.id("financialInstitutionCode");

    public By selectTipoIdentificacionPSE = By.id("userLegalIdType");

    public By inputNumeroDocumentoPSE = By.id("userLegalId");

    public By inputNumeroNEQUI = By.id("mobilePhone");

    public By labelTransaccionAprobada = By.xpath("//span[contains(text(), 'aprobada')]");

}
