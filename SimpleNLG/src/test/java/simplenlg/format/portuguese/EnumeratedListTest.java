/*
 * The contents of this file are subject to the Mozilla Public License
 * Version 1.1 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://www.mozilla.org/MPL/
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * The Original Code is "Simplenlg".
 *
 * The Initial Developer of the Original Code is Ehud Reiter, Albert Gatt and Dave Westwater.
 * Portions created by Ehud Reiter, Albert Gatt and Dave Westwater are Copyright (C) 2010-11 The University of Aberdeen. All Rights Reserved.
 *
 * Contributor(s): Ehud Reiter, Albert Gatt, Dave Wewstwater, Roman Kutlak, Margaret Mitchell, Saad Mahamood.
 */

package simplenlg.format.portuguese;

import org.junit.Test;

import junit.framework.Assert;
import simplenlg.format.english.HTMLFormatter;
import simplenlg.framework.DocumentElement;
import simplenlg.framework.NLGFactory;
import simplenlg.framework.portuguese.PortugueseNLGFactory;
import simplenlg.lexicon.Lexicon;
import simplenlg.realiser.english.Realiser;

/**
 * @author H�linton P. Steffens
 *
 */
public class EnumeratedListTest {

	@Test
	public void bulletList() {
		Lexicon lexicon = Lexicon.getPortugueseDefaultLexicon();
		NLGFactory nlgFactory = new PortugueseNLGFactory(lexicon);
		Realiser realiser = new Realiser(lexicon);
		realiser.setFormatter(new HTMLFormatter());
		DocumentElement document = nlgFactory.createDocument("Document");
		DocumentElement paragraph = nlgFactory.createParagraph();
		DocumentElement list = nlgFactory.createList();
		DocumentElement item1 = nlgFactory.createListItem();
		DocumentElement item2 = nlgFactory.createListItem();
		// NB: a list item employs orthographical operations only until sentence level;
		// nest clauses within a sentence to generate more than 1 clause per list item. 
		DocumentElement sentence1 = nlgFactory.createSentence("esta", "ser", "a primeira senten�a");
		DocumentElement sentence2 = nlgFactory.createSentence("esta", "ser", "a segunda senten�a");
		item1.addComponent(sentence1);
		item2.addComponent(sentence2);
		list.addComponent(item1);
		list.addComponent(item2);
		paragraph.addComponent(list);
		document.addComponent(paragraph);
		String expectedOutput = "<h1>Document</h1>" + "<p>" + "<ul>" + "<li>Esta � a primeira senten�a.</li>"
		                        + "<li>Esta � a segunda senten�a.</li>" + "</ul>" + "</p>";

		String realisedOutput = realiser.realise(document).getRealisation();
		//		System.out.println(expectedOutput);
		//		System.out.println(realisedOutput);
		Assert.assertEquals(expectedOutput, realisedOutput);
	}

	@Test
	public void enumeratedList() {
		Lexicon lexicon = Lexicon.getPortugueseDefaultLexicon();
		NLGFactory nlgFactory = new PortugueseNLGFactory(lexicon);
		Realiser realiser = new Realiser(lexicon);
		realiser.setFormatter(new HTMLFormatter());
		DocumentElement document = nlgFactory.createDocument("Document");
		DocumentElement paragraph = nlgFactory.createParagraph();
		DocumentElement list = nlgFactory.createEnumeratedList();
		DocumentElement item1 = nlgFactory.createListItem();
		DocumentElement item2 = nlgFactory.createListItem();
		// NB: a list item employs orthographical operations only until sentence level;
		// nest clauses within a sentence to generate more than 1 clause per list item. 
		DocumentElement sentence1 = nlgFactory.createSentence("esta", "ser", "a primeira senten�a");
		DocumentElement sentence2 = nlgFactory.createSentence("esta", "ser", "a segunda senten�a");
		item1.addComponent(sentence1);
		item2.addComponent(sentence2);
		list.addComponent(item1);
		list.addComponent(item2);
		paragraph.addComponent(list);
		document.addComponent(paragraph);
		String expectedOutput = "<h1>Document</h1>" + "<p>" + "<ol>" + "<li>Esta � a primeira senten�a.</li>"
		                        + "<li>Esta � a segunda senten�a.</li>" + "</ol>" + "</p>";

		String realisedOutput = realiser.realise(document).getRealisation();
		//		System.out.println(expectedOutput);
		//		System.out.println(realisedOutput);
		Assert.assertEquals(expectedOutput, realisedOutput);
	}

}