package jp.yokomark.utils.audio;

/**
 * @author KeishinYokomaku
 */
@SuppressWarnings("unused") // public APIs
public abstract class ConfigTokenBuilder {
	public static final String TAG = ConfigTokenBuilder.class.getSimpleName();
	private AudioStream mAudioStream;

	public abstract ConfigToken create();

	public ConfigTokenBuilder toAlarm() {
		mAudioStream = AudioStream.ALARM;
		return this;
	}

	public ConfigTokenBuilder toDtmf() {
		mAudioStream = AudioStream.DTMF;
		return this;
	}

	public ConfigTokenBuilder toMusic() {
		mAudioStream = AudioStream.MUSIC;
		return this;
	}

	public ConfigTokenBuilder toNotification() {
		mAudioStream = AudioStream.NOTIFICATION;
		return this;
	}

	public ConfigTokenBuilder toRing() {
		mAudioStream = AudioStream.RING;
		return this;
	}

	public ConfigTokenBuilder toSystem() {
		mAudioStream = AudioStream.SYSTEM;
		return this;
	}

	public ConfigTokenBuilder toCallVolume() {
		mAudioStream = AudioStream.VOICE_CALL;
		return this;
	}

	protected AudioStream getAudioStream() {
		return mAudioStream;
	}
}
