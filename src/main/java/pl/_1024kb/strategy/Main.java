package pl._1024kb.strategy;

import java.time.OffsetDateTime;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {

        CalendarDAO dao = new CalendarDAO();
        CalendarMetadataService metadataService = new CalendarMetadataService(dao, new CalendarValidationService(dao));

        Calendar calendar = new Calendar("Kalendarz1", Scope.USER, Collections.singletonList(OffsetDateTime.now()));
        Calendar calendar2 = new Calendar("Kalendarz2", Scope.USER, Collections.singletonList(OffsetDateTime.now()));
        Calendar calendar3 = new Calendar("Kalendarz3", Scope.USER, Collections.singletonList(OffsetDateTime.now()));
        Calendar calendar4 = new Calendar("Kalendarz4", Scope.USER, Collections.singletonList(OffsetDateTime.now()));
        Calendar calendar5 = new Calendar("Kalendarz5", Scope.USER, Collections.singletonList(OffsetDateTime.now()));
        Calendar calendar6 = new Calendar("Kalendarz6", Scope.USER, Collections.singletonList(OffsetDateTime.now()));
        Calendar calendar7 = new Calendar("Kalendarz7", Scope.USER, Collections.singletonList(OffsetDateTime.now()));
        Calendar calendar8 = new Calendar("Kalendarz8", Scope.USER, Collections.singletonList(OffsetDateTime.now()));

        metadataService.addCalendar(calendar);
        metadataService.addCalendar(calendar2);
        metadataService.addCalendar(calendar3);
        metadataService.addCalendar(calendar4);
        metadataService.addCalendar(calendar5);
        metadataService.addCalendar(calendar6);
        metadataService.addCalendar(calendar7);
        metadataService.addCalendar(calendar8);


        Calendar newCalendar = new Calendar("ANY Calendar name", Scope.GROUP, Collections.singletonList(OffsetDateTime.now()));
        Calendar teamCalendar = new Calendar("ANY Calendar name", Scope.TEAM, Collections.singletonList(OffsetDateTime.now()));

        metadataService.addCalendar(newCalendar);
        metadataService.addCalendar(teamCalendar);

        for (Calendar c :  dao.getCalendars()) {
            System.out.println(c);
        }
    }
}