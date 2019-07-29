package edu.furman.classics.hmtlibutils

import edu.holycross.shot.scm._
import edu.holycross.shot.cite._
import edu.holycross.shot.citeobj._
import edu.holycross.shot.ohco2._
import edu.holycross.shot.seqcomp._
import edu.holycross.shot.citerelation._

import scala.scalajs.js
import scala.scalajs.js.annotation._

/** Providing serializations for Homer Multitext Data **/
@JSExportTopLevel("HmtLibUtils")
class HtmlLibUtils {
	def exists:Boolean = { true }

 /** Create new corpus by extracting all scholia from a
  * given corpus.
  *
  * @param c Corpus to extact scholia from.
  */
  def scholia(c: Corpus) : Corpus = {
    val scholiaUrn = CtsUrn("urn:cts:greekLit:tlg5026:")
    c ~~ scholiaUrn
  }

  /** From a corpus citing scholia at leaf node (lemma, ref, comment),
  * drop all "ref" elements to create a new leaf-node corpus containing
  * only text content of the edition.
  *
  * @param scholia Corpus of scholia cited at leaf node.
  */
  def scholiaTextCorpus (scholia: Corpus): Corpus = {
    Corpus(scholia.nodes.filterNot(_.urn.toString.endsWith(".ref")))
  }

  /** Given a corpus of scholia in HMT archival XML cited at leaf node,
  * create a corpus of well-formed XML texts cited at the level of
  * the whole scholion.  The function first drops any ".ref" nodes,
  * then combines any remaining lemma and comment nodes in a well-formed
  * XML block with URN collapsed by 1 level.
  *
  * @param scholiaXml Corpus of scholia in archival XML cited at leaf node.
  */
  def scholiaCollapsedXml(scholiaXml: Corpus) = {
    val textOnly = scholiaTextCorpus(scholiaXml)
    // There should be 2 citable XML nodes per scholion  in the sequence
    // lemma, comment, so we walk through the nodes 2 at a time.
    val collapsedNodes = for (i <- 0 until (textOnly.size - 1) by 2 ) yield {
      val u = textOnly.nodes(i).urn.collapsePassageBy(1)
      val txt = "<div>" + textOnly.nodes(i).text + " " + textOnly.nodes(i+1).text + "</div>"
      CitableNode(u,txt)
    }
    Corpus(collapsedNodes.toVector)
  }


  /** Given a corpus of scholia in HMT cited at leaf node,
  * create a corpus of well-formed XML texts cited at the level of
  * the whole scholion.  The function first drops any ".ref" nodes,
  * then combines any remaining lemma and comment nodes in text string
  * with URN collapsed by 1 level.
  *
  * @param scholiaXml Corpus of scholia in archival XML cited at leaf node.
  */
  def scholiaCollapsedText(scholiaXml: Corpus) = {
    val textOnly = scholiaTextCorpus(scholiaXml)
    // There should now be 2 citable XML nodes per scholion  in the sequence
    // lemma, comment, so we walk through the nodes 3 at a time.
    val collapsedNodes = for (i <- 0 until (textOnly.size - 1) by 2 ) yield {
      val u = textOnly.nodes(i).urn.collapsePassageBy(1)
      val txt = textOnly.nodes(i).text + " " + textOnly.nodes(i+1).text
      CitableNode(u,txt)
    }
    Corpus(collapsedNodes.toVector)
  }


}
