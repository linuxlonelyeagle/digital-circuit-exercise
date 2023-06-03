package shaftregister

import chisel3._
import chiseltest._
import org.scalatest.freespec.AnyFreeSpec
import chisel3.experimental.BundleLiterals._

class shaftregister_spec extends AnyFreeSpec with ChiselScalatestTester {
  "shaftregister_spec" in {
    test(new shaftregister) { register => 
      register.io.in.poke(1.U)
      register.clock.step()
      register.io.out.expect(1.U) 
      register.io.in.poke(0.U)
      register.clock.step()
      register.io.out.expect(2.U)
    }

  }
}