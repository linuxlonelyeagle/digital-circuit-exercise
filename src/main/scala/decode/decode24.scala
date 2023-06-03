package decode

import chisel3._ 

class decode24 extends Module {
  val io = IO(new Bundle {
    val input = Input(UInt(2.W)) 
    val enable = Input(Bool())
    val out = Output(UInt(4.W))
  })

  val vec_out = Wire(Vec(4, UInt(1.W))) 
  vec_out.foreach(_ := 0.U)
  when(io.enable) {
    for (i <- 0 until 4) {
      when(io.input === i.U) {
        vec_out(i) := 1.U
      }       
    }
  }
  io.out := vec_out.asUInt
}