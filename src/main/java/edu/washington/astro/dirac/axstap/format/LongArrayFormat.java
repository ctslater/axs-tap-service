
package edu.washington.astro.dirac.axstap.format;

import java.sql.ResultSet;
import java.sql.SQLException;
import ca.nrc.cadc.tap.writer.format.AbstractResultSetFormat;

public class LongArrayFormat extends AbstractResultSetFormat
{
    private static final ca.nrc.cadc.dali.util.LongArrayFormat fmt 
                    = new ca.nrc.cadc.dali.util.LongArrayFormat();

    @Override
    public Object extract(ResultSet resultSet, int columnIndex)
            throws SQLException
    {
        return resultSet.getString(columnIndex);
    }

    @Override
    public String format(Object object)
    {
        if (object == null)
            return "";

        if (! (object instanceof String))
            throw new IllegalArgumentException("LongArrayFormat was expecting a string input");

        String val = (String) object;

        if (val.equals("[]"))
            return "";

        String[] stringArray = val.substring(1, val.length() - 1).split(",");

        long[] longArray = new long[stringArray.length];
        for (int i = 0; i < longArray.length; i++) {
            longArray[i] = Long.parseLong(stringArray[i]);
        }

	return fmt.format(longArray);

    }

}


