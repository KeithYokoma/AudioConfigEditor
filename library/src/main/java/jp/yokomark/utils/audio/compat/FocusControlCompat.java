package jp.yokomark.utils.audio.compat;

import android.annotation.SuppressLint;
import android.media.AudioManager;
import android.os.Build;
import android.util.Log;
import android.util.SparseIntArray;

/**
 * @author KeishinYokomaku
 */
public class FocusControlCompat {
	public static final String TAG = FocusControlCompat.class.getSimpleName();
	private static final int NUM_STREAM_TYPES = 10; // @see android.media.AudioSystem
	private final SparseIntArray mStreamVolumes;

	public FocusControlCompat() {
		mStreamVolumes = new SparseIntArray(NUM_STREAM_TYPES);
	}

	@SuppressLint("InlinedApi")
	public boolean needsCompatMode(int durationHint) {
		return Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT &&
				durationHint == AudioManager.AUDIOFOCUS_GAIN_TRANSIENT_EXCLUSIVE;
	}

	public int onFocusGain(AudioManager manager, AudioManager.OnAudioFocusChangeListener l, int streamType, int durationHint) {
		if (!needsCompatMode(durationHint)) {
			Log.v(TAG, "call native audio focus gain request");
			return manager.requestAudioFocus(l, streamType, durationHint);
		}
		if (mStreamVolumes.size() != 0) { // previous focus is present... prevent volume control confusion.
			Log.v(TAG, "you should abandon the previous focus first.");
			return AudioManager.AUDIOFOCUS_REQUEST_FAILED;
		}
		// Note: emulate exclusive transitive focus gain, so actually we don't have any focus on the stream
		Log.v(TAG, "using exclusive transitive focus gain on JB and earlier");
		for (int i = 0; i < NUM_STREAM_TYPES; i++) {
			if (i == streamType)
				continue;
			mStreamVolumes.put(i, manager.getStreamVolume(i));
			manager.setStreamVolume(i, 0, 0);
		}
		return AudioManager.AUDIOFOCUS_REQUEST_GRANTED;
	}

	public int onAbandonFocus(AudioManager manager, AudioManager.OnAudioFocusChangeListener l) {
		if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT && mStreamVolumes.size() != 0) {
			Log.v(TAG, "found a previous volume state that is saved for exclusive focus gain");
			for (int i = 0; i < mStreamVolumes.size(); i++) {
				int level = mStreamVolumes.get(i);
				manager.setStreamVolume(i, level, 0);
			}
			mStreamVolumes.clear(); // reset the state
			return AudioManager.AUDIOFOCUS_REQUEST_GRANTED;
		}
		return manager.abandonAudioFocus(l);
	}
}
