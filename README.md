# Avana bootcamp 2025
Java RESTful API criada para Avana 

## Diagrama de Classes

```mermaid
classDiagram
  class User {
    +String name
    +Account account
    +Feature[] features
    +Card card
    +News[] news
  }

  class Account {
    +String number
    +String agency
    +Float balance
    +Float limit
  }

  class Feature {
    +String icon
    +String description
  }

  class Card {
    +String number
    +Float limit
  }

  class News {
    +String icon
    +String description
  }

  User --> Account
  User --> Card
  User --> Feature
  User --> News
```
