package ALU

import chisel3._ 
import chisel3.experimental.SourceInfo
import scala.collection.mutable._

class alu_1 extends Module {
  val io = IO(new Bundle {
    val a = Input(UInt(1.W))
    val b = Input(UInt(1.W))
    // carray
    val c = Input(UInt(1.W))
    // result
    val s = Output(UInt(1.W))
    // next carray 
    val n = Output(UInt(1.W))
  })
  io.s := io.a ^ io.b ^ io.c 
  io.n := (io.a & io.b) | ((io.a ^ io.b) & io.c)
}

class alu_8 extends Module {
  val io = IO(new Bundle {
    val a = Input(UInt(8.W))
    val b = Input(UInt(8.W))
    var o = Output(UInt(8.W))
    val c = Output(UInt(1.W))
  })

  // carrys 
  val carrys = ArrayBuffer.empty[UInt]
  val as = ArrayBuffer.empty[UInt]
  val bs = ArrayBuffer.empty[UInt]
  val cs = ArrayBuffer.empty[UInt]
  // result
  val ss = ArrayBuffer.empty[UInt]
  val vec_wire = Wire(Vec(8, UInt(1.W)))
  for ( i <- 0 until 8) {
    val alu1 = Module(new alu_1)
    carrys += alu1.io.n 
    as += alu1.io.a 
    bs += alu1.io.b 
    ss += alu1.io.s
    cs += alu1.io.c
  }
  // 连接carry位
  for (i <- 0 until 8) {
    if (i == 0)
      cs(i) := 0.U
    else 
      cs(i) := carrys(i-1)

  }

  for (i <- 0 until 8) {
    as(i) := io.a(i)
    bs(i) := io.b(i)
    vec_wire(i) := ss(i)
  }
  io.o := vec_wire.asUInt
  io.c := carrys(7)
}