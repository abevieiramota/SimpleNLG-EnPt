package simplenlg.features.portuguese;

import simplenlg.features.IInterrogativeType;

/**
 * Enum contendo os tipos de perguntas suportados em portugu�s.
 * 
 * @author H�linton P. Steffens
 * @Jul 13, 2017
 */
public enum PortugueseInterrogativeType implements IInterrogativeType {

		/**
		 * Tipo de interrogativo relativo � maneira em que um evento aconte�e. 
		 * Por exemplo: </em> Como eu irei para a aula.
		 */
		HOW("como"),
		
		/**
		 * Uma quest�o com como relacionada ao predicato da senten�a, dada a senten�a <i> Jo�o � legal</i>, se tornaria <i>Como Jo�o �?</i>
		 */
		HOW_PREDICATE("como"),

		/**
		 * Tipo interrogativo relativo ao objeto de uma frase.
		 * Por exemplo, <em>Uma bola � um brinquedo</em> se torna <em>Que � uma bola?</em>
		 */
		WHAT_OBJECT("que"),

		/**
		 * Tipo interrogativo relativo ao sujeito de uma frase. 
		 * Por exemplo, <em>Uma bola � um brinquedo</em> se torna <em>Que � um brinquedo?</em>
		 */
		WHAT_SUBJECT("que"),

		/**
		 * Tipo de interrogativa que diz respeito ao objeto de um verbo que se relaciona com a localiza��o. 
		 * Por exemplo, <em>Eu estou em casa</em> se torna
		 * <em>Onde eu estou?</em>
		 */
		WHERE("onde"),

		/**
		 * Tipo de interrogativa que � uma quest�o relativa ao objeto indireto de uma frase quando o objeto indireto � uma pessoa. 
		 * Por exemplo, <em>O homem d� a flor do John para a mulher</em> se torna
		 * <em>Para quem o homem d� a flor do John?</em>
		 */
		WHO_INDIRECT_OBJECT("quem"),

		/**
		 * Tipo de interrogativa que � uma quest�o relativa ao objeto de uma frase quando o objeto � uma pessoa. 
		 * Por exemplo, <em>Jo�o beijou Maria</em> se torna <em>Quem Jo�o beijou?</em>
		 */
		WHO_OBJECT("quem"),

		/**
		 * Tipo de interrogativa que � uma quest�o relativa ao sujeito de uma frase quando o sujeito � uma pessoa. 
		 * Por exemplo, <em>Jo�o beijou Maria</em> se torna <em>Quem beijou Maria?</em>
		 */
		WHO_SUBJECT("quem"),

		/**
		 * Tipo de interrogativa que � relativa a raz�o para um evento ter acontencido.
		 * Por exemplo, <em>Jo�o beijou Maria</em> se torna <em>Por que Jo�o beijou Maria?</em>
		 */
		WHY("por que"),

		/**
		 * Tipo de interrogativa que represente uma quest�o de sim ou n�o. 
		 * Por exemplo,  <em>Jo�o beijou Maria</em> se torna <em>Jo�o beijou Maria?</em>
		 */
		YES_NO("sim/n�o"),

		/**
		 * Tipo de interrogativa que represente uma quest�o quantitativa. 
		 * Por exemplo <em>cachorros perseguem Jo�o</em> se torna <em>Quantos cachorros perseguem Jo�o</em>
		 */
		HOW_MANY("quanto");
		
		private String question;
		
		private PortugueseInterrogativeType(String question){
			this.question = question;
		}

		public IInterrogativeType getInstance(String value) {
			if (this.getQuestion().equalsIgnoreCase(value)) {
				return this;
			}
			return null;
		}

		public String getQuestion() {
			return question;
		}

		/**
		 * A method to determine if the {@code InterrogativeType} is a question
		 * concerning an element with the discourse function of an object.
		 * 
		 * @param type
		 *            the interrogative type to be checked
		 * @return <code>true</code> if the type concerns an object,
		 *         <code>false</code> otherwise.
		 */
		public boolean isObject(Object type) {
			return WHO_OBJECT.equals(type) || WHAT_OBJECT.equals(type);
		}
		
		/**
		 * A method to determine if the {@code InterrogativeType} is a question
		 * concerning an element with the discourse function of an indirect object.
		 * 
		 * @param type
		 *            the interrogative type to be checked
		 * @return <code>true</code> if the type concerns an indirect object,
		 *         <code>false</code> otherwise.
		 */
		public boolean isIndirectObject(Object type) {
			return WHO_INDIRECT_OBJECT.equals(type);
		}

	}

