package pl._1024kb.strategy;

public class CalendarMetadataService {
    private final CalendarDAO calendarDAO;
    private final CalendarValidationService calendarValidationService;

    public CalendarMetadataService(CalendarDAO calendarDAO,
                                   CalendarValidationService calendarValidationService) {
        this.calendarDAO = calendarDAO;
        this.calendarValidationService = calendarValidationService;
    }

    public void addCalendar(Calendar calendar) {
        if(calendarValidationService.validateCalendar()) {
            if (calendarValidationService.validate(calendar)) {
                calendarDAO.saveCalendar(calendar);
            } else {
                System.out.println("Nie można dodać już kalendarza: " + calendar.toString() + ".\nLista pełna.\n");
            }
        }else {
            throw new InvalidNumbersOfStrategyException("Liczba strategi nie jest równa liczbie zasięgów; liczba zasięgów: " + Scope.values().length + " - liczba strategii: " + calendarValidationService.getLimitsSize());
        }
    }
}