import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * ABSTRACT CLASS: kerangka dasar semua objek domain.
 * Tidak bisa diinstansiasi langsung; setiap turunan wajib mengimplementasikan getRingkasan().
 */
public abstract class Entitas {
    private static final Map<String, AtomicInteger> COUNTER = new ConcurrentHashMap<>();

    private final String id;

    protected Entitas(String prefix) {
        int urutan = COUNTER.computeIfAbsent(prefix, k -> new AtomicInteger()).incrementAndGet();
        this.id = String.format("%s-%03d", prefix, urutan);
    }

    public String getId() {
        return id;
    }

    /** Method abstrak: tiap entitas mendefinisikan sendiri ringkasannya. */
    public abstract String getRingkasan();

    @Override
    public String toString() {
        return getRingkasan();
    }
}