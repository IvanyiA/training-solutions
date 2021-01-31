package collectionsmap;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class LogParser {

    public static final int NUMBER_OF_FIELDS = 3;

    public static final int POSITION_OF_IP = 0;
    public static final int POSITION_OF_DATE = 1;
    public static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public static final int POSITION_OF_LOGIN = 2;

    public Map<String, List<Entry>> parseLog(String log) {

        try (Scanner scanner = new Scanner(log)) {

            Map<String, List<Entry>> emptyElements = new HashMap<>();

            while (scanner.hasNext()) {
                String line = scanner.next();
                String[] data = line.split(":");
                invalidInputLine(data);
                LocalDate parsedDate = dateParser(data[POSITION_OF_DATE]);

                Entry entry = new Entry(data[POSITION_OF_IP], parsedDate, data[POSITION_OF_LOGIN]);

                fillEntryToMap(emptyElements, entry);
            }
            return emptyElements;
        }

    }

    private LocalDate dateParser(String date) {
        try {
            return LocalDate.parse(date, DATE_FORMAT);
        } catch (DateTimeParseException pe) {
            throw new IllegalArgumentException("Incorrect log: incorrect date");
        }
    }

    private void fillEntryToMap(Map<String, List<Entry>> emptyElements, Entry entry) {
        if (!emptyElements.containsKey(entry.getIpAddress())) {
            emptyElements.put(entry.getIpAddress(), new ArrayList<>());
        }
        emptyElements.get(entry.getIpAddress()).add(entry);
    }

    private void invalidInputLine(String[] lineElements) {
        if (lineElements.length != NUMBER_OF_FIELDS) {
            throw new IllegalArgumentException("Incorrect log: incorrect number of fields");
        }
    }

}
