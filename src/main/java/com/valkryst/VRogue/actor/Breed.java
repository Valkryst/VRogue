package com.valkryst.VRogue.actor;

import com.valkryst.VRogue.interfaces.Describable;
import com.valkryst.VRogue.interfaces.Displayable;
import com.valkryst.VRogue.sprite.ActorSprite;
import com.valkryst.VRogue.sprite.Sprite;
import com.valkryst.VTerminal.component.VPanel;
import lombok.ToString;

@ToString
public enum Breed implements Describable, Displayable {
	GOBLIN("Goblin", ActorSprite.GOBLIN);

	public final String name;
	private final Sprite sprite;

	Breed(final String name, final Sprite sprite) {
		this.name = name;
		this.sprite = sprite;
	}

	@Override
	public void displayAt(final int x, final int y, final VPanel panel) {
		sprite.displayAt(x, y, panel);
	}

	@Override
	public String getDescription() {
		final var color = sprite.getForegroundColor();

		return String.format("""
    			<html>
    				<head>
    					<style type="text/css">
    						i {
    							color: rgb(%d, %d, %d);
    						}
    					</style>
    				</head>
    				<body>
						<p>A <i>%s</i>.</p>
					</body>
				</html>
				""", color.getRed(), color.getGreen(), color.getBlue(), name);
	}
}
