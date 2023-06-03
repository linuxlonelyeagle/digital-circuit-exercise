package mux

import chisel3._ 

class m_mux21 extends Module {
  val io = IO( new Bundle {
    val a = Input(UInt(1.W))
    val b = Input(UInt(1.W))
    val s = Input(UInt(1.W))
    val output = Output(UInt(1.W))
  })
    io.output := (~ io.s & io.a) | (io.s & io.b) 
}

