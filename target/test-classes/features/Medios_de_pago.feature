@TODO
Feature: Transacciones Wompi - Medios de pago

  @TARJETA_CREDITO
  Scenario: Tarjeta de credito - Aprobada
    Given Accedo a la pagina "https://checkout.co.uat.wompi.dev/l/stagtest_VPOS_bdQraT"
    When Ingreso el monto a pagar 5000
    And Selecciono pago por tarjeta de credito "prueba@prueba.com" "prueba" "3213212121"
    And Realizo el pago por tarjeta de credito "4242424242424242" "123" "01" "25" "Prueba" "CC - Cédula de Ciudadanía" "1112233" 2
    Then Espero a que la transaccion sea aprobada
  
  @PSE
  Scenario: PSE - Aprobada
    Given Accedo a la pagina "https://checkout.co.uat.wompi.dev/l/stagtest_VPOS_bdQraT"
    When Ingreso el monto a pagar 5000
    When Selecciono el pago por PSE "prueba@prueba.com" "prueba" "3213212121"
    When Realizo el pago por PSE "Banco que aprueba" "CC - Cédula de ciudadanía" "1112233"
    Then Espero a que la transaccion sea aprobada

  @NEQUI
  Scenario: NEQUI - Aprobada
    Given Accedo a la pagina "https://checkout.co.uat.wompi.dev/l/stagtest_VPOS_bdQraT"
    When Ingreso el monto a pagar 5000
    When Selecciono el pago por NEQUI "prueba@prueba.com" "prueba" "3213212121"
    When Realizo el pago por NEQUI "3991111111"
    Then Espero a que la transaccion sea aprobada