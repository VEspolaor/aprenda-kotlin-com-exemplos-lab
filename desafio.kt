enum class Nivel { Basico, Intermediario, Avançado }

data class Usuario (val nome: String)

data class ConteudoEducacional(val nome: String, val duracao: Int = 60, val nivel : Nivel)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>, val nivel: Nivel) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
         inscritos.add(usuario)
    }
}

fun main() {
    val ListaConteudos = listOf<ConteudoEducacional>(
    ConteudoEducacional(" Java",60, Nivel.Avançado),
    ConteudoEducacional(" JavaScript",50, Nivel.Intermediario),
    ConteudoEducacional(" Python",45, Nivel.Basico)
    )
    val Kotlin = Formacao ("Kotlin",ListaConteudos,Nivel.Avançado)
    
    Kotlin.matricular(Usuario("Jonas"))
    
    println("Curso ${Kotlin.nome} de nivel ${Kotlin.nivel}")
    Kotlin.inscritos.forEach {
        println("${it.nome} está matriculado no curso de ${Kotlin.nome}, ele vai aprender:")
    }
    Kotlin.conteudos.forEach{
        println(" ${it.nome}, com duração de ${it.duracao}  minutos, de nivel ${it.nivel}")
    }
   
}
