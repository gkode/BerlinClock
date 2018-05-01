package com.ubs.opsit.interviews.constants;

public class Constant
{
    public static final char RED = 'R';
    public static final char ON = 'O';
    public static final char YELLOW = 'Y';

    public static final int LAMP_NUM = 4;
    public static final int LAMP_NUM_THIRD_ROW = 11;


    public enum ONOFF
    {
        OFF('Y'), ON(Constant.ON);
        private char value;

        private ONOFF(char value)
        {
            this.value = value;
        }

        public char getValue()
        {
            return value;
        }
    }
}
