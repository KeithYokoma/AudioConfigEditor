package jp.yokomark.utils.audio.volume.token.adjust;

import android.media.AudioManager;

/**
 * @author KeishinYokomaku
 */
public enum AdjustMode {
	RAISE(AudioManager.ADJUST_RAISE),
	LOWER(AudioManager.ADJUST_LOWER),
	SAME(AudioManager.ADJUST_SAME);

	private final int mValue;

	private AdjustMode(final int value) {
		mValue = value;
	}

	public int getValue() {
		return mValue;
	}
}
