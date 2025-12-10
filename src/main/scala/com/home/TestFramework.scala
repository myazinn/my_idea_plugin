package com.home

import com.intellij.psi.PsiElement
import org.jetbrains.plugins.scala.lang.psi.api.toplevel.typedef._
import org.jetbrains.plugins.scala.testingSupport.test.AbstractTestFramework

import java.awt.{Component, Graphics}
import javax.swing.Icon

final class TestFramework extends AbstractTestFramework {
  private val specFqn = "com.home.SpecAbstract"

  override def getMarkerClassFQName: String = specFqn

  override def getDefaultSuperClass: String = specFqn

  override def testFileTemplateName: String = "My Test"

  override def getName: String = s"My Test"

  override def getIcon: Icon = new Icon {
    override val getIconWidth: Int = 128
    override val getIconHeight: Int = 128

    override def paintIcon(c: Component, g: Graphics, x: Int, y: Int): Unit = ()
  }

  override def isTestMethod(element: PsiElement): Boolean = true

  override def isTestMethod(element: PsiElement, checkAbstract: Boolean): Boolean = true

  override protected def isTestClass(definition: ScTemplateDefinition): Boolean = true

  override def baseSuitePaths: Seq[String] = Seq(specFqn)

}
