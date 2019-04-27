import com.atvgstudios.klib.extensions.popBegin
import com.atvgstudios.klib.extensions.popEnd
import com.atvgstudios.klib.extensions.prepend

fun main(){
    val x: MutableList<Int> = mutableListOf()
    println(x.popBegin())
    println(x.popEnd())
}