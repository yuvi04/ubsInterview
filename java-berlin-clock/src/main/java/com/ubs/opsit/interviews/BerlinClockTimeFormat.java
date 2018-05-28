package com.ubs.opsit.interviews;

import java.util.Arrays;
import java.util.stream.Stream;

import com.ubs.opsit.interviews.util.TimeConverterConstant;

/**
 *@author YUVRAJ Thakre
 *@see This the implemantation class to achive the TDD for berline clock.
 *@param FormatNotSupporting exception
 */
public class BerlinClockTimeFormat implements TimeConverter {
	@Override
	public String convertTime(String aTime) {
		String[] timeConverterArr = arryOfStringTimeConverter(aTime);
		String str = Arrays.toString(timeConverterArr);
		return str;
	}

	@Override
	public String[] arryOfStringTimeConverter(String time) {
		int[] parts = Stream.of(time.split(":")).mapToInt(Integer::parseInt).toArray();
		return new String[] { getSecondsInfo(parts[2]), getTopHoursInfo(parts[0]), getBottomHoursInfo(parts[0]),
				getTopMinutesInfo(parts[1]), getBottomMinutesInfo(parts[1]) };
	}

	protected String getSecondsInfo(int number) {
		if (number % 2 == 0)
			return TimeConverterConstant.getMOVE_TO_YELLLO();
		else
			return TimeConverterConstant.getMOVE_TO_OFF();
	}

	protected String getTopHoursInfo(int number) {
		return getOnOff(4, getTopNumberOfOnSigns(number));
	}

	protected String getBottomHoursInfo(int number) {
		return getOnOff(4, number % 5);
	}

	protected String getTopMinutesInfo(int number) {
		return getOnOff(11, getTopNumberOfOnSigns(number), TimeConverterConstant.getMOVE_TO_YELLLO()).replaceAll("YYY",
				"YYR");
	}

	protected String getBottomMinutesInfo(int number) {
		return getOnOff(4, number % 5, TimeConverterConstant.getMOVE_TO_YELLLO());
	}

	private String getOnOff(int lamps, int onSigns) {
		return getOnOff(lamps, onSigns, TimeConverterConstant.getMOVE_TO_RED());
	}

	private String getOnOff(int lamps, int onSigns, String onSign) {
		String out = "";
		for (int i = 0; i < onSigns; i++) {
			out += onSign;
		}
		for (int i = 0; i < (lamps - onSigns); i++) {
			out += "O";
		}
		return out;
	}

	private int getTopNumberOfOnSigns(int number) {
		return (number - (number % 5)) / 5;
	}
}
