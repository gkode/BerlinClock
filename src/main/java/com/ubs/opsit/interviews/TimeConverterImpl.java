package com.ubs.opsit.interviews;

import com.ubs.opsit.interviews.entity.BerlinTime;
import com.ubs.opsit.interviews.exception.BerlinTimeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TimeConverterImpl implements TimeConverter
{
    private static final Logger LOG = LoggerFactory.getLogger(TimeConverterImpl.class);

    @Override
    public String convertTime(String aTime)
    {
        try
        {
            int hour = Integer.valueOf(aTime.substring(0, 2));
            int min = Integer.valueOf(aTime.substring(3, 5));
            int sec = Integer.valueOf(aTime.substring(6, 8));
            if (!isValid(hour, min, sec))
            {
                throw new BerlinTimeException("Invalid Input : Hour or Minute or sec are out of range");
            }
            return new BerlinTime(hour, min, sec).getBerlinTime();
        }
        catch (Exception ex)
        {
            LOG.error("Processing Error {}", ex.getMessage());
            throw new BerlinTimeException(ex, "Processing Error");
        }
    }

    private boolean isValid(int hour, int min, int sec)
    {
        if (hour < 0 || hour > 24 || min < 0 || min > 60 || sec < 0 || sec > 60)
        {
            return false;
        }
        return true;
    }
}
