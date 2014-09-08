package jp.yokomark.utils.audio.focus.token;

import jp.yokomark.utils.audio.ConfigTokenBuilder;

/**
 * @author KeishinYokomaku
 */
public abstract class FocusTokenBuilder extends ConfigTokenBuilder {
	private AudioFocusDurationHint mHint;

	public FocusTokenBuilder gain() {
		mHint = AudioFocusDurationHint.GAIN;
		return this;
	}

	public FocusTokenBuilder trainsient() {
		mHint = AudioFocusDurationHint.TRANSIENT;
		return this;
	}

	public FocusTokenBuilder exclusive() {
		mHint = AudioFocusDurationHint.EXCLUSIVE;
		return this;
	}

	public FocusTokenBuilder allowDuck() {
		mHint = AudioFocusDurationHint.MAY_DUCK;
		return this;
	}

	protected AudioFocusDurationHint getHint() {
		return mHint;
	}
}
