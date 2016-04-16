import mobi.jnkymd.nlp100._

import org.scalatest.FunSpec

class P00Spec extends FunSpec {
  describe("ch.00") {
    describe("reverse 'stressed") {
      it("should equals 'desserts") {
        assert(p00.ReverseString("stressed") == "desserts")
      }
    }
    describe("OddString 'パタトクカシーー'") {
      it("should equals 'タクシー'") {
        assert(p00.OddString("パタトクカシーー") == "タクシー")
      }
    }
    describe("MergeString 'パトカー' and 'タクシー'") {
      it("should equals 'パタトクカシーー'") {
        assert(p00.MergeString("パトカー", "タクシー") == "パタトクカシーー")
      }
    }

  }
}

