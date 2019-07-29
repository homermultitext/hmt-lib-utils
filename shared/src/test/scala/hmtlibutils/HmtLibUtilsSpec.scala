package edu.furman.classics.hmtlibutils
import org.scalatest.FlatSpec

import edu.holycross.shot.scm._
import edu.holycross.shot.cite._
import edu.holycross.shot.citeobj._
import edu.holycross.shot.ohco2._
import edu.holycross.shot.seqcomp._
import edu.holycross.shot.citerelation._

class HtmlLibUtilsSpec extends FlatSpec {

val cex:String = """#!cexversion
3.0

#!citelibrary
name#Fragment from Herodotus' Histories, Book VIII on Papyrus Oxyrhynchus 2099, dated to early 2nd century AD.
urn#urn:cite2:cex:fufolio.2018a:POxy2099
license#CC Share Alike.  For details, see more info.

#!ctscatalog
urn#citationScheme#groupName#workTitle#versionLabel#exemplarLabel#online#lang
urn:cts:greekLit:tlg0016.tlg001.grc_tokens:#book/section/token#Herodotus#Histories#Tokenized Greek, Godley, ed.##true#grc

#!ctsdata
urn:cts:greekLit:tlg0016.tlg001.grc_tokens:8.22.0#Ἀθηναίων
urn:cts:greekLit:tlg0016.tlg001.grc_tokens:8.22.1#δὲ
urn:cts:greekLit:tlg0016.tlg001.grc_tokens:8.22.2#νέας

#!citecollections
URN#Description#Labelling property#Ordering property#License
urn:cite2:fufolio:hdtAlign.blackwell:#Translation alignments#urn:cite2:fufolio:hdtAlign.blackwell.label:##Public Domain
urn:cite2:fufolio:iliadAlign.blackwell:#Translation alignments#urn:cite2:fufolio:iliadAlign.blackwell.label:##Public Domain

#!citeproperties
Property#Label#Type#Authority list
urn:cite2:fufolio:hdtAlign.blackwell.urn:#Alignment Record#Cite2Urn#
urn:cite2:fufolio:hdtAlign.blackwell.label:#Label#String#
urn:cite2:fufolio:hdtAlign.blackwell.description:#Description#String#
urn:cite2:fufolio:hdtAlign.blackwell.editor:#Editor#String#
urn:cite2:fufolio:hdtAlign.blackwell.date:#Date#String#

#!citeproperties
Property#Label#Type#Authority list
urn:cite2:fufolio:iliadAlign.blackwell.urn:#Alignment Record#Cite2Urn#
urn:cite2:fufolio:iliadAlign.blackwell.label:#Label#String#
urn:cite2:fufolio:iliadAlign.blackwell.description:#Description#String#
urn:cite2:fufolio:iliadAlign.blackwell.editor:#Editor#String#
urn:cite2:fufolio:iliadAlign.blackwell.date:#Date#String#

#!citedata
urn#label#description#editor#date
urn:cite2:fufolio:hdtAlign.blackwell:1#Hdt. 1#Herodotus Alignment 1#cwb#2/12/2019
urn:cite2:fufolio:hdtAlign.blackwell:2#Hdt. 2#Herodotus Alignment 2#cwb#2/12/2019

#!citedata
urn#label#description#editor#date
urn:cite2:fufolio:iliadAlign.blackwell:3#Iliad 1#Iliad Alignment 1#cwb#2/12/2019
urn:cite2:fufolio:iliadAlign.blackwell:4#Iliad 2#Iliad Alignment 2#cwb#2/12/2019
"""

 def loadLibrary(cexString:String = cex):CiteLibrary = {
    val library = CiteLibrary(cexString,"#",",")
    library
  }

  val lib:CiteLibrary = loadLibrary()

  def showMe(v:Any):Unit = {
    v match {
      case _:Iterable[Any] => println(s"""\n----\n${v.asInstanceOf[Iterable[Any]].mkString("\n")}\n----\n""")
      case _ => println(s"\n-----\n${v}\n----\n")
    }
  }


}

