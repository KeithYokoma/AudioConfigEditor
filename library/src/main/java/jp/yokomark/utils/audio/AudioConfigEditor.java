package jp.yokomark.utils.audio;

import android.app.Application;
import android.content.Context;
import android.media.AudioManager;
import android.util.Log;

import jp.yokomark.utils.audio.compat.FocusControlCompat;
import jp.yokomark.utils.audio.focus.token.FocusConfigToken;
import jp.yokomark.utils.audio.volume.token.adjust.AdjustVolumeConfigToken;
import jp.yokomark.utils.audio.volume.token.fixed.FixedVolumeConfigToken;

/**
 * @author KeithYokoma
 */
@SuppressWarnings("unused") // public APIs
public final class AudioConfigEditor {
	public static final String TAG = AudioConfigEditor.class.getSimpleName();
	private static AudioConfigEditor sInstance;
	private final AudioManager mAudioManager;
	private FocusControlCompat mFocusControlCompat;

	protected AudioConfigEditor(Application application) {
		mAudioManager = (AudioManager) application.getSystemService(Context.AUDIO_SERVICE);
		mFocusControlCompat = new FocusControlCompat();
	}

	public static synchronized void initialize(Application application) {
		if (sInstance != null) {
			Log.v(TAG, "already initialized");
			return;
		}
		sInstance = new AudioConfigEditor(application);
	}

	public static synchronized AudioConfigEditor getInstance() {
		if (sInstance == null) {
			throw new IllegalStateException(TAG + " not initialized.");
		}
		return sInstance;
	}

	public static synchronized void destroy() {
		if (sInstance == null) {
			Log.v(TAG, "not initialized or already destroyed.");
			return;
		}
		sInstance = null;
	}

	public void adjust(AdjustVolumeConfigToken token) {
		mAudioManager.adjustStreamVolume(
				token.getAudioStream().getValue(),
				token.getAdjustMode().getValue(), token.getFlags());
	}

	public void fix(FixedVolumeConfigToken token) {
		mAudioManager.setStreamVolume(
				token.getAudioStream().getValue(),
				token.getFixedLevel(), token.getFlags());
	}

	public int focusOn(AudioManager.OnAudioFocusChangeListener l, FocusConfigToken token) {
		return mFocusControlCompat.onFocusGain(mAudioManager, l,
				token.getAudioStream().getValue(), token.getDurationHint().getValue());
	}

	public int unfocus(AudioManager.OnAudioFocusChangeListener l) {
		return mFocusControlCompat.onAbandonFocus(mAudioManager, l);
	}
}
