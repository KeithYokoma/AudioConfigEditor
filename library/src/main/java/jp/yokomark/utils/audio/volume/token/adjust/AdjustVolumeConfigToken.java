package jp.yokomark.utils.audio.volume.token.adjust;

import jp.yokomark.utils.audio.ConfigToken;

/**
 * @author KeishinYokomaku
 */
public interface AdjustVolumeConfigToken extends ConfigToken {
	public AdjustMode getAdjustMode();
	public int getFlags();
}
