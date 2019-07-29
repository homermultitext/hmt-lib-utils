package edu.furman.classics.hmtlibutils
import org.scalatest.FlatSpec

import edu.holycross.shot.cite._
import org.scalatest._
import edu.holycross.shot.cite._
import edu.holycross.shot.cex._
import edu.holycross.shot.scm._
import edu.holycross.shot.citeobj._
import edu.holycross.shot.ohco2._

class ExportTest extends FlatSpec {

  "The hmtlibutils class trait"  should "compile" in {
    val urn:CtsUrn = CtsUrn("urn:cts:greekLit:tlg0012.tlg001:msA:1.1")
  	val psg:String = "Μῆνιν ἄειδε θεὰ Πηληϊάδεω Ἀχιλῆος"
  	val cn:CitableNode = CitableNode(urn, psg)
  	val expected:String = "urn:cts:greekLit:tlg0012.tlg001:msA:1.1#Μῆνιν ἄειδε θεὰ Πηληϊάδεω Ἀχιλῆος"
  	assert ( cn.cex("#") == expected )
   
  }


}
