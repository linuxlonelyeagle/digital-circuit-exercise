package FSM

import chisel3._
import chiseltest._
import org.scalatest.freespec.AnyFreeSpec
import chisel3.experimental.BundleLiterals._ 

class fsm_spec extends AnyFreeSpec with  ChiselScalatestTester {
  "fsm_spec" in {
    test(new fsm) { fsm => 
      fsm.io.in.poke(0.U)
      fsm.clock.step()
      // B state
      fsm.io.out.expect(0.U)

      fsm.clock.step(3) 
      // E state 
      fsm.io.out.expect(1.U)

      // E state
      fsm.clock.step()
      fsm.io.out.expect(1.U)
      
      // F
      fsm.io.in.poke(1.U)
      fsm.clock.step()
      fsm.io.out.expect(0.U)
      
      // I
      fsm.clock.step(3)
      fsm.io.out.expect(1.U)

      // reset
      fsm.io.reset.poke(true.B)
      fsm.clock.step()
      fsm.io.out.expect(0.U)
    }
  }
}