/*
 * generated by Xtext 2.12.0
 */
package com.aestheticintegration.atto.parser.antlr;

import java.io.InputStream;
import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider;

public class ItlDslAntlrTokenFileProvider implements IAntlrTokenFileProvider {

	@Override
	public InputStream getAntlrTokenFile() {
		ClassLoader classLoader = getClass().getClassLoader();
		return classLoader.getResourceAsStream("com/aestheticintegration/atto/parser/antlr/internal/InternalItlDsl.tokens");
	}
}
