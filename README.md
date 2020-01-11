# Les experts JVM saison 1 : profiling

Slides : https://olevitt.github.io/profiling

Un crime a eu lieu en prod !
Sur la scène de crime, un message ensanglanté : "java.lang.OutOfMemoryError: Java heap space". Ensemble, nous allons mener l'enquête et ausculter une application Java sous différents angles : CPU, mémoire, threads, requêtes SQL…
Comme toute bonne police scientifique, nous aurons de bons outils : JVisualVM, Glowroot et Arthas.

## Principe

Le dossier `app` contient une application web classique et basique, volontairement non optimisée.  
C'est un bon prétexte pour y tester différents outils de profiling.  
Le lancement de l'application nécessite maven :

```
mvn spring-boot:run
```

## Contenu de la malette

### VisualVM

https://visualvm.github.io/

### Glowroot

https://glowroot.org/

### Arthas

https://github.com/alibaba/arthas
