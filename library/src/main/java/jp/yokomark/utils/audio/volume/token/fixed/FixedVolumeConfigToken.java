package jp.yokomark.utils.audio.volume.token.fixed;

import jp.yokomark.utils.audio.ConfigToken;

/**
 * @author KeishinYokomaku
 */
public interface FixedVolumeConfigToken extends ConfigToken {
	public int getFixedLevel();
	public int getFlags();
}
