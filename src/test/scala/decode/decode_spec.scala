package decode

import chisel3._
import chiseltest._
import org.scalatest.freespec.AnyFreeSpec
import chisel3.experimental.BundleLiterals._

class decode_spec extends AnyFreeSpec with  ChiselScalatestTester {
   "decode test start" in {
    test(new decode24()) { decode => 
     // enable = false 
     decode.io.input.poke(false.B)
     decode.io.out.expect(0.U)
     // enable = true 
     decode.io.enable.poke(true.B) 
     
     decode.io.input.poke(0.U)
     decode.io.out.expect(1.U)

     decode.io.input.poke(1.U)
     decode.io.out.expect(2.U)

     decode.io.input.poke(2.U)
     decode.io.out.expect(4.U)

     decode.io.input.poke(3.U)
     decode.io.out.expect(8.U)

    }
  }
}
