package com.ubs.opsit.interviews;
import org.junit.Assert;
import org.junit.Test;
import com.ubs.opsit.interviews.util.TimeConverterConstant;
/**
 * @author YUVRAJ Thakre
 * @see Test class for all possible positive and nagative scenarios. 
 * @param Throwing exception when value not match with berlin clock format(HH:MM:SS)
 * */
public class BerlinClockTest {

	BerlinClockTimeFormat berlinClockTimeFormat =new BerlinClockTimeFormat();
/**
 * On/OFF for Yellow Lamp in every 2 seconds
 **/
@Test
public void testBlinkOnOffEveryTwoSecondsYellowLamp() {
	   Assert.assertEquals(TimeConverterConstant.getMOVE_TO_YELLLO(), berlinClockTimeFormat.getSecondsInfo(0));
       Assert.assertEquals(TimeConverterConstant.getMOVE_TO_OFF(), berlinClockTimeFormat.getSecondsInfo(1));
       Assert.assertEquals(TimeConverterConstant.getMOVE_TO_OFF(), berlinClockTimeFormat.getSecondsInfo(59));
}

/**
 * 4 lamp should be on top hours
 **/
@Test
public void testTopHoursShouldHave4Lamps() {
    Assert.assertEquals(4, berlinClockTimeFormat.getTopHoursInfo(7).length());
}

/**
 * red lamp for every 5 hours in Top hours
 **/
@Test
public void testTopHoursShouldLightRedLampForEvery5Hours() {
    Assert.assertEquals(TimeConverterConstant.getTOP_HOUR_INFO(), berlinClockTimeFormat.getTopHoursInfo(0));
    Assert.assertEquals(TimeConverterConstant.getTOP_HOUR_INFO_WITH_TWO_RED(), berlinClockTimeFormat.getTopHoursInfo(13));
    Assert.assertEquals(TimeConverterConstant.getTOP_HOUR_INFO_WITH_RED(), berlinClockTimeFormat.getTopHoursInfo(23));
    Assert.assertEquals(TimeConverterConstant.getTOP_HOUR_INFO_WITH_RED(), berlinClockTimeFormat.getTopHoursInfo(24));
}
/**
 * should have 4 lamps Bottom hours
 **/
@Test
public void testBottomHoursShouldHave4Lamps() {
    Assert.assertEquals(4, berlinClockTimeFormat.getBottomHoursInfo(5).length());
}
/**
 * Bottom hours should light a red lamp for every hour left from top hours
 **/
@Test
public void testBottomHoursShouldLightRedLampForEveryHourLeftFromTopHours() {
    Assert.assertEquals(TimeConverterConstant.getTOP_HOUR_INFO(), berlinClockTimeFormat.getBottomHoursInfo(0));
    Assert.assertEquals(TimeConverterConstant.getTOP_HOUR_INFO_WITH_THREE_RED_COLOR(), berlinClockTimeFormat.getBottomHoursInfo(13));
    Assert.assertEquals(TimeConverterConstant.getTOP_HOUR_INFO_WITH_THREE_RED_COLOR(), berlinClockTimeFormat.getBottomHoursInfo(23));
    Assert.assertEquals(TimeConverterConstant.getTOP_HOUR_INFO_WITH_RED(), berlinClockTimeFormat.getBottomHoursInfo(24));
}
/**
 * Top minutes should have 11 lamps
 **/
@Test
public void testTopMinutesShouldHave11Lamps() {
    Assert.assertEquals(11, berlinClockTimeFormat.getTopMinutesInfo(34).length());
}


@Test
public void testTopMinutesShouldHave3rd6thAnd9thLampsInRedToIndicateFirstQuarterHalfAndLastQuarter() {
    String minutes32 = berlinClockTimeFormat.getTopMinutesInfo(32);
    Assert.assertEquals(TimeConverterConstant.getMOVE_TO_RED(), minutes32.substring(2, 3));
    Assert.assertEquals(TimeConverterConstant.getMOVE_TO_RED(), minutes32.substring(5, 6));
    Assert.assertEquals(TimeConverterConstant.getMOVE_TO_OFF(), minutes32.substring(8, 9));
}


@Test
public void testTopMinutesShouldLightYellowLampForEvery5MinutesUnlessItIsFirstQuarterHalfOrLastQuarter() {
    Assert.assertEquals("OOOOOOOOOOO", berlinClockTimeFormat.getTopMinutesInfo(0));
    Assert.assertEquals("YYROOOOOOOO", berlinClockTimeFormat.getTopMinutesInfo(17));
    Assert.assertEquals("YYRYYRYYRYY", berlinClockTimeFormat.getTopMinutesInfo(59));
}


@Test
public void testBottomMinutesShouldHave4Lamps() {
    Assert.assertEquals(4, berlinClockTimeFormat.getBottomMinutesInfo(0).length());
}


@Test
public void testBottomMinutesShouldLightYellowLampForEveryMinuteLeftFromTopMinutes() {
    Assert.assertEquals(TimeConverterConstant.getTOP_HOUR_INFO(), berlinClockTimeFormat.getBottomMinutesInfo(0));
    Assert.assertEquals(TimeConverterConstant.getTOP_HOUR_INFO_WITH_TWO_YELLOW(), berlinClockTimeFormat.getBottomMinutesInfo(17));
    Assert.assertEquals(TimeConverterConstant.getTOP_HOUR_INFO_WITH__YELLOW(), berlinClockTimeFormat.getBottomMinutesInfo(59));
}


@Test
public void testBerlinClockShouldResultInArrayWith5Elements()  {
    Assert.assertEquals(5, berlinClockTimeFormat.arryOfStringTimeConverter("13:17:01").length);
}


@Test
public void testBerlinClockShouldResultInCorrectSecondsHoursAndMinutes() {
    String[] berlinTime = berlinClockTimeFormat.arryOfStringTimeConverter("16:37:16");
    String[] expected = new String[] {"Y", "RRRO", "ROOO", "YYRYYRYOOOO", "YYOO"};
    Assert.assertEquals(expected.length, berlinTime.length);
    for (int index = 0; index < expected.length; index++) {
        Assert.assertEquals(expected[index], berlinTime[index]);
    }
}
}
