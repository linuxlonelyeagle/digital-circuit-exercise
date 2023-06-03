package shaftregister

import chisel3._ 

class shaftregister extends Module {
  val io = IO ( new Bundle {
    val in = Input(UInt(1.W))
    val out = Output(UInt(4.W))
  })
  val state = RegInit(UInt(4.W), 0.U)
  val nextState = (state << 1) | io.in 
  state := nextState
  io.out := state
}
