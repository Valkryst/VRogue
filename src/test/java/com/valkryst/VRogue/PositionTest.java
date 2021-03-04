package com.valkryst.VRogue;

import com.google.common.jimfs.Configuration;
import com.google.common.jimfs.Jimfs;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;

public class PositionTest {
	@Test
	public void canConstructWithNoParameters() {
		final var position = new Position();
		Assertions.assertEquals(0, position.getX());
		Assertions.assertEquals(0, position.getY());
	}

	@Test
	public void canConstructWithParameters() {
		final var position = new Position(1, 2);
		Assertions.assertEquals(1, position.getX());
		Assertions.assertEquals(2, position.getY());
	}

	@Test
	public void canClone() {
		final var original = new Position(1, 2);
		final var clone = (Position) original.clone();
		Assertions.assertNotSame(original, clone);
		Assertions.assertEquals(1, clone.getX());
		Assertions.assertEquals(2, clone.getY());
	}

	@Test
	public void canDeserialize() throws IOException, ClassNotFoundException {
		final var fileSystem = Jimfs.newFileSystem(Configuration.windows());
		final var path = fileSystem.getPath("test.ser");

		final var fileOutputStream = Files.newOutputStream(path);
		final var objectOutputStream = new ObjectOutputStream(fileOutputStream);
		objectOutputStream.writeObject(new Position(1, 2));
		objectOutputStream.close();

		final var fileInputStream = Files.newInputStream(path);
		final var objectInputStream = new ObjectInputStream(fileInputStream);
		final var position = (Position) objectInputStream.readObject();
		objectInputStream.close();
		fileSystem.close();

		Assertions.assertNotNull(position);
		Assertions.assertEquals(1, position.getX());
		Assertions.assertEquals(2, position.getY());
	}

	@Test
	public void canSerialize() throws IOException {
		final var fileSystem = Jimfs.newFileSystem(Configuration.windows());
		final var path = fileSystem.getPath("test.ser");

		final var fileOutputStream = Files.newOutputStream(path);
		final var objectOutputStream = new ObjectOutputStream(fileOutputStream);
		objectOutputStream.writeObject(new Position(1, 2));
		objectOutputStream.close();

		Assertions.assertTrue(Files.exists(path));
		Assertions.assertTrue(Files.isReadable(path));
		Assertions.assertTrue(Files.size(path) > 0);
		fileSystem.close();
	}

	@Test
	public void canDecrementX() {
		final var position = new Position(0, 0);
		position.decrementX();
		Assertions.assertEquals(-1, position.getX());
	}

	@Test
	public void canDecrementY() {
		final var position = new Position(0, 0);
		position.decrementY();
		Assertions.assertEquals(-1, position.getY());
	}

	@Test
	public void canIncrementX() {
		final var position = new Position(0, 0);
		position.incrementX();
		Assertions.assertEquals(1, position.getX());
	}

	@Test
	public void canIncrementY() {
		final var position = new Position(0, 0);
		position.incrementY();
		Assertions.assertEquals(1, position.getY());
	}
}
