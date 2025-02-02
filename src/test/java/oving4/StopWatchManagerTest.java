package oving4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StopWatchManagerTest {

	private StopWatchManager manager;

	@BeforeEach
	public void setup() {
		manager = new StopWatchManager();
	}

	@Test
	@DisplayName("Lage ny stoppeklokke")
	public void testNewStopWatch() {
		StopWatch sw1 = manager.newStopWatch("SW1");
		StopWatch sw2 = manager.newStopWatch("SW2");
		assertEquals(sw1, manager.getStopWatch("SW1"));
		assertEquals(sw2, manager.getStopWatch("SW2"));
	}

	@Test
	@DisplayName("Ticker")
	public void testTicks() {
		StopWatch sw1 = manager.newStopWatch("SW1");
		StopWatch sw2 = manager.newStopWatch("SW2");

		manager.tick(1);
		assertEquals(1, sw1.getTicks());
		assertEquals(1, sw2.getTicks());

		manager.tick(4);
		assertEquals(5, sw1.getTicks());
		assertEquals(5, sw2.getTicks());
	}

	@Test
	@DisplayName("Fjerne stoppeklokke")
	public void testRemoveStopWatches() {
		assertEquals(0, manager.getAllWatches().size());

		StopWatch sw1 = manager.newStopWatch("SW1");
		assertEquals(1, manager.getAllWatches().size());
		assertEquals(sw1, manager.getStopWatch("SW1"));

		StopWatch sw2 = manager.newStopWatch("SW2");
		assertEquals(2, manager.getAllWatches().size());
		assertEquals(sw1, manager.getStopWatch("SW1"));
		assertEquals(sw2, manager.getStopWatch("SW2"));

		manager.removeStopWatch("SW1");
		assertEquals(1, manager.getAllWatches().size());
		assertEquals(null, manager.getStopWatch("SW1"));

		manager.removeStopWatch("SW2");
		assertEquals(0, manager.getAllWatches().size());
		assertEquals(null, manager.getStopWatch("SW1"));
		assertEquals(null, manager.getStopWatch("SW2"));
	}

	@Test
	@DisplayName("Starte og stoppe klokker")
	public void testStartedStoppedWatches() {
		assertEquals(0, manager.getStartedWatches().size());

		manager.newStopWatch("SW1").start();
		assertEquals(1, manager.getStartedWatches().size());
		assertEquals(0, manager.getStoppedWatches().size());
		assertTrue(manager.getStartedWatches().contains(manager.getStopWatch("SW1")));
		assertTrue(manager.getStopWatch("SW1").isStarted());

		manager.newStopWatch("SW2").start();
		assertEquals(2, manager.getStartedWatches().size());
		assertEquals(0, manager.getStoppedWatches().size());
		assertTrue(manager.getStartedWatches().contains(manager.getStopWatch("SW1")));
		assertTrue(manager.getStopWatch("SW1").isStarted());
		assertFalse(manager.getStopWatch("SW1").isStopped());
		assertTrue(manager.getStartedWatches().contains(manager.getStopWatch("SW2")));
		assertTrue(manager.getStopWatch("SW2").isStarted());
		assertFalse(manager.getStopWatch("SW2").isStopped());

		manager.getStopWatch("SW2").stop();
		assertEquals(1, manager.getStoppedWatches().size());
		assertFalse(manager.getStoppedWatches().contains(manager.getStopWatch("SW1")));
		assertFalse(manager.getStopWatch("SW1").isStopped());
		assertTrue(manager.getStoppedWatches().contains(manager.getStopWatch("SW2")));
		assertTrue(manager.getStopWatch("SW2").isStopped());

		manager.getStopWatch("SW1").stop();
		assertEquals(2, manager.getStoppedWatches().size());
		assertTrue(manager.getStoppedWatches().contains(manager.getStopWatch("SW1")));
		assertTrue(manager.getStopWatch("SW1").isStopped());
		assertTrue(manager.getStoppedWatches().contains(manager.getStopWatch("SW2")));
		assertTrue(manager.getStopWatch("SW2").isStopped());
	}
}
