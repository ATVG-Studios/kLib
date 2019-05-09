import klib.extensions.quicksort
import klib.types.queue.Queue
import java.lang.Thread.sleep

fun main(){
    val queue = Queue()
    queue += {
        println("1. Queue Function")
    }
    queue += {
        println("2. Queue Function")
    }
    queue += {
        println("3. Queue Function")
    }
    queue += {
        println("4. Queue Function")
    }
    queue += {
        println("5. Queue Function")
    }
    while(queue.hasItems){
        queue()
    }
    queue += {
        println("6. Queue Function")
    }
}