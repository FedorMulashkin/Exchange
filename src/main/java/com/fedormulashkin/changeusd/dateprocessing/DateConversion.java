package com.fedormulashkin.changeusd.dateprocessing;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

/**
 * Здесь реализована функция для перевода местного времени на британское, так как при использовании местного времени
 * может быть отправлен запрос на https://openexchangerates.org/api/historical/YYYY-MM-DD.json с неправильной для
 * Великобритании датой.
 */
public class DateConversion {
    public static LocalDate convertDateToEngland(){
        TimeZone tz = TimeZone.getDefault();
        LocalDateTime localDateTime = LocalDateTime.now();
        return localDateTime.minusNanos((long) (tz.getRawOffset() * 1E6)).toLocalDate();
    }
}
