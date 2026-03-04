Feature: Test de  Produit

  Scenario: Ajout de produit au panier
    Given je suis sur la page home
    When  je clique sur le button add to cart
    And je clique sur button panier
    Then le produit est ajouté avec succés