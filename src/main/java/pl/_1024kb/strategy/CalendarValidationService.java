package pl._1024kb.strategy;

import pl._1024kb.strategy.scopes.*;

import java.util.EnumMap;

import static pl._1024kb.strategy.Scope.*;


public class CalendarValidationService {

    private final CalendarDAO calendarDAO;
    private final EnumMap<Scope, ScopeStrategy> limits = new EnumMap<>(Scope.class);

    public CalendarValidationService(CalendarDAO calendarDAO) {
        this.calendarDAO = calendarDAO;
    }

    {
        limits.put(USER, new UserScope());
        limits.put(GLOBAL, new GlobalScope());
        limits.put(PROJECT, new ProjectScope());
        limits.put(GROUP, new GroupScope());
        limits.put(TEAM, new TeamScope());
    }

    public int getLimitsSize()
    {
        return limits.size();
    }

    public boolean validateCalendar()
    {
        int strategies = limits.size();
        int scopes = values().length;

        return strategies == scopes;
    }

    public boolean validate(Calendar calendar) {
        int size = calendarDAO.getCalendarByScope(calendar.getScope()).size();

        return limits.entrySet().stream()
                .filter(limit -> limit.getKey().equals(calendar.getScope()))
                .anyMatch(limit -> size < limit.getValue().maxNumber());
    }
}