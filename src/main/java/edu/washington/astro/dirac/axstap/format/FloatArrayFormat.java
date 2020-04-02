
package edu.washington.astro.dirac.axstap.format;

import java.sql.ResultSet;
import java.sql.SQLException;
import ca.nrc.cadc.tap.writer.format.AbstractResultSetFormat;

public class FloatArrayFormat extends AbstractResultSetFormat
{
    private static final ca.nrc.cadc.dali.util.FloatArrayFormat fmt 
                    = new ca.nrc.cadc.dali.util.FloatArrayFormat();

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
            throw new IllegalArgumentException("FloatArrayFormat was expecting a string input");

        String val = (String) object;

        if (val.equals("[]"))
            return "";

        String[] stringArray = val.substring(1, val.length() - 1).split(",");

        float[] floatArray = new float[stringArray.length];
        for (int i = 0; i < floatArray.length; i++) {
            floatArray[i] = Float.parseFloat(stringArray[i]);
        }

	return fmt.format(floatArray);

    }

}


