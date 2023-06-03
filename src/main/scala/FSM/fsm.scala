package FSM

import chisel3._ 
import chisel3.util.switch
import chisel3.util.is

class fsm extends Module {
  val io = IO(new Bundle {
    val reset = Input(Bool())
    val in = Input(UInt(1.W))
    val out = Output(UInt(1.W))
  })  
  // states 
  val A = 0.U 
  val B = 1.U
  val C = 2.U 
  val D = 3.U 
  val E = 4.U 
  val F = 5.U 
  val G = 6.U 
  val H = 7.U 
  val I = 8.U
  // state 
  val state = RegInit(0.U(4.W))
  when(io.reset) {
    state := A
  }.otherwise {
    switch(state) {
      is(A) {
        when(io.in === 0.U) {
          state := B 
        }.otherwise {
          state := F
        }
      } 
      is(B) {
        when(io.in === 0.U) {
          state := C 
        }.otherwise {
          state := F 
        }
      }
      is(C) {
        when(io.in === 0.U) {
          state := D 
        }.otherwise {
          state := F
        }
      }
      is(D) {
        when(io.in === 0.U) {
          state := E 
        }.otherwise {
          state := F 
        }
      }
      is(E) {
        when(io.in === 0.U) {
          state := E 
        }.otherwise {
          state := F 
        }
      }
      is(F) {
        when(io.in === 0.U) {
          state := B 
        }.otherwise {
          state := G 
        }
      }
      is(G) {
        when(io.in === 0.U) {
          state := B 
        }.otherwise {
          state := H 
        }
      }
      is(H) {
        when(io.in === 0.U) {
          state := B 
        }.otherwise {
          state := I
        }
      }
      is(I) {
        when(io.in === 0.U) {
          state := B 
        }.otherwise {
          state := I
        }
      }
    }
  }
  when(state === E) {
    io.out := 1.U 
  }.elsewhen(state === I) {
    io.out := 1.U 
  }.otherwise {
    io.out := 0.U
  }
}
