package com.cc.signalinfo.signals;

import android.telephony.TelephonyManager;
import com.cc.signalinfo.enums.NetworkType;
import com.cc.signalinfo.enums.Signal;
import com.cc.signalinfo.util.StringUtils;

import java.util.EnumSet;
import java.util.Map;

/**
 * @author Wes Lanning
 * @version 2013-04-29
 */
public class CdmaInfo extends SignalInfo
{
    public CdmaInfo(TelephonyManager tm, Map<Signal, String> signals)
    {
        super(NetworkType.CDMA, tm, signals);
        possibleValues = EnumSet.range(Signal.CDMA_RSSI, Signal.EVDO_SNR);
    }

    public CdmaInfo(TelephonyManager tm)
    {
        this(tm, null);
    }

    @Override
    public boolean enabled()
    {
        return !StringUtils.isNullOrEmpty(signals.get(Signal.CDMA_RSSI))
            || !StringUtils.isNullOrEmpty(signals.get(Signal.EVDO_RSSI));
    }
}
