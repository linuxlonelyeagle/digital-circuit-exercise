package encode

package decode

import chisel3._
import chiseltest._
import org.scalatest.freespec.AnyFreeSpec
import chisel3.experimental.BundleLiterals._ 

class encode_spec extends AnyFreeSpec with  ChiselScalatestTester {
  "encode_spec test start" in 
  test(new encode) { encode => 
    encode.io.input.poke(1.U)
    encode.io.out.expect(0.U)

    encode.io.input.poke(2.U)
    encode.io.out.expect(1.U)

    encode.io.input.poke(4.U)
    encode.io.out.expect(2.U)

    encode.io.input.poke(8.U)
    encode.io.out.expect(3.U)
  }
}