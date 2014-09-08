package jp.yokomark.utils.audio.focus.token;

import jp.yokomark.utils.audio.ConfigToken;

/**
 * @author KeishinYokomaku
 */
public interface FocusConfigToken extends ConfigToken {
	public AudioFocusDurationHint getDurationHint();
}
