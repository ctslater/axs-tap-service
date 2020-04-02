


package edu.washington.astro.dirac.axstap.format;

import ca.nrc.cadc.dali.util.Format;
import ca.nrc.cadc.tap.TapSelectItem;
import ca.nrc.cadc.tap.writer.format.DefaultFormatFactory;


public class AxsFormatFactory extends DefaultFormatFactory
{
    @Override
    protected Format<Object> getIntArrayFormat(TapSelectItem columnDesc)
    {
        return new IntArrayFormat();
    }

    @Override
    protected Format<Object> getLongArrayFormat(TapSelectItem columnDesc)
    {
        return new LongArrayFormat();
    }

    @Override
    protected Format<Object> getFloatArrayFormat(TapSelectItem columnDesc)
    {
        return new FloatArrayFormat();
    }

    @Override
    protected Format<Object> getDoubleArrayFormat(TapSelectItem columnDesc)
    {
        return new DoubleArrayFormat();
    }


}

