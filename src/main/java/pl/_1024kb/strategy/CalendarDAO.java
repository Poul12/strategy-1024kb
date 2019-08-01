package pl._1024kb.strategy;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class CalendarDAO {
    private final Map<CalendarID, Calendar> calendars = new HashMap<>();

    void saveCalendar(Calendar calendar) {
        CalendarID id = new CalendarID(calendar.getUUID());

        calendars.put(id, calendar);
    }

    Optional<Calendar> getCalendar(CalendarID id) {
        return Optional.ofNullable(calendars.get(id));
    }

    List<Calendar> getCalendars() {
        return new LinkedList<>(calendars.values());
    }

    public List<Calendar> getCalendarByScope(Scope scope) {
        return getCalendars().stream()
                .filter(c -> c.getScope().equals(scope))
                .collect(Collectors.toList());
    }

    class CalendarID {
        private final String UUID;

        private CalendarID(String UUID) {
            this.UUID = UUID;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            CalendarID that = (CalendarID) o;
            return Objects.equals(UUID, that.UUID);
        }

        @Override
        public int hashCode() {
            return Objects.hash(UUID);
        }
    }
}