import org.scalatest.FunSuite

import cats._
import cats.data._
import Xor.left
import Xor.right

class XorSchoolTest extends FunSuite{

  test("Smoke test"){
    assert(true)
  }

  test("Construir derecha con Xor"){


    val r = right(1)

    val r1 = r.map(x=>x+1)

    assert(r1 == right(2))
  }

  test("flatmap sobre rights"){
    val r1 = right(1)
    val r2 = right(2)

    val r3 = for{
      a <- r1
      b <- r2
    }yield a + b

    println(r3)

    assert(r3.isRight)
    assert(r3.getOrElse(0)==3)

  }

  test("flatmap con left debe dar left"){

    val r: Xor[Int, Int] = right(1)
    val l: Xor[Int, Int] = left(1000)

    val f = for{
      a <- r
      b <- l
    }yield a + b

    assert(f.isLeft)

  }
}
