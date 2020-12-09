# Les enquêtes

Rappel : ces enquêtes doivent être résolues SANS lire une seule ligne de code.

## 1. Un long fleuve tranquille

Cette fonctionnalité permet de calculer le [hash](https://fr.wikipedia.org/wiki/Fonction_de_hachage) (SHA-256) d'un fichier uploadé par l'utilisateur.  
Tout a l'air de bien marcher, non ?

<details>
  <summary>Indice 1</summary>
  
  Cette application est elle vraiment un long fleuve tranquille ?

</details>

<details>
  <summary>Indice 2</summary>
  
  Observer la mémoire utilisée par l'application

</details>

## 2. Un passager clandestin

Cette fonctionnalité tente d'inverser le [hash](https://fr.wikipedia.org/wiki/Fonction_de_hachage) (SHA-256) en cherchant dans une table SQL préconstruite.  
Pourquoi c'est si lent ?

<details>
  <summary>Indice 1</summary>
  
  Si on faisait une filature SQL ?

</details>

<details>
  <summary>Indice 2</summary>
  
  On approche de la fin de la garde à vue du suspect SQL. Coupable ou innocent ?

</details>

<details>
  <summary>Indice 3</summary>
  
  Et si le coupable était ailleurs ?

</details>

## 3. Burnout

Cette fonction est une version simplifiée de l'élément central du minage de bitcoin : le [calcul d'un bloc](https://en.bitcoin.it/wiki/Block_hashing_algorithm).  
Il s'agit de trouver, en fonction de l'input `x` de l'utilisateur, un entier `n` tel que  
`sha256(x:n)` commence par (au moins) un certain nombre de `0` (ce nombre de `0` est appelé difficulté).  
Par exemple, pour une difficulté de `5` (difficulté par défaut de cette application) et pour l'input `toto` (`x`=`toto`), il faut trouver `1029337` car `sha256(toto:1029337)`=`00000deca0f949c4bd452fd1b2aa5f6ed2ebe526f7665003fdaef39199165d29`.

Ca a l'air de bien marcher, non ?

<details>
  <summary>Indice 1</summary>
  
  Est ce qu'il y aurait pas du travail non déclaré ?

</details>

<details>
  <summary>Indice 2</summary>
  
  Attention, j'ai l'impression de voir double

</details>
