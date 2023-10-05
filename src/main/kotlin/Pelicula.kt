class Pelicula(val titulo: String, val director: String, val fecha: Int) {
    override fun toString(): String {
        return " (titulo: '$titulo',director: '$director',fecha: $fecha)"
    }
}

fun main() {
    val peliculas = mutableMapOf<Int, Pelicula>()
    var cont = 1

    do {
        println("\nMenu Jose Maria:")
        println("1. Ingresar una nueva pelicula")
        println("2. Mostrar una pelicula por su codigo")
        println("3. Buscar una pelicula por su codigo")
        println("4. Borrar una pelicula por su codigo")
        println("5. Editar una pelicula")
        println("6. Mostrar todas las peliculas")
        println("0. Salir del menu")
        print("Elige una opcion: ")
        val opcion = readLine()
        when (opcion) {
            "1" -> {
                print("Introduce el titulo de la pelicula: ")
                val titulo = readLine() ?: ""
                print("Introduce el director de la pelicula: ")
                val director = readLine() ?: ""
                print("Introduce el año de la pelicula: ")
                val fecha = readLine()?.toIntOrNull() ?: 0

                val peli = Pelicula(titulo, director, fecha)
                peliculas[cont] = peli
                println("Pelicula agregada correctamente, su codigo es: $cont")
                cont++
            }

            "2" -> {
                print("Introduce el codigo de la pelicula: ")
                val code = readLine()?.toIntOrNull() ?: 0
                val peli = peliculas[code]
                if (peli != null) {
                    println("Pelicula encontrada: $peli")
                } else {
                    println("Pelicula no encontrada, vuelve a intentarlo")
                }
            }

            "3" -> {
                print("Introduce el codigo de la pelicula: ")
                val code = readLine()?.toIntOrNull() ?: 0
                val peli = peliculas[code]
                if (peli != null) {
                    println("Pelicula encontrada: $peli")
                } else {
                    println("Pelicula no encontrada, vuelve a intentarlo")
                }
            }

            "4" -> {
                print("Introduce el codigo de la pelicula: ")
                val code = readLine()?.toIntOrNull() ?: 0
                val peli = peliculas.remove(code)
                if (peli != null) {
                    println("La pelicula ha sido eliminada correctamente")
                } else {
                    println("No se encontro ninguna pelicula con ese codigo, vuelve a intentarlo")
                }
            }

            "5" -> {
                print("Introduce el codigo de la pelicula: ")
                val code = readLine()?.toIntOrNull() ?: 0
                val peli = peliculas[code]
                if (peli != null) {
                    print("Introduce un nuevo nombre para la pelicula: ")
                    val nuevoTitulo = readLine() ?: peli.titulo
                    print("Introduce un nuevo director de la pelicula: ")
                    val nuevoDirector = readLine() ?: peli.director
                    print("Introduce una nueva fecha para la pelicula: ")
                    val nuevaFecha = readLine()?.toIntOrNull() ?: peli.fecha

                    peliculas[code] = Pelicula(nuevoTitulo, nuevoDirector, nuevaFecha)
                    println("Pelicula modificada correctamente")
                } else {
                    println("El codigo introducido es incorrecto, vuelve a intentarlo")
                }
            }

            "6" -> {
                println("Lista de peliculas:")
                peliculas.forEach {
                    print("$it\n")
                }
                println()
            }

            "0" -> {
                println("Saliendo del menu....")
            }

            else -> println("La opcion que has introducido no es correcta, vuelve a intentarlo")
        }
    } while (opcion != "0")
}