
package edu.washington.astro.dirac.axstap.format;

import java.sql.ResultSet;
import java.sql.SQLException;
import ca.nrc.cadc.tap.writer.format.AbstractResultSetFormat;

public class DoubleArrayFormat extends AbstractResultSetFormat
{
    private static final ca.nrc.cadc.dali.util.DoubleArrayFormat fmt 
                    = new ca.nrc.cadc.dali.util.DoubleArrayFormat();

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
            throw new IllegalArgumentException("DoubleArrayFormat was expecting a string input");

        String val = (String) object;

        if (val.equals("[]"))
            return "";

        String[] stringArray = val.substring(1, val.length() - 1).split(",");

        double[] doubleArray = new double[stringArray.length];
        for (int i = 0; i < doubleArray.length; i++) {
            doubleArray[i] = Double.parseDouble(stringArray[i]);
        }

	return fmt.format(doubleArray);

    }

}


