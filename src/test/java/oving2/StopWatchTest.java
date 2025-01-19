package oving2;

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
	@DisplayName("Private fields")
	public void testPrivateFields() {
		TestHelper.checkIfFieldsPrivate(StopWatch.class);
	}

	@Test
	@DisplayName("Constructor")
	public void testConstructor() {
		assertFalse(stopWatch.isStarted(), "Stopwatch should not be started");
		assertFalse(stopWatch.isStopped(), "Stopwatch should not be stopped");
		assertEquals(0, stopWatch.getTicks(), "Wrong ticks returned");
		assertEquals(-1, stopWatch.getTime(), "Time should be -1 when not started");
		assertEquals(-1, stopWatch.getLapTime(), "Lap time should be -1 when not started");
		assertEquals(-1, stopWatch.getLastLapTime(), "Last lap time should be -1 when not started");
	}

	@Test
	@DisplayName("Tick without starting")
	public void testTicksWithoutStart() {
		stopWatch.tick(1);
		assertEquals(-1, stopWatch.getTime(), "Time should be -1 when not started");
		assertEquals(1, stopWatch.getTicks(), "Ticks should be 1 after calling #tick(1)");

		stopWatch.tick(4);
		assertEquals(-1, stopWatch.getTime(), "Time should be -1 when not started");
		assertEquals(5, stopWatch.getTicks(), "Ticks should be 5 after calling #tick(4)");
	}

	@Test
	@DisplayName("Tick, start and stop 1")
	public void testStartTickStop() {
		stopWatch.start();
		assertEquals(0, stopWatch.getTime(), "Time should be 0 when just started");
		assertEquals(0, stopWatch.getTicks(), "Ticks should be 0 when #tick() has not been called");
		assertTrue(stopWatch.isStarted(), "Should be started after calling #start()");
		assertFalse(stopWatch.isStopped(), "Should not be stopped before calling #stop()");

		assertThrows(IllegalStateException.class, () -> {
			stopWatch.start();
		}, "Cannot start already running stopwatch");

		stopWatch.tick(3);
		assertEquals(3, stopWatch.getTime(),
				"Time should be 3 when started and #tick(3) has been called");
		assertEquals(3, stopWatch.getTicks(), "Ticks should be 3 when #tick(3) has been called");
		assertTrue(stopWatch.isStarted(), "Should be started after calling #start()");
		assertFalse(stopWatch.isStopped(), "Should not be stopped before calling #stop()");

		stopWatch.tick(5);
		assertEquals(8, stopWatch.getTime(),
				"Time should be 8 when started and #tick(5) has been called");
		assertEquals(8, stopWatch.getTicks(), "Ticks should be 8 when #tick(5) has been called");
		assertTrue(stopWatch.isStarted(), "Should be started after calling #start()");
		assertFalse(stopWatch.isStopped(), "Should not be stopped before calling #stop()");

		stopWatch.stop();
		assertEquals(8, stopWatch.getTime(), "Time should be 8 after #stop() has been called");
		assertEquals(8, stopWatch.getTicks(), "Ticks should be 8 after #stop() has been called");
		assertTrue(stopWatch.isStarted(), "Should be started even after #stop() has been called");
		assertTrue(stopWatch.isStopped(), "Should be stopped after calling #stop()");

		assertThrows(IllegalStateException.class, () -> {
			stopWatch.stop();
		}, "Cannot stop stopped stopwatch");
	}

	@Test
	@DisplayName("Tick, start and stop 2")
	public void testTickStartTickStopTick() {
		stopWatch.tick(2);
		assertEquals(-1, stopWatch.getTime(), "Time should be -1 when not started");
		assertEquals(2, stopWatch.getTicks(), "Ticks should be 2 when #tick(2) has been called");
		assertFalse(stopWatch.isStarted(), "Stopwatch should not be started");
		assertFalse(stopWatch.isStopped(), "Stopwatch should not be stopped");

		stopWatch.start();
		assertEquals(0, stopWatch.getTime(), "Time should be 0 when just started");
		assertEquals(2, stopWatch.getTicks(), "Ticks should be 2 after #start() has been called");
		assertTrue(stopWatch.isStarted(), "Should be started after calling #start()");
		assertFalse(stopWatch.isStopped(), "Should not be stopped before calling #stop()");

		stopWatch.tick(3);
		assertEquals(3, stopWatch.getTime(),
				"Time should be 3 when started and #tick(3) has been called");
		assertEquals(5, stopWatch.getTicks(), "Ticks should be 5 when #tick(3) has been called");
		assertTrue(stopWatch.isStarted(), "Should be started after calling #tick(3)");
		assertFalse(stopWatch.isStopped(), "Should not be stopped before calling #tick(3)");

		stopWatch.tick(5);
		assertEquals(8, stopWatch.getTime(),
				"Time should be 8 when started and #tick(5) has been called");
		assertEquals(10, stopWatch.getTicks(), "Ticks should be 10 when #tick(5) has been called");
		assertTrue(stopWatch.isStarted(), "Should be started after calling #tick(5)");
		assertFalse(stopWatch.isStopped(), "Should not be stopped before calling #tick(5)");

		stopWatch.stop();
		assertEquals(8, stopWatch.getTime(), "Time should be 8 after #stop() has been called");
		assertEquals(10, stopWatch.getTicks(), "Ticks should be 10 after #stop() has been called");
		assertTrue(stopWatch.isStarted(), "Should be started even after #stop() has been called");
		assertTrue(stopWatch.isStopped(), "Should be stopped after calling #stop()");

		stopWatch.tick(3);
		assertEquals(8, stopWatch.getTime(),
				"Time should be 8 after #tick(3) has been called while stopped");
		assertEquals(13, stopWatch.getTicks(),
				"Ticks should be 13 when #tick(3) has been called while stopped");
		assertTrue(stopWatch.isStarted(),
				"Should be started even after #tick() has been called while stopped");
		assertTrue(stopWatch.isStopped(), "Should be stopped after calling #tick() while stopped");

		assertThrows(IllegalArgumentException.class, () -> {
			stopWatch.tick(-1);
		}, "Time should not go backwards");
	}

	@Test
	@DisplayName("Lap times")
	public void testLaps() {
		assertThrows(IllegalStateException.class, () -> {
			stopWatch.lap();
		}, "Should not be able to lap non-started timer");

		stopWatch.start();
		assertEquals(0, stopWatch.getTime(), "Time should be 0 when just started");
		assertEquals(0, stopWatch.getLapTime(), "Lap time should be 0 when just started");
		assertEquals(-1, stopWatch.getLastLapTime(),
				"Last lap time should be -1 when there is no previous lap");

		stopWatch.tick(3);
		assertEquals(3, stopWatch.getTime(), "Time should be 3 after #tick(3) has been called");
		assertEquals(3, stopWatch.getLapTime(),
				"Lap time should be 3 after calling #tick(3) while started");
		assertEquals(-1, stopWatch.getLastLapTime(),
				"Last lap time should be -1 when there is no previous lap");

		stopWatch.lap();
		assertEquals(3, stopWatch.getTime(), "Time should still be 3 after starting a new lap");
		assertEquals(0, stopWatch.getLapTime(), "Current lap time should be 0 when just started");
		assertEquals(3, stopWatch.getLastLapTime(),
				"Last lap time should be 3 when we just started a new lap");

		stopWatch.tick(5);
		assertEquals(8, stopWatch.getTime(), "Time should be 8 after #tick(5) has been called");
		assertEquals(5, stopWatch.getLapTime(),
				"Current lap time should be 5 after calling #tick(5)");
		assertEquals(3, stopWatch.getLastLapTime(),
				"Last lap time should be 3 even after time passes");

		stopWatch.stop();
		assertEquals(8, stopWatch.getTime(), "Time should be 8 after stopping");
		assertEquals(0, stopWatch.getLapTime(), "Current lap time should be 0 when stopped");
		assertEquals(5, stopWatch.getLastLapTime(),
				"Last lap should be the lap time of the current lap when stopping");

		assertThrows(IllegalStateException.class, () -> {
			stopWatch.lap();
		}, "Should not be able to lap stopped timer");
	}
}
