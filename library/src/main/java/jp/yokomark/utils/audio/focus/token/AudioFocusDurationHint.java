package jp.yokomark.utils.audio.focus.token;

import android.annotation.SuppressLint;
import android.media.AudioManager;

/**
 * @author KeishinYokomaku
 */
@SuppressLint("InlinedApi")
public enum AudioFocusDurationHint {
	GAIN(AudioManager.AUDIOFOCUS_GAIN),
	TRANSIENT(AudioManager.AUDIOFOCUS_GAIN_TRANSIENT),
	EXCLUSIVE(AudioManager.AUDIOFOCUS_GAIN_TRANSIENT_EXCLUSIVE),
	MAY_DUCK(AudioManager.AUDIOFOCUS_GAIN_TRANSIENT_MAY_DUCK);

	private final int mValue;

	AudioFocusDurationHint(int value) {
		mValue = value;
	}

	public int getValue() {
		return mValue;
	}
}
