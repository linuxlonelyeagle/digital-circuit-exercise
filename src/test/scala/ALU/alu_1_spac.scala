package ALU

import chisel3._
import chiseltest._
import org.scalatest.freespec.AnyFreeSpec
import chisel3.experimental.BundleLiterals._

class alu_1_spac extends AnyFreeSpec with  ChiselScalatestTester {
  "alu_1_spac" in {
    test(new alu_1) { alu_1 => 
      alu_1.io.a.poke(0.U)
      alu_1.io.b.poke(0.U) 
      alu_1.io.c.poke(0.U)
      alu_1.io.s.expect(0.U)
      alu_1.io.n.expect(0.U)
      // a = 0 b = 1 c = 0
      alu_1.io.b.poke(1.U)
      alu_1.io.s.expect(1.U)
      alu_1.io.n.expect(0.U)
      // a= 1 b = 0 
      alu_1.io.a.poke(1.U)
      alu_1.io.b.poke(0.U)
      alu_1.io.s.expect(1.U)
      alu_1.io.n.expect(0.U)
      // a = 1 b = 1 c = 0
      alu_1.io.a.poke(1.U)
      alu_1.io.b.poke(1.U)
      alu_1.io.c.poke(0.U)
      alu_1.io.s.expect(0.U)
      alu_1.io.n.expect(1.U)      
      // a = 1 b = 1 c = 0
      alu_1.io.c.poke(1.U)
      alu_1.io.s.expect(1.U)
      alu_1.io.n.expect(1.U)

    }
  }
}
