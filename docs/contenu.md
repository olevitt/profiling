# Les experts JVM saison 1 : profiling

## Olivier Levitt (olivier.levitt@gmail.com), [Insee](https://insee.fr)

## [@LevittOlivier](https://twitter.com/LevittOlivier)

### Code / slides : [https://github.com/olevitt/profiling](https://github.com/olevitt/profiling)

--

<!-- .slide: class="slide" -->

# Le crime

![](images/bug-report.png)

<!-- .element: class="fragment" -->

--

![](images/poireau.png)

--

![](images/cherlock.png)

--

## Retour aux sources

![](images/experts.jpg)

--

# On commence par quoi ?

## Aller sur la scène de crime

ou

## Interroger les suspects

--

# Le matériel

--

# VisualVM

https://visualvm.github.io/

- Profiler
- CPU, mémoire, SQL

=> Local, dev (JMX)

--

# Glowroot

https://glowroot.org/

- APM (Application performance management)
- Very (very) low overhead
- "Java-aware"

=> Local, dev, prod

--

# Arthas

https://github.com/alibaba/arthas

- "Diagnostic tool"
- Boite à outils magique
- Monitoring
- Décompilation / recompilation

=> Local, dev, (prod)

--

# L'enquête continue !

https://github.com/olevitt/profiling

![](images/chat.jpg)<!-- .element height="30%" width="30%" -->
