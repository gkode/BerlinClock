package com.ubs.opsit.interviews.entity;

import com.ubs.opsit.interviews.constants.Constant;

public class BerlinTime
{
    private char[] firstRow;
    private char[] secondRow;
    private char[] thirdRow;
    private char[] fourthRow;
    private char flag;

    private BerlinTime()
    {
        firstRow = new char[Constant.LAMP_NUM];
        secondRow = new char[Constant.LAMP_NUM];
        thirdRow = new char[Constant.LAMP_NUM_THIRD_ROW];
        fourthRow = new char[Constant.LAMP_NUM];
        for (int i = 0; i < firstRow.length; i++)
        {
            firstRow[i] = 'O';
            secondRow[i] = 'O';
            thirdRow[i] = 'O';
            fourthRow[i] = 'O';
        }
        for (int i = Constant.LAMP_NUM; i < thirdRow.length; i++)
        {
            thirdRow[i] = 'O';
        }
    }

    public BerlinTime(int hour, int min, int sec)
    {
        this();
        setFlag(hour * 60 * 60 + min * 60 + sec);
        setFirstRow(hour);
        setSecondRow(hour);
        setThirdRow(min);
        setFourthRow(min);
    }

    public String getBerlinTime()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(flag);
        sb.append(System.lineSeparator());
        sb.append(firstRow);
        sb.append(System.lineSeparator());
        sb.append(secondRow);
        sb.append(System.lineSeparator());
        sb.append(thirdRow);
        sb.append(System.lineSeparator());
        sb.append(fourthRow);
        return sb.toString();
    }

    private void setFirstRow(int hour)
    {
        setOnOff(firstRow, getSign(hour), Constant.RED);
    }

    private void setSecondRow(int hour)
    {
        setOnOff(secondRow, hour % 5, Constant.RED);
    }

    private void setThirdRow(int min)
    {
        setOnOff(thirdRow, getSign(min), Constant.YELLOW);
        setQuater(thirdRow);
    }

    private void setFourthRow(int min)
    {
        setOnOff(fourthRow, min % 5, Constant.YELLOW);
    }

    private void setFlag(int sec)
    {
        if (sec % 2 != 0)
        {
            this.flag = Constant.ONOFF.ON.getValue();
            return;
        }
        this.flag = Constant.ONOFF.OFF.getValue();
    }

    private int getSign(int number)
    {
        return (number - (number % 5)) / 5;
    }

    private void setOnOff(char[] row, int onSigns, char onSign)
    {
        for (int i = 0; i < onSigns; i++)
        {
            row[i] = onSign;
        }
    }

    private void setQuater(char[] quater)
    {
        for (int i = 2; i < quater.length; i += 3)
        {
            if (quater[i] == Constant.YELLOW)
            {
                quater[i] = Constant.RED;
            }
        }
    }
}

