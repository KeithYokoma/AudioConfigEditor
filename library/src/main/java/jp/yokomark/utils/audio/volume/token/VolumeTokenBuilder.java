package jp.yokomark.utils.audio.volume.token;

import android.media.AudioManager;

import jp.yokomark.utils.audio.ConfigTokenBuilder;

/**
 * @author KeishinYokomaku
 */
public abstract class VolumeTokenBuilder extends ConfigTokenBuilder {
	private int mFlags;

	public VolumeTokenBuilder allowRingerMode() {
		mFlags |= AudioManager.FLAG_ALLOW_RINGER_MODES;
		return this;
	}

	public VolumeTokenBuilder showUi() {
		mFlags |= AudioManager.FLAG_SHOW_UI;
		return this;
	}

	public VolumeTokenBuilder playSound() {
		mFlags |= AudioManager.FLAG_PLAY_SOUND;
		return this;
	}

	public VolumeTokenBuilder vibrate() {
		mFlags |= AudioManager.FLAG_VIBRATE;
		return this;
	}

	public VolumeTokenBuilder removeSoundAndVibrate() {
		mFlags |= AudioManager.FLAG_REMOVE_SOUND_AND_VIBRATE;
		return this;
	}

	protected int getFlags() {
		return mFlags;
	}
}
