Feature: Consumir la API booker
  Un cliente quiere consumir la API para crear, consultar o actualizar un libro

  @CrearLibro
  Scenario Outline: El cliente crea un libro
    Given El usuario consume la api "https://restful-booker.herokuapp.com"
    When El usuario crea un libro con la data
      |firstname  |lastname  |totalprice  |depositpaid  |checkin  |checkout  |additionalneeds  |
      |<firstname>|<lastname>|<totalprice>|<depositpaid>|<checkin>|<checkout>|<additionalneeds>|
    Then El status de la API es <status>
    Examples:
    |firstname|lastname|totalprice|depositpaid|checkin   |checkout  |additionalneeds|status|
    |Jim      |Brown   |111       |true       |2018-01-01|2019-01-01|Breakfast      |200   |
    |         |        |          |           |          |          |               |500   |

  @ConsultarLibro
  Scenario: El cliente consulta un libro
    Given El usuario consume la api "https://restful-booker.herokuapp.com"
    And El usuario crea un libro con la data
      |firstname  |lastname  |totalprice  |depositpaid  |checkin   |checkout  |additionalneeds|
      |Jim        |Brown     |111         |true         |2018-01-01|2019-01-01|Breakfast      |
    When El usuario consulta el libro creado
    Then El status de la API es 200
    And El data es la correcta
      |firstname  |lastname  |totalprice  |depositpaid  |checkin   |checkout  |additionalneeds  |
      |Jim        |Brown     |111         |true         |2018-01-01|2019-01-01|Breakfast        |

  @ConsultarLibroNoExistente
  Scenario: El cliente consulta un libro
    Given El usuario consume la api "https://restful-booker.herokuapp.com"
    When El usuario consulta el libro "7286382713"
    Then El status de la API es 404

  @ActualizarLibro
  Scenario Outline: El cliente actualiza un libro
    Given El usuario consume la api "https://restful-booker.herokuapp.com"
    And El usuario crea un libro con la data
      |firstname  |lastname  |totalprice  |depositpaid  |checkin   |checkout  |additionalneeds  |
      |Jim        |Brown     |111         |true         |2018-01-01|2019-01-01|Breakfast        |
    And El usuario crea un usuario
      |username  |password   |
      |admin     |password123|
    When El usuario actualiza el libro creado
      |firstname   |lastname    |totalprice |depositpaid |checkin   |checkout  |additionalneeds |
      |<firstname>|<lastname>|<totalprice>|<depositpaid>|<checkin>|<checkout>|<additionalneeds>|
    Then El status de la API es <status>
    Examples:
      |firstname   |lastname    |totalprice |depositpaid |checkin   |checkout  |additionalneeds |status |
      |Se actualizo|Se actualizo|1          |false       |2021-03-07|2021-03-07|Se actualizo    |200    |
      |            |            |           |            |          |          |                |400    |