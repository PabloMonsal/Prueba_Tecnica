Feature: Agregar productos al carrito
  Un cliente quiere agregar algunos productos al carrito

  @AgregarProductos
  Scenario: El cliente agrega productos al carrito
    Given El cliente ingresa a la pagina "https://www.demoblaze.com"
    When El cliente selecciona los productos y los agrega al carrito
    Then Los productos seleccionados estan en el carrito

  @EliminarProductos
  Scenario: El cliente agrega productos al carrito y los elimina
    Given El cliente ingresa a la pagina "https://www.demoblaze.com"
    And El cliente selecciona los productos y los agrega al carrito
    When El cliente elimina un producto del carrito
    Then Los productos seleccionados estan en el carrito