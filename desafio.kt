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
    ConteudoEducacional(" Python",40, Nivel.Basico)
    )
    val Kotlin = Formacao ("Kotlin",ListaConteudos,Nivel.Avançado)
    
    Kotlin.matricular(Usuario("Jonas"))
    
    println("Curso ${Kotlin.nome} de nivel ${Kotlin.nivel}")
    Kotlin.conteudos.forEach{
        println("${it.nome}, duração ${it.duracao} minutos,nivel ${it.nivel}")
    }
    Kotlin.inscritos.forEach {
        println("${it.nome} está matriculado no curso de ${Kotlin.nome}")
    }
}
