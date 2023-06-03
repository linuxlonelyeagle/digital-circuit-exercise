package count

import chisel3._
import chiseltest._
import org.scalatest.freespec.AnyFreeSpec
import chisel3.experimental.BundleLiterals._

class add_count_spec extends AnyFreeSpec with ChiselScalatestTester {
  "add_count_spec" in {
    test(new add_count) { count => 
      count.io.en.poke(true.B)
      count.clock.step()
      count.io.out.expect(1.U)
      count.clock.step(5)
      count.io.out.expect(6.U)
      
      count.io.en.poke(false.B)
      count.clock.step(1)
      count.io.out.expect(0.U)
    }

  }
}