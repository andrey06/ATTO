/*
 * generated by Xtext 2.12.0
 */
package com.aestheticintegration.atto.generator

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import javax.inject.Inject
import com.aestheticintegration.atto.itlDsl.Model

/**
 * Generates code from your model files on save.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 */
class ItlDslGenerator extends AbstractGenerator {
	@Inject
	private GeneratorOcaml generatorOcaml;
	
	@Inject
	private GeneratorTim generatorTim;

	override void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		fsa.generateFile(this.generatorOcaml.className(resource), this.generatorOcaml.compile(resource.contents.head as Model))
		fsa.generateFile(this.generatorTim.className(resource), this.generatorTim.compile(resource.contents.head as Model))
	}
}
