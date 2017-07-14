package simplenlg.phrasespec.portuguese;

import simplenlg.framework.NLGFactory;
import simplenlg.phrasespec.AbstractSPhraseSpec;

/**
 * Esta classe define uma cl�usula (senten�as semelhante a uma frase). 
 * 
 * @author H�linton P. Steffens
 * @Jul 13, 2017
 */
public class PortugueseSPhraseSpec extends AbstractSPhraseSpec{

	public PortugueseSPhraseSpec(NLGFactory phraseFactory) {
		super(phraseFactory);
	}

	@Override
	public String getComplementiserWord() {
		return "que";
	}

}
