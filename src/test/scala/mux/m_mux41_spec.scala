package mux

import chisel3._
import chiseltest._
import org.scalatest.freespec.AnyFreeSpec
import chisel3.experimental.BundleLiterals._

class m_mux41_spec extends AnyFreeSpec with  ChiselScalatestTester {
   "mux41 test start" in {
    test(new m_mux41) { mux => 
      // select a0 
      mux.io.a.poke(1.U)
      mux.io.s.poke(0.U)
      mux.io.output.expect(1.U)
      // select a1 
      mux.io.a.poke(2.U) 
      mux.io.s.poke(1.U)
      mux.io.output.expect(1.U)
      // select a2 
      mux.io.a.poke(4.U)
      mux.io.s.poke(2.U)
      mux.io.output.expect(1.U)
      // selcect a3 
      mux.io.a.poke(8.U)
      mux.io.s.poke(3.U)
      mux.io.output.expect(1.U)
    }
  }
}