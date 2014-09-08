package jp.yokomark.utils.audio.volume.token.adjust;

import jp.yokomark.utils.audio.AudioStream;
import jp.yokomark.utils.audio.ConfigToken;
import jp.yokomark.utils.audio.volume.token.VolumeTokenBuilder;

/**
 * @author KeishinYokomaku
 */
public class VolumeAdjustToken implements AdjustVolumeConfigToken {
	public static final String TAG = VolumeAdjustToken.class.getSimpleName();
	private final AudioStream mAudioStream;
	private final AdjustMode mAdjustMode;
	private final int mFlags;

	public VolumeAdjustToken(AudioStream stream, AdjustMode adjustMode, int flags) {
		mAudioStream = stream;
		mAdjustMode = adjustMode;
		mFlags = flags;
	}

	@Override
	public AudioStream getAudioStream() {
		return mAudioStream;
	}

	@Override
	public AdjustMode getAdjustMode() {
		return mAdjustMode;
	}

	@Override
	public int getFlags() {
		return mFlags;
	}

	@SuppressWarnings("unused") // public APIs
	public static class Builder extends VolumeTokenBuilder {
		private final AdjustMode mAdjustMode;

		public Builder(AdjustMode adjustMode) {
			mAdjustMode = adjustMode;
		}

		@Override
		public ConfigToken create() {
			return new VolumeAdjustToken(getAudioStream(), mAdjustMode, getFlags());
		}
	}
}