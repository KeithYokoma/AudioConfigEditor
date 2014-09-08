package jp.yokomark.utils.audio;

import android.media.AudioManager;

/**
 * @author KeishinYokomaku
 */
public enum AudioStream {
	ALARM(AudioManager.STREAM_ALARM),
	DTMF(AudioManager.STREAM_DTMF),
	MUSIC(AudioManager.STREAM_MUSIC),
	NOTIFICATION(AudioManager.STREAM_NOTIFICATION),
	RING(AudioManager.STREAM_RING),
	SYSTEM(AudioManager.STREAM_SYSTEM),
	VOICE_CALL(AudioManager.STREAM_VOICE_CALL);

	private final int mValue;

	private AudioStream(final int value) {
		mValue = value;
	}

	public int getValue() {
		return mValue;
	}
}
