package jp.yokomark.utils.audio.volume.token.fixed;

import jp.yokomark.utils.audio.AudioStream;
import jp.yokomark.utils.audio.ConfigToken;
import jp.yokomark.utils.audio.volume.token.VolumeTokenBuilder;

/**
 * @author KeishinYokomaku
 */
public class VolumeFixToken implements FixedVolumeConfigToken {
	public static final String TAG = VolumeFixToken.class.getSimpleName();
	private final AudioStream mAudioStream;
	private final int mLevel;
	private final int mFlags;

	public VolumeFixToken(AudioStream audioStream, int level, int flags) {
		mAudioStream = audioStream;
		mLevel = level;
		mFlags = flags;
	}

	@Override
	public int getFixedLevel() {
		return mLevel;
	}

	@Override
	public int getFlags() {
		return mFlags;
	}

	@Override
	public AudioStream getAudioStream() {
		return mAudioStream;
	}

	@SuppressWarnings("unused") // public APIs
	public static class Builder extends VolumeTokenBuilder {
		private final int mLevel;

		public Builder(int level) {
			mLevel = level;
		}

		@Override
		public ConfigToken create() {
			return new VolumeFixToken(getAudioStream(), mLevel, getFlags());
		}
	}
}
