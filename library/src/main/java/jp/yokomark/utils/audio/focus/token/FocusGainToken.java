package jp.yokomark.utils.audio.focus.token;

import jp.yokomark.utils.audio.AudioStream;
import jp.yokomark.utils.audio.ConfigToken;

/**
 * @author KeishinYokomaku
 */
public class FocusGainToken implements FocusConfigToken {
	public static final String TAG = FocusGainToken.class.getSimpleName();
	private final AudioStream mAudioStream;
	private final AudioFocusDurationHint mDurationHint;

	protected FocusGainToken(AudioStream audioStream, AudioFocusDurationHint durationHint) {
		mAudioStream = audioStream;
		mDurationHint = durationHint;
	}

	@Override
	public AudioStream getAudioStream() {
		return mAudioStream;
	}

	@Override
	public AudioFocusDurationHint getDurationHint() {
		return mDurationHint;
	}

	public static class Builder extends FocusTokenBuilder {
		@Override
		public ConfigToken create() {
			return new FocusGainToken(getAudioStream(), getHint());
		}
	}
}
