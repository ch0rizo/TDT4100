package oving4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StopWatchTest {

	private StopWatch stopWatch;

	@BeforeEach
	public void beforeEach() {
		stopWatch = new StopWatch();
	}

	@Test
	@DisplayName("Sjekk at et nyopprettet StopWatch-objekt har korrekte verdier")
	public void testConstructor() {
		assertFalse(stopWatch.isStarted());
		assertFalse(stopWatch.isStopped());
		assertEquals(0, stopWatch.getTicks());
		assertEquals(-1, stopWatch.getTime());
		assertEquals(-1, stopWatch.getLapTime());
		assertEquals(-1, stopWatch.getLastLapTime());
	}

	@Test
	@DisplayName("Sjekk at tick() uten start ikke endrer tiden")
	public void testTicksWithoutStart() {
		stopWatch.tick(1);
		assertEquals(-1, stopWatch.getTime());
		assertEquals(1, stopWatch.getTicks());

		stopWatch.tick(4);
		assertEquals(-1, stopWatch.getTime());
		assertEquals(5, stopWatch.getTicks());
	}

	@Test
	@DisplayName("Start og stopp klokken og sjekk at tiden er riktig")
	public void testStartTickStop() {
		stopWatch.start();
		assertEquals(0, stopWatch.getTime());
		assertEquals(0, stopWatch.getTicks());
		assertTrue(stopWatch.isStarted());
		assertFalse(stopWatch.isStopped());

		assertThrows(IllegalStateException.class, () -> {
			stopWatch.start();
		}, "Cannot start already running stopwatch");

		stopWatch.tick(3);
		assertEquals(3, stopWatch.getTime());
		assertEquals(3, stopWatch.getTicks());
		assertTrue(stopWatch.isStarted());
		assertFalse(stopWatch.isStopped());

		stopWatch.tick(5);
		assertEquals(8, stopWatch.getTime());
		assertEquals(8, stopWatch.getTicks());
		assertTrue(stopWatch.isStarted());
		assertFalse(stopWatch.isStopped());

		stopWatch.stop();
		assertEquals(8, stopWatch.getTime());
		assertEquals(8, stopWatch.getTicks());
		assertTrue(stopWatch.isStarted());
		assertTrue(stopWatch.isStopped());

		assertThrows(IllegalStateException.class, () -> {
			stopWatch.stop();
		}, "Skal ikke kunne stoppe en klokke som allerede er stoppet");
	}

	@Test
	@DisplayName("Start og stopp klokken, og kall tick() mens den ikke er startet")
	public void testTickStartTickStopTick() {
		stopWatch.tick(2);
		assertEquals(-1, stopWatch.getTime());
		assertEquals(2, stopWatch.getTicks());
		assertFalse(stopWatch.isStarted());
		assertFalse(stopWatch.isStopped());

		stopWatch.start();
		assertEquals(0, stopWatch.getTime());
		assertEquals(2, stopWatch.getTicks());
		assertTrue(stopWatch.isStarted());
		assertFalse(stopWatch.isStopped());

		stopWatch.tick(3);
		assertEquals(3, stopWatch.getTime());
		assertEquals(5, stopWatch.getTicks());
		assertTrue(stopWatch.isStarted());
		assertFalse(stopWatch.isStopped());

		stopWatch.tick(5);
		assertEquals(8, stopWatch.getTime());
		assertEquals(10, stopWatch.getTicks());
		assertTrue(stopWatch.isStarted());
		assertFalse(stopWatch.isStopped());

		stopWatch.stop();
		assertEquals(8, stopWatch.getTime());
		assertEquals(10, stopWatch.getTicks());
		assertTrue(stopWatch.isStarted());
		assertTrue(stopWatch.isStopped());

		stopWatch.tick(3);
		assertEquals(8, stopWatch.getTime());
		assertEquals(13, stopWatch.getTicks());
		assertTrue(stopWatch.isStarted());
		assertTrue(stopWatch.isStopped());

		assertThrows(IllegalArgumentException.class, () -> {
			stopWatch.tick(-1);
		}, "Tiden skal ikke kunne gå bakover");
	}

	@Test
	@DisplayName("Sjekk at laps funker som forventet")
	public void testLaps() {
		assertThrows(IllegalStateException.class, () -> {
			stopWatch.lap();
		}, "Skal ikke kunne starte en ny runde uten å starte klokken");

		stopWatch.start();
		assertEquals(0, stopWatch.getTime());
		assertEquals(0, stopWatch.getLapTime());
		assertEquals(-1, stopWatch.getLastLapTime());

		stopWatch.tick(3);
		assertEquals(3, stopWatch.getTime());
		assertEquals(3, stopWatch.getLapTime());
		assertEquals(-1, stopWatch.getLastLapTime());

		stopWatch.lap();
		assertEquals(3, stopWatch.getTime());
		assertEquals(0, stopWatch.getLapTime());
		assertEquals(3, stopWatch.getLastLapTime());

		stopWatch.tick(5);
		assertEquals(8, stopWatch.getTime());
		assertEquals(5, stopWatch.getLapTime());
		assertEquals(3, stopWatch.getLastLapTime());

		stopWatch.stop();
		assertEquals(8, stopWatch.getTime());
		assertEquals(0, stopWatch.getLapTime());
		assertEquals(5, stopWatch.getLastLapTime());

		assertThrows(IllegalStateException.class, () -> {
			stopWatch.lap();
		}, "Skal ikke kunne starte en ny runde med en stoppet klokke");
	}

}
