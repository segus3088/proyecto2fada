Proyecto 2 FADA
=============

# Punto 1 #

Hay n estudiantes encargados de monitorias de
salas, las cuales se realizan solamente el día
lunes. Cada uno de los estudiantes realiza un
único turno el cual corresponde a un intervalo
continuo de tiempo.
Se quiere elegir los monitores que van a
hacerse cargo de la sala, para esto se busca
asignar los monitores de forma que no hayan
cruces en los horarios de los monitores seleccionados
y se maximice el tiempo que la sala se
encuentre en funcionamiento en el día.
El problema que usted debe resolver es encontrar
la combinación óptima de monitores que
deben realizar los turnos en sala.

## Ejemplo ##

Suponga que n = 5 y los turnos son:

Laura 0:00 - 8:00

Andres 5:00 - 12:00

Camilo 11:00 - 22:00

Sandra 12:00 - 24:00

Jhon 5 22:00 - 24:00

La selección de monitores optima consiste en
*Laura, Camilo y Jhon* con una disponibilidad
de la sala sería de **21 horas.**

## Entrada ##

n

nombre-1 hInicio-1 hFin-1

...

nombre-n hInicio-n hFin-n


Donde la primera linea contiene un numero n
que representa la cantidad de monitores y las siguientes n lineas corresponden a la información
de cada monitor, donde se incluye el nombre, la
hora de inicio y hora de finalización del turno.


## Salida ##
Se espera que la salida sea un archivo de texto
en cual la primera linea corresponde al número
***c*** de monitores que realizan sus monitorias
en la sala, la segunda linea contenga el tiempo
disponible de la sala con su selección y las
siguientes ***c*** lineas corresponden a los nombres
de los monitores seleccionados.

# Punto 2 #

Antes de la invención de fotocopiadoras realizar
copias de un libro era un trabajo hecho a
mano por escritores que se podían tomar meses
en realizar la copia de un libro.
Hace mucho tiempo un profesor de teatro
quería presentar una obra famosa en el festival
anual de teatro. Pero el libreto de la obra
estaba dividido en m libros cada uno con una
cantidad de páginas ***p*** y necesitaba una copia
por cada libro lo mas rápido posible.
Para realizar el trabajo se contrataron ***n*** escritores
en los cuales se debe dividir el trabajo
de forma que a cada escritor se le asigne una
secuencia continua de libros, es decir, si tengo
una secuencia ***l0, l1,l2, ..., lm*** a un escritor le
puede corresponder los libros que estan entre
***l0*** y ***l3***.
Su trabajo es repartir los libros entre los escritores
de forma que el tiempo que se demoren
realizando las copias sea el mínimo teniendo en
cuenta que el tiempo que se demoran en realizar
las copias depende del escritor que tenga
mas páginas asignadas. Hacer la copia de una
página tiene una duración de un día.


## Entrada ##

*n m*

nombrelibro-1 paginas-1

...

nombrelibro-m paginas-m


Donde la primera linea contiene un numero ***n***
que representa la cantidad de escritores y un
número ***m*** que representa la cantidad de libros.
Las siguientes ***m*** lineas contienen la información
de los ***m*** libros, donde se incluye el nombre
y la cantidad de páginas que contiene.


## Salida ##

Se espera que la salida sea un archivo de texto
donde la primera linea sea el tiempo en días que
se demora realizar la copia de todos los libros
y cada una las ***n*** lineas siguientes represente la
distribución de libros elegida.