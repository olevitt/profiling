# Les experts JVM saison 1 : profiling

Slides : https://olevitt.github.io/profiling

Un crime a eu lieu en prod !
Sur la scène de crime, un message ensanglanté : "java.lang.OutOfMemoryError: Java heap space". Ensemble, nous allons mener l'enquête et ausculter une application Java sous différents angles : CPU, mémoire, threads, requêtes SQL…
Comme toute bonne police scientifique, nous aurons de bons outils : VisualVM, Glowroot et Arthas.

## Principe

Le dossier `app` contient un serveur web classique et basique, volontairement non optimisée.  
C'est un bon prétexte pour y tester différents outils de profiling.  
L'application utilise `spring-boot` et peut donc être lancée directement via maven :

```
mvn spring-boot:run
```

L'application écoute sur le port `8080`.  
Pour tester les 3 endpoints, on peut utiliser la page `index.html` du dossier `front`.

Arriverez vous à comprendre tout ce qui se passe dans l'application **sans lire le code** ?

## Les enquêtes

Les enquêtes sont présentées dans le fichier [ENQUETES.md](ENQUETES.md)

## Outils utilisés

### VisualVM

https://visualvm.github.io/

### Glowroot

https://glowroot.org/

### Arthas

https://github.com/alibaba/arthas
