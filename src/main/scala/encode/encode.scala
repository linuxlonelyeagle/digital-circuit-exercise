package encode

import chisel3._

class encode extends Module {
  val io = IO( new Bundle {
    val input = Input(UInt(4.W))
    val out = Output(UInt(2.W))
  })
  io.out := 0.U
  for (i <- 0 until 4) {
    when(io.input(i) === 1.U) {
      io.out := i.U
    }
  }
}