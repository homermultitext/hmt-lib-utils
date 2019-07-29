package edu.furman.classics.hmtlibutils

import scala.xml._
import edu.holycross.shot.scm._
import edu.holycross.shot.cite._
import edu.holycross.shot.citeobj._
import edu.holycross.shot.ohco2._
import edu.holycross.shot.seqcomp._
import edu.holycross.shot.citerelation._


/** Providing serializations for Homer Multitext Data **/
class HtmlLibXmlUtils {
	def exists:Boolean = { true }

 
  /** Given a corpus of scholia in HMT archival XML cited at leaf node,
  * create CiteTriples.
  *
  * @param scholiaXml Corpus of scholia in archival XML cited at leaf node.
  */
  def scholiaComments(scholiaXml: Corpus)  : Vector[Option[CiteTriple]]= {
    val verb = Cite2Urn("urn:cite2:cite:verbs.v1:commentsOn")
    val scholiaNodes = scholiaXml.nodes
    // There should be 3 citable XML nodes per scholion  in the sequence
    // lemma, ref, comment, so we walk through the nodes 3 at a time.
    val commentRelations = for (i <- 0 until (scholiaXml.size - 2) by 3) yield {
      val xref = XML.loadString(scholiaNodes(i+1).text)
      val nList = xref.attribute("n").get
      val scholionUrn = scholiaNodes(i).urn.collapsePassageBy(1)
      val iliadUrnString = xref.text.trim
      try {
        val iliadUrn = CtsUrn(iliadUrnString)
        println("\nYay! Made Iliad URN " + iliadUrn)
        Some(CiteTriple(scholionUrn, verb, iliadUrn))
      } catch {
        case t: Throwable => {
          println(s"Failed to create CiteTriple for scholion ${scholionUrn}.Iliad Urn string was '" + iliadUrnString +  "'" + "\n\t===>" + t)
          None
        }
      }
    }
    commentRelations.toVector
  }

}
