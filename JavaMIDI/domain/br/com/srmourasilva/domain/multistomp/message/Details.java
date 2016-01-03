package br.com.srmourasilva.domain.multistomp.message;

import br.com.srmourasilva.domain.message.Cause;


public class Details<T> implements Cause {
	public enum TypeChange {
		NONE,
		PEDAL_STATUS,
		PARAM,
		PATCH_NUMBER,
		PATCH_NAME;
	}

	private TypeChange type;
	private T newValue;

	public static Details<Integer> NONE() {
		return new Details<>(TypeChange.NONE, 0);
	}
	
	public Details(TypeChange type, T newValue) {
		this.type = type;
		this.newValue = newValue;
	}

	public T newValue() {
		return newValue;
	}
	
	public TypeChange type() {
		return type;
	}
	
	@Override
	public String toString() {
		return "(" + type + " " + newValue + ")";
	}
}