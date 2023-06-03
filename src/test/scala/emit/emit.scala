package emit

import chisel3._
import shaftregister.shaftregister

object emit extends App {
  emitVerilog(new shaftregister)   
}