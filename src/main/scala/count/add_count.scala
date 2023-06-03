package count

import chisel3._ 

class add_count extends Module{
  val io = IO(new Bundle {
    val en = Input(Bool())
    val out = Output(UInt(3.W))
  })
  val Regs = RegInit(0.U(3.W))
  when(io.en) {
    Regs := Regs + 1.U
  }.otherwise {
    Regs := 0.U
  }
  io.out := Regs
}