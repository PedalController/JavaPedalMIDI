package br.com.srmourasilva.multistomp.controller;

import br.com.srmourasilva.domain.message.CommonCause;
import br.com.srmourasilva.domain.message.Messages.Details;
import br.com.srmourasilva.domain.message.Messages.Message;

class MultistompChanger {

	private PedalController controller;

	public MultistompChanger(PedalController controller) {
		this.controller = controller;
	}

	public synchronized void attempt(Message message) {
		this.controller.disableNotificationChangesToDevice();

		if (message.is(CommonCause.TO_PATCH))
			controller.toPatch(message.details().patch);

		else if (this.isActiveEffectCurrentPatch(message))
			controller.activeEffect(message.details().effect);
		
		else if (this.isActiveEffectSpecificPatch(message))
			controller.multistomp().patchs().get(message.details().patch).effects().get(message.details().effect).active();

		else if (this.isDisableEffectCurrentPatch(message))
			controller.disableEffect(message.details().effect);

		else if (this.isDisableEffectSpecificPatch(message))
			controller.multistomp().patchs().get(message.details().patch).effects().get(message.details().effect).disable();

		else if (message.is(CommonCause.SET_PARAM)) {
			int idEffect = message.details().effect;
			int idParam  = message.details().param;
			int newValue = message.details().value;

			controller.setEffectParam(idEffect, idParam, newValue);

		} else if (message.is(CommonCause.PATCH_NAME)) {
			String name = (String) message.details().other;
			this.controller.multistomp().currentPatch().setName(name);
		}

		this.controller.activeNotificationChangesToDevice();
	}
	

	private boolean isActiveEffectCurrentPatch(Message message) {
		return message.is(CommonCause.ACTIVE_EFFECT) && message.details().patch == Details.NULL;
	}

	private boolean isDisableEffectCurrentPatch(Message message) {
		return message.is(CommonCause.DISABLE_EFFECT) && message.details().patch == Details.NULL;
	}

	private boolean isActiveEffectSpecificPatch(Message message) {
		return message.is(CommonCause.ACTIVE_EFFECT) && message.details().patch != Details.NULL;
	}

	private boolean isDisableEffectSpecificPatch(Message message) {
		return message.is(CommonCause.ACTIVE_EFFECT) && message.details().patch != Details.NULL;
	}
}