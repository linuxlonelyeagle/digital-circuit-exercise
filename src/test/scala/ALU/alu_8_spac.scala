package ALU

import chisel3._
import chiseltest._
import org.scalatest.freespec.AnyFreeSpec
import chisel3.experimental.BundleLiterals._

class alu_8_spac extends AnyFreeSpec with  ChiselScalatestTester {
  "alu_8_spac" in {
    test(new alu_8) { alu => 
      alu.io.a.poke(0.U)
      alu.io.b.poke(0.U)
      alu.io.o.expect(0.U)
      
      alu.io.a.poke(11.U)
      alu.io.b.poke(11.U)
      alu.io.o.expect(22.U)

      alu.io.a.poke(100.U)
      alu.io.b.poke(100.U)
      alu.io.o.expect(200.U)

      alu.io.a.poke(200.U)
      alu.io.b.poke(100.U)
      alu.io.o.expect(44.U)
      alu.io.c.expect(1.U)
    }
  }
}
