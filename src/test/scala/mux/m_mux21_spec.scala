package mux

import chisel3._
import chiseltest._
import org.scalatest.freespec.AnyFreeSpec
import chisel3.experimental.BundleLiterals._


class m_mux21_spec extends AnyFreeSpec with  ChiselScalatestTester {
   "mux21 test start" in {
    test(new m_mux21()) { mux => 
      mux.io.a.poke(1)
      mux.io.b.poke(0)
      mux.io.s.poke(0)
      mux.io.output.expect(1)
      mux.io.a.poke(0)
      mux.io.b.poke(1)
      mux.io.s.poke(1)
      mux.io.output.expect(1)
    }
  }
}