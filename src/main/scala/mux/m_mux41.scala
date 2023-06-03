package mux

import chisel3._ 
import chisel3.util.switch
import chisel3.util.is
import chisel3.util.MuxLookup

class m_mux41 extends Module {
  val io = IO(new Bundle {
    val  a = Input(UInt(4.W))
    val  s = Input(UInt(2.W))
    val output = Output(UInt(1.W))
  })

  io.output := MuxLookup(io.s, 0.U, Seq(
    0.U -> io.a(0), 
    1.U -> io.a(1),
    2.U -> io.a(2), 
    3.U -> io.a(3)
  ))
  
}